<%--
  Created by IntelliJ IDEA.
  User: Afpa
  Date: 20/10/2022
  Time: 09:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>C'est la page suivante</h1>
<jsp:useBean id="imc" class="com.example.imcbean.ImcBean" scope="request"/>

<h1>
    Votre IMC est :  <%= imc.getValue() + " " + imc.getMessage()%>
</h1>

</body>
</html>
