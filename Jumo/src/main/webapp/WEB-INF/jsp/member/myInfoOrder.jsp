<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주모</title>
</head>

	<br>
    <div style="text-align:center">
      <h3>주문내역</h3>
    </div>
    <br>
 
      <!--주문 목록 부분 -->
      <div style="text-align:center" id="board">
    	<table id="order" width="60%" border="1" bordercolor="darkgray" align="center" > 
			
    	<thead> 
    		<tr bgcolor="gainsboro"> 
    			<th scope="col">주문번호</th>
    			<th scope="col">운송장번호</th> 
    			<th scope="col">상품명/수량</th> 
    			<th scope="col">가격</th>
    			<th scope="col">상태</th> 
    		</tr> 
    	</thead>
     
    <tbody> 
    <c:choose> 
    	<c:when test="${orderCount!=0}"> 
    		<c:forEach var="order" items="${orderBeanList}" varStatus="status"> 
    		
    	<tr> 
    		<td>${order.OID}</td> 
    		<td>${order.OWAYBILL}</td>
   			<td>${order.OPRODUCT} / ${order.OCOUNT}</td> 
   			<td>${order.OTOTAL}</td> 
   			<td>${order.OSTATUS}</td>  
    	</tr> 
    </c:forEach>
    </c:when>
    
    <c:otherwise> 
   		<tr>
			<td colspan="5">주문한 상품이 없습니다.</td> 
		</tr>
	</c:otherwise>
	
	</c:choose> 
	</tbody> 
		</table>
</div>

<br>

</body>
</html>