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
    <link rel="stylesheet" href="page1.css">
</head>
<body>

<jsp:useBean id="entreprise" class="com.example.entreprisebean.EntrepriseBean" scope="request"/>


<div class="container">
    <h2>Entreprise SIREN</h2>
    <ul class="responsive-table">
        <li class="table-header">
            <div class="col col-1">N° SIREN</div>
            <div class="col col-2" id="col-2">Raison Sociale</div>
            <div class="col col-3">Adresse</div>
            <div class="col col-4">Code postal</div>
            <div class="col col-5">Ville</div>
        </li>
        <li class="table-row">
            <div class="col col-1" data-label="Job Id"><%= entreprise.getSiren() %></div>
            <div class="col col-2" id="col2" data-label="Customer Name"><%= entreprise.getrSociale()%></div>
            <div class="col col-3" data-label="Amount"><%= entreprise.getAdresse()%></div>
            <div class="col col-4" data-label="Payment Status"><%= entreprise.getCodePostal() %></div>
            <div class="col col-5" data-label="Payment Status"><%= entreprise.getVille()%></div>
        </li>

    </ul>
</div>

</body>
</html>
