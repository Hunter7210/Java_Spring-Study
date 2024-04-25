package com.web.escola_completo.Model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Turma implements Serializable{

    @Id
    private String cod_turma;
    private String nome;
    private String periodo;

    //Criando uma foreight key para o professor
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prof.cpf")
    private Professor prof;

    public String getCod_turma() {
        return cod_turma;
    }

    public void setCod_turma(String cod_turma) {
        this.cod_turma = cod_turma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

}
