<%@page import="vo.ReVo"%>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="master/header.jsp"/>

<section>
		<div class="container">
			<p class="title">예약자명단</p>
<%
	ArrayList<ReVo> list = (ArrayList<ReVo>)request.getAttribute("list");
	if(!list.isEmpty()) {
%>		

	<table>
		<tr>
			<td>예약코드</td>
			<td>전화번호</td>
			<td>예약날짜</td>
			<td>예약시간</td>
			<td>인원</td>
			<td>코스요리</td>
			<td>가격</td>
			<td>예약취소</td>
		</tr>
		
<%
	for(ReVo re : list) {
		request.setAttribute("re", re);
%>			
	<tr>
				<td><a href="/cosUpdate?re_code=${re.re_code}&re_phone=${re_phone}">${re.re_code }</a></td>
				<td>${re.re_phone }</td>
				<td>${re.re_date }</td>
				<td>${re.re_time }</td>
				<td>${re.re_person }</td>
				<td>${re.cos_code }</td>
				<td>${re.cos_price }</td>
				<td><a href="/cosDelete?re_code=${re.re_code }">취소</a></td>														
	</tr>
<%
	}
%>						
	</table>
<%
	}else{
%>		
	<p style="text-align: center"> 등록된 회원 정보가 없습니다</p>
<%
	}
%>
		</div>
</section>


<jsp:include page ="master/footer.jsp"/>