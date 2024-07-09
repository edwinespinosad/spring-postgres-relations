package com.relations.service;

import com.relations.entity.Tarea;
import com.relations.repository.TareaRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaService {

    private final TareaRepo tareaRepo;

    public TareaService(TareaRepo tareaRepo) {
        this.tareaRepo = tareaRepo;
    }

    public Tarea guardarTarea(Tarea tarea){
        return tareaRepo.save(tarea);
    }

    public List<Tarea> obtenerTodasLasTareas(){
        return tareaRepo.findAll();
    }

    public Tarea obtenerTareaPorId(Integer id){
        Optional<Tarea> optionalTarea = tareaRepo.findById(id);
        if(optionalTarea.isPresent()){
            return optionalTarea.get();
        }
        return null;
    }

    public Tarea actualizarTarea(Tarea tarea){
        Optional<Tarea> tareaExistente = tareaRepo.findById(tarea.getId());
        if(tareaExistente.isPresent()){
            return tareaRepo.save(tarea);
        }
        return null;
    }

    public String eliminarTareaPorId(Integer id){
        Optional<Tarea> tareaExistente = tareaRepo.findById(id);
        if (tareaExistente.isPresent()){
            tareaRepo.deleteById(id);
            return "Tarea eliminada";
        }
        return "No se ha encontrado la tarea";
    }
}
