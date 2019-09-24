package jogodecartas;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Laura(modificações Tarcisio e Clara)
 */

public class Jogo {

    private final Scanner entrada = new Scanner(System.in);
    private final Baralho BARALHO;
    private Jogador[] jogadores;
    public int vit = 0;

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
                bater(jogadores[vez].getCarta(), vez);
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
                            bater(jogadores[vez].getCarta(), vez);
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
                bater(jogadores[vezJogador].getCarta(), vezJogador);
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
    
    public void bater(ArrayList<Carta> o, int vez){
        int escolhaBater;
        do{
            int car1, car2,car3;
            int aux1, aux2, aux3;
            System.out.println("Digite: 1 - Trinca, 2 - Sequencia, 3 - Cancelar\n");
            escolhaBater = entrada.nextInt();
            switch(escolhaBater){
                case 1: //Pede pro usuário escolher 3 cartas para baixar e formar trinca
                    System.out.println("Escolha 3 cartas da sua mão para formar o jogo de trinca");
                    System.out.println("Para selecionar digite de 1 a 9");
                    jogadores[vez].mostrarCartas();
                    car1 = entrada.nextInt();
                    car2 = entrada.nextInt();
                    car3 = entrada.nextInt();
                    aux1 = Integer.decode(o.get(car1 -1).getFace());
                    aux2 = Integer.decode(o.get(car2 -1).getFace());
                    aux3 = Integer.decode(o.get(car3 -1).getFace());
                    if(aux1 == aux2 && aux1 == aux3 && aux2 == aux3){
                        System.out.println("Forma trinca!");
                        vit +=1;
                        o.remove(car1 -1);
                        o.remove(car1 -1);
                        o.remove(car1 -1);
                        if(vit == 3){
                            System.out.println("Vitória "+ jogadores[vez].getNome() + "!!!");
                        }
                        else{
                            bater(jogadores[vez].getCarta(), vez);
                        }
                    }
                    else{
                        System.out.println("Não forma trinca!");
                        bater(jogadores[vez].getCarta(), vez);
                        }
                    break;
                case 2: //Pede pro usuário baixar 3 cartas formando sequencia
                    System.out.println("Escolha 3 cartas da sua mão para formar o jogo de sequencia");
                    System.out.println("Para selecionar digite de 1 a 9");
                    jogadores[vez].mostrarCartas();
                    car1 = entrada.nextInt();
                    car2 = entrada.nextInt();
                    car3 = entrada.nextInt();
                    aux1 = Integer.decode(o.get(car1 -1).getFace());
                    aux2 = Integer.decode(o.get(car2 -1).getFace());
                    aux3 = Integer.decode(o.get(car3 -1).getFace());
                    if(!(o.get(car1).getNaipe().contains(o.get(car2).getNaipe()) && o.get(car1).getNaipe().contains(o.get(car3).getNaipe()) && o.get(car2).getNaipe().contains(o.get(car3).getNaipe()))){
                        if((aux1 == aux2+1 && aux1 == aux3-1) || (aux1 == aux3+1 && aux1 == aux2-1)){
                            System.out.println("Forma sequencia!");
                            vit +=1;
                            o.remove(car1 -1);
                            o.remove(car1 -1);
                            o.remove(car1 -1);
                            if(vit == 3){
                            System.out.println("Vitória "+ jogadores[vez].getNome() + "!!!");
                            }
                            else{
                                bater(jogadores[vez].getCarta(), vez);
                            }
                        }
                        else if((aux2 == aux1+1 && aux2 == aux3-1) || (aux2 == aux3+1 && aux2 == aux1-1)){
                            System.out.println("Forma sequencia!");
                            vit +=1;
                            o.remove(car1 -1);
                            o.remove(car1 -1);
                            o.remove(car1 -1);
                            if(vit == 3){
                            System.out.println("Vitória "+ jogadores[vez].getNome() + "!!!");
                            }
                            else{
                                bater(jogadores[vez].getCarta(), vez);
                            }
                        }
                        else if((aux3 == aux1+1 && aux3 == aux2-1) ||(aux3 == aux2+1 && aux3 == aux1-1)){
                            System.out.println("Forma sequencia!");
                            vit +=1;
                            o.remove(car1 -1);
                            o.remove(car1 -1);
                            o.remove(car1 -1);
                            if(vit == 3){
                            System.out.println("Vitória "+ jogadores[vez].getNome() + "!!!");
                            }
                            else{
                                bater(jogadores[vez].getCarta(), vez);
                            }
                        }
                        else{
                            System.out.println("Não forma sequencia!");
                            bater(jogadores[vez].getCarta(), vez);
                        }
                    }
                    else{
                            System.out.println("Naipes iguais!");
                            bater(jogadores[vez].getCarta(), vez);
                        }
                    break;
                case 3:
                    System.out.println("Perdeu a vez!");
                    vit = 0;
                    passarVez(vez);
                    break;
                default:
                    System.out.println("Escolha inválida!");
                    break;
            }
        }while(escolhaBater < 1 || escolhaBater > 3);
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