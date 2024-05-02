package com.web.escola_completo.Repository;

import org.springframework.data.repository.CrudRepository;
import com.web.escola_completo.Model.Disciplinas;

/**
 * DisciplinasRepository
 */
public interface DisciplinasRepository extends CrudRepository<Disciplinas, String> {
    Disciplinas findByCoddisciplina(String coddisciplina);
}