package org.myrest.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Board {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String content;

  public Board(Long id, String title, String content) {
    this.id = id;
    this.title = title;
    this.content = content;
  }

  public void update(BoardDTO boardDTO) {
    this.title = boardDTO.getTitle();
    this.content = boardDTO.getContent();
  }
}
