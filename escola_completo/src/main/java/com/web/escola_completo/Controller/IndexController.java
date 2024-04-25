package com.web.escola_completo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;

//Sinaliza para o Spring que esta classe é uma controller
@Controller
// Nesta classe deve conter minhas navegações
public class IndexController {
    @GetMapping("/")
    public String acessoHome() {
        return "index";
    }

    @GetMapping("/home")
    public String acessoHome2() {
        return "index";
    }

    @GetMapping("/login-adm")
    public String acessoLoginAdm() {
        return "login/login-adm";
    }

    @GetMapping("/cad-adm")
    public String acessoCadAdm() {
        return "templates/cadastro/cad-adm";
    }

    @GetMapping("/login-prof")
    public String acessoLoginProf() {
        return "login/login-prof";
    }

    @GetMapping("/cad-prof")
    public String acessoCadProf() {
        return "cadastro/cad-prof";
    }

    @GetMapping("/cad-alun")
    public String acessoCadAlun() {
        return "cadastro/cad-aluno";
    }

    @GetMapping("/login-alun")
    public String acessAlun() {
        return "login/login-aluno";
    }
    
}
