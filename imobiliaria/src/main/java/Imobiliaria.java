import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tarcisio Câmara
 */
public class Imobiliaria {
    private ArrayList<Imovel> imoveis = new ArrayList<Imovel>();
    private Scanner entrada = new Scanner(System.in);
    private int contador = 0;
    
    public void menu(){
        int opMenu;
        do{
            System.out.println("------Menu Imobiliaria------");
            System.out.println("1 - Cadastrar imóvel");
            System.out.println("2 - Alugar imóvel");
            System.out.println("3 - Sair");
            opMenu = entrada.nextInt();
            switch(opMenu){
                case 1:
                    cadastrarImoveis();
                    break;
                case 2:
                    alugarImoveis();
                    break;
                case 3:
                    System.out.println("Saindo do sistema");
                    break;
                default:
                    System.out.println("Número inválido");
                    break;
            }
        }while(opMenu != 3);
    }
    
    private boolean listarImoveis(){
        if(imoveis.isEmpty()){
            return false;
        }else{
            for(Imovel i: imoveis){
                System.out.println(i.toString());
            }
            return true;
        }
    }
    
    private void alugarImoveis(){
        int codImovel;
        listarImoveis();
        if(listarImoveis() == true){
            System.out.println("Digite o código do imóvel: ");
            codImovel = entrada.nextInt();
            for(int i = 0; i < imoveis.size(); i++){
                if(imoveis.get(i).getCodigo() == codImovel){
                    if(imoveis.get(i).isDisponivel()){
                        imoveis.get(i).setDisponivel(false);
                        System.out.println("Imóvel alugado com sucesso!");
                        break;
                    }
                    else{
                        System.out.println("Imóvel indisponível");
                    }
                }
            }
        }
        else{
            System.out.println("Nada cadastrado!");
        }
    }
    
    private void cadastrarImoveis(){
        int opMenuCadastro = 0, numeroQuartos;
        String regiao;
        double valor, areaUtil;
        do{
            System.out.println("------Cadastrar Imóvel------");
            System.out.println("1 - Residencial");
            System.out.println("2 - Comercial");
            System.out.println("3 - Voltar");
            opMenuCadastro = entrada.nextInt();
            switch(opMenuCadastro){
                case 1:
                    System.out.println("Digite a regiao do imovel:");
                    regiao = entrada.next();
                    System.out.println("Digite o valor do imóvel");
                    valor = entrada.nextDouble();
                    System.out.println("Quantos quartos?");
                    numeroQuartos = entrada.nextInt();
                    Residencial res1 = new Residencial(contador, regiao, valor, true, numeroQuartos);
                    imoveis.add(res1);
                    System.out.println("Cadastrado!");
                    contador++;
                    break;
                case 2:
                    System.out.println("Digite a regiao do imovel:");
                    regiao = entrada.next();
                    System.out.println("Digite o valor do imóvel");
                    valor = entrada.nextDouble();
                    System.out.println("Digite a área útil:");
                    areaUtil = entrada.nextDouble();
                    Comercial com1 = new Comercial(contador, regiao, valor, true, areaUtil);
                    imoveis.add(com1);
                    System.out.println("Cadastrado!");
                    contador++;
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Numero Invalido");
                    break;
            }
        }while(opMenuCadastro != 3);
    }
    public static void main(String[] args) {
        Imobiliaria imo = new Imobiliaria();
        imo.menu();
    }
}
