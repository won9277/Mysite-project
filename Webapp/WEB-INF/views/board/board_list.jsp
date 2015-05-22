<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fn"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite2/assets/css/board.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div id="container">
		<div id="header">
			<c:import url="/WEB-INF/views/include/header.jsp" />
		</div>
		<div id="content">
			<div id="board">
				<form id="search_form" action="/mysite2/board" method="post">
					<input type="text" id="kwd" name="kwd" value="">
					<input type="submit" value="찾기">
				</form>
				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>&nbsp;</th>
					</tr>
					
					<c:forEach items="${list }" var="vo">		
					<tr>
						<td>${vo.no}</td>
						<td><a href="/mysite2/board/board_detail/${vo.no }">${vo.title }</a></td>
						<td>${vo.member_name }</td>
						<td>${vo.view_cnt}</td>
						<td>${vo.reg_date }</td>
						<td>
						<c:if test="${authMember.no==vo.member_no}">
							<a href="/mysite2/board/delete/${vo.no }" id="del">삭제</a>
						</c:if>
						
						</td>
					</tr>
					</c:forEach>										
				</table>
				<div class="bottom">
				<c:if test="${authMember.no!=null}">
					<a href="/mysite2/board/board_write/" id="new-book">글쓰기</a>
				</c:if>
				</div>			
							
			</div>
		</div>


		<div id="navigation">
			<c:import url="/WEB-INF/views/include/navigation.jsp">
				<c:param name="type" value="main"></c:param>
			</c:import>
		</div>
		<div id="footer">
			<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
		</div>
	</div>
</body>
</html>