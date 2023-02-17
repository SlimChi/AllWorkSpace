<%@ page import="java.util.Map" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="form.css">
</head>
<body>
<jsp:useBean id="entreprise" class="com.example.entreprisebean.EntrepriseBean" scope="request">
    <jsp:setProperty name="entreprise" property="*"/>
</jsp:useBean>
<% if (entreprise.validate()) {%>
<jsp:forward page="pageSuivante.jsp"/>
<%
    }
    Map errors = entreprise.getErrors();
%>
<form method="POST" action="index.jsp">
    <h2>EntrepriseBean</h2>
    <div>
        <label for="siren">SIREN : </label>
        <input type="text" id="siren" name="siren" class="siren"
               value="<jsp:getProperty name="entreprise" property="siren"/>">
        <div class="erreur">
            <%=(errors.get("siren") == null) ? " " : (String) errors.get("siren")%>
        </div>
    </div>
    <div>
        <label for="rSociale">Raison sociale : </label>
        <input type="text" id="rSociale" name="rSociale" class="rSociale"
               value="<jsp:getProperty name="entreprise" property="rSociale"/>">
        <div class="erreur">
            <%=(errors.get("rSociale") == null) ? " " : (String) errors.get("rSociale")%>
        </div>
    </div>
    <div>
        <label for="adresse">Adresse : </label>
        <input type="text" id="adresse" name="adresse" class="adresse"
               value="<jsp:getProperty name="entreprise" property="adresse"/>">
        <div class="erreur">
            <%=(errors.get("adresse") == null) ? " " : (String) errors.get("adresse")%>
        </div>
    </div>
    <div>
        <label for="codePostal">Code Postal : </label>
        <input type="text" id="codePostal" name="codePostal" class="codePostal"
               value="<jsp:getProperty name="entreprise" property="codePostal"/>">
        <div class="erreur">
            <%=(errors.get("codePostal") == null) ? " " : (String) errors.get("codePostal")%>
        </div>
    </div>
    <div>
        <label for="ville">Ville : </label>
        <input type="text" id="ville" name="ville" class="ville"
               value="<jsp:getProperty name="entreprise" property="ville"/>">
        <div class="erreur">
            <%=(errors.get("ville") == null) ? " " : (String) errors.get("ville")%>
        </div>
    </div>
    <input type="hidden" id="cpt" name="cpt" value="<jsp:getProperty name="entreprise" property="cpt"/>">
    <input type="submit" value="Valider" class="button"/>
</form>

</body>
</html>