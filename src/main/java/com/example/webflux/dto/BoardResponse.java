package com.example.webflux.dto;

import com.example.webflux.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardResponse {
    private Long board_id;
    private String board_title;
    private String board_author;
    private LocalDateTime board_created_at;
    private LocalDateTime board_updated_at;



    public static BoardResponse from(Board board){
        return BoardResponse.builder()
                .board_id(board.getBoard_id())
                .board_title(board.getBoard_title())
                .board_author(board.getBoard_author())
                .board_created_at(board.getBoard_created_at())
                .board_updated_at(board.getBoard_updated_at())
                .build();
    }
}
