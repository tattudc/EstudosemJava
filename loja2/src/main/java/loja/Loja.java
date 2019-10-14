package loja;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Tarcisio Câmara
 */
public class Loja {
    private ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
    private Scanner entrada = new Scanner(System.in);
    private String nome, cpf, codigo;
    private int matricula;
    private double salario, horas, vendas;
    
    public void menu(){
        int menuIni;
        do{
            System.out.println("--------------LOJA--------------");
            System.out.println("1 - Cadastrar Pessoas");
            System.out.println("2 - Remover Pessoas");
            System.out.println("3 - Buscar Pessoas");
            System.out.println("4 - Adicionar produtividade");
            System.out.println("5 - Gerar folha de pagamento");
            System.out.println("6 - Sair");
            menuIni = entrada.nextInt();
            switch(menuIni){
                case 1:
                    cadastrar();
                    break;
                case 2:
                    remover();
                    break;
                case 3:
                    buscar();
                    break;
                case 4:
                    adicionarProdutividade();
                    break;
                case 5:
                    gerarFolhaDePagamento();
                    break;
                case 6:
                    System.out.println("Saindo do sistema");
                    break;
                default:
                    System.out.println("Numero inválido!");
                    break;
            }
        }while(menuIni < 1 || menuIni > 6);
        
    }
    
    private void cadastrar(){
        int menuCad;
        do{
            System.out.println("------CADASTRAR------");
            System.out.println("1 - Cliente");
            System.out.println("2 - Administrativo");
            System.out.println("3 - Vendedor");
            System.out.println("4 - Voltar");
            menuCad = entrada.nextInt();
            switch(menuCad){
                case 1:
                    System.out.println("Digite o nome do cliente: ");
                    nome = entrada.next();
                    System.out.println("Digite o seu CPF: ");
                    cpf = entrada.next();
                    System.out.println("Digite um código para cadastro: ");
                    codigo = entrada.next();
                    pessoas.add(new Cliente(nome, cpf, codigo));
                    System.out.println("Cliente cadastrado com sucesso!!!");
                    menu();
                    break;
                case 2:
                    System.out.println("Digite o nome do funcionário: ");
                    nome = entrada.next();
                    System.out.println("Digite o seu CPF: ");
                    cpf = entrada.next();
                    System.out.println("Digite sua matricula: ");
                    matricula = entrada.nextInt();
                    System.out.println("Digite o seu salário: ");
                    salario = entrada.nextDouble();
                    System.out.println("Quantas horas extras faz?");
                    horas = entrada.nextDouble();
                    pessoas.add(new Administrativo(nome, cpf, matricula, salario, horas));
                    System.out.println("Funcionário cadastrado com sucesso!!!");
                    menu();
                    break;
                case 3:
                    System.out.println("Digite o nome do vendedor: ");
                    nome = entrada.next();
                    System.out.println("Digite o seu CPF: ");
                    cpf = entrada.next();
                    System.out.println("Digite sua matricula: ");
                    matricula = entrada.nextInt();
                    System.out.println("Digite o seu salário: ");
                    salario = entrada.nextDouble();
                    System.out.println("Digite quantas vendas ele realiza");
                    vendas = entrada.nextDouble();
                    pessoas.add(new Vendedor(nome, cpf, matricula, salario, vendas));
                    System.out.println("Vendedor cadastrado com sucesso!!!");
                    menu();
                    break;
                case 4:
                    menu();
                    break;
                default:
                    System.out.println("Número inválido!");
                    break;
            }
        }while(menuCad < 1 || menuCad > 4);
    }
    
    private void remover(){
        System.out.print("Diga o cpf da pessoa desejada: ");
        cpf = entrada.next();
        if(buscar(cpf) != null){
            pessoas.remove(buscar(cpf));
            menu();
        }else{
            System.out.println("Número incorreto ou pessoa inexistente");
            menu();
        }
    }
    
    private Pessoa buscar(String cpf){
        for(int i = 0; i < pessoas.size(); i++){
            if(pessoas.get(i).getCpf().equalsIgnoreCase(cpf)){
                return pessoas.get(i);
            }
        }
        return null;
    }
    
    private void buscar(){
        System.out.print("Informe o cpf: ");
        cpf = entrada.next();
        if(buscar(cpf) != null){
            System.out.println(buscar(cpf).toString());
        }else{
            System.out.println("Usuário não encontrado");
        }
    }
    
    private void listar(){
        for(Pessoa peo: pessoas){
            System.out.println(peo.toString());
        }
    }
    
    private void adicionarProdutividade(){
        System.out.print("Informe o cpf: ");
        cpf = entrada.next();
        if(buscar(cpf) != null){
            if(buscar(cpf) instanceof Administrativo){
                System.out.print("Digite as horas extras a mais: ");
                double produtividade = entrada.nextDouble();
                ((Administrativo) buscar(cpf)).setHoras(produtividade);
                menu();
            }else if(buscar(cpf) instanceof Vendedor){
                System.out.print("Digite as vendas do vendedor: ");
                double produtividade = entrada.nextDouble();
                ((Vendedor) buscar(cpf)).setVendas(produtividade);
                menu();
            }else{
                System.out.println("Um cliente não pode usar essa função");
                menu();
            }
        }else{
            System.out.println("CPF inválido!!!");
            adicionarProdutividade();
        }
    }
    
    private void gerarFolhaDePagamento(){
        for(int i = 0; i < pessoas.size(); i++){
            if(pessoas.get(i) instanceof Administrativo){
                ((Administrativo) pessoas.get(i)).calculaPagamento();
                System.out.println(((Administrativo) pessoas.get(i)).toString());
            }else if(pessoas.get(i) instanceof Vendedor){
                ((Vendedor) pessoas.get(i)).calculaPagamento();
                System.out.println(((Vendedor) pessoas.get(i)).toString());
            }else{
                System.out.println("Clientes não geram folha de pagamento!");
                menu();
            }
        }
        menu();
    }
    
    public static void main(String[] args) {
        Loja loj = new Loja();
        loj.menu();
    }
}
