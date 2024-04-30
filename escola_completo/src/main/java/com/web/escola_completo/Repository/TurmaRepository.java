package com.web.escola_completo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.web.escola_completo.Model.Turma;



/**
 * TurmaRepository
 */
public interface TurmaRepository extends CrudRepository<Turma, String>{

    Turma findByCodturma(String codturma);
}