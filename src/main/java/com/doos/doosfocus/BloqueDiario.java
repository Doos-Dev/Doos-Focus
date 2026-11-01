package com.doos.doosfocus;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class BloqueDiario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;

    // ¿Cumpliste el bloque del dia?
    private boolean cumplido;

    // ¿Hiciste la prueba de 1% mejor?
    private boolean pruebaDelDia;

    @Column(length = 500)
    private String nota;

    // Cada bloque diario peertenece a una meta
    @ManyToOne
    @JoinColumn(name = "meta_id")
    private Meta90Dias meta;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public boolean isCumplido() { return cumplido; }
    public void setCumplido(boolean cumplido) { this.cumplido = cumplido; }

    public boolean isPruebaDelDia() { return pruebaDelDia; }
    public void setPruebaDelDia(boolean pruebaDelDia) { this.pruebaDelDia = pruebaDelDia; }

    public String getNota() { return nota; }
    public void setNota(String nota) { this.nota = nota; }

    public Meta90Dias getMeta() { return meta; }
    public void setMeta(Meta90Dias meta) { this.meta = meta; }

}
