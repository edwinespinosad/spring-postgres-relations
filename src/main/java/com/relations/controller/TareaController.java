package com.relations.controller;

import com.relations.entity.Tarea;
import com.relations.service.TareaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TareaController {

    private final TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @GetMapping("/tareas")
    public ResponseEntity<List<Tarea>> obtenerTodasLasTareas(){
        return ResponseEntity.ok().body(tareaService.obtenerTodasLasTareas());
    }

    @PostMapping("/guardarTarea")
    public ResponseEntity<Tarea> guardarTarea(@RequestBody Tarea tarea){
        return ResponseEntity.ok().body(tareaService.guardarTarea(tarea));
    }

    @GetMapping("/tarea/{id}")
    public ResponseEntity<Tarea> obtenerTareaPorId(@PathVariable Integer id){
        return ResponseEntity.ok().body(tareaService.obtenerTareaPorId(id));
    }

    @PutMapping("/modificarTarea")
    public ResponseEntity<Tarea> actualizarTarea(@RequestBody Tarea tarea){
        return ResponseEntity.ok().body(tareaService.actualizarTarea(tarea));
    }

    @DeleteMapping("/tarea/{id}")
    public ResponseEntity<String> eliminarTareaPorId(@PathVariable Integer id){
        return ResponseEntity.ok().body(tareaService.eliminarTareaPorId(id));
    }
}
