package jogodecartas;

/**
 *
 * @author Laura(modificações Tarcisio e Clara)
 */
import java.util.Random;

public class Baralho {

    private static Carta[] cartas; //Mudar de final para static para melhor acessar
    private final Random ALEATORIO;
    private static int contador;

    public Baralho() {
        ALEATORIO = new Random(); //Gerar o numero aleatório
        cartas = new Carta[52]; //Gerar 52 cartas
        String[] face = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] naipe = {"copas", "espadas", "ouros", "paus"};

        int cont = 0; //inicialização das cartas
        for (String naipe1 : naipe) { //Mudei para for aprimorado
            for (String face1 : face) {
                cartas[cont++] = new Carta(face1, naipe1);
            }
        }
    }

    public void embaralhar() {
        System.out.println("\t\tEMBARALHANDO\n");
        int num, num2;
        Carta temp;
        for (Carta carta : cartas) {             //Embaralha e mistura 2 cartas
            num = ALEATORIO.nextInt(cartas.length); //Até embaralhar 52 vezes
            num2 = ALEATORIO.nextInt(cartas.length);
            temp = cartas[num];
            cartas[num] = cartas[num2];
            cartas[num2] = temp;
        }
    }

    public Carta[] distribuirCartas(int qtdCartas) {
        System.out.println("------------DISTRIBUINDO BARALHO-----------------");

        Carta[] cartasJogador = new Carta[qtdCartas];

        for (int i = 0; i < qtdCartas; i++) {
            cartasJogador[i] = cartas[contador];
            contador++;
        }

        return cartasJogador;
    }
    
    //Agora sim criando metodo de pegar carta do baralho restante
    public Carta[] getCarta(){ 
        return cartas;
    }
    //Metodo para puxar da pilha
    public static Carta puxarPilha(){
        System.out.println("Puxou: "+ cartas[++contador]);
        return cartas[contador];
    }
    
    public void mostrarBaralho() {
        System.out.println("------------APRESENTANDO BARALHO-----------------");
        for (Carta carta : cartas) {
            System.out.println(carta.toString());
        }
    }
}
