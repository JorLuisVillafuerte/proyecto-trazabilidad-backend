package ar.com.trazabilidad.webservice;

import ar.com.trazabilidad.dominio.Pedidos;
import ar.com.trazabilidad.servicio.PedidosService;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin
@Slf4j
public class PedidosRS {
    
    @Autowired
    PedidosService service;

    @GetMapping("/")
    public List<Pedidos> obtener(){
        return service.findAll();
    }
             
    @GetMapping("/id/{id}")
    public ResponseEntity obtenerPorId(@PathVariable("id") Integer id){
        Optional<Pedidos> pedido = service.findById(id);
        if(!pedido.isPresent()){
            throw new ResponseStatusException(
             HttpStatus.NOT_FOUND, "No se encontro un pedido con el ID proporcionado"
        );
        }
        return ResponseEntity.of(pedido);                
                   
    }
    @PostMapping("/")
    public Pedidos crearPedido(@RequestBody Pedidos pedido){
        return service.save(pedido);
    }
    @PostMapping("/all")
    public List<Pedidos> crearPedidos(@RequestBody List<Pedidos> pedidos){
        return service.saveAll(pedidos);
    }
    @DeleteMapping("/id/{id}")
    public ResponseEntity borrarPorId(@PathVariable("id") Integer id){
        Optional<Pedidos> pedido = service.findById(id);
        if(!pedido.isPresent()){
            throw new ResponseStatusException(
             HttpStatus.NOT_FOUND, "No se encontro un pedido para borrar con el ID proporcionado"
        );
        }
        service.deleteById(id);
        return ResponseEntity.ok("Se borro correctamente");                
    }
}
