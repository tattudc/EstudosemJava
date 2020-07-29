package tads.eaj.aula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tads.eaj.aula.model.Livros;

import java.util.List;

public interface LivrosRepository extends JpaRepository<Livros, Long> {
    List<Livros> findByDescricao(String descricao);
    List<Livros> findByAnoLancamento(Integer ano);
}
