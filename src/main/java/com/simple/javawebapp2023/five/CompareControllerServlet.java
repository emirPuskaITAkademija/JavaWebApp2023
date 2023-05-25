package com.simple.javawebapp2023.five;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "compareControllerServlet", value = "/compareNumbers")
public class CompareControllerServlet extends HttpServlet {
    private String resultView;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String prviParam = request.getParameter("prvi");
        String drugiParam = request.getParameter("drugi");
        String resultView;
        try {
            int prviNumber = Integer.parseInt(prviParam);
            int drugiNumber = Integer.parseInt(drugiParam);
            int razlika = prviNumber - drugiNumber;
            if (razlika > 0) {
                resultView = "/veci.jsp";
            } else if (razlika < 0) {
                resultView = "/manji.jsp";
            } else {
                resultView = "/jednak.jsp";
            }
        } catch (Exception e) {
            resultView = "/error.jsp";
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(resultView);
        requestDispatcher.forward(request, response);
    }
}
