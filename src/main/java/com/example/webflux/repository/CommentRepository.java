package com.example.webflux.repository;

import com.example.webflux.domain.Comment;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface CommentRepository  extends R2dbcRepository<Comment,Long> {
}
