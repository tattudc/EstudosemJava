package tads.eaj.aula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tads.eaj.aula.model.Bibliotecas;

import java.util.List;
public interface BibliotecasRepository extends JpaRepository<Bibliotecas, Long> {
    List<Bibliotecas> findByNome(String nome);
    List<Bibliotecas> findByAnoCriacao(Integer ano);
}
