package ar.com.trazabilidad.servicio;

import ar.com.trazabilidad.dominio.PedidoDetalle;
import java.util.List;
import java.util.Optional;

public interface PedidoDetalleService {
    public PedidoDetalle save(PedidoDetalle pedidodetalle);
    public List<PedidoDetalle> findAll();
    public Optional<PedidoDetalle> findById(Integer id);
    public boolean existsById(Integer id);
    public void deleteById(Integer id);
    public void delete(PedidoDetalle pedidodetalle);
}
