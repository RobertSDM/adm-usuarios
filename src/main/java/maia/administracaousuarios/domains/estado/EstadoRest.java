package maia.administracaousuarios.domains.estado;

import maia.administracaousuarios.domains.cidade.Cidade;
import maia.administracaousuarios.repositories.CidadeRepository;
import maia.administracaousuarios.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/estado")
public class EstadoRest {

    @Autowired
    private EstadoRepository estadoRep;

    @PutMapping(name = "/delete/{id}")
    public Boolean put(@PathVariable String id) {
        estadoRep.deleteById(id);
        return true;
    }

    @PutMapping(name = "/updade/{id}")
    public void put(@PathVariable String id, @RequestBody Estado body) {
        try{
            Estado estado = estadoRep.findById(id).get();
            estado.setNome(body.getNome());
            estado.setSigla(body.getSigla());
            estadoRep.save(estado);
        }catch(NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }
}
