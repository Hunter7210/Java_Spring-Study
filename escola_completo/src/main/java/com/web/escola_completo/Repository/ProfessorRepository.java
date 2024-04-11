package com.web.escola_completo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.web.escola_completo.Model.Professor;


public interface ProfessorRepository extends CrudRepository<Professor, String>{

    Professor findByCpf(String cpf);

}
