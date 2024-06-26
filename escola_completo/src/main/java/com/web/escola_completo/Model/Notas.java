package com.web.escola_completo.Model;

import java.io.Serializable;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idnotas;
    private Double valornotas;

    // Criando uma foreight key para chamar o RA do aluno
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alu.ra")
    private Aluno alu;
  

    // Criando uma foreight key para chamar as disciplinas
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "disc.codDisciplina")
    private Disciplinas disc;


      
    public Aluno getAlu() {
        return alu;
    }

    public void setAlu(Aluno alu) {
        this.alu = alu;
    }
    
    public Disciplinas getDisc() {
        return disc;
    }

    public void setDisc(Disciplinas disc) {
        this.disc = disc;
    }

    public Double getValornotas() {
        return valornotas;
    }

    public void setValornotas(Double valornotas) {
        this.valornotas = valornotas;
    }

    public Long getIdnotas() {
        return idnotas;
    }

    public void setIdnotas(Long idnotas) {
        this.idnotas = idnotas;
    }
}