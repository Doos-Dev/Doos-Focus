package com.doos.doosfocus;

import jakarta.persistence.*;

@Entity
public class RevisionSemanal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int semana;

    @Column(length = 1000)
    private String queFuncionoYQueNo;

    @ManyToOne
    @JoinColumn(name = "meta_id")
    private Meta90Dias meta;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getSemana() { return semana; }
    public void setSemana(int semana) { this.semana = semana; }

    public String getQueFuncionoYQueNo() { return queFuncionoYQueNo; }
    public void setQueFuncionoYQueNo(String queFuncionoYQueNo) { this.queFuncionoYQueNo = queFuncionoYQueNo; }

    public Meta90Dias getMeta() { return meta; }
    public void setMeta(Meta90Dias meta) { this.meta = meta; }
}

