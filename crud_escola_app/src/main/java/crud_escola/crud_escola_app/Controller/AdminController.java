package crud_escola.crud_escola_app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import crud_escola.crud_escola_app.Model.Admin;
import crud_escola.crud_escola_app.Repository.AdminRepository;


/**
 * AdminController
 */
@Controller //Declara a classe como contoller
public class AdminController {

    @Autowired
    private AdminRepository adm;


    @RequestMapping(value = "/adm", method=RequestMethod.GET)
    public String verificarAdm(Admin admin) {
        return "admin/admin";
    }
    

    @RequestMapping(value = "/verificar", method=RequestMethod.POST)
    public String verificarAdm(Admin admin){
        adm.
    }
    
}