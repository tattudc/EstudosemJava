package tads.eaj.aula.model;

import lombok.AllArgsConstructor; //Vai gerar construtor
import lombok.Data; //Gerar gets e sets
import lombok.NoArgsConstructor; //Gera construtor vazio

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Enderecos {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String rua;
    Integer numero;
    String bairro;
    String cidade;

    @OneToOne
    @MapsId
    @JoinColumn(name = "usuarios_id")
    Usuarios usuarios;

}
