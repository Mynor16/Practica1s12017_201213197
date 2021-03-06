/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PMatriz;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Mynor
 */
public class Matriz {
    
    public NodoMatriz inicio;
    public NodoMatriz actual;
    public int totalCasillas;
    public int casillasActivas;
     public int x;
    public int y;
    String nodos;
    String relaciones;
    String textoMatriz;
    
    
    public void Matriz(){
    totalCasillas=0;
    casillasActivas=0;
    x=0;
    y=0;
    nodos="";
    relaciones="";
    textoMatriz="";
    }
    
    public void crearMatriz(int x, int y){
        this.x=x;
        this.y=y;
        inicio= new NodoMatriz();//creamos el nodo inicial del cual partiremos
        inicio.id = totalCasillas;
        totalCasillas ++;
        NodoMatriz aux = inicio; //posicionamos nuestro nodo auxiliar en el inicio
        NodoMatriz siguienteFila = new NodoMatriz();//este nodo nos servirá para saber endonde inicia la sigiente fila
        for (int j = 0; j < y; j++){//este for crea las filas en el eje y
            System.out.println("\n posición"+j+" - ");
            for(int i = 0; i< x; i++){//este for crea las casillas de la matriz en el eje x
                System.out.print(" elemento"+i+" - ");
                if(j== 0){// si es la primer fila
                    if(i==0){//si es la primer fila y la primer columna
                        aux.x=i;
                        aux.y=j;
                        aux.derecha = new NodoMatriz();//creamos el nodo de la derecha
                        aux.derecha.id=totalCasillas;
                        totalCasillas ++;
                        aux.derecha.izquierda= aux;//lo enlazamos al nodo actual
                        aux.abajo = new NodoMatriz();//creamos el nodo de abao
                        aux.abajo.id=totalCasillas;
                        totalCasillas ++;
                        aux.abajo.arriba = aux;//lo enlasamos al nodo actual
                        siguienteFila=aux.abajo;//guardamos el nodo de la posición 1,2 que nos servirá para crear la siguiente fila 
                        aux=aux.derecha;// movemos nuestro nodo auxiliar al de la derecha
                    }else if(i== x-1){//si es la ultima columna de la primer fila
                        aux.x=i;
                        aux.y=j;
                        aux.abajo = new NodoMatriz();//creamos el nodo de abajo
                        aux.abajo.id=totalCasillas;
                        totalCasillas ++;
                        aux.abajo.arriba=aux;//lo enlazamos con el actual
                        aux=siguienteFila;// pasamos al inicio de la siguiente fila (la segunda)
                    }else{//si es un nodo intermedio de la primer fila
                        aux.x=i;
                        aux.y=j;
                    aux.abajo = new NodoMatriz();//creamos el nodo de abajo
                    aux.abajo.id=totalCasillas;
                    totalCasillas ++;
                    aux.abajo.arriba = aux;//y lo enlazamos al actual
                    aux.derecha = new NodoMatriz();//creamos el nodo de la derecha
                    aux.derecha.id=totalCasillas;
                    totalCasillas ++;
                    aux.derecha.izquierda= aux;//lo enlazamos al nodo actual
                    aux=aux.derecha;//avansamos a la siguiente posición
                    }
                }//si no es la primer fila
                else if(j == y-1){//si es la ultima fila
                    if(i==0){//si es la primer columna de la ultima fila
                        aux.x=i;
                        aux.y=j;
                        aux.derecha = aux.arriba.derecha.abajo;//enlasamos el nodo actual al de la derecha
                        aux.derecha.izquierda=aux;//y el de la derecha con el actual
                        aux=aux.derecha;//avansamos a la siguiente posición
                        //siguienteFila=null;// y ya no necesitamos saber cual es la siguiente fila porque no existe
                    }else if(i== x-1){//si es la ultima columna de la ultima fila
                        aux.x=i;
                        aux.y=j;
                        JOptionPane.showMessageDialog( null, "La matriz fue creada exitosamente" ); //lo logramos
                    }else{// si es la ultima fila pero no el inicio ni el final
                        aux.x=i;
                        aux.y=j;
                         aux.derecha=aux.arriba.derecha.abajo;//enlasamos el nodo actual con el de la derecha
                         aux.derecha.izquierda=aux;//y el de la derecha con el actual
                         aux=aux.derecha;//seguimos avansando
                    }
                }else{//si no es la primer ni la ultima fila
                    if(i==0){//si es la primer columna de una fila media
                        aux.x=i;
                        aux.y=j;
                    aux.abajo = new NodoMatriz();//creamos el nodo de abajo
                    aux.abajo.id=totalCasillas;
                    totalCasillas ++;
                    aux.abajo.arriba = aux;//lo enlazamos con el nodo actual
                    siguienteFila=aux.abajo;//guardamos el inicio de la sigueitne fila
                    aux.derecha=aux.arriba.derecha.abajo;//enlasamos el nodo actual con el de la derecha
                    aux.derecha.izquierda=aux;//y el de la derecha con el actual
                    aux=aux.derecha;//y nos movemos al siguiente nodo
                    }else if(i ==x-1){//si es la ultima columna de una fila media
                        aux.x=i;
                        aux.y=j;
                        aux.abajo = new NodoMatriz();//creamos el nodo de abajo
                        aux.abajo.id=totalCasillas;
                        totalCasillas ++;
                        aux.abajo.arriba=aux;//lo enlazamos con el actual
                        aux=siguienteFila;// pasamos al inicio de la siguiente fila
                    }else{//si es un nodo intermedio de una fila intemedia
                        aux.x=i;
                        aux.y=j;
                    aux.abajo = new NodoMatriz();//creamos el nodo de abajo
                    aux.abajo.id=totalCasillas;
                    totalCasillas ++;
                    aux.abajo.arriba = aux;//y lo enlazamos al actual
                    aux.derecha=aux.arriba.derecha.abajo;//enlasamos el nodo actual con el de la derecha
                    aux.derecha.izquierda=aux;//y el de la derecha con el actual
                    aux=aux.derecha;
                    }
                }
            }
        }System.out.println("la matriz se creó con "+totalCasillas+" casillas en total");
    }
    
