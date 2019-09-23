package jogodecartas;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Laura(modificações Tarcisio e Clara)
 */

public class Jogador {

    private final String NOME;
    private ArrayList<Carta> cartas;

    public Jogador(String nome) {
        this.NOME = nome;
    }
    
    public String getNome(){
        return NOME;
    }

    public void setCartas(Carta[] cartas) {
        this.cartas = new ArrayList<Carta>();
        for(Carta mao: cartas){
            this.cartas.add(mao);
        }
    }
    //
    public ArrayList<Carta> getCarta(){
        return cartas;
    }

    public void mostrarCartas() {
        Collections.sort(cartas);
        System.out.println("-----------CARTAS DE " + NOME.toUpperCase() + "------------------");
        cartas.forEach((carta) -> {
            System.out.println(carta);
        });
    }
    
    //Metodo para descartar
    public void descartar(int des){
        cartas.remove(des);
    }
    //METODO PUXAR DESCARTE
    public void puxarDescarte(){
        cartas.add(Descarte.setCarta());
    }
    //Metodo puxar da pilha
    public void puxarPilha(){
        cartas.add(Baralho.puxarPilha());     
    }
    //MEtodo descartar carta
    public Carta descartMao(int descart){
        return cartas.get(descart);
    }
}
