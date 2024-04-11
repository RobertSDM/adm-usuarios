package maia.administracaousuarios.domains.usuario;

import maia.administracaousuarios.domains.logradouro.Logradouro;
import maia.administracaousuarios.repositories.LogradouroRepository;
import maia.administracaousuarios.repositories.UsuarioRepository;
import maia.administracaousuarios.security.Encrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioRest {

    @Autowired
    private UsuarioRepository usuarioRep;

    @PutMapping(name = "/delete/{id}")
    public Boolean put(@PathVariable String id) {
        usuarioRep.deleteById(id);
        return true;
    }

    @PutMapping(name = "/updade/all/{id}")
    public void putAll(@PathVariable String id, @RequestBody Usuario body) {
        try{
            Usuario usuario = usuarioRep.findById(id).get();
            ArrayList<String> encrypt = Encrypt.encryptPassword(body.getSenha());
            usuario.setSenha(encrypt.get(0));
            usuario.setSalt(encrypt.get(1));
            usuario.setLogin(body.getLogin());

            usuarioRep.save(usuario);
        }catch(NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }

    @PutMapping(name = "/updade/password/{id}")
    public void putPassword(@PathVariable String id, @RequestBody Usuario body) {
        try{
            Usuario usuario = usuarioRep.findById(id).get();
            ArrayList<String> encrypt = Encrypt.encryptPassword(body.getSenha());
            usuario.setSenha(encrypt.get(0));
            usuario.setSalt(encrypt.get(1));

            usuarioRep.save(usuario);
        }catch(NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }

    @PutMapping(name = "/updade/login/{id}")
    public void putLogin(@PathVariable String id, @RequestBody Usuario body) {
        try{
            Usuario usuario = usuarioRep.findById(id).get();
            usuario.setLogin(body.getLogin());

            usuarioRep.save(usuario);
        }catch(NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }
}
