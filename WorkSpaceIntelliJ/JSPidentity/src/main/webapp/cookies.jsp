<%@ page import="com.example.jspidentity.Identity" %><%--
  Created by IntelliJ IDEA.
  User: Afpa
  Date: 19/10/2022
  Time: 09:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String prenom=request.getParameter("prenom");
    Identity identity= new Identity(request.getParameter("prenom"),request.getParameter("nom"));
    Cookie unCookie = new Cookie("nomCookie",identity.toString());
    unCookie.setMaxAge(30);

    response.addCookie(unCookie);

%>
<h1>Les cookies ont bien été créés ! </h1>

</body>
</html>
