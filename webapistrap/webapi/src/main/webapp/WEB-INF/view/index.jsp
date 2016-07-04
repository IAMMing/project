<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎使用WebApiStrap</title>
</head>
<script src="./static/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="./static/md5.js"></script>
<script type="text/javascript" src="./static/ValidHelper.js"></script>
<script type="text/javascript" src="./static/jquery.request.js"></script>
<style>
p{
text-indent: 2em;
}
.p{
text-indent: 2em;
}
</style>
<body>
<h1>欢迎使用WebApiStrap</h1>
<p>当前版本是<b>0.0.1-SNAPSHOT</b>只为一个雏形版本，目的是为了学习和提高自己对框架的认知。</p>
<p>在这个示例版本中简单的实现了，动态身份验证和访问入口的统一。距离实际的生产环境还有一段很远的路要走。</p>
<h3>实现功能</h3>
<hr>
<ol>
	<li>请求的统一入口控制</li>
	<li>身份认证的实现</li>
</ol>
<h3>遇到的问题</h3>
<hr>
<ol>
	<li>forward转发的时候，参数需要进行调整（需要抛出命令和验证参数，只留下对action有效的参数）<br>
	<span class="p"><b>替代方案</b>：整个命令参数传递过去</span>
	</li>
	<li>参数有效进入最终处理action的时候能否进行对象绑定装载（pojo）在js中对实际参数进行处理，影响到最终的对象装载<br>
	<span class="p"><b>替代方案</b>：在具体action中把json串重新反序列为对象</span>
	</li>
</ol>
<h3>ajax请求示例</h3>
<hr>
<a onclick="test()">测试验证加载</a>
	<script type="text/javascript">
		function test() {
			$.request({
				url : '/webapi/',
				data : {
					r : '10001',
					paaa:'aaa'
				},
				type : 'post',
				success : function(response) {
					alert(JSON.stringify(response));
				}
			});
		}
	</script>
</body>
</html>