package mai.administracaousuarios.api.controller;

import mai.administracaousuarios.model.Empresa;
import mai.administracaousuarios.model.Funcionario;
import mai.administracaousuarios.repository.EmpresaRepository;
import mai.administracaousuarios.repository.FuncionarioRepository;
import mai.administracaousuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class HomePageController {
    @Autowired
    private FuncionarioRepository funcionarioRep;
    @Autowired
    private EmpresaRepository empresaRep;
    @Autowired
    private UsuarioRepository usuarioRep;

    @GetMapping("/")
    public ModelAndView home() {
        var mv = new ModelAndView("index");

        Optional<Funcionario> funcionario = funcionarioRep.findById("24f7f9d9-45df-409a-b8bf-d8454d73ab07");
        List<Empresa> empresas = empresaRep.findAll();

        mv.addObject("func", funcionario.get());
        mv.addObject("empresas", empresas);

        return mv;
    }

    @GetMapping("/adm/empresa/deletar/{id}")
    public String deletarEmpresa (@PathVariable String id) {
        empresaRep.deleteById(id);

        return "redirect:/";

    }

}
