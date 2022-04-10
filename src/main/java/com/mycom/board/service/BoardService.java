package com.mycom.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.board.dto.BoardDto;
import com.mycom.board.mapper.BoardMapper;

@Service
public class BoardService {

	@Autowired
	private BoardMapper boardMapper;

	public List<BoardDto> selectBoardList() {
		return boardMapper.selectBoardList();
	}

	public void insertBoard(BoardDto board) {
		boardMapper.insertBoard(board);
	}

	public BoardDto selectBoardDetail(int boardIdx) {
		boardMapper.updateHitCount(boardIdx);
		// int i = 10 / 0; // 일부러 예외를 발생시켜서 트랜잭션 테스트!
		BoardDto board = boardMapper.selectBoardDetail(boardIdx);
		return board;
	}

	public void updateBoard(BoardDto board) {
		boardMapper.updateBoard(board);
	}

	public void deleteBoard(int boardIdx) {
		boardMapper.deleteBoard(boardIdx);
	}

}
