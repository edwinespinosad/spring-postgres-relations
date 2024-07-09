package com.relations.repository;

import com.relations.entity.EmpleadoTareas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoTareaRepo extends JpaRepository<EmpleadoTareas, Integer> {
}
