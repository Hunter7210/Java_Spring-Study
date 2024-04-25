package com.web.escola_completo.Model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Notas implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_notas")
    private Long id_notas;

    private Double valor_notas;

    // Criando uma foreight key para chamar o RA do aluno
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alu.ra")
    private Aluno alu;
    
    // Criando uma foreight key para chamar as disciplinas
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "disc.codDisciplina")
    private Disciplinas disc;


    public Double getValor_notas() {
        return valor_notas;
    }

    public void setValor_notas(Double valor_notas) {
        this.valor_notas = valor_notas;
    }

    public Long getId_notas() {
        return id_notas;
    }

    public void setId_notas(Long id_notas) {
        this.id_notas = id_notas;
    }
}