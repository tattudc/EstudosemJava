package tads.eaj.aula.model;

import lombok.AllArgsConstructor; //Vai gerar construtor
import lombok.Data; //Gerar gets e sets
import lombok.NoArgsConstructor; //Gera construtor vazio
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Livros extends RepresentationModel<Livros> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String urlImage;
    String titulo;
    String categoria;
    String descricao;
    String editora;
    Integer anoLancamento;

    //@ManyToMany(mappedBy = "livros")
    //List<Emprestimos> emprestimos;

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*public void setEmprestimos(List<Emprestimos> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public List<Emprestimos> getEmprestimos() {
        return emprestimos;
    }*/
}
