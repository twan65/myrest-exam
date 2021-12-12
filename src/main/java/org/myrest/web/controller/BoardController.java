package org.myrest.web.controller;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.myrest.web.model.Board;
import org.myrest.web.model.BoardDTO;
import org.myrest.web.service.BoardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
@RequestMapping("/board")
public class BoardController {

  private final BoardService boardService;

  @GetMapping("/list")
  public String findAll(
      Model model,
      @PageableDefault(size = 4) Pageable pageable,
      @RequestParam(required = false, defaultValue = "") String searchText) {
    Page<Board> boards = boardService.findAll(searchText, pageable);

    int startPage = Math.max(1, boards.getPageable().getPageNumber() - 4);
    int endPage = Math.min(boards.getTotalPages(), boards.getPageable().getPageNumber() + 4);

    model.addAttribute("boards", boards);
    model.addAttribute("startPage", startPage);
    model.addAttribute("endPage", endPage);

    return "board/list";
  }

  @GetMapping("/form")
  public String form(Model model, @RequestParam(required = false) Long id) {
    if (id == null) {
      model.addAttribute("board", new BoardDTO());
    } else {
      model.addAttribute("board", boardService.findById(id));
    }
    return "board/form";
  }

  @PostMapping("/form")
  public String save(
      @ModelAttribute("board") @Valid BoardDTO board, BindingResult bindingResult, Model model) {
    if (bindingResult.hasErrors()) {
      model.addAttribute("board", board);
      return "board/form";
    }

    boardService.save(board);
    return "redirect:/board/list";
  }
}
