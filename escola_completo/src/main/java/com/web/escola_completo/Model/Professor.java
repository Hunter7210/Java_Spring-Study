package com.web.escola_completo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Professor {
    
    
    @Id
    private String nome;
    private String email;
    private String disciplina; //Pensar em criar uma tabela para armazenar todas as disciplinas e tambem todas as turmas
    private String cpf;
    private String senha;


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDisciplina() {
        return disciplina;
    }
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

}
