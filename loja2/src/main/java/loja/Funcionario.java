package loja;

/**
 *
 * @author Tarcisio Câmara
 */
public abstract class Funcionario extends Pessoa {
    private int matricula;
    private double salario;

    public Funcionario(String nome, String cpf, int matricula, double salario) {
        super(nome, cpf);
        this.matricula = matricula;
        this.salario = salario;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    public abstract double calculaPagamento();

    @Override
    public String toString() {
        return "Funcionario{Nome: "+ getNome() + " matricula= " + matricula + ", salario= " + calculaPagamento() + '}';
    }
}
