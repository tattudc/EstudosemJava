package tads.eaj.aula.model;
import lombok.AllArgsConstructor; //Vai gerar construtor
import lombok.Data; //Gerar gets e sets
import lombok.NoArgsConstructor; //Gera construtor vazio
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.websocket.ClientEndpoint;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Emprestimos extends RepresentationModel<Emprestimos> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String quantidade;
    String dataEmprestimo;

    /*@ManyToOne
    @JoinColumn(name = "usuarios_id")
    Usuarios usuarios;*/

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "emprestimos_livros",
            joinColumns = @JoinColumn(name = "emprestimos_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "livros_id")
    )
    List<Livros> livros;

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getQuantidade() {
        return quantidade;
    }

    /*public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }*/

    public void setLivros(List<Livros> livros) {
        this.livros = livros;
    }

    public List<Livros> getLivros() {
        return livros;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
