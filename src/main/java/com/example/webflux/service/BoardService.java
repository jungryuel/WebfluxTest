package com.example.webflux.service;

import com.example.webflux.domain.Board;
import com.example.webflux.dto.CreateBoard;
import com.example.webflux.dto.UpdateBoard;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface BoardService {
    Mono<Void> save(CreateBoard createBoard);

    Flux<Board> getAll();

    Mono<Board> getBoard(Long id);

    Mono<Void> update(Long id,UpdateBoard updateBoard);

    Mono<Void> delete(Long id);
}
