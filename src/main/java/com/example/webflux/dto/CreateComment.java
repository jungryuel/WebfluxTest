package com.example.webflux.dto;

import com.example.webflux.domain.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateComment {
    private String comment_content;
    private String comment_author ;

    public Comment toEntity(Long boardId){
        return Comment.builder()
                .boardId(boardId)
                .comment_content(comment_content)
                .comment_author(comment_author)
                .build();
    }
}
