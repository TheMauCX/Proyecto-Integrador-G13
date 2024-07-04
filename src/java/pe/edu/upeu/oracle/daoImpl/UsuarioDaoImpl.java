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
import pe.edu.upeu.oracle.dao.UsuarioDao;
import pe.edu.upeu.oracle.dto.UsuariLogin;
import pe.edu.upeu.oracle.entity.UsuarioEntity;

/**
 *
 * @author USER
 */
public class UsuarioDaoImpl implements UsuarioDao {

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx = null;

    @Override
    public int createUsuario(UsuarioEntity usuario) {
        String SQL = "INSERT INTO usuario (idpersona,nombre,clave,estado) VALUES(?,?,?,A)";
        int x = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, usuario.getIdpersona());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getClave());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return x;
    }

    @Override
    public int updateUsuario(UsuarioEntity usuario) {
        String SQL = "UPDATE usuario SET idpersona=? nombre=? clave=? estado=? WHERE idusuario=?";
        int x = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, usuario.getIdpersona());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getClave());
            ps.setString(4, usuario.getNombre());
            ps.setInt(5, usuario.getIdusuario());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return x;
    }

    @Override
    public int deleteUsuario(int id) {
        String SQL = "DELETE FROM usuario WHERE idusuario=?";
        String SQL1 = "UPDATE usuario SET estado=0 WHERE idusuario=?";
        int x = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return x;
    }

    @Override
    public UsuarioEntity readUsuario(int id) {
        UsuarioEntity usuario = new UsuarioEntity();
        String SQL = "SELECT *FROM usuario WHERE idusuario=?";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                usuario.setIdusuario(rs.getInt("idusuario"));
                usuario.setIdpersona(rs.getInt("idpersona"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setClave(rs.getString("clave"));
                usuario.setEstado(rs.getString("estado"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return usuario;
    }

    @Override
    public List<UsuarioEntity> readAllUsuario() {
        List<UsuarioEntity> lista = new ArrayList<>();
        String SQL = "SELECT *FROM usuario";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                UsuarioEntity usuario = new UsuarioEntity();
                usuario.setIdusuario(rs.getInt("idusuario"));
                usuario.setIdpersona(rs.getInt("idpersona"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setClave(rs.getString("clave"));
                usuario.setEstado(rs.getString("estado"));
                lista.add(usuario);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return lista;
    }

    @Override
    public boolean buscarUsuario(String username) {
        return true;
    }

    ;
    @Override
    public List<UsuariLogin> login(String nombre, String clave) {
        List<UsuariLogin> lista = new ArrayList<>();
        String SQL = "SELECT r.nombre as rol, u.idusuario, u.nombre FROM usuario_rol ur "
                + "inner join usuario u on ur.idusuario = u.idusuario "
                + "inner join rol r on ur.idrol=r.idrol "
                + "where u.nombre = ? and u.clave = ?";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, nombre);
            ps.setString(2, clave);
            rs = ps.executeQuery();
            while (rs.next()) {
                UsuariLogin login = new UsuariLogin();
                login.setIdusuario(rs.getInt("idusuario"));
                login.setUsuario(rs.getString("nombre"));
                login.setRol(rs.getString("rol"));
                lista.add(login);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return lista;
    }

}
