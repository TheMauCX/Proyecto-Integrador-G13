/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.upeu.oracle.dao;

import java.util.List;
import pe.edu.upeu.oracle.entity.Rol_accesoEntity;

/**
 *
 * @author USER
 */
public interface Rol_accesoDao {
    public int createRolAcceso(Rol_accesoEntity rol_acceso);
    public int updateRolAcceso(Rol_accesoEntity rol_acceso);
    public int deleteRolAcceso(int id);
    public Rol_accesoEntity readRolAcceso(int id);
    public List<Rol_accesoEntity> readAllRolAcceso();
}
