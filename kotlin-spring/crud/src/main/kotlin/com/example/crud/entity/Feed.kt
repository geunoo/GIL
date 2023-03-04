package com.example.crud.entity

import javax.persistence.*

@Entity
class Feed (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id : Long = 0,

        @Column(columnDefinition = "VARCHAR(20)", nullable = false)
        val title : String,

        @Column(columnDefinition = "VARCHAR(1000)", nullable = false)
        val content : String,
) {

}