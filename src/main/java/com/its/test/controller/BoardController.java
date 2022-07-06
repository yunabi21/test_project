package com.its.test.controller;

import com.its.test.dto.BoardDTO;
import com.its.test.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
  private final BoardService bs;

  @PostMapping("/save")
  public String save(@ModelAttribute BoardDTO boardDTO) {
    Long saveId = bs.save(boardDTO);
    return "redirect:/board";
  }

  @GetMapping("/board")
  public String findAll(Model model) {
    List<BoardDTO> boardDTOList = bs.findAll();
    model.addAttribute("boardList", boardDTOList);
    return null;
  }

  @GetMapping("/{id}")
  public String findById(@PathVariable("id") Long id, Model model) {
    BoardDTO boardDTO = bs.findById(id);
    model.addAttribute("board", boardDTO);
    return "boardPages/detail";
  }

}
