/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TatuEdi
 */
public class Loja {
    public static void main(String[] args) {
        Vendedor fun1 = new Vendedor("João", "123456789", 2000, 0);
        Administrativo fun2 = new Administrativo("Pedro", "987654321", 2000, 0);
        fun1.setVendas(1500);
        fun2.setHoras(10);
        
        System.out.println(fun1.toString());
        System.out.println(fun2.toString());
    }
    
}
