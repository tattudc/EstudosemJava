package tads.eaj.aula;
import lombok.AllArgsConstructor; //Vai gerar construtor
import lombok.Data; //Gerar gets e sets
import lombok.NoArgsConstructor; //Gera construtor vazio

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Livros {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @NotBlank(message = "Url da imagem não deve está em branco")
    String urlImage;
    @NotBlank(message = "Titulo não deve está em branco")
    @Size(min = 5, max = 10, message = "O tamanho está fora do padrão")
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
