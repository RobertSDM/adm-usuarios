package mai.administracaousuarios.rest;

import mai.administracaousuarios.domains.Logradouro;
import mai.administracaousuarios.repositories.LogradouroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/logradouro")
public class LogradouroRest {

    @Autowired
    private LogradouroRepository logradouroRep;

    @GetMapping(value = "/find/all")
    public ResponseEntity<List<Logradouro>> findAll() {
        List<Logradouro> logradouros = logradouroRep.findAll();
        if(logradouros.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(logradouros);
    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<Logradouro> findById(@PathVariable String id) {
        try {
            Logradouro logradouro = logradouroRep.findById(id).get();
            return ResponseEntity.ok().body(logradouro);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Logradouro> put(@PathVariable String id, @RequestBody Logradouro body) {
        try{
            Logradouro logradouro = logradouroRep.findById(id).get();
            logradouro.setCep(body.getCep());
            logradouroRep.save(logradouro);
            return ResponseEntity.ok().body(logradouro);
        }catch(NoSuchElementException e){
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
}
