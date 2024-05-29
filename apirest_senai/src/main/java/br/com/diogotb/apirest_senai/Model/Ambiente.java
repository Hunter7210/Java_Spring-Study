package br.com.diogotb.apirest_senai.Model;

import java.io.Serializable;

import java.util.List;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ambiente implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nonnull
    private String nome;

    @OneToMany(mappedBy = "ambiente")
    private List<AtivoPatrimonial> ativos;

    @OneToOne
    @JoinColumn(name = "responsavel_id", nullable = false)
    private Responsavel responsavel;

}
