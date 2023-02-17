<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - IMC</title>
    <link rel="stylesheet" href="form.css">
</head>
<body>

<form method="POST" action="imc-servlet">
    <p id="imc">Calcul IMC</p>
      <div>
        <label for="poids">Poids en Kg   :</label>
        <input type="text" id="poids" name="poids">
    </div>
    <div>
        <label for="taille">Taille en cm :</label>
        <input type="text" id="taille" name="taille">
    </div>
    <input type="submit" value="Valider" />
</form>
</body>
</html>