package com.relations.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
//    @JoinTable(
//            name = "empleado_tareas",
//            joinColumns = @JoinColumn(name = "id_empleado"),
//            inverseJoinColumns = @JoinColumn(name = "id_tarea")
//    )

@Entity
@Table(name = "tarea")
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private int duracion;

    @OneToMany(mappedBy = "tarea")
    private List<EmpleadoTareas> tareas;

    public Tarea() {
    }

    public Tarea(String nombre, int duracion) {
        this.nombre = nombre;
        this.duracion = duracion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public List<EmpleadoTareas> getTareas() {
        return tareas;
    }

    public void setTareas(List<EmpleadoTareas> tareas) {
        this.tareas = tareas;
    }
}
