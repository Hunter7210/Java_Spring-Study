package crud_escola.crud_escola_app.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * AdminController
 */
@Controller //Declara a classe como contoller
public class AdminController {

    @RequestMapping(value = "/Adm", method=RequestMethod.GET)
    public String abrir(@RequestParam String param) {
        return new String();
    }
    
}