package com.example.webflux.service;

import com.example.webflux.domain.Comment;
import com.example.webflux.dto.CreateComment;
import com.example.webflux.dto.UpdateComment;
import com.example.webflux.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Override
    public Mono<Void> save(Long board_id, CreateComment createComment) {
        return commentRepository.save(createComment.toEntity(board_id)).then();
    }
    @Override
    public Flux<Comment> getAll(Long boardId) {
        return commentRepository.findByBoardId(boardId);
    }

    @Override
    public Mono<Void> update(Long boardId, Long commentId, UpdateComment updateComment) {
        return commentRepository.findById(commentId)
                .flatMap(existingComment -> {
                    existingComment.setComment_content(updateComment.getComment_content());
                    return commentRepository.save(existingComment);
                })
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Comment not found")))
                .then();
    }

    @Override
    public Mono<Void> delete(Long boardId, Long commentId) {
        return commentRepository.deleteById(commentId);
    }
}
