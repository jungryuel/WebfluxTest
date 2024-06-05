package com.example.webflux.domain;

import lombok.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;


import java.time.LocalDateTime;

@Table("Boards")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Board {

    @Id
    private Long board_id;

    @Setter
    private String board_title;
    @Setter
    private String board_content;

    private String board_author;
    @CreatedDate
    private LocalDateTime board_created_at;
    @LastModifiedDate
    private LocalDateTime board_updated_at;

}
