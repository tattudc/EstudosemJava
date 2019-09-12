package jogodecartas;

import java.util.Scanner;

public class Jogo {

    private final Scanner entrada = new Scanner(System.in);
    private final Baralho BARALHO;
    private Jogador[] jogadores;

    public Jogo() {
        BARALHO = new Baralho();
        BARALHO.mostrarBaralho();
        BARALHO.embaralhar();
        BARALHO.mostrarBaralho();
    }

    public void criarJogadores() {
        jogadores = new Jogador[2];
            System.out.println("Jogador 1, digite seu nome:");
            jogadores[0] = new Jogador(entrada.next());
            System.out.println("Jogador 2, digite seu nome:");
            jogadores[1] = new Jogador(entrada.next());
    }
    
    public void inicioJogador(){
        int escolhaMenu;
        System.out.println("Bem vindo a trinca, escolha uma das opções abaixo\n");
        System.out.println("1 - Puxar carta\n2 - Bater\n3 - Passar a vez");
        escolhaMenu = entrada.nextInt();
        switch (escolhaMenu) {
            case 1:
                int escolhaPuxa = 0;
                System.out.println("Puxar de...\n1 - Descarte\n2 - Pilha");
                escolhaPuxa = entrada.nextInt();
                switch (escolhaPuxa){
                    case 1:
                        System.out.println("Puxando do descarte");
                        break;
                    case 2:
                        System.out.println("Puxando da pilha");
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
                break;
            case 2:
                System.out.println("Conferindo...");
                break;
            case 3:
                System.out.println("Passando a vez...");
                inicioJogador();
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    public void distribuirCartas(int qtdCartas) {
        for (Jogador jogadore : jogadores) {
            jogadore.setCartas(BARALHO.distribuirCartas(qtdCartas));
        }
    }

    public void mostrarCartas() {
        for (Jogador jogadore : jogadores) {
            jogadore.mostrarCartas();
        }
    }

    public static void main(String[] args) {
        Jogo executar = new Jogo();
        executar.criarJogadores();
        executar.distribuirCartas(9);
        executar.inicioJogador();
        executar.mostrarCartas();
    }
}

//Comentários
//Jogador1
//Comparar jogos
//puxar(Do descarte ou pilha - função mostrar cartas)
//Descartar(Se tiver +9 obrigar descarte)
//Comparar jogos(Se tiver 3 jogos, ganhou senão passa vez)
//Jogador2
//Repete procedimento
//Criar metodo na classe jogo para iniciar jogo
