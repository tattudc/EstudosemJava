/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

/**
 *
 * @author TatuEdi
 */
public class Poupanca extends Conta {
    private double rendimento;

    public Poupanca(int numero, double saldo, double rendimento) {
        super(numero, saldo);
        this.rendimento = rendimento;
    }
    
    public void creditaRendimento(){
        setSaldo(getSaldo()+ rendimento);
    }

    @Override
    public String toString() {
        return "Poupanca{" + "rendimento=" + rendimento + '}';
    }
}
