<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String contextPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Test Webservice</title>
</head>
<body>
<p>----CXF----</p>
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
<p>----Jaxws----</p>
<p>
    <a href="<%=contextPath%>/client.do">client</a>
</p>
<p>
    <a href="<%=contextPath%>/client2.do">other Service client</a>
</p>
<p>----Aix----</p>
 <p>
    <a href="<%=contextPath%>/AixToJava.do">aix:调用java </a>
  </p>

<p>----RestEasy----</p>
<p>
    <a href="<%=contextPath%>/resteasyclient.do">HttpURLConnection client</a>
</p>
<p>
    <a href="<%=contextPath%>/resteasyclient2.do">ClientRequest client</a>
</p>
</body>
</html>