<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주모</title>
</head>
<body>
memberList.jsp
<h3> 회원정보 </h3>
	<form action="memberList.al" method="get"> <%-- <c:if test="${condition eq 'titlename' }">selected</c:if>	 --%>
		<label for="condition">검색조건</label>
		<select name="condition" id="condition">
			<option value="titlename" <c:if test="${memberBean eq 'EMAIL' }">selected</c:if>>이메일</option>
			<option value="title" <c:if test="${memberBean eq 'NAME' }">selected</c:if>>이름</option>
			<option value="writer" <c:if test="${memberBean eq 'RANK' }">selected</c:if>>랭크</option>
		</select>
		<input type="text" name="keyword" id="keyword"
			placeholder="검색어 ..." value="${keyword }"/>
		<button type="submit">검색</button>
	</form><!-- condition이라는 파라미터 명으로 넘어간다. -->


<div id=title  align="center" >
	<h2> 회원정보 </h2>
</div>
	<div  align="center" >
<table id =table2  border=1 > 
	<tr>
		<td>랭크</td>
		<td>이메일</td>
		<td>이름</td>
		<td>전화번호</td>
		<td>핸드폰번호</td>
		<td>주소</td>
	</tr>
<c:forEach var="member" items="${memberBeanList}"> 
    <tr> 
    	<td><a href="memberDetail.al">${member.RANK}</a></td>
    	<td><a href="memberDetail.al">${member.EMAIL}</a></td>
    	<td><a href="memberDetail.al">${member.NAME}</a></td>
    	<td><a href="memberDetail.al">${member.PHONE}</a></td> 
    	<td><a href="memberDetail.al">${member.MOBILE}</a></td>
   		<td><a href="memberDetail.al">${member.ADDRESS1} / ${member.ADDRESS2}</a></td>   		
   	</tr>  
</c:forEach>
</table>
</div>

<br>
<a href="/Jumo/memberDetail.al">회원이메일 클릭 - 회원정보</a><br>
</body>
</html>