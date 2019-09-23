package jogodecartas;

/**
 *
 * @author Laura(modificações Tarcisio e Clara)
 */

public class Carta {

    private final String FACE;
    private final String NAIPE;

    public Carta(String face, String naipe) {
        this.FACE = face;
        this.NAIPE = naipe;
    }
    
    public String getFace(){
        return FACE;
    }

    public String getNaipe(){
        return NAIPE;
    }
    @Override
    public String toString() {
        return FACE + " de " + NAIPE;
    }

}
