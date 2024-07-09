package com.relations.service;

import com.relations.entity.Direccion;
import com.relations.entity.Empleado;
import com.relations.repository.DireccionRepo;
import com.relations.repository.EmpleadoRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DireccionService {

    private final DireccionRepo direccionRepo;
    private final EmpleadoRepo empleadoRepo;

    public DireccionService(DireccionRepo direccionRepo, EmpleadoRepo empleadoRepo) {
        this.direccionRepo = direccionRepo;
        this.empleadoRepo = empleadoRepo;
    }

    public Direccion guardarDireccion(Direccion direccion){
        return direccionRepo.save(direccion);
    }

    public List<Direccion> obtenerTodasLasDirecciones(){
        return direccionRepo.findAll();
    }

    @Transactional
    public Direccion guardarEmpleadoConDireccion(Empleado empleado, Direccion direccion) {
        Empleado empleadoGuardado = empleadoRepo.save(empleado);
        direccion.setEmpleado(empleadoGuardado);
        return direccionRepo.save(direccion);
    }

    public Direccion obtenerDireccionPorId(Integer id){
        Optional<Direccion> optionalDireccion = direccionRepo.findById(id);
        if(optionalDireccion.isPresent()){
            return optionalDireccion.get();
        }
        return null;
    }

    public Direccion actualizarDireccion(Direccion direccion){
        Optional<Direccion> direccionExistente = direccionRepo.findById(direccion.getId());
        if(direccionExistente.isPresent()){
            return direccionRepo.save(direccion);
        }
        return null;
    }

    public String eliminarDireccionPorId(Integer id){
        Optional<Direccion> direccionExistente = direccionRepo.findById(id);
        if(direccionExistente.isPresent()){
            direccionRepo.deleteById(id);
            return "Direccion eliminada";
        }
        return "No se ha encontrado la dirección";
    }
}
