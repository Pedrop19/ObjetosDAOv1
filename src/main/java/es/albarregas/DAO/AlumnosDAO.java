/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.albarregas.DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.albarregas.beans.Alumno;
import es.albarregas.beans.Equipo;

/**
 *
 * @author pedro
 */
public class AlumnosDAO implements IAlumnosDAO {
    
    @Override
    public List<Alumno> getAlumnos() {
        List<Alumno> alumnos = null;
        String sql = "SELECT * FROM alumnos";
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
            alumnos = new ArrayList<>();
            while (resultado.next()) {
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(resultado.getInt("idAlumno"));
                alumno.setNombre(resultado.getString("nombre"));
                alumno.setGrupo(resultado.getString("grupo"));
                alumnos.add(alumno);
            }
            resultado.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los alumnos");
            ex.printStackTrace();
        } finally {
            this.closeConnection();
        }
        return alumnos;
    }

    @Override
    public List<Alumno> getAlumnoEquipo() {
        List<Alumno> alumnos = null;
        String sql = "SELECT a.idAlumno, a.nombre, a.grupo, e.marca, e.numSerie, e.idEquipo FROM alumnos a LEFT JOIN equipos e ON a.idEquipo = e.idEquipo";
        try{
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
            alumnos = new ArrayList<>();
            while(resultado.next()){
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(resultado.getInt("idAlumno"));
                alumno.setNombre(resultado.getString("nombre"));
                alumno.setGrupo(resultado.getString("grupo"));
                Equipo equipo = new Equipo();
                equipo.setIdEquipo(resultado.getInt("idEquipo"));
                equipo.setMarca(resultado.getString("marca"));
                equipo.setNumSerie(resultado.getString("numSerie"));
                alumno.setEquipo(equipo);
                alumnos.add(alumno);
            }
        }catch(SQLException ex){
            System.out.println("Error al obtener los alumnos con su equipo");
            ex.printStackTrace();
        } finally {
            this.closeConnection();
        }
        return alumnos;
    }

    @Override
    public void closeConnection() {
        ConnectionFactory.closeConexion();
    }
}
