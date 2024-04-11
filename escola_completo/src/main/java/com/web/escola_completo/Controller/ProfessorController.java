package com.web.escola_completo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
/* import org.springframework.web.bind.annotation.GetMapping; */
import org.springframework.web.bind.annotation.PostMapping;
/* import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping; */
import org.springframework.web.bind.annotation.RequestParam;


import com.web.escola_completo.Repository.ProfessorRepository;

@Controller
public class ProfessorController {

    @Autowired
    private ProfessorRepository pfc;

    @PostMapping("acesso-prof")
    public String acessoProf(@RequestParam String cpf,
            @RequestParam String senha) {
        try {
            boolean verificaCpf = pfc.existsById(cpf);
            boolean verificaSenha = pfc.findByCpf(cpf).getSenha().equals(senha);
            String url = "";
            System.out.println(verificaCpf);
            System.out.println(verificaSenha);
            if (verificaCpf && verificaSenha) {
                url = "redirect:/login-adm";

                System.out.println("Login realizado com sucesso");
            } else {
                url = "redirect:/login-prof";
                System.out.println("Login Fracassado");
            }
            return url;
        } catch (Exception e) {
            return "redirect:/login-adm";
        }
    }
}
