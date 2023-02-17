<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Cookies</title>

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

    <%
        if (getCookie(request.getCookies(),"nomCookie") == null)
            request.getRequestDispatcher("inscription.jsp").forward(request,response);
        else
            request.getRequestDispatcher("bienvenue.jsp").forward(request,response);
        %>

</body>
</html>