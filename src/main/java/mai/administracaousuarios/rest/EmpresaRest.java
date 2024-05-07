package mai.administracaousuarios.rest;

import jakarta.validation.Valid;
import mai.administracaousuarios.model.Empresa;
import mai.administracaousuarios.repositories.EmpresaRepository;
import mai.administracaousuarios.security.Encrypt;
import org.apache.logging.slf4j.SLF4JLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/empresa")
public class EmpresaRest {
    @Autowired()
    private EmpresaRepository empresaRep;

    private final Logger logger = LoggerFactory.getLogger(SLF4JLogger.class);


    @GetMapping(value = "/find/all")
    public ResponseEntity<List<Empresa>> findAll() {
        List<Empresa> empresas = empresaRep.findAll();
        if(empresas.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(empresas);
    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<Empresa> findById(@PathVariable String id) {
        try {
            Empresa empresa = empresaRep.findById(id).get();
            return ResponseEntity.ok().body(empresa);
        } catch (NoSuchElementException e) {
            logger.error(e.getMessage());
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping(value = "/create")
    public ResponseEntity<Empresa> create(@Valid @RequestBody Empresa body) {
        ArrayList<String> encrypted = Encrypt.encryptPassword(body.getUsuario().getSenha());

        body.getUsuario().setSenha(encrypted.get(0));
        body.getUsuario().setSalt(encrypted.get(1));

        Empresa empresa = empresaRep.save(body);
        return ResponseEntity.created(null).body(empresa);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Empresa> delete(@PathVariable String id) {
        try{
            empresaRep.findById(id).get();
            empresaRep.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            logger.error(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Empresa> update(@PathVariable String id, @Valid @RequestBody Empresa body) {
        try{
            Empresa empresa = empresaRep.findById(id).get();

            empresa.setNome(body.getNome());
            empresa.setCnpj(body.getCnpj());

            empresaRep.save(empresa);
            return ResponseEntity.ok(empresa);
        }catch(NoSuchElementException e){
            logger.error(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
}
