/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PCola;

/**
 *
 * @author Mynor
 */
public class NodoCola {
    
    public int IDFicha;
    public char letra;
    public int valor;
    public NodoCola siguiente;
    
    public NodoCola(){
        IDFicha=0;
        letra =' ';
        valor = 1;
        siguiente = null;
    }
    
}
