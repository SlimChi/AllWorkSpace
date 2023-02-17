<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="form.css">
</head>
<body>
<form method="get" action="bienvenue.jsp">
    <p id="idendif">Identification</p>
    <p class="label">Nom    : <input type="text" name="nom" class="input"/></p>
    <p class="label">Prénom : <input type="text" name="prenom" class="input"/></p>
    <input type="submit" value="Valider" />
</form>
</body>
</html>