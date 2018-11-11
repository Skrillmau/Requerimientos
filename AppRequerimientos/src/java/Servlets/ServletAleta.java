/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import clases.Metodo;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luill
 */
@WebServlet(name = "ServletAleta", urlPatterns = {"/ServletAleta"})
public class ServletAleta extends HttpServlet {

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
        String Nombre=request.getParameter("Nombre");
        Metodo objReq=new Metodo();
        String vpara = request.getParameter("txtpara");
        System.out.println(request.getParameter("txtid"));
        int ID = Integer.parseInt(request.getParameter("txtid"));
        String modificado = request.getParameter("Modificado");
        String eliminado = request.getParameter("Eliminado");
        
        String fecha = request.getParameter("Fecha");
        /*java.sql.Date fecFormatoDate = null;
        try {
            SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd", new Locale("es", "ES"));
            fecFormatoDate = new java.sql.Date(sdf.parse(fecha).getTime());
            System.out.println("Fecha con el formato java.sql.Date: " + fecFormatoDate);
        } catch (Exception ex) {
            System.out.println("Error al obtener el formato de la fecha/hora: " + ex.getMessage());
        }*/
        
        
        
        
        
        
        if(vpara.equals("N")){
        
        }
        if(vpara.equals("N")){
        
        }
        if(vpara.equals("M")){
            objReq.modificar(ID, Nombre, modificado, eliminado, fecha);
            RequestDispatcher rd=getServletContext().getRequestDispatcher("/operaciones.jsp");
            rd.forward(request, response);
        }
        if(vpara.equals("N")){
        
        }
        if(vpara.equals("N")){
        
        }
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletAleta</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletAleta at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
