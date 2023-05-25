package com.simple.javawebapp2023.five.login;

import com.simple.javawebapp2023.five.connection.ConnectionPool;
import com.simple.javawebapp2023.five.connection.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet -> klasa -> kreiranje objekta po njenom
 * <p>
 *     GlassFish, Tomcat .... objekat loginServlet
 * </p>
 * <p>
 *      Browser -> http get request htt...base_url/login-servlet
 *     loginServlet.doGet() , doPost
 * </p>
 */
@WebServlet(name = "loginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        //instancirao ConnectionPool -> otvarale konekcije
        ConnectionPool.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);
    }

    @Override
    public void destroy() {
        super.destroy();
        ConnectionPool.close();
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username, password);
        session.setAttribute("user", user);
        String poruka;
        if(username.isBlank() ||password.isBlank()){
            poruka = "Niste unijeli username ili password";
            request.setAttribute("poruka", poruka);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        }
        Connection connection = ConnectionPool.getInstance().getConnection();
        //password -> hashirati i onda provjeravati
        try{
            String sqlQuery = "SELECT * FROM user WHERE username=? AND password=?";
            PreparedStatement ps = connection.prepareStatement(sqlQuery);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                user.setName(name);
                user.setSurname(surname);
                request.setAttribute("poruka", String.format("Korisnik %s %s", user.getName(), user.getSurname()));
                RequestDispatcher dispatcher = request.getRequestDispatcher("/prikaz2.jsp");
                dispatcher.forward(request, response);
            }else{
                poruka = "Neispravna kombinacija korisničkog imena i lozinke";
                request.setAttribute("poruka", poruka);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
                dispatcher.forward(request, response);
            }
        }catch (SQLException exception){
            session.invalidate();
            String errorMessage = exception.getMessage();
            request.setAttribute("errorMessage", errorMessage);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
            dispatcher.forward(request, response);
        }finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
    }
}
