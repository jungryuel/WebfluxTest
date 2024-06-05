package com.example.webflux.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("Comments")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment {
    @Id
    private Long comment_id;

    private String comment_content;

    private String comment_author;

    private Long board_id;

    @CreatedDate
    private LocalDateTime comment_created_at;

    @LastModifiedDate
    private LocalDateTime comment_updated_at;
}
