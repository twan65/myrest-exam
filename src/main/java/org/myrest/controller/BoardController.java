package org.myrest.controller;

import lombok.RequiredArgsConstructor;
import org.myrest.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/board")
public class BoardController {

  private final BoardService boardService;

  @GetMapping("/list")
  public String list (Model model) {
    model.addAttribute("boards", boardService.findAll());
    return "board/list";
  }

}
