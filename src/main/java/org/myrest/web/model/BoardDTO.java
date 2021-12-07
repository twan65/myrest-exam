package org.myrest.web.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class BoardDTO {

  private Long id;
  private String title;
  private String content;

  public BoardDTO(Board board) {
    this.id = board.getId();
    this.title = board.getTitle();
    this.content = board.getContent();
  }

  public Board toEntity() {
    return new Board(id, title, content);
  }
}
