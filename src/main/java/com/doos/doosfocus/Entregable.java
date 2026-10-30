package com.doos.doosfocus;

import jakarta.persistence.*;

@Entity
public class Entregable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    // Numero de semana dentro de los 90 dias (1 a 13)
    private int semana;

    // Porcentaje de avance, de 0 a 100
    private int porcentajeAvance;

    @ManyToOne
    @JoinColumn(name = "meta_id")
    private Meta90Dias meta;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public int getSemana() { return semana; }
    public void setSemana(int semana) { this.semana = semana; }

    public int getPorcentajeAvance() { return porcentajeAvance; }
    public void setPorcentajeAvance(int porcentajeAvance) { this.porcentajeAvance = porcentajeAvance; }

    public Meta90Dias getMeta() { return meta; }
    public void setMeta(Meta90Dias meta) { this.meta = meta; }


}
