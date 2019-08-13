/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Aluno Tarcisio Dantas Câmara
 */
public class Dado {
    private int valorFace;
    
    public void Dado(int valorFace){
        this.valorFace = valorFace;
    }
    
    public int getValorFace(){
        return valorFace;
    }
    public void setValorFace(){
        valorFace = (int) (1 + Math.random()*6);
    }
}
