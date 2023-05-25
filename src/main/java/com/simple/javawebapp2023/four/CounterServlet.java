package com.simple.javawebapp2023.four;

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

@WebServlet(name = "counterServlet", value = "/count")
public class CounterServlet extends HttpServlet {

//    private int counter = 0;

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
            out.println("<h1>Brojač zahtjeva</h1>");
            //Ovdje trebam čuvati informacije o zahtjevima koji dolaze od pojedinačnih korisnika
            HttpSession session = request.getSession();
            UserCounter userCounter = (UserCounter) session.getAttribute("broj_posjeta");
            if(userCounter == null){
                userCounter = new UserCounter();
                session.setAttribute("broj_posjeta", userCounter);
            }
            userCounter.increment();

            ServletContext servletContext = getServletContext();
            ApplicationCount applicationCount = (ApplicationCount) servletContext.getAttribute("ukupan_broj_posjeta");
            if(applicationCount == null){
                applicationCount = new ApplicationCount();
                servletContext.setAttribute("ukupan_broj_posjeta", applicationCount);
            }
            applicationCount.increment();

            out.println("<h3>Ukupan broj posjeta GlassFish: " + applicationCount.getCount() + "</h3>");
            out.println("<h4> Broj posjekta korisnika: " + userCounter.getCount()+"</h4>");
            out.println("</body>");
            out.println("</html>");
        } catch (IOException e) {

        }
    }
}
