package tads.eaj.aula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tads.eaj.aula.model.Emprestimos;

import java.util.List;

public interface EmprestimosRepository extends JpaRepository<Emprestimos, Long> {
   }
