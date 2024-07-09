package com.relations.repository;

import com.relations.entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepo extends JpaRepository<Tarea, Integer> {
}
