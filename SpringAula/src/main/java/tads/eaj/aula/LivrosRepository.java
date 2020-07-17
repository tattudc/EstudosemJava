package tads.eaj.aula;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivrosRepository extends JpaRepository<Livros, Long> {
    List<Livros> findByDescricao(String descricao);
    List<Livros> findByAnoLancamento(Integer ano);
}
