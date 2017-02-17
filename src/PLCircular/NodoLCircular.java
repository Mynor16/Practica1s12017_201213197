/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PLCircular;

import scrabble.Inicio;

/**
 *
 * @author Mynor
 */
public class NodoLCircular {
    String nombre;
    int punteo;
    ListaMano mano;
    NodoLCircular siguiente;
    
    public void NodoLcircular(){
        
        nombre = "";
        punteo= 0;
        siguiente=null;
        mano = new ListaMano();
        
    }
}
