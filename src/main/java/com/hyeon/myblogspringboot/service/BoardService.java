package com.hyeon.myblogspringboot.service;

import com.hyeon.myblogspringboot.model.Board;
import com.hyeon.myblogspringboot.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    public Optional<Board> findById(Long id) {
        return boardRepository.findById(id);
    }

    public Board save(Board board) {
        board.setRegDateTime(LocalDateTime.now());
        return boardRepository.save(board);
    }

    public Board update(Long id, Board newBoard) {
        return boardRepository.findById(newBoard.getId())
                .map(board -> {
                    board.setTitle(newBoard.getTitle());
                    board.setContent(newBoard.getContent());
                    board.setModDateTime(LocalDateTime.now());
                    return boardRepository.save(board);
                }).orElseGet(() -> {
                    newBoard.setId(id);
                    return boardRepository.save(newBoard);
                });
    }

    public void delete(Long id) {
        boardRepository.deleteById(id);
    }
}
