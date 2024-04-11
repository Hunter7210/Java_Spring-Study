package com.web.escola_completo.Repository;

/* import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata; */
import org.springframework.data.repository.CrudRepository;

import com.web.escola_completo.Model.PreCadAdm;
/* import java.util.List; */



public interface PreCadAdmRepository extends CrudRepository<PreCadAdm, String>{

    boolean findByCpf(String cpf); //Se fosse list eu retornaria varios valores, como aqui so quero um, não é necessário
    

}
