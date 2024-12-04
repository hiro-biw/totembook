package br.com.totembook.livro_totem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.totembook.livro_totem.entiity.Livro;
import br.com.totembook.livro_totem.repository.LivroRepository;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    //Find all
    public List<Livro> findAll(){
        return livroRepository.findAll();
    }

    //Find By ID
    public Livro findById(Long id){
        return livroRepository.findById(id).orElse(null);
    }

    //Insert New
    public Livro insertNew(Livro livro){
        return livroRepository.save(livro);
    }

    //Insert List
    public List<Livro> insertList(List<Livro> livros){
        return livroRepository.saveAll(livros);
    }

    //update
    public Livro update(Long id, Livro livroAlterado){
        Livro livroAtual = findById(id);
        livroAtual.setTitulo(livroAlterado.getTitulo());
        livroAtual.setAutor(livroAlterado.getAutor());
        livroAtual.setGenero(livroAlterado.getGenero());
        livroAtual.setClassificacao(livroAlterado.getClassificacao());
        livroAtual.setEditora(livroAlterado.getEditora());
        return livroRepository.save(livroAtual);
    }

    //delete
    public Boolean deleteById(Long id){
        Livro livro = findById(id);
        if(livro == null){
            return false;
        }
        else{
            livroRepository.deleteById(id);
            return true;
        }
    }

}
