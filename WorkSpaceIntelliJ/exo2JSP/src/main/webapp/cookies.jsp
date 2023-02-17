<%--
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
    Cookie nom = new Cookie("nom",request.getParameter("name"));
    nom.setMaxAge(30);
    response.addCookie(nom);

    Cookie prenom = new Cookie("prenom",request.getParameter("firstName"));
    nom.setMaxAge(30);
    response.addCookie(prenom);

    response.setCharacterEncoding("UTF-8");

%>
<h1>Les cookies ont bien été créés !</h1>

</body>
</html>
