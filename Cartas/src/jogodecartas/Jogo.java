package jogodecartas;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Laura(modificações Tarcisio e Clara)
 */

public class Jogo {

    private final Scanner entrada = new Scanner(System.in);
    private final Baralho BARALHO;
    private Baralho baralho2;
    private Jogador[] jogadores;
    //private descarte[]; //ajeitar lista

    public Jogo() {
        BARALHO = new Baralho();
        baralho2 = new Baralho();
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
                bater(jogadores[vezJogador].getCarta());
                
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
    
    public void bater(ArrayList<Carta> o){
        String[] maoJogador = new String[o.size()];
               
        for(int i = 0; i < maoJogador.length; i++){
            maoJogador[i] = o.get(i).getFace();
        }
        
        
        int cont = 0, vit = 0;
        Carta carta1 = new Carta("Sem face", "Sem naipe");
        Carta carta2 = new Carta("Sem face", "Sem naipe");
        for (int i = 0; i < o.size(); i++) {
            for(int j = 0; j < o.size(); j++){
                if (maoJogador[i].contains(o.get(j).getFace())){
                    cont++;
                    carta1 = o.get(i);
                    carta2 = o.get(j);
                }
                if(cont >= 3){
                    vit += 1;
                    }
                o.remove(o.indexOf(o))
                }
            cont = 0;
        }
        System.out.println(cont);
        System.out.println(vit);
        
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
