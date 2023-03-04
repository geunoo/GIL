package com.example.crud.entity

import javax.persistence.*

@Entity
class Feed (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id : Long = 0,

        @Column(columnDefinition = "VARCHAR(20)", nullable = false)
        var title : String,

        @Column(columnDefinition = "VARCHAR(1000)", nullable = false)
        var content : String,
) {
        fun update(title: String, content: String) {
                this.title = title
                this.content = content

        }
}