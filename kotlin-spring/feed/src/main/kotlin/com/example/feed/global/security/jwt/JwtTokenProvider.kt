package com.example.feed.global.security.jwt

import com.example.feed.domain.user.domain.RefreshToken
import com.example.feed.domain.user.domain.repository.RefreshTokenJpaRepository
import com.example.feed.global.exception.ExpiredTokenException
import com.example.feed.global.exception.InvalidTokenException
import com.example.feed.global.security.auth.AuthDetailsService
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.util.Date
import javax.servlet.http.HttpServletRequest

@Component
class JwtTokenProvider(
        private val jwtProperties: JwtProperties,
        private val refreshTokenJpaRepository: RefreshTokenJpaRepository,
        private val authDetailsService: AuthDetailsService,
) {

    fun generateAccessToken(accountId: String): String {
        return generateToken(accountId, "access", jwtProperties.accessExp)
    }

    fun generateRefreshToken(accountId: String): String {
        val refreshToken = generateToken(accountId, "refresh", jwtProperties.refreshExp)

        refreshTokenJpaRepository.save(RefreshToken(
                accountId = accountId,
                token = refreshToken,
                jwtProperties.refreshExp
        ))
        return refreshToken
    }

    fun getAuthentication(token: String): Authentication {
        val claims: Claims = getClaims(token)

        if (!claims.get("type", String::class.java).equals("access")) {
            println(claims.get("type"))
            throw InvalidTokenException
        }

        val userDetails: UserDetails = authDetailsService.loadUserByUsername(claims.subject)
        return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
    }

    fun resolveToken(httpServletRequest: HttpServletRequest): String? {
        val token: String? = httpServletRequest.getHeader(jwtProperties.header)
        if (token != null && token.startsWith(jwtProperties.prefix)) {
            return token.replace(jwtProperties.prefix, "")
        }
        return null;
    }

    private fun generateToken(accountId: String, type: String, exp: Long): String {
        return Jwts.builder()
                .setSubject(accountId)
                .signWith(SignatureAlgorithm.HS256, jwtProperties.secret)
                .setIssuedAt(Date())
                .setExpiration(Date(System.currentTimeMillis() + exp * 1000))
                .claim("type", type)
                .compact()
    }

    fun getClaims(token: String): Claims {
        try {
            return Jwts.parser()
                    .setSigningKey(jwtProperties.secret)
                    .parseClaimsJws(token)
                    .body
        } catch (e: ExpiredJwtException) {
            throw ExpiredTokenException
        } catch (e: Exception) {
            throw InvalidTokenException
        }
    }

}