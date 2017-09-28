<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String contextPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CXF Webservice</title>
</head>
<body>
<p>
    <a href="<%=contextPath%>/DynamicClient.do">DynamicClient</a>
</p>
<p>
    <a href="<%=contextPath%>/ProxyClient.do">ProxyClient</a>
</p>
<p>
    <a href="<%=contextPath%>/DynamicClientFactoryClient.do">DynamicClientFactoryClient</a>
</p>
<p>
    <a href="<%=contextPath%>/StubClient.do">StubClient</a>
</p>
</body>
</html>