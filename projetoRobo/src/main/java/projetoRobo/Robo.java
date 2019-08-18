/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoRobo;
import projetoRobo.Ambiente;

/**
 *
 * @author TatuEdi
 */
public class Robo {
    private int linha;
    private int coluna;
    private Ambiente sala = new Ambiente();
    
    public void Robo(int linha, int coluna, Ambiente sala){
        this.linha = linha;
        this.coluna = coluna;
        this.sala = sala;
    }
    
    public void mostrarPosicao(){
        //return system.out.println(linha, coluna);
    }
    
    
    
    
}
