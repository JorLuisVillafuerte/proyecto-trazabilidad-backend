package ar.com.trazabilidad.datos;

import org.springframework.data.repository.CrudRepository;
import ar.com.trazabilidad.dominio.Productos;

public interface ProductosDao extends CrudRepository<Productos, Integer>{
    
}
