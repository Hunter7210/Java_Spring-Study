package webapp.rhapp_jpa.Model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//Entidade é um registro de mundo real para aquela classe. Isso vai se transformar em uma tabela.
@Entity
// A partit daqui eu tranformo o meu modelo em algo real no meu banco de dados,
// transformando em dados(bites)
public class Funcionario implements Serializable { // Serializable grava os dados em bites, o JPA faz esta conversão de
                                                   // dados em bites
    private static final long serialVersionUID = 1L;
    //Tudo isso para devefinir minha chave primaria; anotação @Id para transformar o atributo long id em chave primária na tabela Funcionario dentro do banco de dados.
    @Id
    //E com isso ele fica auto incremental
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private String nome;
    private String email;

    // Criação dos Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

}
