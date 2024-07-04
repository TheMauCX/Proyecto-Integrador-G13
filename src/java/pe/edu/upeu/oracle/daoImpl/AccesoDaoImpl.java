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
import pe.edu.upeu.oracle.dao.AccesoDao;
import pe.edu.upeu.oracle.entity.AccesoEntity;

/**
 *
 * @author USER
 */
public class AccesoDaoImpl implements AccesoDao {
private PreparedStatement ps;
private ResultSet rs;
private Connection cx= null;
    @Override
    public int createAcceso(AccesoEntity acceso) {
        String SQL= "INSERT INTO acceso (nombre,estado) VALUES(?,'A')";
        int x = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, acceso.getNombre());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        
        return x;
    }

    @Override
    public int updateAcceso(AccesoEntity acceso) {
        String SQL= "UPDATE acceso SET nombre=?, estado=? WHERE idacceso=?";
        int x = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, acceso.getNombre());
            ps.setString(2, acceso.getEstado());
            ps.setInt(3, acceso.getIdacceso());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        
        return x;
    }

    @Override
    public int deleteAcceso(int id) {
        String SQL= "DELETE FROM acceso WHERE idacceso=?";
        String SQL1= "UPDATE acceso SET estado=0 WHERE idacceso=?";
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
    public AccesoEntity readAcceso(int id) {
        AccesoEntity acceso = new AccesoEntity(); 
        String SQL= "SELECT *FROM acceso WHERE idacceso=?";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                acceso.setIdacceso(rs.getInt("idacceso"));
                acceso.setNombre(rs.getString("nombre"));
                acceso.setEstado(rs.getString("estado"));
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        
        return acceso;
    }

    @Override
    public List<AccesoEntity> readAllAcceso() {
        List<AccesoEntity> lista = new ArrayList<>(); 
        String SQL= "SELECT *FROM acceso";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                AccesoEntity acceso = new AccesoEntity();
                acceso.setIdacceso(rs.getInt("idacceso"));
                acceso.setNombre(rs.getString("nombre"));
                acceso.setEstado(rs.getString("estado"));
                lista.add(acceso);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return lista;
    }
    
}
