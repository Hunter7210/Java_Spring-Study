package com.web.escola_completo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.web.escola_completo.Model.Administrador;
import com.web.escola_completo.Model.Professor;
import com.web.escola_completo.Repository.AdministradorRepository;
import com.web.escola_completo.Repository.PreCadAdmRepository;
import com.web.escola_completo.Repository.ProfessorRepository;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class AdministradorController {
    @Autowired // Auto escrita, no caso ele faz uma auto escrita no banco de dados, ele escreve
               // no banco de dados
    private AdministradorRepository ar;

    @Autowired
    private PreCadAdmRepository pcar;

    @Autowired
    private ProfessorRepository profRepo;

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

    // Metodo para realizar logout do adm
    @PostMapping("logout-adm")
    public String logoutAdm() {
        try {
            String url = "";
            if (acessoAdm) {
                acessoAdm = false;

                url = "index.html";
                System.out.println("Logout concluido com sucesso!");
            } else {
                url = "redirect:/login-adm";
                System.out.println("Por favor, Cadastre=se!");
            }
            return url;
        } catch (Exception e) {
            return "redirect:/login-adm";
        }
    }


    //Metodo para cadastrar o professor
    @PostMapping("cadastro-prof")
    public String cadastroProf(Professor prof) {
        boolean cpfVerificacao = profRepo.existsById(prof.getCpf());

        String url = "";

        //Verfica se o cpf existe, se não ele realiza o cadastro
        if (!cpfVerificacao) {
            profRepo.save(prof); // Registrnado o usuario no meu banco de dados

            url = "login/login-prof";
            System.out.println("Cadastro realizado com sucesso");// Aqui envia uma mensagem
        } else {
            System.out.println("Cadastro não realizado");
            url = "redirect:/cadastro-prof";
        }
        return url; // Aqui é oque nós retornamos para o usuario neste exemplo nós iremos
        // redireciona-lo para a pagina de login
    }



    //Metodo para listar todos os professores
    @GetMapping("list-prof")
    public ModelAndView listarProf() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("professor", ar.findAll());
        return mv;
    }
    

/*     @PostMapping("list-prof")
    public String listarProf(Professor prof) {
        profRepo.findAll();
        
        String url = "";
        System.out.println(listarProf);
        
        
        
        return url;
    } */
    

}