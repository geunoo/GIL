package com.example.hexagonalfeed.common.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@SuperBuilder
@NoArgsConstructor
@MappedSuperclass
public abstract class BaseTimeEntity extends BaseUUIDEntity {

    @CreatedDate
    @Column(columnDefinition = "DATETIME(6)", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
