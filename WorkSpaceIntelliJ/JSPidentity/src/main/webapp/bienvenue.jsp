<%@ page import="com.example.jspidentity.Identity" %><%--
  Created by IntelliJ IDEA.
  User: Afpa
  Date: 19/10/2022
  Time: 08:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        Cookie[] cookies = request.getCookies();
        String nom = "";
        String prenom = "";
        Identity identity = new Identity();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("nomCookie")) {
                identity = identity.identityFromString(cookie.getValue());
                prenom = identity.getPrenom();
                nom = identity.getNom();

            }
        }
    %>

</head>
<body>

<h1>Bonjour <%=prenom + " " + nom.toUpperCase()+ " !" %>
</h1>
</body>
</html>
