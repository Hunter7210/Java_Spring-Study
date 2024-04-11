package com.web.escola_completo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.web.escola_completo.Repository.AlunoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AlunoController {

    @Autowired
    private AlunoRepository alr;


    @PostMapping("acesso-alun")
    public String acessoAlun(@RequestParam String matricula,
            @RequestParam String senha) {
        try {
            boolean verificaCpf = alr.existsById(matricula);
            boolean verificaSenha = alr.findByMatricula(matricula).getSenha().equals(senha);
            
            String url = "";
            System.out.println(verificaCpf);
            System.out.println(verificaSenha);
            
            if (verificaCpf && verificaSenha) {
                url = "redirect:/login-adm";

                System.out.println("Login realizado com sucesso");
            } else {
                url = "redirect:/login-alun";
                System.out.println("Login Fracassado");
            }
            return url;
        } catch (Exception e) {
            return "redirect:/login-adm";
        }
    }

}
