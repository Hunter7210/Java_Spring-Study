package com.web.escola_completo.Model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Disciplinas implements Serializable {

    // Para realizar uma foreigny key
    // @ManyToOne
    // @JoinColumn(name = "forumId")
    // private Forum forum
    @Id
    private String codDisciplina;
    private String nome;
    private String duracao;

    //Relacionar essa tabela com sa tabelas de aluno e professor

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
    public String getDuracao() {
        return duracao;
    }
    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }


    



}
