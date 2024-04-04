package com.web.escola_completo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.web.escola_completo.Model.PreCadAdm;


/**
 * VerificaAdmRepository
 */
public interface VerificaAdmRepository extends CrudRepository<PreCadAdm, String>{
    PreCadAdm findByCpf(String cpf);
    
}