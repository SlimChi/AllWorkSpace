package com.example.newprojectjee;

import java.io.*;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    private String titre;
    public void init() {
        ServletContext context = getServletContext();



    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        response.setContentType("text/html");

        Cookie nom = new Cookie("nom","nom");
        response.addCookie(nom);

        PrintWriter out = response.getWriter();
        ServletConfig config = getServletConfig();
        titre = config.getInitParameter("titre");
        request.getServletContext();

        out.println("<html><body>");
        out.println("<h1>"+titre+"</h1>");

        out.println("<h1>Bienvenue " + " " + request.getParameter("prenom")+" "+ request.getParameter("nom").toUpperCase()+ " "+ "! </h1>");
        out.println("</body></html>");
    }
    public void destroy() {
    }
}