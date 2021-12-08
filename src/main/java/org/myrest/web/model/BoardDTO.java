package org.myrest.web.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class BoardDTO {

  private Long id;

  @NotNull
  @Size(min = 2, max = 50, message = "タイトルは{min}〜{max}桁で入力してください。")
  private String title;

  @NotNull
  @Size(min = 2, max = 255, message = "内容はは{min}〜{max}桁で入力してください。")
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
