<%--
  Created by IntelliJ IDEA.
  User: Afpa
  Date: 19/10/2022
  Time: 09:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="form.css">
</head>
<body>
<form method="get" action="cookies.jsp">
    <p id="idendif">Inscription</p>
    <div>
        <label for="nom">Nom :</label>
        <input type="text" id="nom" name="nom">
    </div>
    <div>
        <label for="prenom">Prénom :</label>
        <input type="text" id="prenom" name="prenom">
    </div>
    <div class="container">
    <input type="submit" value="Valider" class="button"/>
    </div>
</form>
</body>
</html>
