/*
 * Códigos gerados para ensino
 */
package jogodados;

import java.util.Scanner;

/**
 *
 * @author Laura Emmanuella <lauraemmanuella at eaj.ufrn.br>
 */
public class Jogo {

    private final Scanner entrada = new Scanner(System.in);

    private final Dado dado1 = new Dado();
    private final Dado dado2 = new Dado();

    private Jogador[] jogadores;

    private int resultado;

    public void inserirJogadores() {
        int totalJogadores = 0;
        System.out.println("Informe quantos jogadores");
        do{
            System.out.println("Máximo 11 jogadores");
            totalJogadores = entrada.nextInt();
        }while(totalJogadores > 11);
        jogadores = new Jogador[totalJogadores];
        
        for(int i = 0; i < jogadores.length; i++ ){
            System.out.println("Jogador " + (i + 1) + "Informe seu nome: ");
            jogadores[i] = new Jogador(entrada.next());
        }
    }

    public void inserirApostas() {
        int aposta;
        for(Jogador j : jogadores){
            do {
            System.out.println(j.getNome() + " informe sua aposta:");
            aposta = entrada.nextInt();
            } while (aposta < 2 || aposta > 12);
            j.setValorAposta(aposta);
        }

        /*do {
            System.out.println(jogador2.getNome() + "informe sua aposta:");
            aposta = entrada.nextInt();
            if (aposta == jogador1.getValorAposta()) {
                System.out.println("Valor ja escolhido. Tente outro.");
            }
        } while (aposta < 2 || aposta > 12 || aposta == jogador1.getValorAposta());
        jogador2.setValorAposta(aposta);*/
    }

    public void jogarDados() {
        dado1.setValorFace();
        dado2.setValorFace();
    }

    public void mostrarResultado() {
        resultado = dado1.getValorFace() + dado2.getValorFace();
        System.out.println("Resultado: " + resultado);
    }

    public void mostrarVencedor() {
        boolean ganhou = false;
        for(Jogador j: jogadores){
            if (resultado == j.getValorAposta()) {
                System.out.println(j.getNome() + " venceu a aposta");
                ganhou = true;
                }
            }
        
        if(!ganhou){
            System.out.println("O computador ganhou");
        }
        
    }

}
