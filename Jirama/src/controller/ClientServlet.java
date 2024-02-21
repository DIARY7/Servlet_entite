package controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Client;

@WebServlet(name = "ClientServlet", urlPatterns = {"/ClientServlet"})
public class ClientServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        try {
            if (req.getParameter("action").compareTo("read") == 0) {
                read(req, res);
            }
            else if (req.getParameter("action").compareTo("delete") == 0) {
                try {
                    delete(req, res);  //Exception lors d'une suppression d'une clé etrangère                      
                } catch (Exception e) {
                    req.setAttribute("erreur",e.getMessage());
                }
                read(req, res);
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.print(e);
        }
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        try {
            if (req.getParameter("action").compareTo("create") == 0) {
                insert(req, res);
            }
            else if (req.getParameter("action").compareTo("update") == 0) {
                update(req, res);             
            }
        } catch (Exception e) {
            // TODO: handle exception
            out.println(e);
        }
    }
    private void read(HttpServletRequest req, HttpServletResponse res) throws Exception {
        Vector v = Client.getAll();
        req.setAttribute("client", v);
        RequestDispatcher dispat = req.getRequestDispatcher("page/client.jsp");
        dispat.forward(req,res);
    }
    private void delete(HttpServletRequest req, HttpServletResponse res) throws Exception {
        Client.delete( req.getParameter("id"));
    }
    private void insert(HttpServletRequest req, HttpServletResponse res) throws Exception {
        Client.insert(req.getParameter("nom"), req.getParameter("idRegion"));
        res.sendRedirect("ClientServlet?action=read");
    }
    private void update(HttpServletRequest req, HttpServletResponse res) throws Exception {
        Client.update(req.getParameter("id"), req.getParameter("nom"), req.getParameter("idRegion"));
        res.sendRedirect("ClientServlet?action=read");
    }
}
