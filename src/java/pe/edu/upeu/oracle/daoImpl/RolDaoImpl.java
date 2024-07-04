
package pe.edu.upeu.oracle.daoImpl;

import java.util.List;
import pe.edu.upeu.oracle.dao.RolDao;
import pe.edu.upeu.oracle.entity.RolEntity;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.upeu.oracle.config.Conexion;

public class RolDaoImpl implements RolDao {
private PreparedStatement ps;
private ResultSet rs;
private Connection cx= null;
    @Override
    public int createRol(RolEntity rol) {
        String SQL= "INSERT INTO rol (nombre,estado) VALUES(?,'A')";
        int x = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, rol.getNombre());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        
        return x;
    }

    @Override
    public int updateRol(RolEntity rol) {
        String SQL= "UPDATE rol SET nombre=?, estado=? WHERE idrol=?";
        int x = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, rol.getNombre());
            ps.setString(2, rol.getEstado());
            ps.setInt(3, rol.getIdrol());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        
        return x;
    }

    @Override
    public int deleteRol(int id) {
        String SQL= "DELETE FROM rol WHERE idrol=?";
        String SQL1= "UPDATE rol SET estado=0 WHERE idrol=?";
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
    public RolEntity readRol(int id) {
        RolEntity rol =new RolEntity(); 
        String SQL= "SELECT *FROM rol WHERE idrol=?";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                rol.setIdrol(rs.getInt("idrol"));
                rol.setNombre(rs.getString("nombre"));
                rol.setEstado(rs.getString("estado"));
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        
        return rol;
    }

    @Override
    public List<RolEntity> readAllRol() {
        List<RolEntity> lista = new ArrayList<>(); 
        String SQL= "SELECT *FROM rol";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                RolEntity rol =new RolEntity(); 
                rol.setIdrol(rs.getInt("idrol"));
                rol.setNombre(rs.getString("nombre"));
                rol.setEstado(rs.getString("estado"));
                lista.add(rol);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        
        return lista;
    }
    
}
