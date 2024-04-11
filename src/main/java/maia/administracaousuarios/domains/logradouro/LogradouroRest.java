package maia.administracaousuarios.domains.logradouro;

import maia.administracaousuarios.domains.estado.Estado;
import maia.administracaousuarios.repositories.EstadoRepository;
import maia.administracaousuarios.repositories.LogradouroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/logradouro")
public class LogradouroRest {

    @Autowired
    private LogradouroRepository logradouroRep;

    @PutMapping(name = "/delete/{id}")
    public Boolean put(@PathVariable String id) {
        logradouroRep.deleteById(id);
        return true;
    }

    @PutMapping(name = "/updade/{id}")
    public void put(@PathVariable String id, @RequestBody Logradouro body) {
        try{
            Logradouro logradouro = logradouroRep.findById(id).get();
            logradouro.setCep(body.getCep());
            logradouroRep.save(logradouro);
        }catch(NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }
}
