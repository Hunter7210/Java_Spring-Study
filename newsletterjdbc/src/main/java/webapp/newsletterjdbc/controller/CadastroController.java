package webapp.newsletterjdbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import webapp.newsletterjdbc.connection.IndexDAO;

@Controller
public class CadastroController {
    @RequestMapping(value = "/", method = RequestMethod.POST)
public ModelAndView abrirCadas(@RequestParam("nome"), @RequestParam("email"),@RequestParam("tel")@RequestParam("senha") ) String email) {
        ModelAndView mv = new ModelAndView("index");
        new IndexDAO().cadastrar(nome, email, tel, senha);

        return mv;
    }

}