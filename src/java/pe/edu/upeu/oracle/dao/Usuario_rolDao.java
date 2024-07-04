/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.upeu.oracle.dao;

import java.util.List;
import pe.edu.upeu.oracle.entity.Usuario_rolEntity;

/**
 *
 * @author USER
 */
public interface Usuario_rolDao {
    public int createUsuarioRol(Usuario_rolEntity usuario_rol);
    public int updateUsuarioRol(Usuario_rolEntity usuario_rol);
    public int deleteUsuarioRol(int id);
    public Usuario_rolEntity readUsuarioRol(int id);
    public List<Usuario_rolEntity> readAllUsuarioRol();
}