    public void establecerMult(int x, int y, int mult){
        
        buscarCasilla(x,y);
        actual.multiple=mult;
        //System.out.println("la casilla "+(1+actual.x)+","+(actual.y+1)+" adquirió la multiplicidad "+actual.multiple);
        //JOptionPane.showMessageDialog( null,"la casilla "+(1+actual.x)+","+(actual.y+1)+" adquirió la multiplicidad "+actual.multiple);
    }
    
    public void agregarLetra(int x,int y,char letra){
        
        buscarCasilla(x,y);
        actual.ficha= new PCola.NodoCola();
        actual.ficha.letra=letra;
        
    }
    
    public void buscarCasilla(int w, int z){
        boolean encontrado=false;
        this.actual=inicio;
        NodoMatriz aux = inicio;
        NodoMatriz siguienteFila = new NodoMatriz();
        for(int j=0; j<this.y;j++){
            if(encontrado){
                    break;
            }else{
            for(int i=0; i<this.x;i++){
                if(aux.x==w & aux.y==z){
                    this.actual=aux;
                    //JOptionPane.showMessageDialog( null, "El elemento"+(1+actual.x)+","+(actual.y+1)+" fue encontrado!!!! con id"+actual.id );
                    //System.out.println("La casilla seleccionada es de multiplicidad x"+actual.multiple);
                    encontrado=true;
                    break;
                }else{
                     if(j== 0){// si es la primer fila
                    if(i==0){//si es la primer fila y la primer columna
                        siguienteFila=aux.abajo;//guardamos el nodo de la posición 1,2 que nos servirá para crear la siguiente fila 
                        aux=aux.derecha;// movemos nuestro nodo auxiliar al de la derecha
                    }else if(i== x-1){//si es la ultima columna de la primer fila
                        aux=siguienteFila;// pasamos al inicio de la siguiente fila (la segunda)
                    }else{//si es un nodo intermedio de la primer fila
                    aux=aux.derecha;//avansamos a la siguiente posición
                    }
                }//si no es la primer fila
                else if(j == y-1){//si es la ultima fila
                    if(i==0){//si es la primer columna de la ultima fila
                        aux=aux.derecha;//avansamos a la siguiente posición
                    }else if(i== x-1){//si es la ultima columna de la ultima fila
                        JOptionPane.showMessageDialog( null, "El elemento buscado no existe en la matriz" ); //lo logramos
                    }else{// si es la ultima fila pero no el inicio ni el final
                         aux=aux.derecha;//seguimos avansando
                    }
                }else{//si no es la primer ni la ultima fila
                    if(i==0){//si es la primer columna de una fila media
                    siguienteFila=aux.abajo;//guardamos el inicio de la sigueitne fila
                    aux=aux.derecha;//y nos movemos al siguiente nodo
                    }else if(i ==x-1){//si es la ultima columna de una fila media
                        aux=siguienteFila;// pasamos al inicio de la siguiente fila
                    }else{//si es un nodo intermedio de una fila intemedia
                    aux=aux.derecha;
                    }
                 }      
               }  
            }
          }
        }
    }
    
    
    public void graficarMatriz(){
        
        nodos="";
        relaciones="";
        textoMatriz="";
        
        NodoMatriz aux = inicio; //posicionamos nuestro nodo auxiliar en el inicio
        NodoMatriz siguienteFila = new NodoMatriz();//este nodo nos servirá para saber endonde inicia la sigiente fial
        
        for (int j = 0; j < y; j++){//este for crea las filas en el eje y
            for(int i = 0; i< x; i++){//este for crea las casillas de la matriz en el eje x
                if(j== 0){// si es la primer fila
                    if(i==0){//si es la primer fila y la primer columna  +" [label="+aux.letra+aux.valor+"];"
                        //nodos+= aux.id+";"+"\n";
                        nodos+= aux.id+"[label =x"+aux.x+"y"+aux.y +"];"+"\n";
                        nodos+= aux.derecha.id+"[label =x"+aux.derecha.x+"y"+aux.derecha.y +"];"+"\n";
                        relaciones+=aux.id+"->"+aux.derecha.id+";"+"\n";
                        relaciones+=aux.derecha.id+"->"+aux.id+";"+"\n";
                        nodos+= aux.abajo.id+"[label =x"+aux.abajo.x+"y"+aux.abajo.y +"];"+"\n";
                        relaciones+=aux.id+"->"+aux.abajo.id+";"+"\n";
                        relaciones+=aux.abajo.id+"->"+aux.id+";"+"\n";
                        siguienteFila=aux.abajo;//guardamos el nodo de la posición 1,2 que nos servirá para crear la siguiente fila 
                        aux=aux.derecha;// movemos nuestro nodo auxiliar al de la derecha
                    }else if(i== x-1){//si es la ultima columna de la primer fila
                        //nodos+= aux.id+";"+"\n";
                        nodos+= aux.abajo.id+"[label =x"+aux.abajo.x+"y"+aux.abajo.y +"];"+"\n";
                        relaciones+=aux.id+"->"+aux.abajo.id+";"+"\n";
                        relaciones+=aux.abajo.id+"->"+aux.id+";"+"\n";
                        aux=siguienteFila;// pasamos al inicio de la siguiente fila (la segunda)
                    }else{//si es un nodo intermedio de una fila intemedia
                    nodos+= aux.abajo.id+"[label =x"+aux.abajo.x+"y"+aux.abajo.y +"];"+"\n";
                        relaciones+=aux.id+"->"+aux.abajo.id+";"+"\n";
                        relaciones+=aux.abajo.id+"->"+aux.id+"\n";
                        nodos+= aux.derecha.id+"[label =x"+aux.derecha.x+"y"+aux.derecha.y +"];"+"\n";
                        relaciones+=aux.id+"->"+aux.derecha.id+";"+"\n";
                        relaciones+=aux.derecha.id+"->"+aux.id+";"+"\n";
                        aux=aux.derecha;//avansamos a la siguiente posición
                        
                    }
                }//si no es la primer fila
                else if(j == y-1){//si es la ultima fila
                    if(i==0){//si es la primer columna de la ultima fila
                        relaciones+=aux.id+"->"+aux.derecha.id+";"+"\n";
                        relaciones+=aux.derecha.id+"->"+aux.id+";"+"\n";
                        aux=aux.derecha;//avansamos a la siguiente posición
                        siguienteFila=null;// y ya no necesitamos saber cual es la siguiente fila porque no existe
                    }else if(i== x-1){//si es la ultima columna de la ultima fila
                        JOptionPane.showMessageDialog( null, "La matriz fue graficada con exito (creo)" ); //lo logramos
                    }else{// si es la ultima fila pero no el inicio ni el final
                        relaciones+=aux.id+"->"+aux.derecha.id+";"+"\n";
                        relaciones+=aux.derecha.id+"->"+aux.id+";"+"\n";
                         aux=aux.derecha;//seguimos avansando
                    }
                }else{//si no es la primer ni la ultima fila
                    if(i==0){//si es la primer columna de una fila media
                         nodos+= aux.abajo.id+"[label =x"+aux.abajo.x+"y"+aux.abajo.y +"];"+"\n";
                        relaciones+=aux.id+"->"+aux.abajo.id+";"+"\n";
                        relaciones+=aux.abajo.id+"->"+aux.id+";"+"\n";
                        siguienteFila=aux.abajo;//guardamos el inicio de la sigueitne fila
                        relaciones+=aux.id+"->"+aux.derecha.id+";"+"\n";
                        relaciones+=aux.derecha.id+"->"+aux.id+";"+"\n";
                        aux=aux.derecha;//y nos movemos al siguiente nodo
                    }else if(i ==x-1){//si es la ultima columna de una fila media
                         nodos+= aux.abajo.id+"[label=x"+aux.abajo.x+"y"+aux.abajo.y +"];"+"\n";
                        relaciones+=aux.id+"->"+aux.abajo.id+";"+"\n";
                        relaciones+=aux.abajo.id+"->"+aux.id+";"+"\n";
                        aux=siguienteFila;// pasamos al inicio de la siguiente fila
                    }else{//si es un nodo intermedio de una fila intemedia
                        nodos+= aux.abajo.id+"[label=x"+aux.abajo.x+"y"+aux.abajo.y +"];"+"\n";
                        relaciones+=aux.id+"->"+aux.abajo.id+";"+"\n";
                        relaciones+=aux.abajo.id+"->"+aux.id+";"+"\n";
                        relaciones+=aux.id+"->"+aux.derecha.id+";"+"\n";
                        relaciones+=aux.derecha.id+"->"+aux.id+";"+"\n";
                        aux=aux.derecha;
                    }
                }
        }
    }
        
     System.out.println(nodos);
     System.out.println(relaciones);   
     
     // une las dos partes del archivo en una sola cadena y le agrega el encabezado
            textoMatriz="digraph G \n {"+nodos+relaciones+"}";
            System.out.println(textoMatriz);
            String pathM = "C:\\Users\\Mynor\\Documents\\NetBeansProjects\\Scrabble\\src\\PMatriz\\GraficaMatriz.dot";
            //el siguiente bloque de codigo genera el archivo .txt que será compilado en graphviz
            //creamos el archivo
            File archivo = new File(pathM);
             //creamos el buffer
            BufferedWriter bw;
            //usamos try-catch para evitar que la aplicación muera si hay un error
            try{
                //si el arhivo no existe lo creamos
        if(archivo.exists()) {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(textoMatriz);
        } else {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(textoMatriz);
        }
        bw.close();
            }catch (IOException ex) {
                    Logger.getLogger(Matriz.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        scrabble.GeneradorJPG.generarGrafo( pathM,"C:\\Users\\Mynor\\Documents\\NetBeansProjects\\Scrabble\\src\\PMatriz\\imagenMatriz.jpg");
     
     
    }
    
}
