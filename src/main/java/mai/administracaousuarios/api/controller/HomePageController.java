package mai.administracaousuarios.api.controller;

import jakarta.servlet.http.HttpServletRequest;
import mai.administracaousuarios.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomePageController {
    @Autowired
    private FuncionarioRepository funcionarioRep;

    @GetMapping("/")
    public ModelAndView home(HttpServletRequest req) {
        var mv = new ModelAndView("index");
        var funcionario = funcionarioRep.findById("24f7f9d9-45df-409a-b8bf-d8454d73ab07");

        mv.addObject("func", funcionario.get());

        return mv;
    }
}
