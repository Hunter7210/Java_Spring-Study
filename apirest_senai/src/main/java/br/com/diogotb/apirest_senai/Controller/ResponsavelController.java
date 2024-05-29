package br.com.diogotb.apirest_senai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.diogotb.apirest_senai.Model.Responsavel;
import br.com.diogotb.apirest_senai.Repository.ResponsavelAmbiente;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//put atualiza os dados

//Api rest me possibilita ler e inserir dados
//Api somente me possibilita ler 
@RestController
@RequestMapping("/responsavel")
public class ResponsavelController {
    @Autowired
    private ResponsavelAmbiente repository;

    @GetMapping
    public List<Responsavel> getAllResponsaveis() {
        return (List<Responsavel>) repository.findAll();
    }

    @PostMapping
    public Responsavel createResponsavel(@RequestBody Responsavel responsavel) {
        return repository.save(responsavel);
    }

}
