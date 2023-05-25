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
import java.util.ArrayList;

@WebServlet(name = "shoppingCartServlet", value = "/prikazKorpe")
public class ShoppingCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter();) {
            out.println("<html>");
            out.println("<head><title>Prikaz artikala u korpi</title></head>");
            out.println("<body bgcolor='#FDF5E6'>");
            HttpSession session = request.getSession();
            ArrayList<String> prethodniProizvodi = (ArrayList<String>) session.getAttribute("artikliKorpe");
            if(prethodniProizvodi == null){
                prethodniProizvodi = new ArrayList<>();
                session.setAttribute("artikliKorpe", prethodniProizvodi);
            }
            String noviProizvod = request.getParameter("noviProizvod");
            if(noviProizvod != null && !noviProizvod.isBlank()){
                prethodniProizvodi.add(noviProizvod);
            }
            out.println(noviProizvod.isEmpty() ? "<h1>Nema artikala u korpi</h1>":"<h1>Artikli u korpi</h1>");
            if(!noviProizvod.isEmpty()){
                out.println("<ul>");
                for(String proizvod: prethodniProizvodi){
                    out.println("<li>"+proizvod+"</li>");
                }
                out.println("</ul>");
            }
            out.println("<br/>");
            out.println("<a href='ekorpa.html'> Nazad na kupovinu </a>");
            out.println("</body>");
            out.println("</html>");
        } catch (IOException e) {

        }
    }
}
