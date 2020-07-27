package tads.eaj.aula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tads.eaj.aula.model.Usuarios;

import java.util.List;
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
}
