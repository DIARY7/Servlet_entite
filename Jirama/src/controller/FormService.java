package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Region;
import model.Service;

@WebServlet(name = "form-service", urlPatterns = {"/form-service"})
public class FormService extends HttpServlet {
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
                
        RequestDispatcher dispat = req.getRequestDispatcher("form/form-service.jsp");
        dispat.forward(req,res);
    }
    private void prepareForUpdate(HttpServletRequest req, HttpServletResponse res) throws Exception {
        Service service = Service.getById(req.getParameter("id"));
        req.setAttribute("service", service);
        prepareForInsert(req, res);
    }
    
}
