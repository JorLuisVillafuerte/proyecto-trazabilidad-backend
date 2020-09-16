package ar.com.trazabilidad.dominio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="usuarios")
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idusuario;
    private String nombre;
    private String apellido;
    @Basic(optional = false)
    private String email;
    @Basic(optional = false)
    private Integer dni;
    @Basic(optional = false)
    private String cargo;
    @Basic(optional = false)
    private String password;
    private Integer galpon;
    
    
}
