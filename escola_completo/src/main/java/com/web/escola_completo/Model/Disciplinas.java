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
    private String codDisciplina;
    private String nome;

    //Criando uma foreight key de professor
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prof.cpf")
    private Professor prof;


    public String getCodDisciplina() {
        return codDisciplina;
    }
    public void setCodDisciplina(String codDisciplina) {
        this.codDisciplina = codDisciplina;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
