package com.web.escola_completo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.web.escola_completo.Model.Notas;

/**
 * NotasRepository
 */
public interface NotasRepository extends CrudRepository<Notas, Long>{

    Notas findByIdnotas(Long idnotas);
    
}