/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodecartas;

/**
 *
 * @author Tarcisio e Clara
 */

//Criando classe de descarte pois não dava para incluir na classe Baralho
public class Descarte {
    public static Carta cartaDescarte = new Carta("Vazio", "Vazio");
    
    public static String cartaDescarte(){
        return cartaDescarte.toString();
    }
    
    public static Carta setCarta(){
        return cartaDescarte;
    }
    
}
