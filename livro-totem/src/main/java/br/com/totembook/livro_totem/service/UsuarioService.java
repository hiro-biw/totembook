package br.com.totembook.livro_totem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.totembook.livro_totem.entiity.Usuario;
import br.com.totembook.livro_totem.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    //Find all
    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    //Find By ID
    public Usuario findById(Long id){
        return usuarioRepository.findById(id).orElse(null);
    }

    //Insert New
    public Usuario insertNew(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    //Insert List
    public List<Usuario> insertList(List<Usuario> usuarios){
        return usuarioRepository.saveAll(usuarios);
    }

    //update
    public Usuario update(Long id, Usuario usuarioAlterado){
        Usuario usuarioAtual = findById(id);
        usuarioAtual.setNome(usuarioAlterado.getNome());
        usuarioAtual.setEmail(usuarioAlterado.getEmail());
        usuarioAtual.setSenha(usuarioAlterado.getSenha());
        usuarioAtual.setTelefone(usuarioAlterado.getTelefone());
        usuarioAtual.setEstado(usuarioAlterado.getEstado());
        usuarioAtual.setCidade(usuarioAlterado.getCidade());
        usuarioAtual.setBairro(usuarioAlterado.getBairro());
        usuarioAtual.setRua(usuarioAlterado.getRua());
        return usuarioRepository.save(usuarioAtual);
    }

    //delete
    public Boolean deleteById(Long id){
        Usuario usuario = findById(id);
        if(usuario == null){
            return false;
        }
        else{
            usuarioRepository.deleteById(id);
            return true;
        }
    }

}
