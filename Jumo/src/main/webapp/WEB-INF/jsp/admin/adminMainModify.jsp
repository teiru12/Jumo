<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주모</title>
</head>
<body>
<script>
    $(document).ready(function () {
        if(${not empty result}){
            alert('${result} 파일 저장 성공');
        } else {
            alert('파일 저장 실패');
        }
    })
</script>
</body>
</html>