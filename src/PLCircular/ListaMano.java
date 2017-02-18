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
         
         PCola.NodoCola nuevo= new PCola.NodoCola();
        nuevo.IDFicha= cantidad;
        nuevo.valor= valor;
        nuevo.letra=caracter;
        System.out.println("el nodo "+cantidad+" tomará el valo: "+nuevo.letra);
        if (LFvacia()) {
            inicio = nuevo;
            System.out.println("el nodo "+cantidad+" ya tomó el valo: "+inicio.letra);
        } else{
            PCola.NodoCola aux = inicio;
            while(aux.siguiente != null){
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo;
            System.out.println("el nodo "+cantidad+" ya tomó el valo: "+nuevo.letra);
        }
        this.cantidad++;
     }
     public void CambiarFicha(char fichaPrevia){
         
        PCola.NodoCola aux = inicio;
        boolean encontrado = false;
        while(aux != null && encontrado != true){
            if (fichaPrevia == aux.letra){
                encontrado = true;
            }
            else{
                aux = aux.siguiente;
            }
        }
        if(encontrado){
            if (inicio.letra == fichaPrevia) {
                Inicio.colaFichas.IncertarFicha(inicio.letra, inicio.valor);
                inicio = inicio.siguiente;
            } else{
                while(aux.siguiente.letra != fichaPrevia){
                    aux = aux.siguiente;
                }
                Inicio.colaFichas.IncertarFicha(aux.siguiente.letra, aux.siguiente.valor);
                PCola.NodoCola siguiente = aux.siguiente.siguiente;
                aux.siguiente=siguiente;  
            }
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
