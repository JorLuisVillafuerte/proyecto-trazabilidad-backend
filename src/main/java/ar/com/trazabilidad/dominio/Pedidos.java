/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.trazabilidad.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="pedidos")
public class Pedidos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idpedido;
    @Basic(optional = false)
    private String codPedido;
    private String descripcion;
    private String cliente;
    @Column(updatable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEmision;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaProduccion;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTerminado;
    private String vendedor;
    private String direccion;
    private Integer galpon;
    @OneToMany(mappedBy = "idpedido")
    private List<PedidoDetalle> pedidoDetalleList;

    public Pedidos(Integer idpedido) {
        this.idpedido = idpedido;
    }

    public Pedidos(Integer idpedido, String codPedido) {
        this.idpedido = idpedido;
        this.codPedido = codPedido;
    }
    
}
