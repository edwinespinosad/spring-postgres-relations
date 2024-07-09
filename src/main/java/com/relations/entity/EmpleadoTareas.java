package com.relations.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "empleado_tareas")
public class EmpleadoTareas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    @JsonIgnoreProperties("tareas")
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "tareas_id")
    @JsonIgnoreProperties("tareas")
    private Tarea tarea;

    public EmpleadoTareas() {
    }

    public EmpleadoTareas(Empleado empleado, Tarea tarea) {
        this.empleado = empleado;
        this.tarea = tarea;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }
}
