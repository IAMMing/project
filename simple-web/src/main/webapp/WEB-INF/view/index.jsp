<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎来到首页</title>
<script src="./static/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="./static/md5.js"></script>
<script type="text/javascript" src="./static/ValidHelper.js"></script>
<script type="text/javascript" src="./static/jquery.request.js"></script>
</head>
<body>
	首页原始加载<br>
	<a onclick="test()">测试验证加载</a>
	<script type="text/javascript">
		function test() {
			$.request({
				url : '/news/auth',
				data : {
					r : '10001',
					paaa:'aaa'
				},
				type : 'post',
				success : function(response) {
					alert(response.name);
				}
			});
		}
	</script>
</body>
</html>