package com.example.feed.global.entity

import java.util.UUID
import javax.persistence.Column
import javax.persistence.Id
import javax.persistence.MappedSuperclass
import com.fasterxml.uuid.Generators

@MappedSuperclass
abstract class BaseUUIDEntity(

        @Id @Column(columnDefinition = "BINARY(16)", nullable = false)
        val id: UUID = Generators.timeBasedGenerator().generate()
)