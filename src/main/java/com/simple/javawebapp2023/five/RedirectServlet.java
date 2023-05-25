package com.simple.javawebapp2023.five;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "redirectServlet", value = "/redirectServlet")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        request.setAttribute("novoImeParametra", "Neki tekst na nivou REQUEST-a");

        String sesijskiNivo = "Ovo je u sesiju ubačeno";
        HttpSession session = request.getSession();
        session.setAttribute("sesijaAtribut", sesijskiNivo);

        //response.sendRedirect("responsibleServlet");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("responsibleServlet");
        requestDispatcher.forward(request, response);
    }
}
