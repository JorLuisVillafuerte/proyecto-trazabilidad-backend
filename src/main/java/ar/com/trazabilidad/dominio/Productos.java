/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.trazabilidad.dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="productos")
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idproducto;
    @Basic(optional = false)
    private String codProducto;
    private String descripcion;
    private String imagen;
    @OneToMany(mappedBy = "idproducto")
    private List<PedidoDetalle> pedidoDetalleList;

 
    public Productos(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public Productos(Integer idproducto, String codProducto) {
        this.idproducto = idproducto;
        this.codProducto = codProducto;
    }
    
}
