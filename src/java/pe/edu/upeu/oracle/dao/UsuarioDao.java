/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.upeu.oracle.dao;
import java.util.List;
import pe.edu.upeu.oracle.dto.UsuariLogin;
import pe.edu.upeu.oracle.entity.UsuarioEntity;
/**
 *
 * @author USER
 */
public interface UsuarioDao {
    public int createUsuario(UsuarioEntity usuario);
    public int updateUsuario(UsuarioEntity usuario);
    public int deleteUsuario(int id);
    public UsuarioEntity readUsuario(int id);
    public List<UsuarioEntity> readAllUsuario();
    public boolean buscarUsuario(String username);
    public List<UsuariLogin> login(String username, String clave);
}
