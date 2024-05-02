package com.web.escola_completo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.web.escola_completo.Model.Disciplinas;



/**
 * DisciplinasRepository
 */
public interface DisciplinasRepository extends CrudRepository<Disciplinas, String> {
       @Query("SELECT d FROM Disciplinas d JOIN d.prof p WHERE p.cpf = :cpf")
    List<Disciplinas> findByProfCpf(@Param("cpf") String cpf);
}