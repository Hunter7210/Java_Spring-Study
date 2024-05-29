package com.web.escola_completo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.web.escola_completo.Repository.AlunoRepository;
import com.web.escola_completo.Repository.NotasRepository;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AlunoController {

    @Autowired
    private AlunoRepository alr;
    
    @Autowired
    private NotasRepository ntr;
    

    @PostMapping("acesso-alun")
    public String acessoAlun(@RequestParam String ra,
            @RequestParam String senha, Model model) {
        try {
            boolean verificaCpf = alr.existsById(ra);
            boolean verificaSenha = alr.findByRa(ra).getSenha().equals(senha);

            String url = "";
            System.out.println(verificaCpf);
            System.out.println(verificaSenha);

            if (verificaCpf && verificaSenha) {
                url = "areaAluno/view-nota-aluno";
                model.addAttribute("notas", ntr.findAll());

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

    // Metodo para listar todos os professores
    @GetMapping("view-nota-aluno")
    public String listarProfAlun(org.springframework.ui.Model model) { // Utiliza a classe Model para passar dados do
                                                                       // controlador para a view.
        return "areaAluno/view-nota-aluno"; // Nome da página Thymeleaf que irá listar os professores
       
    }   

}