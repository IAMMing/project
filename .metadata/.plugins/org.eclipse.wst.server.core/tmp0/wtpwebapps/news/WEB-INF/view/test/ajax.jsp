<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试ajax</title>
</head>
<body>
<%-- <script type="text/javascript" src="<c:url value='/js/jquery-1.8.3.min.js' />"></script> --%>
<script type="text/javascript" src="/static/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
function testAjax()
{
	$.ajax({
		url:"/test/index2",
		type:"post",
		data:"1111",
		success:function(response){
			alert(response);
		}
		
	});
	}
</script>

<a onclick="testAjax()">试一下</a>
</body>
</html>