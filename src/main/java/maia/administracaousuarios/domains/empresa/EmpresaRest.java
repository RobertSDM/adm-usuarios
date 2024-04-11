package maia.administracaousuarios.domains.empresa;

import maia.administracaousuarios.repositories.*;
import maia.administracaousuarios.security.Encrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/empresa")
public class EmpresaRest {
    @Autowired()
    private EmpresaRepository empresaRep;


    @GetMapping(value = "/find/all")
    public List<Empresa> findAll() {
        return empresaRep.findAll();
    }

    @GetMapping(value = "/find/{id}")
    public Empresa findById(@PathVariable String id) {
        try {
            return empresaRep.findById(id).get();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @PostMapping(value = "/create")
    public Boolean create(@RequestBody Empresa body) {
        ArrayList<String> encrypted = Encrypt.encryptPassword(body.getUsuario().getSenha());


        System.out.println(encrypted.get(0));
        body.getUsuario().setSenha(encrypted.get(0));
        body.getUsuario().setSalt(encrypted.get(1));

        empresaRep.save(body);
        return true;
    }

    @DeleteMapping(value = "/delete/{id}")
    public Boolean delete(@PathVariable String id) {
        empresaRep.deleteById(id);
        return true;
    }

    @PutMapping(value = "/update/{id}")
    public void update(@PathVariable String id, @RequestBody Empresa body) {
        try{
            Empresa empresa = empresaRep.findById(id).get();

            empresa.setNome(body.getNome());
            empresa.setCnpj(body.getCnpj());

            empresaRep.save(empresa);

        }catch(NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }
}
