/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.upeu.oracle.dao;

import java.util.List;
import pe.edu.upeu.oracle.entity.AccesoEntity;

/**
 *
 * @author USER
 */
public interface AccesoDao {
    public int createAcceso(AccesoEntity acceso);
    public int updateAcceso(AccesoEntity acceso);
    public int deleteAcceso(int id);
    public AccesoEntity readAcceso(int id);
    public List<AccesoEntity> readAllAcceso();
}
