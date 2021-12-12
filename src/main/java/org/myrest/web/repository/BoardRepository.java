package org.myrest.web.repository;

import org.myrest.web.model.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
  Page<Board> findByTitleContainingOrContentContaining(String title, String content, Pageable pageable);
}
