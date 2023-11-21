package es.albarregas.controllers;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.albarregas.DAO.AlumnosDAO;
import es.albarregas.DAO.EquiposDAO;
import es.albarregas.DAO.IAlumnosDAO;
import es.albarregas.DAO.IEquiposDAO;
import es.albarregas.beans.Alumno;
import es.albarregas.beans.Equipo;

/**
 *
 * @author pedro
 */
@WebServlet(urlPatterns = { "/FrontController" })
public class FrontController extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String button = request.getParameter("button");
        List<Alumno> alumnos = null;
        List<Equipo> equipos = null;
        String url = null;
        IAlumnosDAO alumnosDAO = new AlumnosDAO();
        IEquiposDAO equiposDAO = new EquiposDAO();

        switch (button) {
            case "alumnos":
                alumnos = alumnosDAO.getAlumnos();
                request.setAttribute("alumnos", alumnos);
                url = "JSP/vistaFinalAlumno.jsp";
                break;
            case "equipos":
                equipos = equiposDAO.getEquipos();
                request.setAttribute("equipos", equipos);
                url = "JSP/vistaFinalEquipo.jsp";
                break;
            case "alumnosEquipos":
                alumnos = alumnosDAO.getAlumnoEquipo();
                for (Alumno alumno : alumnos) {
                    Equipo equipo = alumno.getEquipo();
                    if(equipo.getNumSerie() == null){
                        equipo.setNumSerie("Sin equipo");
                    }
                }
                request.setAttribute("alumnos", alumnos);
                url = "JSP/vistaFinalAlumnoEquipos.jsp";
                break;
            case "equiposAlumnos":
                equipos = equiposDAO.getEquipoAlumnos();
                request.setAttribute("equipos", equipos);
                url = "JSP/vistaFinalEquipoAlumno.jsp";
                break;
            case "equiposSinAlumnos":
                equipos = equiposDAO.getEquipos();
                request.setAttribute("equipos", equipos);
                url= "JSP/vistaFinalEquipoSinAlumno.jsp";
                break;
        }
        request.getRequestDispatcher(url).forward(request, response);
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
