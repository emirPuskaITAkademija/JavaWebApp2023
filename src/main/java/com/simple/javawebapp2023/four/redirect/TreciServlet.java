package com.simple.javawebapp2023.four.redirect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "treciServlet", value = "/treciServlet")
public class TreciServlet extends HttpServlet {

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
            out.println("<h2>Ja sam TREĆI </h2>");
            out.println("<h2> Dobro došli "  + request.getParameter("ime")+"</h2>");
            out.println("<a href='forme/index.html'>Ispočetka</a>");
            out.println("</body>");
            out.println("</html>");
        } catch (IOException e) {

        }
    }
}
