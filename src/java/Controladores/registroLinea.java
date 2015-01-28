/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import senaDAO.equipoDAO;
import senaDAO.lineaDAO;
import senaDAO.personaDAO;
import senaDTO.equipoDTO;
import senaDTO.lineaDTO;

/**
 *
 * @author fabian
 */
@WebServlet(name = "registroLinea", urlPatterns = {"/registroLinea"})
public class registroLinea extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        if (request.getParameter("registrar") != null) {

            lineaDTO pdto = new lineaDTO();
            lineaDAO pdao = new lineaDAO();
            personaDAO pe = new personaDAO();
            pdto.setNumerolinea(Long.parseLong(request.getParameter("linea")));
            pdto.setPerid(Integer.parseInt(request.getParameter("cedula")));
            pdto.setLinestado("1");
            pdto.setTelefono(Integer.parseInt(request.getParameter("telefono")));
         
            long x = pdao.validar(Long.parseLong(request.getParameter("linea")));
            int t = pe.validarUsuario(Integer.parseInt(request.getParameter("cedula")));
            int f = pdao.validarSerial(Integer.parseInt(request.getParameter("telefono")));
            if(x ==0 && t !=0 && f !=0){
               String mensaje = pdao.crearLinea(pdto);  
               response.sendRedirect("registrarLinea.jsp?msg=" + mensaje);
            }
           
            else if(x !=0){
                response.sendRedirect("registrarLinea.jsp?invalida=" + x);
            }
            else if(t ==0){
               response.sendRedirect("registrarLinea.jsp?noex=" + t); 
            }  
            else if(f ==0){
               response.sendRedirect("registrarLinea.jsp?no=" + f); 
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(registroLinea.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(registroLinea.class.getName()).log(Level.SEVERE, null, ex);
        }
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
