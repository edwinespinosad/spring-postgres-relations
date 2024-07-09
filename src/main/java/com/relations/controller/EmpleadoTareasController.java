package com.relations.controller;

import com.relations.entity.EmpleadoTareas;
import com.relations.service.EmpleadoTareasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpleadoTareasController {

    private final EmpleadoTareasService empleadoTareasService;

    public EmpleadoTareasController(EmpleadoTareasService empleadoTareasService) {
        this.empleadoTareasService = empleadoTareasService;
    }

    @GetMapping("/empleadosTareas")
    public ResponseEntity<List<EmpleadoTareas>> obtenerTodasLasTareasEmpleados(){
        return ResponseEntity.ok().body(empleadoTareasService.obtenerTodasLasTareasEmpleados());
    }

    @PostMapping("/guardarEmpleadoTarea")
    public ResponseEntity<EmpleadoTareas> crearEmpleadoTarea(@RequestBody EmpleadoTareas empleadoTareas){
        EmpleadoTareas empleadoTareasGuardado = empleadoTareasService.guardarTareaEmpleado(empleadoTareas);
        return new ResponseEntity<>(empleadoTareasGuardado, HttpStatus.CREATED);
    }

    @PutMapping("/modificarEmpleadoTarea")
    public ResponseEntity<EmpleadoTareas> actualizarDepartamento(@RequestBody EmpleadoTareas empleadoTareas){
        return ResponseEntity.ok().body(empleadoTareasService.actualizarEmpleadoTareas(empleadoTareas));
    }

    @DeleteMapping("/empleadosTareas/{id}")
    public ResponseEntity<String> eliminarTareaEmpleadoPorId(@PathVariable Integer id){
        return ResponseEntity.ok().body(empleadoTareasService.eliminarTareaEmpleadoPorId(id));
    }
}
