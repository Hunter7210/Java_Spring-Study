package br.com.diogotb.apirest_senai.Repository;

import org.springframework.data.repository.CrudRepository;

import br.com.diogotb.apirest_senai.Model.Responsavel;

//Basicamete esta interface serve somente para gerenciar os meus metodos do CrudRepository, conectando-o ao meu model
public interface ResponsavelRepository extends CrudRepository<Responsavel, Long>{
    
}
