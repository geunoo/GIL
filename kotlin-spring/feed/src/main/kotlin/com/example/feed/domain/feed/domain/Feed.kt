package com.example.feed.domain.feed.domain

import com.example.feed.domain.user.domain.User
import com.example.feed.global.entity.BaseEntity
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class Feed(

        override val id: UUID,

        @Column(columnDefinition = "VARCHAR(30)", nullable = false)
        val title: String,

        @Column(columnDefinition = "VARCHAR(1000)", nullable = false)
        val content: String,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", nullable = false)
        val user: User,

        ): BaseEntity()