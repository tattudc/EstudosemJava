/**
 *
 * @author Tarcisio Câmara
 */
public class Residencial extends Imovel {
    private int numeroQuartos;

    public Residencial(int codigo, String regiao, double valor, boolean disponivel, int numeroQuartos) {
        super(codigo, regiao, valor, disponivel);
        this.numeroQuartos = numeroQuartos;
    }

    public int getNumeroQuartos() {
        return numeroQuartos;
    }

    public void setNumeroQuartos(int numeroQuartos) {
        this.numeroQuartos = numeroQuartos;
    }

    @Override
    public String toString() {
        return "Residencial{" + "numeroQuartos=" + numeroQuartos + '}';
    }
}
