package com.example.feed.domain.user.domain

import com.example.feed.domain.user.domain.enums.Sex
import com.example.feed.global.entity.BaseUUIDEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated

@Entity
class User(

        @Column(columnDefinition = "VARCHAR(30)", nullable = false, unique = true)
        val accountId: String,

        @Column(columnDefinition = "VARCHAR(100)", nullable = false)
        val password: String,

        @Column(columnDefinition = "VARCHAR(20)", nullable = false)
        val name: String,

        @Column(columnDefinition = "VARCHAR(10)", nullable = false)
        val birthday: String,

        @Enumerated(EnumType.STRING)
        @Column(columnDefinition = "VARCHAR(6)", nullable = false)
        val sex: Sex,

): BaseUUIDEntity()