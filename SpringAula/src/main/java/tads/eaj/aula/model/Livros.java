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
public class Livros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotBlank(message = "Url da imagem não deve está em branco")
    String urlImage;
    @NotBlank(message = "Titulo não deve está em branco")
    String titulo;
    @NotBlank(message = "Categoria não deve está em branco")
    String categoria;
    @NotBlank(message = "Descrição não deve está em branco")
    String descricao;
    @NotBlank(message = "Editora não deve está em branco")
    String editora;
    @NotNull(message = "Insira um ano")
    Integer anoLancamento;


}
