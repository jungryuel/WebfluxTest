package com.example.webflux.service;

import com.example.webflux.domain.Comment;
import com.example.webflux.dto.CreateComment;
import com.example.webflux.dto.UpdateComment;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CommentService {
    Mono<Void> save(Long board_id, CreateComment createComment);

    Flux<Comment> getAll(Long board_id);

    Mono<Void> update(Long boardId, Long commentId, UpdateComment updateComment);

    Mono<Void> delete(Long boardId, Long commentId);
}
