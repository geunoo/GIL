package com.example.feed.global.querydsl

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Configuration
class QuerydslConfig(

        @PersistenceContext
        private val entityManager: EntityManager,

) {

    @Bean
    fun queryFactory() :JPAQueryFactory {
        return JPAQueryFactory(entityManager)
    }
}