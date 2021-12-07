package org.myrest.web.service;

import static java.util.stream.Collectors.toList;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.myrest.web.model.Board;
import org.myrest.web.model.BoardDTO;
import org.myrest.web.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BoardService {

  private final BoardRepository boardRepository;

  public List<BoardDTO> findAll() {
    return boardRepository.findAll().stream().map(BoardDTO::new).collect(toList());
  }

  @Transactional(readOnly = true)
  public BoardDTO findById(Long id) {
    Board board =
        boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("投稿がありません。"));
    return new BoardDTO(board);
  }

  @Transactional
  public Long save(BoardDTO boardRequestDTO) {
    return boardRepository.save(boardRequestDTO.toEntity()).getId();
  }
}
