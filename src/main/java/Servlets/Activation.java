/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Beans.UserService;
import Beans.UsuarioService;
import GestaoProcessos.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Beans.UsuarioServiceLocal;
import javax.persistence.EntityManager;

/**
 *
 * @author Rian Alves Leal <ral2 at ifnmg.edu.br>
 */
@WebServlet(name = "Activation", urlPatterns = {"/Activation"})
public class Activation extends HttpServlet {

    @Inject
    private UserService serviceBean;
    
    @Inject
    private UsuarioServiceLocal usuarioService;
    
    protected void processRequest(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String key = request.getParameter("activationKey");
        System.out.println(">> >> >>" + email);
        
        if (email == null || key == null) {
            response.sendRedirect("checkemail.xhtml");
            
        } else {
            Usuario user = usuarioService.buscarPorEmail(email);
            if (user != null && user.getKey().toString().equals(key)) {
                user.setAtivo(true);
                serviceBean.setEmail(email);
                System.out.println(">> >> >>" + user.getAtivo());
                usuarioService.editar(user);
//                em.persist(user);
                response.sendRedirect("activation.xhtml");
            } else {
                response.sendRedirect("checkemail.xhtml");
            }
//            response.sendRedirect("activation.xhtml");
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
//        System.out.println("qualquer cousa!");
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