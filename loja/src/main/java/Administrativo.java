/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TatuEdi
 */
public class Administrativo extends Funcionario {
    private double horas;

    public Administrativo(String nome, String cpf, double salario, double horas) {
        super(nome, cpf, salario);
        this.horas = horas;
    }

    public double getHoras() {
        return horas;
    }

    public void setHoras(double horas) {
        this.horas = horas;
    }
    
    @Override
    public double calculaPagamento(){
        return getSalario() + (getSalario()*(getHoras() / 100));
    }

    @Override
    public String toString() {
        return "Administrativo{Funcionário: " + super.getNome() + " horas= " + horas + " Salário: "+calculaPagamento()+'}';
    }
}
