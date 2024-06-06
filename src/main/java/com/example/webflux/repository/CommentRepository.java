package com.example.webflux.repository;

import com.example.webflux.domain.Comment;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface CommentRepository  extends R2dbcRepository<Comment,Long> {
    Flux<Comment> findByBoardId(Long boardId);
//    @Query(value = "SELECT * FROM Comment WHERE board_id = :boardId")
}
