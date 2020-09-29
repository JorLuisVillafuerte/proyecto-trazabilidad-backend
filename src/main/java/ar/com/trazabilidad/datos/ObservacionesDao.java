package ar.com.trazabilidad.datos;

import org.springframework.data.repository.CrudRepository;
import ar.com.trazabilidad.dominio.Observaciones;

public interface ObservacionesDao extends CrudRepository<Observaciones, Integer>{
    
}
