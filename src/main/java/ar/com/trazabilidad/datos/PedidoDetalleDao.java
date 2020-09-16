package ar.com.trazabilidad.datos;
import org.springframework.data.repository.CrudRepository;
import ar.com.trazabilidad.dominio.PedidoDetalle;

public interface PedidoDetalleDao extends CrudRepository<PedidoDetalle, Integer>{
    
}
