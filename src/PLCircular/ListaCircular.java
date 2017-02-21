/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PLCircular;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import scrabble.Inicio;

/**
 *
 * @author Mynor
 */
public class ListaCircular {
    
    public NodoLCircular inicio;
    public NodoLCircular fin;
    public int cantidad;
    String nodosC = "";
    String relacionesC = "";
    
    public void ListaCircular(){
        inicio=null;
        fin=null;
        cantidad=0;
    }
    
    public boolean LCVacia(){
        return inicio == null;
    }
    
    public void LCIncertFinal(String nombre){
        // Define un nuevo nodo.
        NodoLCircular nuevo = new NodoLCircular();
        // Agrega al valor al nodo.
        nuevo.nombre=nombre;
        System.out.println("se incertara el nombre: "+nuevo.nombre+"en la lista circular");
        
        
        
        // Consulta si la lista esta vacia.
        if (LCVacia()) {
            // Inicializa la lista agregando como inicio al nuevo nodo.
            inicio = nuevo;
            inicio.mano = new ListaMano();
            inicio.mano.llenarMano();
            Inicio.colaFichas.graficar();
            // De igual forma el ultimo nodo sera el nuevo.
            fin = nuevo;
            // Y el puntero del ultimo debe apuntar al primero.
            fin.siguiente = inicio;
            System.out.println("el nombre "+fin.nombre+" fue incertado con exito en la posición "+cantidad);
            inicio.mano.graficarMano(nombre);
        } else{// Caso contrario el nodo se agrega al final de la lista.
            //verificamos que el nombre a ingresar aun no existea en la lista
            if(existe(nuevo.nombre)){
                JOptionPane.showMessageDialog( null, "EL nombre que ingresaste ya existe!, Intentalo de nuevo" );
            }else{
            // Apuntamos con el ultimo nodo de la lista al nuevo.
            fin.siguiente = nuevo;
            // Apuntamos con el nuevo nodo al inicio de la lista.
            nuevo.siguiente = inicio;
            // Como ahora como el nuevo nodo es el ultimo se actualiza la variable ultimo.
            fin = nuevo;
            fin.mano = new ListaMano();
            fin.mano.llenarMano();
            Inicio.colaFichas.graficar();
            System.out.println("el nombre "+fin.nombre+" fue incertado con exito en la posición "+cantidad);
            fin.mano.graficarMano(nombre);
            }
        }
        // Incrementa el contador de tamaño de la lista
        
        cantidad++;
    }
    
    //metodo que verifica si el elemento ya existe en la lista
    public boolean existe(String evaluado){
        // Crea una copia de la lista.
        NodoLCircular aux = inicio;
        // Bandera para indicar si el valor existe.
        boolean encontrado = false;
        // Recorre la lista hasta encontrar el elemento o hasta 
        // llegar al primer nodo nuevamente.
        do{
            // Consulta si el valor del nodo es igual al de referencia.
            if (evaluado.equals(aux.nombre)){
                // Cambia el valor de la bandera.
                encontrado = true;
            }
            else{
                // Avansa al siguiente. nodo.
                aux = aux.siguiente;
            }
        }while(aux != inicio && encontrado != true);
        // Retorna el resultado de la bandera.
        return encontrado;
    }
    
    public void sumarPuntos(String nombre, int puntos){
        if(existe(nombre)){
             // Crea ua copia de la lista.
            NodoLCircular aux = inicio;
            // Recorre la lista hasta llegar al nodo de referencia.
            while(!aux.nombre.equals(nombre)){
                aux = aux.siguiente;
            }
            aux.punteo= aux.punteo + puntos;
        }else{
        JOptionPane.showMessageDialog( null, "Error!!! el jugador no existe :O !!!!!" );
        }
    }
    
    public String buscarGanador(){
        NodoLCircular aux = inicio;
        String ganador=aux.nombre;
        if(!LCVacia()){
            do{
            if(aux.siguiente.punteo>aux.punteo)
                ganador = aux.siguiente.nombre;
            }
            while(aux!=inicio);
            
        }
        return ganador;
    }
    
    public void graficarCirculo(){
        String textoLista="";
         String pathLC=new String();
        // Verifica si la lista contiene elementoa.
        if (!LCVacia()) {
            // Crea una copia de la lista.
            NodoLCircular aux = inicio;
            // Posicion de los elementos de la lista.
            int i = 0;
            System.out.print("-> ");
            // Recorre la lista hasta llegar nuevamente al incio de la lista.
            do{
                // Imprime en pantalla el valor del nodo.
                this.nodosC+= aux.nombre+ ";"+"\n";
                relacionesC +=aux.nombre+"->"+aux.siguiente.nombre+";"+"\n";
                 // Imprime en pantalla la cadena de nodos y de relaciones actual.
                System.out.println(nodosC);
                System.out.println(relacionesC);
                // Avanza al siguiente nodo.
                aux = aux.siguiente;
                // Incrementa el contador de la posión.
                i++;
            }while(aux != inicio);
            
            textoLista="digraph G \n {"+nodosC+relacionesC+"}";
            System.out.println(textoLista);//C:\\Program Files (x86)\\Graphviz2.38\\bin
            pathLC = "C:\\Users\\Mynor\\Documents\\NetBeansProjects\\Scrabble\\src\\PLCircular\\GraficaListaCircular.dot";
            //el siguiente bloque de codigo genera el archivo .txt que será compilado en graphviz
            //creamos el archivo
            File archivo = new File(pathLC);
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
                    Logger.getLogger(ListaCircular.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            System.out.println ("Error, la lista está vacia"); 
        }
        scrabble.GeneradorJPG.generarGrafo( pathLC,"C:\\Users\\Mynor\\Documents\\NetBeansProjects\\Scrabble\\src\\PLCircular\\imagenLC.jpg");

    }
}
