package com.example.webflux.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("comments")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Comment {
    @Id
    @Column(value = "comment_id")
    private Long comment_id;

    @Setter
    @Column(value = "comment_content")
    private String comment_content;

    @Column(value = "comment_author")
    private String comment_author;

    @Column(value = "board_id")
    private Long boardId;

    @CreatedDate
    @Column(value = "comment_created_at")
    private LocalDateTime comment_created_at;

    @LastModifiedDate
    @Column(value = "comment_updated_at")
    private LocalDateTime comment_updated_at;
}
