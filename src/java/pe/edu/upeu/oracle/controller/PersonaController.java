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
import pe.edu.upeu.oracle.dao.PersonaDao;
import pe.edu.upeu.oracle.daoImpl.PersonaDaoImpl;
import pe.edu.upeu.oracle.entity.PersonaEntity;

/**
 *
 * @author USER
 */
@WebServlet(name = "PersonaController", urlPatterns = {"/persona"})
public class PersonaController extends HttpServlet {

    private PersonaDao personaDao = new PersonaDaoImpl();
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
                out.println(g.toJson(personaDao.readAllPersona()));
            case 2 ->
                out.println(personaDao.createPersona(new PersonaEntity(0, request.getParameter("nombre"), request.getParameter("apepat"),request.getParameter("apemat"),request.getParameter("numero"),request.getParameter("correo"),request.getParameter("fecha"), "A")));
            case 3 ->
                out.println(personaDao.deletePersona(Integer.parseInt(request.getParameter("id"))));
            case 4 ->
                out.println(g.toJson(personaDao.readPersona(Integer.parseInt(request.getParameter("id")))));
            case 5 -> {
                int id = Integer.parseInt(request.getParameter("id"));
                String nombre = request.getParameter("nombre");
                String apepat = request.getParameter("apepat");
                String apemat = request.getParameter("apemat");
                String numero = request.getParameter("numero");
                String correo = request.getParameter("correo");
                String fecha = request.getParameter("fecha");
                String estado = request.getParameter("estado");
                PersonaEntity updatedPersona = new PersonaEntity(id, nombre, apepat, apemat, numero, correo, fecha, estado);
                System.out.println("Updating persona: " + updatedPersona); // Log para depuración
                out.println(personaDao.updatePersona(updatedPersona));
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
