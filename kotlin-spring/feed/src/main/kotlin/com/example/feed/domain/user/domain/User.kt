package com.example.feed.domain.user.domain

import com.example.feed.domain.user.domain.enums.Sex
import com.example.feed.global.entity.BaseUUIDEntity
import java.util.UUID
import javax.persistence.*

@Entity
@Table(name = "user_tbl")
class User(

        override val id: UUID,

        @Column(columnDefinition = "VARCHAR(30)", nullable = false, unique = true)
        val accountId: String,

        @Column(columnDefinition = "VARCHAR", nullable = false)
        val password: String,

        @Column(columnDefinition = "VARCHAR(20)", nullable = false)
        val name: String,

        @Column(columnDefinition = "VARCHAR(10)", nullable = false)
        val birthday: String,

        @Enumerated(EnumType.STRING)
        @Column(columnDefinition = "VARCHAR(6)", nullable = false)
        val sex: Sex,

): BaseUUIDEntity()