package com.web.escola_completo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.web.escola_completo.Model.Administrador;
import com.web.escola_completo.Repository.AdministradorRepository;
import com.web.escola_completo.Repository.PreCadAdmRepository;

@Controller
public class AdministradorController {
    @Autowired // Auto escrita, no caso ele faz uma auto escrita no banco de dados, ele escreve
               // no banco de dados
    private AdministradorRepository ar;

    @Autowired
    private PreCadAdmRepository pcar;


    @PostMapping("cadastro-adm") // Este nome de ser o mesmo que está no post
    public String postCadastroAdm(Administrador adm) {
        String cpfVerificacao = pcar.findByCpf(adm.getCpf()).getCpf();


        if(cpfVerificacao.equals(adm.getCpf())){
        
        ar.save(adm); //Registrnado o usuario no meu banco de dados
        // Aqui envia uma mensagem
        System.out.println("Cadastro realizado com sucesso");
        }
        return "login/login-adm"; // Aqui é oque nós retornamos para o usuario neste exemplo nó iremos
                        // redireciona-lo para a pagina de login
    }

}
