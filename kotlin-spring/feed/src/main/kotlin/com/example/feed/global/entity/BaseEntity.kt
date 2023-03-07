package com.example.feed.global.entity

import com.fasterxml.uuid.Generators
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class BaseEntity(

        @Id @Column(columnDefinition = "BINARY(16)", nullable = false)
        val id: UUID = Generators.timeBasedGenerator().generate()

): BaseTimeEntity()