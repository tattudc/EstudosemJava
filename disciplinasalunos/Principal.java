/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disciplinasalunos;
import java.util.Scanner;
import disciplinasalunos.Disciplina;

/**
 *
 * @author Aluno Tarcisio Dantas Câmara
 */
public class Principal {
    private Disciplina d;
    private Scanner entrada = new Scanner(System.in);
    
    //iniciar objeto da disciplina
    public void iniciarDisciplina(){
        System.out.println("Digite o nome da Disciplina");
        String nome = entrada.nextLine();
        System.out.println("Digite a quantidade de alunos");
        int qtdAlunos = entrada.nextInt();
        d = new Disciplina(nome, qtdAlunos);
    }
        
    public void cadastrarNotas(){
        for(int i = 0; i < d.getQtdAlunos(); i++){
            System.out.println("Informe as 3 notas do aluno");
            for(int j = 0; j < d.getQTDNOTAS(); j++){
                d.setNota(i, j, entrada.nextDouble());
            }
        }
    }
    
    public void mostrarMedia(){
        System.out.println("A media de todos os alunos foi " + d.getMedia());
    }
    
    public static void main(String[] args) {
        Principal p = new Principal();
        p.iniciarDisciplina();
        p.cadastrarNotas();
        p.mostrarMedia();
    }
}
