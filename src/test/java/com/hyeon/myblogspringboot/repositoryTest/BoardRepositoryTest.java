package com.hyeon.myblogspringboot.repositoryTest;

import com.hyeon.myblogspringboot.model.Board;
import com.hyeon.myblogspringboot.repository.BoardRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@DataJpaTest
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void testInsert() {
        Board board = new Board();
        board.setTitle("제목제목제목제목제목제목제목제목제목제목제목제목");
        board.setContent("내용을적으세요내용을적으세요내용을적으세요내용을적으세요내용을적으세요내용을적으세요내용을적으세요");
        board.setRegDate(LocalDateTime.now());
        boardRepository.save(board);

//        Assert.assertThat(board.getTitle()).isEqualTo("제목제목제목제목제목제목제목제목제목제목제목제목");
//        Assert.assertEquals(board.getContent()).isEqualTo("내용을적으세요내용을적으세요내용을적으세요내용을적으세요내용을적으세요내용을적으세요내용을적으세요");
    }

    @Test
    public void testUpdate() {
        Optional<Board> board = boardRepository.findById(1L);
        board.get().setTitle("히히" + LocalDateTime.now());
        boardRepository.save(board.get());
    }

}
