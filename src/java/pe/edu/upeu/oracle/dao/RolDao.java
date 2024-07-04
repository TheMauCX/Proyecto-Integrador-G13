
package pe.edu.upeu.oracle.dao;

import java.util.List;
import pe.edu.upeu.oracle.entity.RolEntity;

/**
 *
 * @author Docente
 */
public interface RolDao {
    public int createRol(RolEntity rol);
    public int updateRol(RolEntity rol);
    public int deleteRol(int id);
    public RolEntity readRol(int id);
    public List<RolEntity> readAllRol();
}
