package loja;

/**
 *
 * @author Tarcisio Câmara
 */
public class Vendedor extends Funcionario {
    private double vendas;

    public Vendedor(String nome, String cpf, int matricula, double salario, double vendas) {
        super(nome, cpf, matricula, salario);
        this.vendas = vendas;
    }

    public double getVendas() {
        return vendas;
    }

    public void setVendas(double vendas) {
        this.vendas += vendas;
    }

    /*@Override
    public String toString() {
        return "Vendedor{" + "vendas=" + vendas + '}';
    }*/

    @Override
    public double calculaPagamento() {
        return getSalario() + (getVendas() * 0.1);
    }
    
    
}
