package com.web.escola_completo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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

    boolean acessoAdm = false;

    @PostMapping("cadastro-adm") // Este nome de ser o mesmo que está no post
    public String postCadastroAdm(Administrador adm) {
        boolean cpfVerificacao = pcar.existsById(adm.getCpf());

        if (cpfVerificacao) {

            ar.save(adm); // Registrnado o usuario no meu banco de dados
            // Aqui envia uma mensagem
            System.out.println("Cadastro realizado com sucesso");
        } else {
            System.out.println("Cadastro não realizado");
        }
        return "login/login-adm"; // Aqui é oque nós retornamos para o usuario neste exemplo nó iremos
        // redireciona-lo para a pagina de login
    }

    @GetMapping("/view-adm.html")
    public String acessoPageInternaAdm() {
        String url = "";
        if (acessoAdm) {
            url = "restrito/view-adm.html";
        } else {
            url = "login/login-adm";
        }
        return url;
    }

    @PostMapping("acesso-adm")
    public String acessoAdm(@RequestParam String cpf,
            @RequestParam String senha) {
        try {
            boolean verificaCpf = ar.existsById(cpf);
            boolean verificaSenha = ar.findByCpf(cpf).getSenha().equals(senha);
            String url = "";
            if (verificaCpf && verificaSenha) {
                acessoAdm = true;
                url = "redirect:/view-adm.html";
            } else {
                url = "redirect:/login-adm";
            }
            return url;
        } catch (Exception e) {
            return "redirect:/login-adm";
        }
    }
}