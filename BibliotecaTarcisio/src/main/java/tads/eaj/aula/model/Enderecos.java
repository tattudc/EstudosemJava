package tads.eaj.aula.model;
import lombok.AllArgsConstructor; //Vai gerar construtor
import lombok.Data; //Gerar gets e sets
import lombok.NoArgsConstructor; //Gera construtor vazio
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Enderecos extends RepresentationModel<Enderecos> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String rua;
    Integer numero;

    /*@OneToOne
    @MapsId
    @JoinColumn(name = "usuarios_id")
    Usuarios usuarios;*/

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getRua() {
        return rua;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }*/
}
