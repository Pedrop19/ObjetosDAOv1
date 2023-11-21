/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package es.albarregas.DAO;

import java.util.List;

import es.albarregas.beans.Alumno;

/**
 *
 * @author pedro
 */
public interface IAlumnosDAO {

    public List<Alumno> getAlumnos();

    public List<Alumno> getAlumnoEquipo();

    public void closeConnection();
}
