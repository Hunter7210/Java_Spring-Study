package crud_escola.crud_escola_app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import crud_escola.crud_escola_app.Repository.AdminRepository;



@Controller
public class ListaAdminController {
    @Autowired
    private AdminRepository adm;

    @RequestMapping(value = "/verify", method=RequestMethod.POST)
    public String verificarAdm(@PathVariable("cpf") String cpf) {
        adm.findByCpf(cpf);
        return "redirect:/lista";
    }
    
}
