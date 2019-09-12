package jogodecartas;

import java.util.Random;

public class Baralho {

    private final Carta[] CARTAS;
    private final Random ALEATORIO;
    private int contador;

    public Baralho() {
        ALEATORIO = new Random(); //Gerar o numero aleatório
        CARTAS = new Carta[52]; //Gerar 52 cartas
        String[] face = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] naipe = {"copas", "espadas", "ouros", "paus"};

        int cont = 0; //inicialização das cartas
        for (int i = 0; i < naipe.length; i++) {
            for (int j = 0; j < face.length; j++) {
                CARTAS[cont++] = new Carta(face[j], naipe[i]);
            }
        }
    }

    public void embaralhar() {
        System.out.println("\t\tEMBARALHANDO\n");
        int num, num2;
        Carta temp;
        for (int i = 0; i < CARTAS.length; i++) { //Embaralha e mistura 2 cartas
            num = ALEATORIO.nextInt(CARTAS.length); //Até embaralhar 52 vezes
            num2 = ALEATORIO.nextInt(CARTAS.length);
            temp = CARTAS[num];
            CARTAS[num] = CARTAS[num2];
            CARTAS[num2] = temp;
        }
    }

    public Carta[] distribuirCartas(int qtdCartas) {
        System.out.println("------------DISTRIBUINDO BARALHO-----------------");

        Carta[] cartasJogador = new Carta[qtdCartas];

        for (int i = 0; i < qtdCartas; i++) {
            cartasJogador[i] = CARTAS[contador];
            contador++;
        }

        return cartasJogador;
    }

    public void mostrarBaralho() {
        System.out.println("------------APRESENTANDO BARALHO-----------------");
        for (Carta carta : CARTAS) {
            System.out.println(carta.toString());
        }
    }
}
