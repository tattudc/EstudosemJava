package jogodecartas;

import java.util.Scanner;

/**
 *
 * @author Laura(modificações Tarcisio e Clara)
 */

public class Jogo {

    private final Scanner entrada = new Scanner(System.in);
    private final Baralho BARALHO;
    private Jogador[] jogadores;
    //private descarte[]; //ajeitar lista

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
    
    public void passarVez(int vez){
        System.out.println("Passando a vez...");
        if(vez == 0){
            inicioJogador(1);
            }
        else{
            inicioJogador(0);
            }
    }
    
    public void puxandoDescarte(int vez, int escolhaMenu){
        System.out.println("Puxando do descarte");
        if ("Vazio".equals(Descarte.cartaDescarte.getNaipe())) {
            System.out.println("Nada foi descartado, por favor puxe da pilha");
            puxandoPilha(vez, escolhaMenu);
            } 
        else {
            jogadores[vez].puxarDescarte();
            int descart;
            do{
                System.out.println("Agora escolha uma carta para descartar de 1 a 10");
                jogadores[vez].mostrarCartas();
                descart = entrada.nextInt();
                if(descart <= 10){
                    Descarte.cartaDescarte = jogadores[vez].descartMao(descart - 1);
                    jogadores[vez].descartar(descart -1);
                }
                else{
                    System.out.println("Escolha de 1 a 10 para selecionar a carta");
                }
            }while(descart < 1 || descart > 10);
            jogadores[vez].mostrarCartas();
            System.out.println("Agora quer bater ou passar a vez?\n1 - Bater\n2 ou + - Passar a vez");
            escolhaMenu = entrada.nextInt();
            if(escolhaMenu == 1){
                System.out.println("Conferindo");
                }
            else{
                passarVez(vez);
               }
            }
    }
    
    public void puxandoPilha(int vez, int escolhaMenu){
        System.out.println("Puxando da pilha");
                        jogadores[vez].puxarPilha();
                        int descart;
                        do{
                            System.out.println("Agora escolha uma carta para descartar de 1 a 10");
                            jogadores[vez].mostrarCartas();
                            descart = entrada.nextInt();
                            if(descart <= 10){
                                Descarte.cartaDescarte = jogadores[vez].descartMao(descart - 1);
                                jogadores[vez].descartar(descart -1);
                            }
                            else{
                                System.out.println("Escolha de 1 a 10 para selecionar a carta");
                            }
                        }while(descart < 1 || descart > 10);
                        jogadores[vez].mostrarCartas();
                        System.out.println("Agora quer bater ou passar a vez?\n1 - Bater\n2 ou + - Passar a vez");
                        escolhaMenu = entrada.nextInt();
                        if(escolhaMenu == 1){
                            System.out.println("Conferindo");
                        }
                        else{
                            passarVez(vez);
                        }
    }
    
    public void inicioJogador(int vez){
        int escolhaMenu, vezJogador = vez;
        System.out.println("Bem vindo a trinca jogador " + jogadores[vez].getNome() + ", escolha uma das opções abaixo\n");
        do{
            System.out.println("1 - Puxar carta\n2 - Bater\n3 - Passar a vez");
        escolhaMenu = entrada.nextInt();
        switch (escolhaMenu) {
            case 1:
                 int escolhaPuxa;
                do{
                System.out.println("Puxar de...\n1 - Descarte\n2 - Pilha");
                escolhaPuxa = entrada.nextInt();
                switch (escolhaPuxa){
                    case 1:
                        puxandoDescarte(vez, escolhaMenu);
                        break;
                    case 2:
                        puxandoPilha(vez, escolhaMenu);
                        break;
                    default:
                        System.out.println("Opção inválida!\nEscolha entre 1 ou 2");
                        break;
                }
                }while(escolhaPuxa < 1 || escolhaPuxa > 2);
                break;
            case 2:
                System.out.println("Conferindo...");
                break;
            case 3:
                passarVez(vezJogador);
                break;
            default:
                System.out.println("Opção inválida!\nEscolha uma opção de 1 a 3");
                break;
        }
        }while(escolhaMenu < 1 || escolhaMenu > 3);
        
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
        executar.inicioJogador(0);
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
