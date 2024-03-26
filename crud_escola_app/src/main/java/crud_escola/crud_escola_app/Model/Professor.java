package crud_escola.crud_escola_app.Model;

import java.io.Serializable;

import jakarta.persistence.Entity;

@Entity
public class Professor implements Serializable{
    
    private String nome;
    private String dataNasc;
    private String especialidade;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDataNasc() {
        return dataNasc;
    }
    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }
    public String getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }


    
}
