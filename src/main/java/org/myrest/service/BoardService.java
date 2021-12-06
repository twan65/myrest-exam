package org.myrest.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.myrest.model.Board;
import org.myrest.repository.BoardRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService {

  private final BoardRepository boardRepository;

  public List<Board> findAll() {
    return boardRepository.findAll();
  }

}
