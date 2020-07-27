package tads.eaj.aula.model;
import lombok.AllArgsConstructor; //Vai gerar construtor
import lombok.Data; //Gerar gets e sets
import lombok.NoArgsConstructor; //Gera construtor vazio

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Bibliotecas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @NotBlank(message = "Nome da biblioteca não pode está em branco")
    String nome;
    @NotNull(message = "Insira um ano")
    Integer anoCriacao;
}
