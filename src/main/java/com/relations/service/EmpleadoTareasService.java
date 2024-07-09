package com.relations.service;

import com.relations.entity.EmpleadoTareas;
import com.relations.repository.EmpleadoTareaRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoTareasService {

    private final EmpleadoTareaRepo empleadoTareaRepo;

    public EmpleadoTareasService(EmpleadoTareaRepo empleadoTareaRepo) {
        this.empleadoTareaRepo = empleadoTareaRepo;
    }

    public List<EmpleadoTareas> obtenerTodasLasTareasEmpleados(){
        return empleadoTareaRepo.findAll();
    }

    public EmpleadoTareas guardarTareaEmpleado(EmpleadoTareas empleadoTareas){
        return empleadoTareaRepo.save(empleadoTareas);
    }

    public EmpleadoTareas actualizarEmpleadoTareas(EmpleadoTareas empleadoTareas){
        Optional<EmpleadoTareas> empleadoTareasExistente = empleadoTareaRepo.findById(empleadoTareas.getId());
        if (empleadoTareasExistente.isPresent()){
            return empleadoTareaRepo.save(empleadoTareas);
        }
        return null;
    }

    public String eliminarTareaEmpleadoPorId(Integer id){
        Optional<EmpleadoTareas> empleadoTareasExistente = empleadoTareaRepo.findById(id);
        if (empleadoTareasExistente.isPresent()){
            empleadoTareaRepo.deleteById(id);
            return "Tarea de empleado eliminada";
        }
        return "No se ha encontrado la tarea asignada al empleado";
    }
}
