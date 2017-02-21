/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PLCircular;

/**
 *
 * @author Mynor
 */
public class NodoLCircular {
    public String nombre;
    public int punteo;
    public ListaMano mano;
    public NodoLCircular siguiente;
    
    public void NodoLcircular(){
        
        nombre = "";
        punteo= 0;
        siguiente=null;
        mano = new ListaMano();
        
    }
}
