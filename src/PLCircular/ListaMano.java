/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PLCircular;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import scrabble.Inicio;

/**
 *
 * @author Mynor
 */
public class ListaMano {
    
    PCola.NodoCola inicio;
    int cantidad;
    String nodos="", relaciones="";
    
    public ListaMano (){
        inicio=null;
        cantidad=0;
        this.llenarMano();
        graficarMano("jugador de turno");
    }
    public boolean LFvacia (){
        if (inicio == null){
            return true;
        } else {
            return false;
        }
    }
     public int contar(){
        return cantidad;
     }
     
     public void LFIncertFinal(char caracter, int valor){
        // Define un nuevo nodo.
         PCola.NodoCola nuevo= new PCola.NodoCola();
        // Agrega al valor al nodo.
        nuevo.IDFicha= cantidad;
        System.out.println("el nodo "+cantidad+" tomará el valo: "+nuevo.letra);
        // Consulta si la lista esta vacia.
        if (LFvacia()) {
            // Inicializa la lista agregando como inicio al nuevo nodo.
            inicio = nuevo;
            System.out.println("el nodo "+cantidad+" ya tomó el valo: "+inicio.letra);
        // Caso contrario recorre la lista hasta llegar al ultimo nodo
        //y agrega el nuevo.
        } else{
            // Crea ua copia de la lista.
            PCola.NodoCola aux = inicio;
            // Recorre la lista hasta llegar al ultimo nodo.
            while(aux.siguiente != null){
                aux = aux.siguiente;
            }
            // Agrega el nuevo nodo al final de la lista.
            aux.siguiente = nuevo;
            System.out.println("el nodo "+cantidad+" ya tomó el valo: "+nuevo.letra);
        }
        // Incrementa el contador de tamaño de la lista
        this.cantidad++;
     }
     public void CambiarFicha(char fichaPrevia){
         
          // Crea una copia de la lista.
        PCola.NodoCola aux = inicio;
        // Bandera para indicar si el valor existe.
        boolean encontrado = false;
        // Recorre la lista hasta encontrar el elemento o hasta 
        // llegar al final de la lista.
        while(aux != null && encontrado != true){
            // Consulta si el valor del nodo es igual al de referencia.
            if (fichaPrevia == aux.letra){
                // Cambia el valor de la bandera.
                encontrado = true;
            }
            else{
                // Avansa al siguiente. nodo.
                aux = aux.siguiente;
            }
        }
        if(encontrado){
            // Consulta si el nodo a eliminar es el pirmero
            if (inicio.letra == fichaPrevia) {
                // El primer nodo apunta al siguiente.
                Inicio.colaFichas.IncertarFicha(inicio.letra, inicio.valor);
                inicio = inicio.siguiente;
            } else{
                // Crea ua copia de la lista.
                //PCola.NodoCola aux = inicio;
                // Recorre la lista hasta llegar al nodo anterior 
                // al de referencia.
                while(aux.siguiente.letra != fichaPrevia){
                    aux = aux.siguiente;
                }
                // Guarda el nodo siguiente del nodo a eliminar.
                Inicio.colaFichas.IncertarFicha(aux.siguiente.letra, aux.siguiente.valor);
                PCola.NodoCola siguiente = aux.siguiente.siguiente;
                // Enlaza el nodo anterior al de eliminar con el 
                // sguiente despues de el.
                aux.siguiente=siguiente;  
            }
            // Disminuye el contador de tamaño de la lista.
            cantidad--;
        }
     }
     
     public void llenarMano(){
         for(int i=0; i<7;i++){
            System.out.println("Incetando elemento numero "+i+" en la mano del jugador creado");
        LFIncertFinal(Inicio.colaFichas.inicio.letra, Inicio.colaFichas.inicio.valor);
        Inicio.colaFichas.sacarFicha();
        }
     }
     
     public void graficarMano(String padre){
         
         nodos="";
        relaciones="";
         String textoMano;
         String pathCL=new String();
        // Verifica si la lista contiene elementos.
        if (!LFvacia()) {
            // Crea una copia de la lista.
            PCola.NodoCola aux = inicio;
            aux.letra=inicio.letra;
            aux.valor = inicio.valor;
            aux.IDFicha = inicio.IDFicha;
            
            nodos += padre+";"+"\n";
            relaciones+= padre+"->"+aux.IDFicha+";"+"\n";
            
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
            textoMano="digraph G \n { \n"+nodos+relaciones+"}";
            System.out.println(textoMano);
            pathCL = "C:\\Users\\Mynor\\Documents\\NetBeansProjects\\Scrabble\\src\\PLCircular\\GraficaMano.dot";
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
            bw.write(textoMano);
        } else {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(textoMano);
        }
        bw.close();
            }catch (IOException ex) {
                    Logger.getLogger(ListaMano.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            System.out.println ("Error, la Mano está vacia"); 
        }
        scrabble.GeneradorJPG.generarGrafo( pathCL,"C:\\Users\\Mynor\\Documents\\NetBeansProjects\\Scrabble\\src\\PLCircular\\imagenMano.jpg");
     
         
         
        }
    
}
