package br.com.diogotb.apirest_senai.Model;

import java.io.Serializable;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Responsavel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nonnull
    private String nome;

    @OneToOne(mappedBy = "responsavel")
    private Ambiente ambiente;

    public void setId(Long id2) {
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }
    
}
