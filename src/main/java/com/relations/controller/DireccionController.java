package com.relations.controller;

import com.relations.entity.Direccion;
import com.relations.service.DireccionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DireccionController {
    private final DireccionService direccionService;

    public DireccionController(DireccionService direccionService) {
        this.direccionService = direccionService;
    }

    @GetMapping("/direcciones")
    public ResponseEntity<List<Direccion>> obtenerTodasLasDirecciones(){
        return ResponseEntity.ok().body(direccionService.obtenerTodasLasDirecciones());
    }

    @PostMapping("/guardarDireccion")
    public ResponseEntity<Direccion> guardarDireccion(@RequestBody Direccion direccion){
        return ResponseEntity.ok().body(direccionService.guardarDireccion(direccion));
    }

    @PostMapping("/guardarEmpleadoConDireccion")
    public ResponseEntity<Direccion> crearEmpleadoConDireccion(@RequestBody Direccion direccion) {
        Direccion direccionGuardada = direccionService.guardarEmpleadoConDireccion(direccion.getEmpleado(), direccion);
        return new ResponseEntity<>(direccionGuardada, HttpStatus.CREATED);
    }

    @GetMapping("/direccion/{id}")
    public ResponseEntity<Direccion> obtenerDireccionPorId(@PathVariable Integer id){
        return ResponseEntity.ok().body(direccionService.obtenerDireccionPorId(id));
    }

    @PutMapping("/modificarDireccion")
    public ResponseEntity<Direccion> actualizarDireccion(@RequestBody Direccion direccion){
        return ResponseEntity.ok().body(direccionService.actualizarDireccion(direccion));
    }

    @DeleteMapping("/direccion/{id}")
    public ResponseEntity<String> eliminarDireccionPorId(@PathVariable Integer id){
        return ResponseEntity.ok().body(direccionService.eliminarDireccionPorId(id));
    }
}
