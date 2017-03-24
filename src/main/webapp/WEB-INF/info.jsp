<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<body>
<h2>Hello World!</h2>
<%--ServletContext context = req.getServletContext();
context.setAttribute("name",name);
context.setAttribute("url",url);
context.setAttribute("contextPath",contextPath);
context.setAttribute("servletPath",servletPath);
context.setAttribute("requestURI",requestURI);--%>
name : ${name}<br/>
url : ${url}<br/>
contextPath : ${contextPath}<br/>
servletPath : ${servletPath}<br/>
requestURI : ${requestURI}<br/>
</body>
</html>
