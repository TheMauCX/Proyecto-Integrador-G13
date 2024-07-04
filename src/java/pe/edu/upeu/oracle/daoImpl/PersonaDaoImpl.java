/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.oracle.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.upeu.oracle.config.Conexion;
import pe.edu.upeu.oracle.dao.PersonaDao;
import pe.edu.upeu.oracle.entity.PersonaEntity;

/**
 *
 * @author USER
 */
public class PersonaDaoImpl implements PersonaDao {
private PreparedStatement ps;
private ResultSet rs;
private Connection cx= null;
    @Override
    public int createPersona(PersonaEntity persona) {
        String SQL= "INSERT INTO persona (nombre,apepat,apemat,numero,correo,fecha,estado) VALUES(?,?,?,?,?,?,'A')";
        int x = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApepat());
            ps.setString(3, persona.getApemat());
            ps.setString(4, persona.getNumero());
            ps.setString(5, persona.getCorreo());
            ps.setString(6, persona.getFecha());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        
        return x;
    }

    @Override
    public int updatePersona(PersonaEntity persona) {
        String SQL= "UPDATE persona SET nombre=?, apepat=?, apemat=?, numero=?, correo=?, fecha=?, estado=? WHERE idpersona=?";
        int x = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApepat());
            ps.setString(3, persona.getApemat());
            ps.setString(4, persona.getNumero());
            ps.setString(5, persona.getCorreo());
            ps.setString(6, persona.getFecha());
            ps.setString(7, persona.getEstado());
            ps.setInt(8, persona.getIdpersona());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        
        return x;
    }

    @Override
    public int deletePersona(int id) {
        String SQL= "DELETE FROM persona WHERE idpersona=?";
        String SQL1= "UPDATE persona SET estado=0 WHERE idpersona=?";
        int x = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        
        return x;
    }

    @Override
    public PersonaEntity readPersona(int id) {
        PersonaEntity persona = new PersonaEntity(); 
        String SQL= "SELECT *FROM persona WHERE idpersona=?";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                persona.setIdpersona(rs.getInt("idpersona"));
                persona.setNombre(rs.getString("nombre"));
                persona.setApepat(rs.getString("apepat"));
                persona.setApemat(rs.getString("apemat"));
                persona.setNumero(rs.getString("numero"));
                persona.setCorreo(rs.getString("correo"));
                persona.setFecha(rs.getString("fecha"));
                persona.setEstado(rs.getString("estado"));
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        
        return persona;
    }

    @Override
    public List<PersonaEntity> readAllPersona() {
        List<PersonaEntity> lista = new ArrayList<>(); 
        String SQL= "SELECT *FROM persona";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                PersonaEntity persona = new PersonaEntity(); 
                persona.setIdpersona(rs.getInt("idpersona"));
                persona.setNombre(rs.getString("nombre"));
                persona.setApepat(rs.getString("apepat"));
                persona.setApemat(rs.getString("apemat"));
                persona.setNumero(rs.getString("numero"));
                persona.setCorreo(rs.getString("correo"));
                persona.setFecha(rs.getString("fecha"));
                persona.setEstado(rs.getString("estado"));
                lista.add(persona);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        
        return lista;
    }
    
}
