package org.myrest.web.service;

import static java.util.stream.Collectors.toList;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.myrest.web.model.Board;
import org.myrest.web.model.BoardDTO;
import org.myrest.web.model.User;
import org.myrest.web.repository.BoardRepository;
import org.myrest.web.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BoardService {

  private final BoardRepository boardRepository;
  private final UserRepository userRepository;

  public Page<Board> findAll(String searchText, Pageable pageable) {
    return boardRepository.findByTitleContainingOrContentContaining(searchText, searchText, pageable);
  }

  @Transactional(readOnly = true)
  public BoardDTO findById(Long id) {
    Board board =
        boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("投稿がありません。"));
    return new BoardDTO(board);
  }

  @Transactional
  public Long save(BoardDTO boardRequestDTO, String username) {
    User user = userRepository.findByUsername(username);
    return boardRepository.save(boardRequestDTO.toEntity(user)).getId();
  }
}
