package com.web.escola_completo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.escola_completo.Model.Disciplinas;
import com.web.escola_completo.Model.Notas;
import com.web.escola_completo.Model.Professor;
import com.web.escola_completo.Repository.AlunoRepository;
import com.web.escola_completo.Repository.DisciplinasRepository;
import com.web.escola_completo.Repository.NotasRepository;
import com.web.escola_completo.Repository.ProfessorRepository;

@Controller
public class ProfessorController {

    @Autowired
    private ProfessorRepository pfc;

    @Autowired
    private AlunoRepository alr;

    @Autowired
    private NotasRepository ntr;

    @Autowired
    private DisciplinasRepository dir;

    String cpf_logado;
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
                url = "areaProfessor/view-home-prof";
                cpf_logado = cpf;
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

    // Metodo para listar todos os alunos
    @GetMapping("view-alunos-prof")
    public String acessProfViewAlun(Model model) { // Utiliza a classe Model para passar dados do controlador para a
                                                   // vi ew.
        model.addAttribute("alunos", alr.findAll());
        return "areaProfessor/view-todos-alunos";// Nome da página Thymeleaf que irá listar os professores
    }

    @GetMapping("cad-nota")
    public String acessProfLancNo(Model model) {
        List<Disciplinas> disciplinas = dir.findByProfCpf(cpf_logado);
    
        model.addAttribute("alunos", alr.findAll());
        model.addAttribute("disciplinas", disciplinas);
        return "areaProfessor/cadastro-nota";
        
    }
    
    @PostMapping("cadastro-nota") // Este nome de ser o mesmo que está no post
    public String postCadastroAdm(Notas nt) {
        boolean cpfVerificacao = ntr.existsById(nt.getIdnotas());

        if (!cpfVerificacao) {
            ntr.save(nt); // Registrnado o usuario no meu banco de dados
            // Aqui envia uma mensagem
            System.out.println("Cadastro realizado com sucesso");
        } else {
            System.out.println("Cadastro não realizado");
        }
        return "areaProfessor/cadastro-nota"; // Aqui é oque nós retornamos para o usuario neste exemplo nó iremos
        // redireciona-lo para a pagina de login
    }

}
