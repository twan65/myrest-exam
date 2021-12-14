package org.myrest.web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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


  @ManyToOne
  @JoinColumn(name = "user_id")
  @JsonIgnore
  private User user;

  public Board(Long id, String title, String content, User user) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.user = user;
  }

  public void update(BoardDTO boardDTO) {
    this.title = boardDTO.getTitle();
    this.content = boardDTO.getContent();
  }
}
