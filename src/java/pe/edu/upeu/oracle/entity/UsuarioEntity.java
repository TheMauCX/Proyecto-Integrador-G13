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
public class UsuarioEntity {
    private int idusuario;
    private String nombre;
    private String clave;
    private int idpersona;
    private String estado;
}
