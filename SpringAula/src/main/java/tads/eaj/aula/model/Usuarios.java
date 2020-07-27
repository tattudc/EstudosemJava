package tads.eaj.aula.model;

import lombok.AllArgsConstructor; //Vai gerar construtor
import lombok.Data; //Gerar gets e sets
import lombok.NoArgsConstructor; //Gera construtor vazio

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    Integer idade;

    @OneToOne(mappedBy = "usuarios")
    Enderecos enderecos;

}
