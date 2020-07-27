package tads.eaj.aula.model;
import lombok.AllArgsConstructor; //Vai gerar construtor
import lombok.Data; //Gerar gets e sets
import lombok.NoArgsConstructor; //Gera construtor vazio

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.websocket.ClientEndpoint;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Emprestimos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotNull(message = "Insira uma quantidade")
    Integer quatidade;
    @NotBlank(message = "Qual a data do emprestimo?")
    String dataEmprestimo;
    @NotBlank(message = "Qual a data da devolução?")
    String dataDevolucao;


}
