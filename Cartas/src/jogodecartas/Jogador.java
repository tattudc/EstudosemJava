package jogodecartas;

import java.util.ArrayList;

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

    public void mostrarCartas() {
        System.out.println("-----------CARTAS DE " + NOME.toUpperCase() + "------------------");
        cartas.forEach((carta) -> {
            System.out.println(carta);
        });
    }
    
    public void descartar(int des){
        cartas.remove(des);
    }
    public void puxarDescarte(){
        cartas.add(Descarte.setCarta());
    }
    public void puxarPilha(){
        cartas.add(Baralho.puxarPilha());     
    }
    
    public Carta descartMao(int descart){
        return cartas.get(descart);
    }
}
