
package pe.edu.upeu.oracle.daoImpl;

import java.util.List;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.upeu.oracle.config.Conexion;
import pe.edu.upeu.oracle.dao.Rol_accesoDao;
import pe.edu.upeu.oracle.entity.Rol_accesoEntity;
/**
 *
 * @author Docente
 */
public class Rol_accesoDaoImpl implements Rol_accesoDao {
private PreparedStatement ps;
private ResultSet rs;
private Connection cx= null;
    @Override
    public int createRolAcceso(Rol_accesoEntity rol_acceso) {
        String SQL= "INSERT INTO rol_acceso (idrol,idacceso,estado) VALUES(?,?,A)";
        int x = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, rol_acceso.getIdrol());
            ps.setInt(2, rol_acceso.getIdacceso());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        
        return x;
    }

    @Override
    public int updateRolAcceso(Rol_accesoEntity rol_acceso) {
        String SQL= "UPDATE rol_acceso SET idrol=? idacceso=? estado=? WHERE idrol_acceso=?";
        int x = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, rol_acceso.getIdrol());
            ps.setInt(2, rol_acceso.getIdacceso());
            ps.setString(3, rol_acceso.getEstado());
            ps.setInt(4, rol_acceso.getIdrol_acceso());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        
        return x;
    }

    @Override
    public int deleteRolAcceso(int id) {
        String SQL= "DELETE FROM rol_acceso WHERE idrol_acceso=?";
        String SQL1= "UPDATE rol_acceso SET estado=0 WHERE idrol_acceso=?";
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
    public Rol_accesoEntity readRolAcceso(int id) {
        Rol_accesoEntity rol_acceso =new Rol_accesoEntity(); 
        String SQL= "SELECT *FROM rol_acceso WHERE idrol_acceso=?";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                rol_acceso.setIdrol_acceso(rs.getInt("idrol_acceso"));
                rol_acceso.setIdrol(rs.getInt("idrol"));
                rol_acceso.setIdacceso(rs.getInt("idacceso"));
                rol_acceso.setEstado(rs.getString("estado"));
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        
        return rol_acceso;
    }

    @Override
    public List<Rol_accesoEntity> readAllRolAcceso() {
        List<Rol_accesoEntity> lista = new ArrayList<>(); 
        String SQL= "SELECT *FROM rol_acceso";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                Rol_accesoEntity rol_acceso =new Rol_accesoEntity(); 
                rol_acceso.setIdrol_acceso(rs.getInt("idrol_acceso"));
                rol_acceso.setIdrol(rs.getInt("idrol"));
                rol_acceso.setIdacceso(rs.getInt("idacceso"));
                rol_acceso.setEstado(rs.getString("estado"));
                lista.add(rol_acceso);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        
        return lista;
    }
    
}
