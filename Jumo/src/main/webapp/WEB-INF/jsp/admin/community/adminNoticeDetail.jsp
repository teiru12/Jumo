<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주모</title>
</head>
<br>
	<div style="text-align:center">
 		<h3>공지 내용</h3>
	</div> 		
  	    <br>
  		<!-- 공지사항 부분 -->
		<div style="text-align:center" id="noticeDetail" >
    	<table id="noticeDetail" action="adminNoticeDelete.al" width="70%" border="1" cellpadding="5" bordercolor="lightgray" frame="void" align="center" > 
		<tbody>
			<tr></tr>
			<tr>
				<td colspan="1" bgcolor="gainsboro">작성자</td>
				<td colspan="3" bgcolor="gainsboro">${noticeBean.CWRITER}</td>
			</tr>
			<tr>
				<td>제목</td>
				<td width="50%">${noticeBean.CTITLE}</td>
				<td>날짜</td>
				<td width="*%">${noticeBean.CDATE}</td>
			</tr>
			
			<tr>
				<td colspan="1"><br>글 내용</td>
				<td colspan="3"><br>${noticeBean.CCONTENT}</td>
			</tr>

		</tbody>
		</table>
</div>
<br>
<hr width="70%" bordercolor="lightgray">

<style>
#test_btn1{ border-top-left-radius: 5px; border-bottom-left-radius: 5px; margin-right:-4px; }
#test_btn2{ border-top-left-radius: 5px; border-bottom-left-radius: 5px; margin-right:-4px; }
#btn_group button{ border: 1px solid skyblue; background-color: rgba(0,0,0,0); color: skyblue; padding: 5px; }
#btn_group button:hover{ color:white; background-color: skyblue; }
</style>
<p style="text-align:center;" id="btn_group">
<button id="test_btn1"  onclick="location.href='adminNoticeModifyForm.al?CIDX=${noticeBean.CIDX}'">수정</button>
<button id="test_btn2"  onclick="location.href='adminNoticeDelete.al?CIDX=${noticeBean.CIDX}'">삭제</button>
</p>
</body>
</html>