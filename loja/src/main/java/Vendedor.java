/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TatuEdi
 */
public class Vendedor extends Funcionario {
    private double vendas;
    
    public Vendedor(String nome, String cpf, double salario, double vendas) {
        super(nome, cpf, salario);
        this.vendas = vendas;
    }

    public double getVendas() {
        return vendas;
    }

    public void setVendas(double vendas) {
        this.vendas = vendas;
    }
    
    @Override
    public double calculaPagamento(){
        return getSalario() + (getVendas() * 0.1);
    }

    @Override
    public String toString() {
        return "Vendedor{Funcionário: "+ getNome() + " vendas= " + vendas + " Salário: "+calculaPagamento()+'}';
    }
}
