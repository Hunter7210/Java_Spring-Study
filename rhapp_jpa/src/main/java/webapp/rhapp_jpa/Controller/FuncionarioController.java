package webapp.rhapp_jpa.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import webapp.rhapp_jpa.Model.Funcionario;
import webapp.rhapp_jpa.Repository.FuncionarioRespository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller // Declara a classe como controller
public class FuncionarioController {
    @Autowired
    private FuncionarioRespository fr; // Objeit da classe Funcionario repository


    //Abrir os site na pagina funcioanrios
    @RequestMapping(value = "/funcionario", method = RequestMethod.GET)
    public String abrirfuncionario(Funcionario funcionario) {
        return "funcionario/funcionario";

    }

    //Apertando o btn do forms ele chama o obj da funcionarioRepository fr, onde ele chama o metodo salvar
    @RequestMapping(value = "/funcionario", method = RequestMethod.POST)
    public String gravarfuncionario(Funcionario funcionario) {
        fr.save(funcionario);
        return "redirect:/funcionario";
    }

}
