package crud_escola.crud_escola_app.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import crud_escola.crud_escola_app.Model.Admin;
import java.util.List;


public interface AdminRepository extends CrudRepository<Admin, String>{

    
    Admin findByNome(String nome);

    @Query(value = "Select cpf from BancoAdmin")List<Admin> findByCpf(String cpf);
    @Query(value = "Select senha from BancoAdmin")List<Admin> findBySenha(String senha);


    
} 
