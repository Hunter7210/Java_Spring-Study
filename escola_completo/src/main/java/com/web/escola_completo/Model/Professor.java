package com.web.escola_completo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Professor {
    
    @Id
    private String cpf;
    private String nome;
    private String email;
    private String disciplina; //Colocar o CODIGO de cada disciplina EXEMPLO: 001; 002; // UM PROFESSOR DA UMA OU DUAS DISCIPLINA
    private String disciplina_reserva; // UM PROFESSOR DA UMA DISCIPLINA
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
    public String getDisciplina_reserva() {
        return disciplina_reserva;
    }
    public void setDisciplina_reserva(String disciplina_reserva) {
        this.disciplina_reserva = disciplina_reserva;
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
