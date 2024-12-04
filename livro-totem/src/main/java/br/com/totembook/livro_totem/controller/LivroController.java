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

import br.com.totembook.livro_totem.entiity.Livro;
import br.com.totembook.livro_totem.service.LivroService;


@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    //Find All
    @GetMapping
    public ResponseEntity<List<Livro>> findAll(){
        List<Livro> livros = livroService.findAll();
        return ResponseEntity.ok().body(livros);
    }

    //find By id
    @GetMapping("/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Long id){
        Livro livro = livroService.findById(id);
        return ResponseEntity.ok().body(livro);
    }

    //insert new
    @PostMapping
    public ResponseEntity<Livro> insertNew(@RequestBody Livro livro){
        Livro livroInserido = livroService.insertNew(livro);
        return ResponseEntity.ok().body(livroInserido);
    }

    //insert list
    @PostMapping("/list")
    public ResponseEntity<List<Livro>> insertList(@RequestBody List<Livro> livros){
        List<Livro> livrosList = livroService.insertList(livros);
        return ResponseEntity.ok().body(livrosList);
    }

    //Update
    @PutMapping("/{id}")
    public ResponseEntity<Livro> update(@PathVariable Long id, @RequestBody Livro livro){
        Livro livroAlterado = livroService.update(id, livro);
        return ResponseEntity.ok().body(livroAlterado);
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id){
        Boolean flag = livroService.deleteById(id);
        return ResponseEntity.ok().body(flag);
    }
}
