/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disciplinasalunos;

/**
 *
 * @author Aluno Tarcisio Dantas Câmara
 */
public class Disciplina {
    private String nomeDisciplina;
    private int qtdAlunos;
    private final int QTDNOTAS = 3;
    private double [][] notas;

    public Disciplina(String nomeDisciplina, int qtdAlunos){
        this.nomeDisciplina = nomeDisciplina;
        this.qtdAlunos = qtdAlunos;
        notas = new double[qtdAlunos] [QTDNOTAS];
   
    }
     
    public String getNomeDisciplina(){
        return nomeDisciplina;
    }
    
    public void setNomeDisciplina(String nomeDisciplina){
        this.nomeDisciplina = nomeDisciplina;
    }
    
    public int getQtdAlunos(){
        return qtdAlunos;
    }
    
    public void setQtdAlunos(int qtdAlunos){
        this.qtdAlunos = qtdAlunos;
    }
    
    public int getQTDNOTAS(){
        return QTDNOTAS;
    }
    
    public double[][] getNotas(){
        return notas;
    }
    
    public void setNotas(double [][] notas){
        this.notas = notas;
    }
    
    public void setNota(int i, int j, double valor){
        notas[i][j] = valor;
    }
    
    public double getNota(int i, int j){
        return notas[i][j];
    }
    
    public double getMedia(){
       double somaNotas = 0;
       for(double[] linha: notas){
           for(double elemento: linha){
               somaNotas += elemento; 
           }
       }
       somaNotas /= qtdAlunos * QTDNOTAS;
       return somaNotas;
    }
    
}
