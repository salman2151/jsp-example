package com.bloggingapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bloggingapp.dao.LoginDao;
import com.bloggingapp.dto.LoginDto;


@WebServlet("/login") // mapper with login, as url pattern as we are not using web.xml or deployment descriptor, that why we are using @WebServlet to define Servlet
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoginDao loginDao;

    public void init() {
        loginDao = new LoginDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        LoginDto logindto = new LoginDto();
        logindto.setEmail(email);
        logindto.setPassword(password);

        try {
            if (loginDao.validate(logindto)) {
                response.sendRedirect("home.jsp");
            } else {
            	PrintWriter printWriter = response.getWriter();
            	printWriter.println("<script type=\"text/javascript\">");
            	printWriter.println("alert('User or password incorrect');");
            	printWriter.println("location='login.jsp';");
            	printWriter.println("</script>");
            	
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}