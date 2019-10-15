package loja;

/**
 *
 * @author Tarcisio Câmara
 */
public class Administrativo extends Funcionario {
    private double horas;

    public Administrativo(String nome, String cpf, int matricula, double salario, double horas) {
        super(nome, cpf, matricula, salario);
        this.horas = horas;
    }

    public double getHoras() {
        return horas;
    }

    public void setHoras(double horas) {
        this.horas += horas;
    }

    @Override
    public double calculaPagamento() {
        return getSalario() + (getSalario()*(getHoras() / 100));
    }
}
