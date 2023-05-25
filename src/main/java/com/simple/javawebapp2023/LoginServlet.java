package com.simple.javawebapp2023;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("korime");
        String password = request.getParameter("lozinka");
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<body>");
            out.println("<head><title>LOGIN servlet</title></head>");
            if ("admin".equals(username) && "admin".equals(password)) {
                out.println("<h1>USPJEŠNO</h1>");
                out.println("<p>" + LocalDateTime.now() + "</p>");
            }else{
                out.println("<h1>NEUSPJEŠNO</h1>");
                out.println("<p>" + LocalDateTime.now() + "</p>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }
}
