package com.mycom.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycom.board.dto.BoardDto;
import com.mycom.board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	@GetMapping("/board/openBoardList")
	public String openBoardList(Model model) throws Exception {
		System.out.println("/board/openBoardList 호출됨!");
		List<BoardDto> list = boardService.selectBoardList();
		model.addAttribute("list", list);
		return "/board/boardList";
	}

	@GetMapping("/board/openBoardWrite")
	public String openBoardWrite() throws Exception{
		System.out.println("/board/openBoardWrite 호출됨!");
		return "/board/boardWrite";
	}

	@PostMapping("/board/insertBoard")
	public String insertBoard(BoardDto board) throws Exception{
		System.out.println("/board/insertBoard 호출됨!");
		System.out.println("board=" + board);
		boardService.insertBoard(board);
		return "redirect:/board/openBoardList";
	}

	@GetMapping("/board/openBoardDetail")
	public String openBoardDetail(@RequestParam int boardIdx, Model model) throws Exception{
		System.out.println("/board/openBoardDetail 호출됨!");
		BoardDto board = boardService.selectBoardDetail(boardIdx);
		model.addAttribute("board", board);
		return "/board/boardDetail";
	}

	@PostMapping("/board/updateBoard")
	public String updateBoard(BoardDto board) throws Exception{
		System.out.println("/board/updateBoard 호출됨!");
		boardService.updateBoard(board);
		return "redirect:/board/openBoardList";
	}

	@PostMapping("/board/deleteBoard")
	public String deleteBoard(int boardIdx) throws Exception{
		System.out.println("/board/deleteBoard 호출됨!");
		boardService.deleteBoard(boardIdx);
		return "redirect:/board/openBoardList";
	}

}
