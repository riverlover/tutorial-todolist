<html>
<body>
<h2>Hello World!</h2>
</body>

<%
String ok = "ok";
pageContext.setAttribute("ok", ok);

%>

${pageScope.ok}
</html>
