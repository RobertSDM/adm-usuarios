package mai.administracaousuarios.rest;

import jakarta.validation.Valid;
import mai.administracaousuarios.model.Usuario;
import mai.administracaousuarios.repositories.UsuarioRepository;
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
@RequestMapping(value = "/usuario")
public class UsuarioRest {

    @Autowired
    private UsuarioRepository usuarioRep;

    private final Logger logger = LoggerFactory.getLogger(SLF4JLogger.class);

    @GetMapping(value = "/find/all")
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> usuarios = usuarioRep.findAll();
        if(usuarios.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(usuarios);
    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable String id) {
        try {
            Usuario  usuario = usuarioRep.findById(id).get();
            return ResponseEntity.ok().body(usuario);
        } catch (NoSuchElementException e) {
            logger.error(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Usuario> put(@PathVariable String id, @Valid @RequestBody Usuario body) {
        try{
            Usuario usuario = usuarioRep.findById(id).get();
            ArrayList<String> encrypt = Encrypt.encryptPassword(body.getSenha());
            usuario.setLogin(body.getLogin());
            usuario.setSenha(encrypt.get(0));
            usuario.setSalt(encrypt.get(1));
            usuarioRep.save(usuario);
            return ResponseEntity.ok().body(usuario);
        }catch(NoSuchElementException e){
            logger.error(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/validar-usuario")
    public ResponseEntity<String> validar(@RequestBody Usuario body) {
        Usuario usuarioBanco = usuarioRep.findByLogin(body.getLogin());

        Boolean valid = Encrypt.validatePassword(body.getSenha(), usuarioBanco.getSalt(), usuarioBanco.getSenha());

        if(valid){
            return ResponseEntity.ok().body("valid");
        }else{
            return ResponseEntity.unprocessableEntity().body("invalid");
        }
    }
}
