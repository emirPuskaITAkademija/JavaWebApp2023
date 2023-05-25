package com.simple.javawebapp2023.four;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Kad startamo app na GlassFish.
 *
 * <p>
 *     GlassFish kreira po šablonu ove klase {@link HttpAttributeServlet}
 *     objekat i taj objekat živi unutar Servlet Container.
 * </p>
 *
 */
@WebServlet(name = "atributObjekat", value = "/atributi")
public class HttpAttributeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Analiza HTTP request zaglavlja</title></head>");
        out.println("<body>");
        out.println("<h1>Analiza request objekta</h1>");
        out.println("<h2>" + request.getContextPath()+"</h2>");
        Enumeration<String> headerNames =  request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            out.println("<p>" + headerName+" : " + headerValue+"</p>");
        }
        out.println("</body>");
        out.println("</html>");
    }
}
