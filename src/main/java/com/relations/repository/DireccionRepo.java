package com.relations.repository;

import com.relations.entity.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DireccionRepo extends JpaRepository<Direccion, Integer> {
}
