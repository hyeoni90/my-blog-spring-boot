package com.hyeon.myblogspringboot.controller;

import com.hyeon.myblogspringboot.model.Board;
import com.hyeon.myblogspringboot.service.BoardService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/boards")
    public List<Board> boards() {
        return boardService.findAll();
    }

    @GetMapping("/boards/{id}")
    public Optional<Board> getBoardById(@PathVariable Long id) {
        return boardService.findById(id);
    }

    @PostMapping("/boards")
    public Board save(@Valid Board board) {
        return boardService.save(board);
    }

    @PutMapping("/boards/{id}")
    public Board update(@PathVariable Long id, Board board) {
        return boardService.update(id, board);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        boardService.delete(id);
    }

}
