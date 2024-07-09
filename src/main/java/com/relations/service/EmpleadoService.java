package com.relations.service;

import com.relations.entity.Empleado;
import com.relations.repository.EmpleadoRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    private final EmpleadoRepo empleadoRepo;

    public EmpleadoService(EmpleadoRepo empleadoRepo) {
        this.empleadoRepo = empleadoRepo;
    }

    public List<Empleado> obtenerTodosLosEmpleados(){
        return empleadoRepo.findAll();
    }

    public Empleado guardarEmpleado(Empleado empleado){
        return empleadoRepo.save(empleado);
    }

    public Empleado obtenerEmpleadoPorId(Integer id){
        Optional<Empleado> optionalEmpleado = empleadoRepo.findById(id);
        if(optionalEmpleado.isPresent()){
            return optionalEmpleado.get();
        }
        return null;
    }

    public Empleado actualizarEmpleado(Empleado empleado){
        Optional<Empleado> empleadoExistente = empleadoRepo.findById(empleado.getId());
        if(empleadoExistente.isPresent()){
            return empleadoRepo.save(empleado);
        }
        return null;
    }

    public String eliminarEmpleadoPorId(Integer id){
        Optional<Empleado> empleadoExistente = empleadoRepo.findById(id);
        if (empleadoExistente.isPresent()){
            empleadoRepo.deleteById(id);
            return "Empleado eliminado";
        }
        return "No se ha encontrado el empleado";
    }

}
