<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>게시글 상세 화면</title>
	<link rel="stylesheet" href="${root}/resources/css/style.css" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#list").on("click", function(){
				location.href = "/board/openBoardList";
			});
			$("#edit").on("click", function(){
				var frm = $("#frm")[0];
				frm.action = "/board/updateBoard";
				frm.submit();
			});
			$("#delete").on("click", function(){
				$("#frm").attr("action", "/board/deleteBoard").submit();
			});
		});
	</script>
</head>
<body>
	<div class="container">
		<h2>게시글 상세 화면</h2>
	    <form id="frm" method="post">
	    	<table class="board_detail">
				<colgroup>
					<col width="15%"/>
					<col width="35%"/>
					<col width="15%"/>
					<col width="35%"/>
				</colgroup>
				<caption>게시글 상세내용</caption>
				<tbody>
					<tr>
						<th scope="row">글 번호</th>
						<td>${board.boardIdx}</td>
						<th scope="row">조회수</th>
						<td>${board.hitCnt}</td>
					</tr>
					<tr>
						<th scope="row">작성자</th>
						<td>${board.creatorId}</td>
						<th scope="row">작성일</th>
						<td>${board.createdDatetime}</td>
					</tr>
					<tr>
						<th scope="row">제목</th>
						<td colspan="3"><input type="text" id="title" name="title" value="${board.title}"/></td>
					</tr>
					<tr>
						<td colspan="4" class="view_text">
							<textarea title="내용" id="contents" name="contents">${board.contents}</textarea>
						</td>
					</tr>
				</tbody>
			</table>
			<input type="hidden" id="boardIdx" name="boardIdx" value="${board.boardIdx }">
		</form>
		<a id="list" class="btn">목록으로</a>
		<a id="edit" class="btn">수정하기</a>
		<a id="delete" class="btn">삭제하기</a>
	</div>
</body>
</html>