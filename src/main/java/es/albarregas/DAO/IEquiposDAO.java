/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package es.albarregas.DAO;

import java.util.List;

import es.albarregas.beans.Equipo;

/**
 *
 * @author pedro
 */
public interface IEquiposDAO {
    
    public List<Equipo> getEquipos();

    public List<Equipo> getEquipoAlumnos();

    public List<Equipo> getEquipoSinAlumnos();

    public void closeConnection();
}
