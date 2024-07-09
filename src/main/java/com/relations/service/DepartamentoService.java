package com.relations.service;

import com.relations.entity.Departamento;
import com.relations.repository.DepartamentoRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {
    private final DepartamentoRepo departamentoRepo;

    public DepartamentoService(DepartamentoRepo departamentoRepo) {
        this.departamentoRepo = departamentoRepo;
    }

    public Departamento guardarDepartamento(Departamento departamento){
        return departamentoRepo.save(departamento);
    }

    public List<Departamento> obtenerTodosLosDepartamentos() {
        return departamentoRepo.findAll();
    }

    public Departamento obtenerDepartamentoPorId(Integer id){
        Optional<Departamento> optionalDepartamento = departamentoRepo.findById(id);
        if(optionalDepartamento.isPresent()){
            return optionalDepartamento.get();
        }
        return null;
    }

    public Departamento actualizarDepartamento(Departamento departamento){
        Optional<Departamento> departamentoExistente = departamentoRepo.findById(departamento.getId());
        if (departamentoExistente.isPresent()){
            return departamentoRepo.save(departamento);
        }
        return null;
    }
}
