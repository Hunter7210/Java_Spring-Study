package br.com.diogotb.apirest_senai.Model;

import java.io.Serializable;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Responsael
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Responsavel implements Serializable {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nonnull
    private String nome;

    @OneToOne(mappedBy = "responsavel")
    private Ambiente ambiente;

}