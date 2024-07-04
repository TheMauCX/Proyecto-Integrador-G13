package pe.edu.upeu.oracle.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Docente
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario_rolEntity {
    private int idusuario_rol;
    private int idusuario;
    private int idrol;
    private String estado;
}
