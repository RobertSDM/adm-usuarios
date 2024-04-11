package maia.administracaousuarios.domains.cidade;

import maia.administracaousuarios.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/cidade")
public class CidadeRest {

    @Autowired
    private CidadeRepository cidadeRep;

    @PutMapping(name = "/delete/{id}")
    public Boolean put(@PathVariable String id) {
        cidadeRep.deleteById(id);
        return true;
    }

    @PutMapping(name = "/updade/{id}")
    public void put(@PathVariable String id, @RequestBody Cidade body) {
        try{
            Cidade cidade = cidadeRep.findById(id).get();
            cidade.setNome(body.getNome());
            cidadeRep.save(cidade);
        }catch(NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }
}
