<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form action="go7" method="post" enctype="multipart/form-data">
 姓名：<input type="text" name="uname">
  年龄：<input type="text" name="age">
  头像：<input type="file" name="headimage">
  <input type="submit" value="注册">
 </form>
</body>
</html>