package mai.administracaousuarios.domains.cidade;

import mai.administracaousuarios.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/cidade")
public class CidadeRest {

    @Autowired
    private CidadeRepository cidadeRep;

    @GetMapping(value = "/find/all")
    public ResponseEntity<List<Cidade>> findAll() {
        List<Cidade> cidades = cidadeRep.findAll();
        if(cidades.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(cidades);
    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<Cidade> findById(@PathVariable String id) {
        try {
            Cidade cidade = cidadeRep.findById(id).get();
            return ResponseEntity.ok().body(cidade);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping(name = "/delete/{id}")
    public ResponseEntity put(@PathVariable String id) {
        cidadeRep.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(name = "/update/{id}")
    public ResponseEntity put(@PathVariable String id, @RequestBody Cidade body) {
        try{
            Cidade cidade = cidadeRep.findById(id).get();
            cidade.setNome(body.getNome());
            cidadeRep.save(cidade);
            return ResponseEntity.ok().body(cidade);
        }catch(NoSuchElementException e){
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
}
