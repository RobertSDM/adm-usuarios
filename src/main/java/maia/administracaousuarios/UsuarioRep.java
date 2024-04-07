package maia.administracaousuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioRep {
    @Autowired()
    private UsuarioRepository usuarioRep;

    @GetMapping(value = "/find/all")
    public List<Usuario> findAll() {
        return usuarioRep.findAll();
    }

    @GetMapping(value = "/find/{id}")
    public Usuario findById(@PathVariable String id) {
        try {
            return usuarioRep.findById(id).get();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    private String createEnderecoId(Endereco endereco){
        String enderecoCompleto = endereco.getLogradouro() + ";"
                + endereco.getCidade() + ";"
                + endereco.getEstado();

        return enderecoCompleto.toLowerCase();
    }

    // TODO: create the encrypt and validate password

    @PostMapping(value = "/create")
    public Boolean create(@RequestBody Usuario body) {

        Endereco endereco = body.getEndereco();

        String enderecoCompleto = this.createEnderecoId(endereco);
        endereco.setEnderecoCompleto(enderecoCompleto);

        body.setEndereco(endereco);

        usuarioRep.save(body);

        return true;
    }

    @DeleteMapping(value = "/delete/{id}")
    public Boolean delete(@PathVariable String id) {
        usuarioRep.deleteById(id);
        return true;
    }

    @PutMapping(value = "/update/{id}")
    public void update(@PathVariable String id, @RequestBody Usuario body) {
        try{
            Usuario usuario = usuarioRep.findById(id).get();

            String enderecoCompleto = createEnderecoId(usuario.getEndereco());

            usuario.setNome(body.getNome());
            usuario.setCnpj(body.getCnpj());
            usuario.setContato(body.getContato());
            usuario.setEndereco(body.getEndereco());
            usuario.getEndereco().setEnderecoCompleto(enderecoCompleto);

            usuarioRep.save(usuario);

        }catch(NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }
}
