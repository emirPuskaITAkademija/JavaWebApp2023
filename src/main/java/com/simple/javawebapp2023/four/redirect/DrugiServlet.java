package com.simple.javawebapp2023.four.redirect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
// /drugiServlet  ->
@WebServlet(name = "drugiServlet", value = "/drugiServlet")
public class DrugiServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter();) {
            out.println("<html>");
            out.println("<head><title>Analiza HTTP request zaglavlja</title></head>");
            out.println("<body>");
            out.println("<h2>Ja sam DRUGI </h2>");
            out.println("<form action='treciServlet'>");
            out.println("Unesite ime: <input type='text' name='ime'/>");
            out.println("<input type='submit' value='Gađaj treći'/>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        } catch (IOException e) {

        }
    }
}
