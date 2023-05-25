package com.simple.javawebapp2023;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 * <li>1. extends HttpServlet</li>
 * <li>2. @  anotation based configuration</li>
 */
@WebServlet(name = "second", value = "/drugi")
public class SecondServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = response.getWriter()){
            out.println("<html>");
            out.println("<head><title>Naslov DRUGOG Servleta</title></head>");
            out.println("<body>");
            out.println("<h1>Pozdrav iz DRUGOG servleta</h1>");
            out.println("<p>" + LocalDateTime.now()+"</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
