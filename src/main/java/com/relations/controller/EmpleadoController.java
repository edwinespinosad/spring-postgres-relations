package com.relations.controller;

import com.relations.entity.Empleado;
import com.relations.service.EmpleadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping("/empleados")
    public ResponseEntity<List<Empleado>> obtenerTodosLosEmpleados(){
        return ResponseEntity.ok().body(empleadoService.obtenerTodosLosEmpleados());
    }

    @PostMapping("/guardarEmpleado")
    public ResponseEntity<Empleado> guardarEmpleado(@RequestBody Empleado empleado){
        return ResponseEntity.ok().body(empleadoService.guardarEmpleado(empleado));
    }

    @GetMapping("/empleado/{id}")
    public ResponseEntity<Empleado> obtenerEmpleadoPorId(@PathVariable Integer id){
        return ResponseEntity.ok().body(empleadoService.obtenerEmpleadoPorId(id));
    }

    @PutMapping("/modificarEmpleado")
    public ResponseEntity<Empleado> actualizarEmpleado(@RequestBody Empleado empleado){
        return ResponseEntity.ok().body(empleadoService.actualizarEmpleado(empleado));
    }

    @DeleteMapping("/empleado/{id}")
    public ResponseEntity<String> eliminarEmpleadoPorId(@PathVariable Integer id){
        return ResponseEntity.ok().body(empleadoService.eliminarEmpleadoPorId(id));
    }
}
