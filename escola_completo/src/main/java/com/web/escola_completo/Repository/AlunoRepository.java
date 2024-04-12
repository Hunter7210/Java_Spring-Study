package com.web.escola_completo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.web.escola_completo.Model.Aluno;
/**
 * AlunoRepository
 */
public interface AlunoRepository extends CrudRepository<Aluno, String>{
    
    Aluno findByMatricula(String matricula);
}