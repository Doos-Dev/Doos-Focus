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

}
