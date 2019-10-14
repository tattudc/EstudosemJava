package loja;

/**
 *
 * @author Tarcisio Câmara
 */
public class Cliente extends Pessoa {
    private String codigo;

    public Cliente(String nome, String cpf, String codigo) {
        super(nome, cpf);
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "codigo=" + codigo + '}';
    }  
    
}
