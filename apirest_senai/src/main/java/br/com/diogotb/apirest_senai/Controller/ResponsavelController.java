package br.com.diogotb.apirest_senai.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.diogotb.apirest_senai.Model.Responsavel;
import br.com.diogotb.apirest_senai.Repository.ResponsavelRepository;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/responsaveis")
public class ResponsavelCotroller {

    @Autowired
    private ResponsavelRepository repository;

    @GetMapping
    public List<Responsavel> getAllResponsaveis() {
        return (List<Responsavel>) repository.findAll();
    }

    @PostMapping
    public Responsavel createResponsavel(@RequestBody Responsavel responsavel) {
        return repository.save(responsavel);
    }

    @GetMapping("/{id}")
    public Optional<Responsavel> getResponsavelById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PutMapping("/{id}")
    public Responsavel putResponsavel(@PathVariable Long id, @RequestBody Responsavel responsavel) {
        Optional<Responsavel> responsavel2 = repository.findById(id);
        if (responsavel2.isPresent()) {
            responsavel.setId(id);
            return repository.save(responsavel);
        } else {
            return null;
        }
    }

}
