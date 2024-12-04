package br.com.totembook.livro_totem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.totembook.livro_totem.entiity.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

}
