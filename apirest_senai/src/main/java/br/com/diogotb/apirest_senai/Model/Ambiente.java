package br.com.diogotb.apirest_senai.Model;

import java.io.Serializable;
import java.util.List;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter; //lombok permite facilita a criação de getter and setters como usado a seguir.

@Entity
@Getter
@Setter
public class Ambiente implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private String nome;

    @OneToMany(mappedBy = "ambiente")
    private List<AtivoPatrimonial> ativos;

    @ManyToOne
    @JoinColumn(name = "responsavel_id", nullable = false)
    private Responsavel responsavel;

    
}