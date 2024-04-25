package com.web.escola_completo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.web.escola_completo.Model.Notas;

public interface NotasRepository extends CrudRepository<Notas, Long> {

    @Query(value = "SELECT notas.valor_notas AS Notas, " +
            "notas.disc_cod_disciplina AS COD_MATERIA, " +
            "notas.alu_ra AS RA_ALUNO, " +
            "disciplinas.nome AS Nome_Materia, " +
            "professor.nome AS Nome_Professor " +
            "FROM notas " +
            "INNER JOIN disciplinas ON disciplinas.cod_disciplina = notas.disc_cod_disciplina " +
            "INNER JOIN professor ON professor.cpf = disciplinas.prof_cpf", nativeQuery = true)
    List<Object[]> buscarNotasDetalhadas();
}
