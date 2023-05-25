package com.simple.javawebapp2023;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Random;

@WebServlet(name = "passwordGeneratorServlet", value = "/generate")
public class PasswordGeneratorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handlePasswordGeneration(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handlePasswordGeneration(req, resp);
    }

    private void handlePasswordGeneration(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head><title>Password Generation</title></head>");
            out.println("<body>");
            out.println("<h1>Generator lozinki</h1>");
            out.println("<h3>" + generatePassword() + "</h3>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private String generatePassword() {
        Random random = new Random();
        String possibleChars = "abcdefghjrkljmnopqe12345678!?*";
        int passwordLength = 5 + random.nextInt(11);// između 5 i 15
        StringBuilder lozinkaContent = new StringBuilder();
        for(int i = 0; i<passwordLength; i++){
            int slucajnaPozicija = random.nextInt(possibleChars.length());
            char slucajniKarakter = possibleChars.charAt(slucajnaPozicija);
            lozinkaContent.append(slucajniKarakter);
        }
        return lozinkaContent.toString();
    }
}
