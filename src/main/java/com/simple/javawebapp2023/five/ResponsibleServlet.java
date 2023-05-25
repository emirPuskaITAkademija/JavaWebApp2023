package com.simple.javawebapp2023.five;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responsibleServlet", value = "/responsibleServlet")
public class ResponsibleServlet extends HttpServlet {
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
            out.println("<h1>JA SAM ODGOVORAN</h1>");

            String tekstAttribute =(String) request.getAttribute("novoImeParametra");
            out.println("<h2>DOŠLO IZ REDIRECT servlet : "+tekstAttribute+ "/h2>");
            String tekst = request.getParameter("novoImeParametra");
            out.println("<h2>DOŠLO IZ FORME kao parametar: "+tekst+ "/h2>");

            HttpSession session = request.getSession();
            out.println("<h2>DOŠLO IZ SESIJE: "+session.getAttribute("sesijaAtribut")+ "/h2>");

            out.println("</body>");
            out.println("</html>");
        } catch (IOException e) {

        }
    }
}
