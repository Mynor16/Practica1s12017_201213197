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
    
    int id;
    int multiple;
    int x;
    int y;
    public PCola.NodoCola ficha;
    NodoMatriz izquierda, derecha, arriba,abajo;
    
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
