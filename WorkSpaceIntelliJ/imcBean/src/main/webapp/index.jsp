<%@ page import="java.util.Map" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="form.css">
</head>
<body>
<jsp:useBean id="imc" class="com.example.imcbean.ImcBean" scope="request">
    <jsp:setProperty name="imc" property="*"/>
</jsp:useBean>
<% if (imc.validate()) {%>
<jsp:forward page="pageSuivante.jsp"/>
<%
    }
    Map errors = imc.getErrors();
%>
<form method="POST" action="index.jsp">
    <p id="imc">Calcule IMC</p>
    <div>
        <label for="taille">Taille en cm : </label>
        <input type="text" id="taille" name="taille" class="taille"
               value="<jsp:getProperty name="imc" property="taille"/>">
        <div>
            <%=(errors.get("taille") == null) ? " " : (String) errors.get("taille")%>
        </div>

    </div>
    <div>
        <label for="poids">Poids en Kg : </label><br>
        <input type="text" id="poids" name="poids" class="poids"
               value="<jsp:getProperty name="imc" property="poids" />">
        <div>
            <%=(errors.get("poids") == null) ? " " : (String) errors.get("poids")%>
        </div>

    </div>
    <input type="submit" value="Valider"/>
</form>
</body>
</html>