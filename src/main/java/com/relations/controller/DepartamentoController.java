package com.relations.controller;

import com.relations.entity.Departamento;
import com.relations.service.DepartamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartamentoController {

    private final DepartamentoService departamentoService;

    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @GetMapping("/departamentos")
    public ResponseEntity<List<Departamento>> obtenerTodosLosDepartamentos(){
        return ResponseEntity.ok().body(departamentoService.obtenerTodosLosDepartamentos());
    }

    @PostMapping("/guardarDep")
    public ResponseEntity<Departamento> guardarDepartamento(@RequestBody Departamento departamento){
        return ResponseEntity.ok().body(departamentoService.guardarDepartamento(departamento));
    }

    @GetMapping("/departamento/{id}")
    public ResponseEntity<Departamento> obtenerDepartamentoPorId(@PathVariable Integer id){
        return ResponseEntity.ok().body(departamentoService.obtenerDepartamentoPorId(id));
    }

    @PutMapping("/modificarDepartamento")
    public ResponseEntity<Departamento> actualizarDepartamento(@RequestBody Departamento departamento){
        return ResponseEntity.ok().body(departamentoService.actualizarDepartamento(departamento));
    }
}
