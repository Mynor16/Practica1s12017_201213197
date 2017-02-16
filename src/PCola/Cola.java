/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PCola;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public void IncertarFicha(char letra, int puntos){
        NodoCola nuevo = new NodoCola();
        nuevo.letra= letra;
        nuevo.valor = puntos;
        nuevo.IDFicha = cantidad;
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
            System.out.println("el nodo "+cantidad+" ya tomo el valo: "+nuevo.letra);
        }
        this.cantidad++;
     }
    
    public void sacarFicha(){
        if(!colaVacia()){inicio = inicio.siguiente;}
    }
    
    
    //++++++++++++++++++++++++++++++++++++
    public void graficar(){
         String textoCola;
         String pathCL=new String();
        // Verifica si la lista contiene elementos.
        if (!colaVacia()) {
            // Crea una copia de la lista.
            NodoCola aux = inicio;
            aux.letra=inicio.letra;
            aux.valor = inicio.valor;
            aux.IDFicha = inicio.IDFicha;
            // Recorre la lista hasta el final.
            while(aux != null){
                //agrega a la cadena de nodos el nodo actual
                nodos +=aux.IDFicha +" [label="+aux.letra+aux.valor+"];"+"\n";
                // agrega a la cadena de relaciones la del nodo actual y su siguiente mientras este no sea nulo
                if(aux.siguiente != null) 
                {relaciones +=aux.IDFicha+"->"+aux.siguiente.IDFicha+";"+"\n";
                }
                aux = aux.siguiente;
            }
            // une las dos partes del archivo en una sola cadena y le agrega el encabezado
            textoCola="digraph G \n { \n"+nodos+relaciones+"}";
            System.out.println(textoCola);
            pathCL = "C:\\Users\\Mynor\\Documents\\NetBeansProjects\\Scrabble\\src\\PCola\\GraficaCola.dot";
            //el siguiente bloque de codigo genera el archivo .txt que será compilado en graphviz
            //creamos el archivo
            File archivo = new File(pathCL);
             //creamos el buffer
            BufferedWriter bw;
            //usamos try-catch para evitar que la aplicación muera si hay un error
            try{
                //si el arhivo no existe lo creamos
        if(archivo.exists()) {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(textoCola);
        } else {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(textoCola);
        }
        bw.close();
            }catch (IOException ex) {
                    Logger.getLogger(Cola.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            System.out.println ("Error, la lista está vacia"); 
        }
        scrabble.GeneradorJPG.generarGrafo( pathCL,"C:\\Users\\Mynor\\Documents\\NetBeansProjects\\Scrabble\\src\\PCola\\imagenCL.jpg");
     }
}
