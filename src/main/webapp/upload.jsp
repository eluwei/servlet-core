<%--
  Created by IntelliJ IDEA.
  User: hong
  Date: 2017/3/21
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<!--index.html文件部分代码-->
<form action="/servlet-core/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    <input type="submit" name="upload" value="上传">
</form>
</body>
</html>
