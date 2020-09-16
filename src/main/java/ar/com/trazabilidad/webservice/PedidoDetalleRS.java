package ar.com.trazabilidad.webservice;

import ar.com.trazabilidad.dominio.PedidoDetalle;
import ar.com.trazabilidad.servicio.PedidoDetalleService;
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
@RequestMapping("/pedidoDetalle")
@CrossOrigin
@Slf4j
public class PedidoDetalleRS {
    
    @Autowired
    PedidoDetalleService service;

    @GetMapping("/")
    public List<PedidoDetalle> obtener(){
        return service.findAll();
    }
             
    @GetMapping("/id/{id}")
    public ResponseEntity obtenerPorId(@PathVariable("id") Integer id){
        Optional<PedidoDetalle> pedido = service.findById(id);
        if(!pedido.isPresent()){
            throw new ResponseStatusException(
             HttpStatus.NOT_FOUND, "No se encontro un detalle de pedido con el ID proporcionado"
        );
        }
        return ResponseEntity.of(pedido);                
                   
    }
    @PostMapping("/")
    public PedidoDetalle crearPedidoDetalle(@RequestBody PedidoDetalle pedido){
        return service.save(pedido);
    }
    @DeleteMapping("/id/{id}")
    public ResponseEntity borrarPorId(@PathVariable("id") Integer id){
        Optional<PedidoDetalle> pedido = service.findById(id);
        if(!pedido.isPresent()){
            throw new ResponseStatusException(
             HttpStatus.NOT_FOUND, "No se encontro un detalle de pedido para borrar con el ID proporcionado"
        );
        }
        service.deleteById(id);
        return ResponseEntity.ok("Se borro correctamente");                
    }
}
