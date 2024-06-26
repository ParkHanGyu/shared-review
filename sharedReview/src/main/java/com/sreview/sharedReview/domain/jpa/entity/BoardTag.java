// 게시물 - 태그 연결 테이블
package com.sreview.sharedReview.domain.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BoardTag { // 게시물-태그 연결 테이블
    // 게시물-태그 ID
    @Id
    @GeneratedValue
    @Column(name = "BoardTag_ID")
    private Long id;

    // Tag테이블 Tag_ID 외래키

    // Post테이블 Post_ID 외래키

    // 다대일
    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    // 다대일
    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;
}
