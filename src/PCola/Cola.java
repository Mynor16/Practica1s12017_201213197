/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PCola;

/**
 *
 * @author Mynor
 */
public class Cola {
    NodoCola inicio;
    int cantidad;
    String nodos="", relaciones="";
    
    public void Cola(){
        inicio = null;
        cantidad = 0;
    }
    public boolean colaVacia(){
        if (inicio == null){
            return true;
        } else {
            return false;
        }
    }
    public int contarCola(){
        return cantidad;
    }
    
    public void IncertarFicha(char letra){
        NodoCola nuevo = new NodoCola();
        nuevo.letra= letra;
        System.out.println("el nodo "+cantidad+" tomará el valo: "+nuevo.letra);
        if (colaVacia()) {
            inicio = nuevo;
            System.out.println("el nodo "+cantidad+" ya tomó el valo: "+inicio.letra);
        } else{
            NodoCola aux = inicio;
            while(aux.siguiente != null){
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo;
            System.out.println("el nodo "+cantidad+" tomará el valo: "+nuevo.letra);
        }
        this.cantidad++;
     }
    
    public void sacarFicha(){
        if(!colaVacia()){inicio = inicio.siguiente;}
    }
}
