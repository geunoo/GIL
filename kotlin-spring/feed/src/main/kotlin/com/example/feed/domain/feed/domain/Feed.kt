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

        title: String,
        content: String,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", nullable = false)
        val user: User,

): BaseEntity() {

        @Column(columnDefinition = "VARCHAR(30)", nullable = false)
        var title: String = title
                protected set

        @Column(columnDefinition = "VARCHAR(1000)", nullable = false)
        var content: String = content
                protected set
}