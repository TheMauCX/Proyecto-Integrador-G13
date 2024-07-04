/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.upeu.oracle.dao;
import java.util.List;
import pe.edu.upeu.oracle.entity.PersonaEntity;

/**
 *
 * @author USER
 */
public interface PersonaDao {
    public int createPersona(PersonaEntity persona);
    public int updatePersona(PersonaEntity persona);
    public int deletePersona(int id);
    public PersonaEntity readPersona(int id);
    public List<PersonaEntity> readAllPersona();
}
