package com.example.webflux.repository;

import com.example.webflux.domain.Board;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface BoardRepository extends R2dbcRepository <Board, Long>{
}
