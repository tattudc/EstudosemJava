package tads.eaj.aula.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Usuarios extends RepresentationModel<Usuarios> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    Integer idade;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "enderecos_id")
    Enderecos enderecos;

    @OneToMany(fetch = FetchType.EAGER ,cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "usuarios_id")
    List<Emprestimos> emprestimos;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }

    public void setEnderecos(Enderecos enderecos) {
        this.enderecos = enderecos;
    }

    public Enderecos getEnderecos() {
        return enderecos;
    }

    public void setEmprestimos(List<Emprestimos> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public List<Emprestimos> getEmprestimos() {
        return emprestimos;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
