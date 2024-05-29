package com.web.escola_completo.Model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Disciplinas implements Serializable {

    // Para realizar uma foreigny key
    // @ManyToOne
    // @JoinColumn(name = "forumId")
    // private Forum forum
    @Id
    private String coddisciplina;
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cpf") // nome da coluna na tabela Disciplinas
    private Professor prof;
    

    public Professor getProf() {
        return prof;
    }
    public void setProf(Professor prof) {
        this.prof = prof;
    }
    public String getCoddisciplina() {
        return coddisciplina;
    }
    public void setCoddisciplina(String coddisciplina) {
        this.coddisciplina = coddisciplina;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
