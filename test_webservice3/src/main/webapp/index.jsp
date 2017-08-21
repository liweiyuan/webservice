<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%
    String contextPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<p>----jersey(sun) RestWebservice----</p>
<p>
    <a href="<%=contextPath%>/jerseyclient2.do">jersey(glassfish)</a>
</p>
<p>----resteasy3 ----</p>
<p> <a href="<%=contextPath%>/resteasy3client2.do">ResteasyClient client</a></p>

<p>----resteasy3 ----</p>
<p> <a href="<%=contextPath%>/Client.do">ResteasyClient client</a></p>

</body>
</html>