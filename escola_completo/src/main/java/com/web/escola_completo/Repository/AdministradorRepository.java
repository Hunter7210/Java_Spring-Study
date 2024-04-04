package com.web.escola_completo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.web.escola_completo.Model.Administrador;

//Aqui é onde devemos criar as classes especiais
//Aqui serve para chamar as classes do crud
public interface AdministradorRepository extends CrudRepository<Administrador, String>{
  
    Administrador findByCpf(String cpf);
}
