package com.simple.javawebapp2023.four.pozdrav;

import com.simple.javawebapp2023.four.model.ApplicationCount;
import com.simple.javawebapp2023.four.model.UserCounter;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.ZoneId;


@WebServlet(name = "greetingServlet", value = "/pozdrav")
public class GreetingServlet extends HttpServlet {
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
            out.println("<head><title>Pozdravni</title></head>");
            out.println("<body>");
            String name = request.getParameter("ime");
            String surname = request.getParameter("prezime");
            out.println("<h1> Dobro veče '" + name+" " +surname+"'</h1>" );
            out.println("</body>");
            out.println("</html>");
        } catch (IOException e) {

        }
    }

}
