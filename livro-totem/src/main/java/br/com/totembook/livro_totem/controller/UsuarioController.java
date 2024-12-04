package br.com.totembook.livro_totem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.totembook.livro_totem.entiity.Usuario;
import br.com.totembook.livro_totem.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

     @Autowired
    private UsuarioService usuarioService;

    //Find All
    @GetMapping
    public ResponseEntity<List<Usuario>> findAll(){
        List<Usuario> usuarios = usuarioService.findAll();
        return ResponseEntity.ok().body(usuarios);
    }

    //find By id
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id){
        Usuario usuario = usuarioService.findById(id);
        return ResponseEntity.ok().body(usuario);
    }

    //insert new
    @PostMapping
    public ResponseEntity<Usuario> insertNew(@RequestBody Usuario usuario){
        Usuario usuarioInserido = usuarioService.insertNew(usuario);
        return ResponseEntity.ok().body(usuarioInserido);
    }

    //insert list
    @PostMapping("/list")
    public ResponseEntity<List<Usuario>> insertList(@RequestBody List<Usuario> usuarios){
        List<Usuario> usuariosList = usuarioService.insertList(usuarios);
        return ResponseEntity.ok().body(usuariosList);
    }

    //Update
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usuario){
        Usuario usuarioAlterado = usuarioService.update(id, usuario);
        return ResponseEntity.ok().body(usuarioAlterado);
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id){
        Boolean flag = usuarioService.deleteById(id);
        return ResponseEntity.ok().body(flag);
    }
}
