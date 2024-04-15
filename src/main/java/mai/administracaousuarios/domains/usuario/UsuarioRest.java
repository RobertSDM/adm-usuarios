package mai.administracaousuarios.domains.usuario;

import mai.administracaousuarios.repositories.UsuarioRepository;
import mai.administracaousuarios.security.Encrypt;
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
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Usuario> put(@PathVariable String id,@RequestParam(defaultValue = "login") String type, @RequestBody Usuario body) {
        try{
            Usuario usuario = usuarioRep.findById(id).get();
            ArrayList<String> encrypt = Encrypt.encryptPassword(body.getSenha());
            switch (type) {
                case "all":
                    usuario.setSenha(encrypt.get(0));
                    usuario.setSalt(encrypt.get(1));
                    usuario.setLogin(body.getLogin());
                    break;
                case "password":
                    usuario.setSenha(encrypt.get(0));
                    usuario.setSalt(encrypt.get(1));
                    break;
                case "login":
                    usuario.setLogin(body.getLogin());
                    break;
            }
            usuarioRep.save(usuario);
            return ResponseEntity.ok().body(usuario);
        }catch(NoSuchElementException e){
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
}
