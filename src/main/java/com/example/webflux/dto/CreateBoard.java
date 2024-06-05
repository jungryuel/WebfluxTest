package com.example.webflux.dto;

import com.example.webflux.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateBoard {
    private String board_author;
    private String board_title;
    private String board_content;

    public Board toEntity(){
        return Board.builder()
                .board_author(board_author)
                .board_content(board_content)
                .board_title(board_title)
                .build();
    }
}
