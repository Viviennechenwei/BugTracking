<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html"; charset=utf-8 >
    <title>Hello World</title>
</head>
<body>
<form action="loginSubmit" method="post">
    用户名：<input type="text" name="loginId" value="root"/><br/>
    密码：<input type="password" name="password" value="root"/>
    <input type="submit" value="登陆"/>
    <a href="regist">注册</a>
</form>
</body>
</html>