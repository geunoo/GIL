package com.example.hexagonalfeed.persistence.feed.entity;

import com.example.hexagonalfeed.common.entity.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@SuperBuilder
@NoArgsConstructor
@Table(name = "tbl_feed")
@Entity
public class FeedJpaEntity extends BaseTimeEntity {

    @Column(columnDefinition = "VARCHAR(30)", nullable = false)
    private String title;

    @Column(columnDefinition = "VARCHAR(1000)", nullable = false)
    private String content;

}
