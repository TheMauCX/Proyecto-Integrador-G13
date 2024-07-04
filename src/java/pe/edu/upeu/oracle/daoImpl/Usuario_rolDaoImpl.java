
package pe.edu.upeu.oracle.daoImpl;

import java.util.List;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.upeu.oracle.config.Conexion;
import pe.edu.upeu.oracle.dao.Usuario_rolDao;
import pe.edu.upeu.oracle.dto.UsuariLogin;
import pe.edu.upeu.oracle.entity.Usuario_rolEntity;
/**
 *
 * @author Docente
 */
public class Usuario_rolDaoImpl implements Usuario_rolDao {
private PreparedStatement ps;
private ResultSet rs;
private Connection cx= null;
    @Override
    public int createUsuarioRol(Usuario_rolEntity usuario_rol) {
        String SQL= "INSERT INTO usuario_rol (idusuario,idrol,estado) VALUES(?,?,A)";
        int x = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, usuario_rol.getIdusuario());
            ps.setInt(2, usuario_rol.getIdrol());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        
        return x;
    }

    @Override
    public int updateUsuarioRol(Usuario_rolEntity usuario_rol) {
        String SQL= "UPDATE usuario_rol SET idusuario=? idrol=? estado=? WHERE idusuario_rol=?";
        int x = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, usuario_rol.getIdusuario());
            ps.setInt(2, usuario_rol.getIdrol());
            ps.setString(3, usuario_rol.getEstado());
            ps.setInt(4, usuario_rol.getIdusuario_rol());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        
        return x;
    }

    @Override
    public int deleteUsuarioRol(int id) {
        String SQL= "DELETE FROM usuario_rol WHERE idusuario_rol=?";
        String SQL1= "UPDATE usuario_rol SET estado=0 WHERE idusuario_rol=?";
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
    public Usuario_rolEntity readUsuarioRol(int id) {
        Usuario_rolEntity usuario_rol =new Usuario_rolEntity(); 
        String SQL= "SELECT *FROM usuario_rol WHERE idusuario_rol=?";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                usuario_rol.setIdusuario_rol(rs.getInt("idusuario_rol"));
                usuario_rol.setIdusuario(rs.getInt("idusuario"));
                usuario_rol.setIdrol(rs.getInt("idrol"));
                usuario_rol.setEstado(rs.getString("estado"));
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        
        return usuario_rol;
    }

    @Override
    public List<Usuario_rolEntity> readAllUsuarioRol() {
        List<Usuario_rolEntity> lista = new ArrayList<>(); 
        String SQL= "SELECT *FROM usuario_rol";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                Usuario_rolEntity usuario_rol =new Usuario_rolEntity(); 
                usuario_rol.setIdusuario_rol(rs.getInt("idusuario_rol"));
                usuario_rol.setIdusuario(rs.getInt("idusuario"));
                usuario_rol.setIdrol(rs.getInt("idrol"));
                usuario_rol.setEstado(rs.getString("estado"));
                lista.add(usuario_rol);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        
        return lista;
    }
}
