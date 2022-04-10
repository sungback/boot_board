package com.mycom.board.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BoardDto {
	private int boardIdx;
	private String title;
	private String contents;
	private int hitCnt;
	private String creatorId;
	private String createdDatetime;
	private String updaterId;
	private String updatedDatetime;
}

/*
CREATE TABLE t_board(
	board_idx INT NOT NULL AUTO_INCREMENT,
	title VARCHAR(300) NOT NULL,
	contents TEXT NOT NULL,
	hit_cnt SMALLINT NOT NULL DEFAULT 0,
	created_datetime DATETIME NOT NULL DEFAULT NOW(),
	creator_id VARCHAR(50) NOT NULL,
	updated_datetime DATETIME ,
	updater_id VARCHAR(50),
	deleted_yn CHAR(1) NOT NULL DEFAULT 'N',
	PRIMARY KEY(board_idx)
);
*/

// 많은 데이터 넣기 : 실행할 때마다 데이터가 2배씩 증가한다.
// INSERT INTO t_board(title,contents,creator_id) (SELECT title,contents,'admin' FROM t_board);
