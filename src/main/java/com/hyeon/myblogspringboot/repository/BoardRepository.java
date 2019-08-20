package com.hyeon.myblogspringboot.repository;

import com.hyeon.myblogspringboot.model.Board;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardRepository extends CrudRepository<Board, Long> {

    List<Board> findAll();

    Optional<Board> findById(Long id);

    void deleteById(Long id);
}
