package com.example.webflux.controller;

import com.example.webflux.domain.Comment;
import com.example.webflux.dto.CreateComment;
import com.example.webflux.dto.UpdateComment;
import com.example.webflux.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/boards")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/{boardId}/comments")
    public Mono<Void> createComment(@PathVariable Long boardId, @RequestBody CreateComment createComment){
        return commentService.save(boardId,createComment);
    }

    @GetMapping("/{boardId}/comments")
    public Flux<Comment> getAll(@PathVariable Long boardId){
        return commentService.getAll(boardId);
    }
    @PutMapping("/{boardId}/comments/{commentId}")
    public Mono<Void> update(@PathVariable Long boardId,@PathVariable Long commentId , @RequestBody UpdateComment updateComment){
        return commentService.update(boardId ,commentId ,updateComment);
    }

    @DeleteMapping("/{boardId}/comments/{commentId}")
    public Mono<Void> delete(@PathVariable Long boardId,@PathVariable Long commentId){
        return commentService.delete(boardId,commentId);
    }
}
