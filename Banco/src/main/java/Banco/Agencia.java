/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author TatuEdi
 */
public class Agencia {
    ArrayList<Conta> contas;
    Scanner entrada = new Scanner(System.in);
    private int numero = 100;
    
    public void menu(){
        int opcao = 0;
        
         do {
        System.out.println("AGENCIA EAJ\n1 - Criar conta\n2 - Acessa Conta\n3 - Sair do aplicativo\n");
        opcao = entrada.nextInt();
            switch (opcao) {
                case 1:
                    criarConta();
                    break;
                case 2:
                    System.out.println("Informe o numero da conta: ");
                    Conta c = existeConta(entrada.nextInt()); //passa o numero da conta e recebe um objeto de Conta
                    if (c != null) {
                        acessarConta(c); //caso a conta exista, acessa a conta passando o objeto da conta na lista
                    } else {
                        System.out.println("Conta nao foi criada");
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opcao Invalida");
            }
        } while (opcao != 3);
    }
    
    private void criarConta() {

        System.out.println("Criando conta de numero " + numero);
        System.out.println("Informe o saldo inicial da conta");
        contas.add(new Conta(numero++, entrada.nextDouble()));

    }

    private Conta existeConta(int numero) {
        for (Conta c : contas) {
            if (c.getNumero() == numero) {
                return c;
            }
        }
        return null;
    }

    private void acessarConta(Conta c) {
        int opcao = 0;
        do {
            System.out.println("\n\tCONTA " + c.getNumero());
            System.out.println("1 - Consultar Saldo");
            System.out.println("2 - Realizar Deposito");
            System.out.println("3 - Realizar Saque");
            System.out.println("4 - Voltar");
            opcao = entrada.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Saldo = " + c.getSaldo());
                    break;
                case 2:
                    System.out.println("Digite o valor que deseja depositar:");
                    c.deposito(entrada.nextDouble());
                    break;
                case 3:
                    System.out.println("Digite o valor que deseja sacar:");
                    if (!c.saque(entrada.nextDouble())) {
                        System.out.println("Saldo Insuficiente");
                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opcao Invalida");
            }
        } while (opcao != 4);
    }

    
    public static void main(String[] args) {
        Agencia bancoEAJ = new Agencia();
        bancoEAJ.menu();
    }
}
