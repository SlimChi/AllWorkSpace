package fr.cs.javajstl.servlet;

import java.io.*;

import fr.cs.javajstl.bean.CompetencesBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;


@WebServlet(name = "ControlleurServlet", urlPatterns = "/action")
public class ControlleurServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");

        CompetencesBean competencesBean = new CompetencesBean();
        competencesBean.setNom(request.getParameter("nom"));
        competencesBean.setCompetencesMaitrisees(request.getParameterValues("notionJava"));
        request.setAttribute("competencesBean", competencesBean);
        request.getRequestDispatcher("bilan.jsp").forward(request,response);
    }

}