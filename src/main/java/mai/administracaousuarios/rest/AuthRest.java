package mai.administracaousuarios.rest;

import jakarta.validation.Valid;
import mai.administracaousuarios.model.Empresa;
import mai.administracaousuarios.model.Usuario;
import mai.administracaousuarios.repositories.EmpresaRepository;
import mai.administracaousuarios.repositories.UsuarioRepository;
import mai.administracaousuarios.security.Encrypt;
import mai.administracaousuarios.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/")
public class AuthRest {

    @Autowired
    UsuarioRepository usuarioRep;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    EmpresaRepository empresaRep;

    TokenService tokenService = new TokenService();

    @PostMapping(value = "/register")
    public ResponseEntity<Empresa> register(@Valid @RequestBody Empresa body) {
        ArrayList<String> encrypted = Encrypt.encryptPassword(body.getUsuario().getSenha());

        body.getUsuario().setSenha(encrypted.get(0));
        body.getUsuario().setSalt(encrypted.get(1));

        Empresa empresa = empresaRep.save(body);

        return ResponseEntity.created(null).body(empresa);
    }

    @PostMapping("/login")
    public ResponseEntity<HashMap<String, String>> login(@RequestBody  Usuario body) {
        System.out.println("No login");

        Usuario usuario = usuarioRep.findByLogin(body.getLogin());

        UsernamePasswordAuthenticationToken userPass = new UsernamePasswordAuthenticationToken(body.getLogin(), body.getSenha() + usuario.getSalt());
        var auth = this.authenticationManager.authenticate(userPass);

        System.out.println("Passou do auth");

        String token = tokenService.createToken((Usuario) auth.getPrincipal());

        System.out.println("Criou o token");

        HashMap<String, String> responseMap = new HashMap<>();
        responseMap.put("token", token);

        return ResponseEntity.ok().body(responseMap);
    }
}
