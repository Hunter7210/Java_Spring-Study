package com.web.escola_completo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.web.escola_completo.Model.Administrador;
import com.web.escola_completo.Model.Aluno;
import com.web.escola_completo.Model.Disciplinas;
import com.web.escola_completo.Model.Professor;
import com.web.escola_completo.Model.Turma;
import com.web.escola_completo.Repository.AdministradorRepository;
import com.web.escola_completo.Repository.AlunoRepository;
import com.web.escola_completo.Repository.DisciplinasRepository;
import com.web.escola_completo.Repository.PreCadAdmRepository;
import com.web.escola_completo.Repository.ProfessorRepository;
import com.web.escola_completo.Repository.TurmaRepository;

@Controller
public class AdministradorController {
    @Autowired // Auto escrita, no caso ele faz uma auto escrita no banco de dados, ele escreve
               // no banco de dados
    private AdministradorRepository ar;

    @Autowired
    private PreCadAdmRepository pcar;

    @Autowired
    private ProfessorRepository pfr;

    @Autowired
    private AlunoRepository alr;

    @Autowired
    private DisciplinasRepository dir;

    @Autowired
    private TurmaRepository turm;

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

    // Criando metodo para acesso a pagina solicitada, se o requerente houver o
    // nivel de acesso minimo ele entra
    @GetMapping("/cad-mat")
    public String acessoCadMat(Model model) {
        String url = "";
        try {
            if (acessoAdm) {
                // Utiliza a classe Model para passar dados do controlador para a view.
                model.addAttribute("materias", dir.findAll());
                model.addAttribute("professores", pfr.findAll());
                url = "restrito/cadastro-rest/cad-materias";

                System.out.println("Você tem acesso a esta pagina");
            } else {
                System.out.println("Você não tem acesso a esta pagina");
                url = "login/login-adm";
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return url;
    }

    @GetMapping("/cad-turm")
    public String acessoCadTurm(Model model) {
        String url = "";
        try {
            if (acessoAdm) {
                model.addAttribute("turmas", turm.findAll());
                url = "restrito/cadastro-rest/cad-turma";
            } else {
                url = "login/login-adm";
            }
        } catch (Exception e) {
            System.out.println("Você não tem acesso a esta pagina!");
        }
        return url;
    }

    // Metodo para listar todos os professores
    @GetMapping("/view-db")
    public String listarProfAlun(Model model) { // Utiliza a classe Model para passar dados do controlador para a view.
        model.addAttribute("professores", pfr.findAll());
        model.addAttribute("alunos", alr.findAll());
        return "restrito/view-db.html"; // Nome da página Thymeleaf que irá listar os professores
    }

    // Metodo para cadastrar o professor
    @PostMapping("cadastro-prof")
    public String cadastroProf(Professor prof) {
        boolean cpfVerificacao = pfr.existsById(prof.getCpf());

        String url = "";
        System.out.println("Verifica se é false" + cpfVerificacao);
        // Verfica se o cpf existe, se não ele realiza o cadastro
        if (!cpfVerificacao) {
            pfr.save(prof); // Registrnado o usuario no meu banco de dados

            url = "login/login-prof";
            System.out.println("Cadastro realizado com sucesso");// Aqui envia uma mensagem
        } else {
            System.out.println("Cadastro não realizado");
            url = "redirect:/cadastro-prof";
        }
        return url; // Aqui é oque nós retornamos para o usuario neste exemplo nós iremos
        // redireciona-lo para a pagina de login
    }

    // Metodo para cadastrar o aluno
    @PostMapping("cadastro-alun")
    public String cadastroAluno(Aluno alun) {
        boolean cpfVerificacao = alr.existsById(alun.getMatricula());

        String url = "";

        // Verfica se o cpf existe, se não ele realiza o aluno
        if (!cpfVerificacao) {
            alr.save(alun); // Registrnado o usuario no meu banco de dados

            url = "login/login-aluno";
            System.out.println("Cadastro realizado com sucesso");// Aqui envia uma mensagem
        } else {
            System.out.println("Cadastro não realizado");
            url = "login/login-aluno";
        }
        return url; // Aqui é oque nós retornamos para o usuario neste exemplo nós iremos
        // redireciona-lo para a pagina de login
    }

    @PostMapping("cadastro-turma")
    public String cadastroTurma(Turma turma) {
        boolean turmaVerifica = turm.existsById(turma.getCodturma());
        String url = "";
        // Verfica se o cpf existe, se não ele realiza o aluno
        if (!turmaVerifica) {
            turm.save(turma); // Registrnado o usuario no meu banco de dados

            url = "restrito/cadastro-rest/cad-turma.html";
            System.out.println("Cadastro realizado com sucesso");// Aqui envia uma mensagem
        } else {
            System.out.println("Cadastro não realizado");
            url = "login/login-aluno";
        }
        return url; // Aqui é oque nós retornamos para o usuario neste exemplo nós iremos
        // redireciona-lo para a pagina de login
    }

    @PostMapping("cadastro-materias")
    public String cadastroMaterias(Disciplinas disc) {
        // Criar uma boolean para verificar se ja existe o valor na minha tabela
        boolean codDiscVerif = dir.existsById(disc.getCoddisciplina());
        String url = "";
        // Verfica se o cpf existe, se não ele realiza o aluno
        if (!codDiscVerif) {

            dir.save(disc);

            // Registrnado o usuario no meu banco de
            url = "redirect:/view-adm.html";
        } else {
            System.out.println("Cadastro não realizado");
            url = "login/login-aluno";
        }
        return url; // Aqui é oque nós retornamos para o usuario neste exemplo nós iremos
        // redireciona-lo para a pagina de login
    }

}