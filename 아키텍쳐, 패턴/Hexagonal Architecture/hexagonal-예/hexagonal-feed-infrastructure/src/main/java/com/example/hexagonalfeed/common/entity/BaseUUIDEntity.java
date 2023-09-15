package com.example.hexagonalfeed.common.entity;

import com.fasterxml.uuid.Generators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@Getter
@SuperBuilder
@NoArgsConstructor
@MappedSuperclass
public abstract class BaseUUIDEntity {

    @Id
    @GeneratedValue(generator = "timeBasedUUIDGenerator")
    @GenericGenerator(name = "timeBasedUUIDGenerator", strategy = "com.example.hexagonalfeed.common.entity.TimeBasedUUIDGenerator")
    @Column(columnDefinition = "BINARY(16)", nullable = false)
    private UUID id;
}
