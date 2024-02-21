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
import model.Region;

@WebServlet(name = "form-region", urlPatterns = {"/form-region"})
public class FormRegion extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
         PrintWriter out = res.getWriter();
        try {
            if (req.getParameter("action")!=null) {
                prepareForUpdate(req, res);
            }
            else{
                prepareForInsert(req, res);
            }
        } catch (Exception e) {
            // TODO: handle exception
            out.println(e);
        }       
    }
    private void prepareForInsert(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        RequestDispatcher dispat = req.getRequestDispatcher("form/form-region.jsp");
        dispat.forward(req,res);
    }
    private void prepareForUpdate(HttpServletRequest req, HttpServletResponse res) throws Exception {
        Region region = Region.getById(req.getParameter("id"));
        req.setAttribute("region", region);
        prepareForInsert(req, res);
    }
    
}
