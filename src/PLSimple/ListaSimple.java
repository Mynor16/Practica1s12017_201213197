/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PLSimple;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mynor
 */
public class ListaSimple {
    NodoLSimple inicio;
    int cantidad;
    String nodos="", relaciones="";
    
    public void ListaSimple(){
        inicio = null;
        cantidad = 0;
    }
    
    //emtodo que indica si la lista tiene elementos ó no
    public boolean LSvacia (){
        if (inicio == null){
            return true;
        } else {
            return false;
        }
    }
     public int contar(){
        return cantidad;
     }
     
     // metodo que incerta un nuevo elemento en la lista al final de la misma
     public void LSIncertFinal(String newPalabra){
        // Define un nuevo nodo.
        NodoLSimple nuevo = new NodoLSimple();
        // Agrega al valor al nodo.
        nuevo.palabra= newPalabra;
        System.out.println("el nodo "+cantidad+" tomará el valo: "+nuevo.palabra);
        // Consulta si la lista esta vacia.
        if (LSvacia()) {
            // Inicializa la lista agregando como inicio al nuevo nodo.
            inicio = nuevo;
            System.out.println("el nodo "+cantidad+" ya tomó el valo: "+inicio.palabra);
        // Caso contrario recorre la lista hasta llegar al ultimo nodo
        //y agrega el nuevo.
        } else{
            // Crea ua copia de la lista.
            NodoLSimple aux = inicio;
            // Recorre la lista hasta llegar al ultimo nodo.
            while(aux.siguiente != null){
                aux = aux.siguiente;
            }
            // Agrega el nuevo nodo al final de la lista.
            aux.siguiente = nuevo;
            System.out.println("el nodo "+cantidad+" ya tomó el valo: "+nuevo.palabra);
        }
        // Incrementa el contador de tamaño de la lista
        this.cantidad++;
     }
     //metodo que genera el cuerpo del archivo graphviz y lo envia a graficar.
     public void graficar(){
         String textoLista ="";
         nodos="";
         relaciones="";
         String pathLS=new String();
        // Verifica si la lista contiene elementos.
        if (!LSvacia()) {
            // Crea una copia de la lista.
            NodoLSimple aux = inicio;
            aux.palabra=inicio.palabra;
            // Recorre la lista hasta el final.
            while(aux != null){
                //agrega a la cadena de nodos el nodo actual
                nodos +=aux.palabra+ ";"+"\n";
                // agrega a la cadena de relaciones la del nodo actual y su siguiente mientras este no sea nulo
                if(aux.siguiente != null) 
                {relaciones +=aux.palabra+"->"+aux.siguiente.palabra+";"+"\n";
                }
                // Imprime en pantalla la cadena de nodos y de relaciones actual.
                System.out.println(nodos);
                System.out.println(relaciones);
                // Avanza al siguiente nodo.
                aux = aux.siguiente;
            }
            // une las dos partes del archivo en una sola cadena y le agrega el encabezado
            textoLista="digraph G \n {"+nodos+relaciones+"}";
            System.out.println(textoLista);
            pathLS = "C:\\Users\\Mynor\\Documents\\NetBeansProjects\\Scrabble\\src\\PLSimple\\GraficaListaSimple.dot";
            //el siguiente bloque de codigo genera el archivo .txt que será compilado en graphviz
            //creamos el archivo
            File archivo = new File(pathLS);
             //creamos el buffer
            BufferedWriter bw;
            //usamos try-catch para evitar que la aplicación muera si hay un error
            try{
                //si el arhivo no existe lo creamos
        if(archivo.exists()) {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(textoLista);
        } else {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(textoLista);
        }
        bw.close();
            }catch (IOException ex) {
                    Logger.getLogger(ListaSimple.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            System.out.println ("Error, la lista está vacia"); 
        }
        scrabble.GeneradorJPG.generarGrafo( pathLS,"C:\\Users\\Mynor\\Documents\\NetBeansProjects\\Scrabble\\src\\PLSimple\\imagenLS.jpg");
     }
    
}
