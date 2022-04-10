<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>board</title>
<link rel="stylesheet" href="${root}/resources/css/style.css" />
</head>
<body>
	<div class="container">
		<h2>게시글 목록</h2>
		<table class="board_list">
			<colgroup>
				<col width="15%" />
				<col width="*" />
				<col width="15%" />
				<col width="20%" />
			</colgroup>
			<thead>
				<tr>
					<th scope="col">글번호</th>
					<th scope="col">제목</th>
					<th scope="col">조회수</th>
					<th scope="col">작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${list != null}">
					<c:forEach var="b" items="${list}">
						<tr>
							<td>${b.boardIdx}</td>
							<td class="title"><a href="/board/openBoardDetail?boardIdx=${b.boardIdx}">${b.title}</a></td>
							<td>${b.hitCnt}</td>
							<td>${b.createdDatetime}</td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${list == null}">
					<tr>
						<td colspan="4">조회된 결과가 없습니다.</td>
					</tr>
				</c:if>
			</tbody>
		</table>
		<a href="/board/openBoardWrite" class="btn">글 쓰기</a>
	</div>
</body>
</html>
