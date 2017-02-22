/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PMatriz;

/**
 *
 * @author Mynor
 */
public class NodoMatriz {
    
    public int id;
    public int multiple;
    public int x;
    public int y;
    public PCola.NodoCola ficha;
    public NodoMatriz izquierda, derecha, arriba,abajo;
    
    public void NodoMatriz(){
        id = 0;
        multiple=1;
        x = 0;
        y = 0;
        ficha = new PCola.NodoCola();
        ficha.letra='_';
        this.izquierda=null;
        this.derecha=null;
        this.arriba=null;
        this.abajo=null;
    }
}
