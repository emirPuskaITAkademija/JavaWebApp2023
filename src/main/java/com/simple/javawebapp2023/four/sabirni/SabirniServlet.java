package com.simple.javawebapp2023.four.sabirni;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "sabirniServlet", value = "/saberi")
public class SabirniServlet extends HttpServlet {
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
            out.println("<head><title>Sabira iz računovodstva</title></head>");
            out.println("<body>");
            String prvi = request.getParameter("sabirak1");
            String drugi = request.getParameter("sabirak2");
            Integer suma = Integer.parseInt(prvi)+Integer.parseInt(drugi);
            out.println("<h1> SUMA = " + suma+" </h1>");
            out.println("</body>");
            out.println("</html>");
        } catch (IOException e) {

        }
    }
}
