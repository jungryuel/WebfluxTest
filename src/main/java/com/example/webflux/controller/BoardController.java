package com.example.webflux.controller;

import com.example.webflux.domain.Board;
import com.example.webflux.dto.CreateBoard;
import com.example.webflux.dto.UpdateBoard;
import com.example.webflux.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("api/boards")
@RequiredArgsConstructor
public class BoardController {


    private final BoardService boardService;

    @PostMapping
    public Mono<Void> save (@RequestBody CreateBoard createBoard){
        return boardService.save(createBoard);
    }

    @GetMapping
    public Flux<Board> getAll(){
        return boardService.getAll();
    }

    @GetMapping("/{id}")
    public Mono<Board> getAll(@PathVariable Long id){
        return boardService.getBoard(id);
    }

    @PutMapping("/{id}")
    public Mono<Void> update(@PathVariable Long id, @RequestBody UpdateBoard updateBoard){
        return boardService.update(id,updateBoard);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Long id){
        return boardService.delete(id);
    }


}
