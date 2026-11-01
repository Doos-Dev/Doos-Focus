package com.doos.doosfocus;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Meta90Dias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(length = 1000)
    private String descripcion;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    // Que cuenta como el "1% mejor" cada dia
    private String pruebaDiaria;

    // Area de la meta: Codigo, Salud, Finanzas, Estudios, etc.
    private String area;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public LocalDate getFechaInicio() { return fechaInicio = fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }

    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }

    public String getPruebaDiaria() { return pruebaDiaria; }
    public void setPruebaDiaria(String pruebaDiaria) { this.pruebaDiaria = pruebaDiaria; }

    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }

    }
