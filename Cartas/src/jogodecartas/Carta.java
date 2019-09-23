package jogodecartas;

import java.util.Objects;

/**
 *
 * @author Laura(modificações Tarcisio e Clara)
 */

public class Carta implements Comparable<Carta> {

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

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carta other = (Carta) obj;
        if (!Objects.equals(this.NAIPE, other.NAIPE)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Carta o) {
        if(this.FACE.equals(o.FACE)){
            return this.NAIPE.compareTo(o.NAIPE);
        }
        else{
            return this.FACE.compareTo(o.FACE);
        }
    }

}
