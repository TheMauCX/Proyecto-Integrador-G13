/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package pe.edu.upeu.oracle.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.upeu.oracle.dao.RolDao;
import pe.edu.upeu.oracle.daoImpl.RolDaoImpl;
import pe.edu.upeu.oracle.entity.RolEntity;

/**
 *
 * @author USER
 */
@WebServlet(name = "RolController", urlPatterns = {"/rol"})
public class RolController extends HttpServlet {

    private RolDao rolDao = new RolDaoImpl();
    private Gson g = new Gson();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int opcion = Integer.parseInt(request.getParameter("opc"));
        switch (opcion) {
            case 1 ->
                out.println(g.toJson(rolDao.readAllRol()));
            case 2 ->
                out.println(rolDao.createRol(new RolEntity(0, request.getParameter("rol"), "A")));
            case 3 ->
                out.println(rolDao.deleteRol(Integer.parseInt(request.getParameter("id"))));
            case 4 ->
                out.println(g.toJson(rolDao.readRol(Integer.parseInt(request.getParameter("id")))));
            case 5 -> {
                int id = Integer.parseInt(request.getParameter("id"));
                String nombre = request.getParameter("rol");
                String estado = request.getParameter("estado");
                RolEntity updatedRol = new RolEntity(id, nombre, estado);
                System.out.println("Updating rol: " + updatedRol); // Log para depuración
                out.println(rolDao.updateRol(updatedRol));
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
