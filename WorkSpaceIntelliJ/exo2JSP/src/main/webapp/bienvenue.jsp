<%--
  Created by IntelliJ IDEA.
  User: Afpa
  Date: 19/10/2022
  Time: 08:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

  <%!
    private String getCookie(Cookie[] cookies, String nom) {

      for (Cookie cookie : cookies) {
        if (cookie.getName().equals(nom))
          return cookie.getValue();
      }

      return null;
    }

  %>

</head>
<body>
  <h1>Bonjour <%=getCookie(request.getCookies(),"prenom")+" "+ getCookie(request.getCookies(),"nom").toUpperCase() +" !" %></h1>
</body>
</html>
