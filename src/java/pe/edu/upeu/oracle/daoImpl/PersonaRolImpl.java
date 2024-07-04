/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.oracle.daoImpl;

import java.util.ArrayList;
import java.util.List;
import pe.edu.upeu.oracle.entity.PersonaRolEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pe.edu.upeu.oracle.config.Conexion;

/**
 *
 * @author USER
 */
public class PersonaRolImpl {

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx = null;

    public List<PersonaRolEntity> getRolesWithCount() {
        List<PersonaRolEntity> lista = new ArrayList<>();
        String SQL = "SELECT r.nombre AS nombre_del_rol, COUNT(p.idpersona) AS cantidad_de_personas "
                + "FROM rol r "
                + "JOIN usuario_rol ur ON r.idrol = ur.idrol "
                + "JOIN usuario u ON ur.idusuario = u.idusuario "
                + "JOIN persona p ON u.idpersona = p.idpersona "
                + "GROUP BY r.nombre";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("nombre_del_rol");
                int cantidad = rs.getInt("cantidad_de_personas");
                lista.add(new PersonaRolEntity(nombre, cantidad));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return lista;
    }
}
