package fr.cs.exerciceimcjee;

import fr.cs.exerciceimcjee.metier.Imc;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "imcServlet", value = "/imc-servlet")
public class ImcServlet extends HttpServlet {


    public void init() {
        ServletContext context = getServletContext();
        }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Imc imc  = new Imc(request.getParameter("taille"),(request.getParameter("poids")));
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + getServletContext().getInitParameter("titre") + "<h1>");
        out.println("<h1>" +"votre imc est : "+"</h1>");
        out.println("<h1>"+ imc.getImc()+"</h1>");
        out.println("<h2>" +imc.calculRange()+"</h2>");
        out.println("</body></html>");

        request.getServletContext();

    }
}
