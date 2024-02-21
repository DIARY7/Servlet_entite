package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utilitaire.Traitement;

@WebServlet(name = "traite-login", urlPatterns = {"/traite-login"})
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //Tokony mampiasa cookie
        try {
            Traitement.checkLogin(req.getParameter("login"),req.getParameter("mdp"));
            res.sendRedirect("ClientServlet?action=read");
        } catch (Exception e) {
            // TODO: handle exception
            res.sendRedirect("page/login.jsp?erreur=1");
        }
        
    }    

}
