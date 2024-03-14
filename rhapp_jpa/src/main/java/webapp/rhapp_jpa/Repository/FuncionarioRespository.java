package webapp.rhapp_jpa.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import webapp.rhapp_jpa.Model.Funcionario;
import java.util.List;


public interface FuncionarioRespository extends CrudRepository<Funcionario, Long> { //O tipo long é o unico que me possibilita fazer um auto_increment

    // Criando para a busca Funcionario por id ou chave primaria
    Funcionario findById(long id);

    // Criando a busca para Funcionarios por nome
    //Não é necessário escrever o codigo em SQL, pois ele ja faz isso com o metodo findByNome, findById etc
    Funcionario findByNome(String nome);

    //Buscando varios nomes
    //Criando um codigo em SQL que toda vez que eu chamar findByNomes ele me retorna o select 
    @Query(value = "select u from Funcionario u where u.nome like %?1%")
    List<Funcionario> findByNomes(String nome);

    //Pesquisar todos os metodos dentro da classe CRUD, aquela em que nós estamos fazendo a extensão
}
