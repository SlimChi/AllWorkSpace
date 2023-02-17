package com.example.exo2jsp;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class AccueilServlet extends HttpServlet {

    private String titre;
    public void init() {
        ServletContext context = getServletContext();



    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        process(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");



    }
    public void destroy() {
    }
}