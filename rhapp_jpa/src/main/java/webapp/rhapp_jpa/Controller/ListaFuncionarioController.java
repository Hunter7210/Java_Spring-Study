package webapp.rhapp_jpa.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import webapp.rhapp_jpa.Model.Funcionario;
import webapp.rhapp_jpa.Repository.FuncionarioRespository;

@Controller
public class ListaFuncionarioController {
    @Autowired
    private FuncionarioRespository fr;

    @RequestMapping(value = "/lista", method = RequestMethod.GET)
    public ModelAndView listarfuncionario() {
        ModelAndView mv = new ModelAndView("funcionario/listarfuncionarios");
        mv.addObject("funcionarios", fr.findAll());
        return mv;
    }

    @RequestMapping(value = "/deletarfuncionario/{id}", method = RequestMethod.GET)
    public String deletarFuncionario(@PathVariable("id") long id) {
        fr.delete(fr.findById(id));
        return "redirect:/lista";
    }

    @RequestMapping(value = "/editarfuncionario/{id}", method = RequestMethod.GET)
    public ModelAndView abrireditarfuncionario(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView("funcionario/editarfuncionario");
        mv.addObject("funcionario", fr.findById(id));
        return mv;
    }

    @RequestMapping(value = "/editarfuncionario/{id}", method = RequestMethod.POST)
    public String updateFuncionario(Funcionario funcionario) {
        fr.save(funcionario);
        return "redirect:/lista";
    }
}
