package ar.com.trazabilidad.webservice;

import ar.com.trazabilidad.servicio.ObservacionesService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ar.com.trazabilidad.dominio.Observaciones;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/observaciones")
@CrossOrigin
@Slf4j
public class ObservacionesRS {
    @Autowired
    ObservacionesService service;
    
    @GetMapping("/")
    public List<Observaciones> obtener(){
        return service.findAll();
    }
    
    @GetMapping("/id/{id}")
    public ResponseEntity obtenerPorId(@PathVariable("id") Integer id){
        Optional<Observaciones> obs = service.findById(id);
        if(!obs.isPresent()){
            throw new ResponseStatusException(
             HttpStatus.NOT_FOUND, "No se encontro una observacion con el ID proporcionado");
        }
        return ResponseEntity.ok(obs);
    }
    @PostMapping
    public Observaciones crear (@RequestBody Observaciones obs){
        return service.save(obs);
    }
    @DeleteMapping("/id/{id}")
    public ResponseEntity borrarPorId(@PathVariable("id") Integer id){
        Optional<Observaciones> obs = service.findById(id);
        if(!obs.isPresent()){
            throw new ResponseStatusException(
             HttpStatus.NOT_FOUND, "No se encontro una observacion para borrar con el ID proporcionado"
        );
        }
        service.deleteById(id);
        return ResponseEntity.ok("Se borro correctamente");                
    }
}
