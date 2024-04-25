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
    public String acessoAlun(@RequestParam String ra,
            @RequestParam String senha) {
        try {
            boolean verificaCpf = alr.existsById(ra);
            boolean verificaSenha = alr.findByRa(ra).getSenha().equals(senha);

            String url = "";
            System.out.println(verificaCpf);
            System.out.println(verificaSenha);

            if (verificaCpf && verificaSenha) {
                url = "area_aluno/view-nota-aluno";

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