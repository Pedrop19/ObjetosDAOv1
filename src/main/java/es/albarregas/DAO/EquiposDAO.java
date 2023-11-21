/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.albarregas.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.albarregas.beans.Alumno;
import es.albarregas.beans.Equipo;

/**
 *
 * @author pedro
 */
public class EquiposDAO implements IEquiposDAO {

    @Override
    public List<Equipo> getEquipos() {
        List<Equipo> equipos = null;
        String sql = "SELECT * FROM equipos";
        try {
            PreparedStatement preparada = ConnectionFactory.getConnection().prepareStatement(sql);
            ResultSet resultado = preparada.executeQuery();
            equipos = new ArrayList<>();
            while (resultado.next()) {
                Equipo equipo = new Equipo();
                equipo.setIdEquipo(resultado.getInt("idEquipo"));
                equipo.setMarca(resultado.getString("marca"));
                equipo.setNumSerie(resultado.getString("numSerie"));
                equipos.add(equipo);
            }
            resultado.close();
            preparada.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los equipos");
            ex.printStackTrace();
        } finally {
            this.closeConnection();
        }
        return equipos;
    }

    @Override
    public List<Equipo> getEquipoAlumnos() {
        List<Equipo> equipos = new ArrayList<>();
    
        String sql = "SELECT e.idEquipo, e.marca, e.numSerie, a.idAlumno, a.nombre, a.grupo " +
                     "FROM equipos e " +
                     "LEFT JOIN alumnos a ON e.idEquipo = a.idEquipo";
    
        try (PreparedStatement preparada = ConnectionFactory.getConnection().prepareStatement(sql);
             ResultSet resultado = preparada.executeQuery()) {
    
            while (resultado.next()) {
                int idEquipo = resultado.getInt("idEquipo");
                String marca = resultado.getString("marca");
                String numSerie = resultado.getString("numSerie");
    
                Equipo equipo = new Equipo();
                equipo.setIdEquipo(idEquipo);
                equipo.setMarca(marca);
                equipo.setNumSerie(numSerie);
    
                int idAlumno = resultado.getInt("idAlumno");
                if (idAlumno > 0) {
                    Alumno alumno = new Alumno();
                    alumno.setIdAlumno(idAlumno);
                    alumno.setNombre(resultado.getString("nombre"));
                    alumno.setGrupo(resultado.getString("grupo"));
                    alumno.setEquipo(equipo);
                    equipo.addAlumno(alumno);
                }
    
                equipos.add(equipo);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener los equipos");
            ex.printStackTrace();
        } finally {
            this.closeConnection();
        }
        return equipos;
    }

    @Override
    public void closeConnection() {
        ConnectionFactory.closeConexion();
    }

}
