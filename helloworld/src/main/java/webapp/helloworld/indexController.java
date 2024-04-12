package webapp.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class indexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView abrirIndex() {
        ModelAndView mv = new ModelAndView("index");

        String mensagem = "Olá, seja bem-vinda(o)!";
        mv.addObject("msg", mensagem);

        return mv;
    }

    // Quando na minha poagina index for excutador o methodo post ele armazeena
    // algum valor em buscar
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView buscarIndex(@RequestParam("buscar") String buscar) {
        ModelAndView mv = new ModelAndView("index");
        String mensagem = "Resultado da Busca !";
        mv.addObject("msg", mensagem);
        mv.addObject("buscar", buscar);

        return mv;
    }

}
