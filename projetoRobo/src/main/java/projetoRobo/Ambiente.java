/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoRobo;

/**
 *
 * @author Tarcisio Dantas Câmara
 */
public class Ambiente {
    private int qtdLinhas;
    private int qtdColunas;
    
    public void Ambiente(int linhas, int colunas){
        this.qtdLinhas = linhas;
        this.qtdColunas = colunas;
    }
    
    public int getQtdLinhas(){
        return qtdLinhas;
    }
    
    public void setQtdLinhas(int linhas){
        this.qtdLinhas = linhas;
    }
    
    public int getQtdColunas(){
        return qtdColunas;
    }
    
    public void setQtdColunas (int colunas){
        this.qtdColunas = colunas;
    }
    
}
