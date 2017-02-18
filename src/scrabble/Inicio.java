/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scrabble;

import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Mynor
 */
public class Inicio extends javax.swing.JFrame {

    public static PLSimple.ListaSimple lsPalabras;
    public static PLCircular.ListaCircular lcJugadores;
    public static PCola.Cola colaFichas;
    public static PMatriz.Matriz tableroLogico;
    /**
     * Creates new form Inicio
     */
    public Inicio() {
        initComponents();
        System.out.println("el numero aleatorio generado es es : "+(int) (Math.random()*100));
        //System.out.println("el timpo del sistema en milisegundos es : "+((System.currentTimeMillis()%100))/4);
        
        lsPalabras =new PLSimple.ListaSimple();
        lcJugadores= new PLCircular.ListaCircular();
        colaFichas = new PCola.Cola();
        //implementacion de prueba del tablero logico
        tableroLogico=new PMatriz.Matriz();
        //tableroLogico.crearMatriz(6, 6);
        //tableroLogico.graficarMatriz();
        /*lsPalabras.LSIncertFinal("Cero");
        lsPalabras.LSIncertFinal("Uno");
        lsPalabras.LSIncertFinal("Dos");
        lsPalabras.LSIncertFinal("Tres");
        lsPalabras.LSIncertFinal("Cuatro");
        lsPalabras.LSIncertFinal("Cinco");
        lsPalabras.graficar();*/
        /*
        lcJugadores.LCIncertFinal("Mynor");
        lcJugadores.LCIncertFinal("Anita");
        lcJugadores.LCIncertFinal("Toño");
        lcJugadores.LCIncertFinal("Josuesín");
        lcJugadores.LCIncertFinal("Tobiberto");
        lcJugadores.graficarCirculo();*/
    }
    
    
    //metodo que llena la cola de fichas para iniciar el juego.
    public void llenadoColaInicial(){
        int random = 0;
        //int a,b,c,d,e,f,g,h,i,j,m,n,ñ,o,p,q,r,s,t,u,v,x,y,z;
        int na,nb,nc,nd,ne,nf,ng,nh,ni,nj,nl,nn,nm,nñ,no,np,nq,nr,ns,nt,nu,nv,nx,ny,nz;
        na=nb=nc=nd=ne=nf=ng=nh=ni=nj=nl=nn=nm=nñ=no=np=nq=nr=ns=nt=nu=nv=nx=ny=nz=0;
        
        for(int k=1; k<90;){
            //random = (int) (System.currentTimeMillis()%100)/4;
            random = (int) (Math.random()*100)/2;
            System.out.println(k+") provando valor "+ random + " para la cola");
            
                switch(random){
                    
                    case 1:{
                        if(nz<1){colaFichas.IncertarFicha('z',10);
                        k++;
                        nz++;}
                        break;
                    }
                    case 2:{
                        if(nx<1){colaFichas.IncertarFicha('x',8);
                        k++;
                        nx++;}
                        break;
                    }
                    case 3:{
                        if(nñ<1){colaFichas.IncertarFicha('ñ',8);
                        k++;
                        nñ++;}
                    }
                    case 4:{
                        if(nj<1){colaFichas.IncertarFicha('j',8);
                        k++;
                        nj++;}
                        break;
                    }
                     case 5:{
                        if(nq<1){colaFichas.IncertarFicha('q',5);
                        k++;
                        nq++;}
                        break;
                    }
                    case 6:{
                        if(ny<1){colaFichas.IncertarFicha('y',4);
                        k++;
                        ny++;}
                        break;
                    }
                    case 7:{
                        if(nv<1){colaFichas.IncertarFicha('v',4);
                        k++;
                        nv++;}
                        break;
                    }
                    case 8:{
                        if(nf<1){colaFichas.IncertarFicha('f',4);
                        k++;
                        nf++;}
                        break;
                    }
                    case 9:{
                        if(nh<2){colaFichas.IncertarFicha('h',5);
                        nh++;}
                        break;
                    }
                    case 10:{
                        if(np<2){colaFichas.IncertarFicha('p',3);
                        k++;
                        np++;}
                        break;
                    }    
                    case 11:{
                        if(nm<2){colaFichas.IncertarFicha('m',3);
                        k++;
                        nm++;}
                        break;
                    }    
                    case 12:{
                        if(nb<2){colaFichas.IncertarFicha('b',3);
                        k++;
                        nb++;}
                        break;
                    }    
                    case 13:{
                        if(nc<4){colaFichas.IncertarFicha('c',3);
                        k++;
                        nc++;}
                        break;
                    }    
                    case 14:{
                        if(ng<2){colaFichas.IncertarFicha('g',2);
                        k++;
                        ng++;}
                        break;
                    }    
                    case 15:{
                        if(nd<5){colaFichas.IncertarFicha('d',2);
                        k++;
                        nd++;}
                        break;
                    }
                    case 16:{
                        if(nt<4){colaFichas.IncertarFicha('t',1);
                        k++;
                        nt++;}
                        break;
                    }
                        case 17:{
                        if(nu<5){colaFichas.IncertarFicha('u',1);
                        k++;
                        nu++;}
                        break;
                    }
                        case 18:{
                        if(nr<5){colaFichas.IncertarFicha('r',1);
                        k++;
                        nr++;}
                        break;
                    }
                        case 19:{
                        if(nl<4){colaFichas.IncertarFicha('l',1);
                        nl++;}
                        break;
                    }
                     case 20:{
                        if(nn<5){colaFichas.IncertarFicha('n',1);
                        k++;
                        nn++;}
                        break;
                    }
                        case 21:{
                        if(ns<6){colaFichas.IncertarFicha('s',1);
                        k++;
                        ns++;}
                        break;
                    }
                        case 22:{
                        if(ni<6){colaFichas.IncertarFicha('i',1);
                        k++;
                        ni++;}
                        break;
                    }
                        case 23:{
                        if(no<9){colaFichas.IncertarFicha('o',1);
                        k++;
                        no++;}
                        break;
                    }
                        case 24:{
                        if(ne<12){colaFichas.IncertarFicha('e',1);
                        k++;
                        ne++;}
                        break;
                    }
                        case 25:{
                        if(na<12){colaFichas.IncertarFicha('a',1);
                        k++;
                        na++;}
                        break;
                    }
                        
                }
        }
        
       colaFichas.graficar();
       System.out.println("la cola fue llenada y graficada exitosamente");
    }
    //fin metodo llenarndo cola inicial

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonJugar = new javax.swing.JButton();
        ButtonCargar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        ButtonJugar.setText("Jugar");
        ButtonJugar.setEnabled(false);
        ButtonJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonJugarActionPerformed(evt);
            }
        });

        ButtonCargar.setText("Cargar Archivo");
        ButtonCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCargarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Yu Gothic Light", 1, 24)); // NOI18N
        jLabel1.setText("Scrabble");

        jButton1.setText("Probar cola");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ButtonCargar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ButtonJugar)
                        .addGap(0, 321, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton1))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ButtonJugar)
                .addGap(85, 85, 85)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(ButtonCargar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCargarActionPerformed
       
        
        //codigo que abre el filechooser para obtener el url del archivo xml a abrir
         String path="";
            JFileChooser abrirArchivo = new JFileChooser("C:/Users/Mynor/Documents/NetBeansProjects/Scrabble/src/ArchivosXML");
            //Con esto solamente podamos abrir archivos
            abrirArchivo.setFileSelectionMode( JFileChooser.FILES_ONLY );
             FileNameExtensionFilter filtroxml=new FileNameExtensionFilter("XML,xml","xml","XML");
 
            int seleccion = abrirArchivo.showOpenDialog( this );
 
            if( seleccion == JFileChooser.APPROVE_OPTION )
            {
                File f = abrirArchivo.getSelectedFile();
                try
                {
                    
                    path = f.getAbsolutePath();
 
                }catch( Exception exp){
                System.out.println("error al cargar el archivo: "+ exp);
                }
            }
        
        
        //fon jfilechooser
        //invocación a analizador.
        Lectorxml lector = new Lectorxml(path);
         lsPalabras.graficar();
         if(!lsPalabras.LSvacia()){
             ButtonJugar.setEnabled(true);
             
         }
        
    }//GEN-LAST:event_ButtonCargarActionPerformed

    private void ButtonJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonJugarActionPerformed
        // TODO add your handling code here:
        
        System.out.println("el timpo del sistema en milisegundos es : "+((System.currentTimeMillis()%0.001)));
        this.llenadoColaInicial();
        FormularioJugadores Jugadores = new FormularioJugadores();
        Jugadores.setVisible(true);
        
    }//GEN-LAST:event_ButtonJugarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        char letra = colaFichas.inicio.letra;
        int valor = colaFichas.inicio.valor; 
        colaFichas.IncertarFicha(letra, valor);
        colaFichas.sacarFicha();
        letra = colaFichas.inicio.letra;
        valor = colaFichas.inicio.valor; 
        colaFichas.IncertarFicha(letra, valor);
        colaFichas.sacarFicha();
        colaFichas.graficar();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonCargar;
    private javax.swing.JButton ButtonJugar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
