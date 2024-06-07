package com.example.webflux.service;

import com.example.webflux.domain.Board;
import com.example.webflux.dto.BoardResponse;
import com.example.webflux.dto.CreateBoard;
import com.example.webflux.dto.UpdateBoard;
import com.example.webflux.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    private final BoardRepository boardRepository;
    @Override
    public Mono<Void> save(CreateBoard createBoard) {
        return boardRepository.save(createBoard.toEntity()).then();
    }

    @Override
    public Flux<BoardResponse> getAll() {
        return boardRepository.findAll().map(BoardResponse :: from);
    }

    @Override
    public Mono<Board> getBoard(Long id) {
        return boardRepository.findById(id);
    }

    @Override
    public Mono<Void> update(Long id ,UpdateBoard updateBoard) {
        return boardRepository.findById(id)
                .flatMap(existingBoard -> {
                    existingBoard.setBoard_title(updateBoard.getBoard_title());
                    existingBoard.setBoard_content(updateBoard.getBoard_content());
                    return boardRepository.save(existingBoard);
                }).then();
    }

    @Override
    public Mono<Void> delete(Long id) {
        return boardRepository.deleteById(id);
    }
}
