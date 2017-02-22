/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scrabble;

import javax.swing.JOptionPane;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Mynor
 */
public class Lectorxml {
    
    static int dimension;
    static String cadenaDim;
    static int x,y;
    
    public static void main(String[] args) {
        dimension=0;
        cadenaDim="";
        x=0;
        y=0;
        
        

   }

    Lectorxml(String path) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         try {

	SAXParserFactory factory = SAXParserFactory.newInstance();
	SAXParser saxParser = factory.newSAXParser();

	DefaultHandler handler = new DefaultHandler() {

	boolean bpalabra = false;
        boolean bcasilla = false;
        boolean bdimension = false;
        boolean bdobles = false;
        boolean btriples = false;
        boolean bx = false;
        boolean by = false;

	public void startElement(String uri, String localName,String qName,
                Attributes attributes) throws SAXException {

		System.out.println("Start Element :" + qName);

		if (qName.equalsIgnoreCase("palabra")) {
			bpalabra = true;
		}

		if (qName.equalsIgnoreCase("casilla")) {
			bcasilla = true;
		}
                if (qName.equalsIgnoreCase("dimension")) {
			bdimension = true;
		}
                if (qName.equalsIgnoreCase("x")) {
                    bx=true;
                }
                if(qName.equalsIgnoreCase("y")) {
                    by=true;
                }
                if(qName.equalsIgnoreCase("dobles")){
                    bdobles=true;
                }
                if(qName.equalsIgnoreCase("triples")){
                    btriples=true;
                }


	}

	public void endElement(String uri, String localName,
		String qName) throws SAXException {

		System.out.println("End Element :" + qName);
                if ("dobles".equals(qName)){
                    //JOptionPane.showMessageDialog( null,"se encontro el elemento de cierre de: "+qName);
                    bdobles=false;
                }else
                if ( "triples".equals(qName)){
                    //JOptionPane.showMessageDialog( null,"se encontro el elemento de cierre de: "+qName);
                    btriples=false;
                }

	}

	public void characters(char ch[], int start, int length) throws SAXException {

		if (bpalabra) {
			System.out.println("palabra : " + new String(ch, start, length));
                        
                         Inicio.lsPalabras.LSIncertFinal( new String(ch, start, length));
                         
			bpalabra = false;
		}

		if (bcasilla) {
			System.out.println("casilla : " + new String(ch, start, length));
			bcasilla = false;
		}
                if (bdimension) {
			System.out.println("dimensión : " + new String(ch, start, length));
                         cadenaDim= new String(ch, start, length);
                        dimension = Integer.parseInt(cadenaDim);
                        System.out.println("se creará la lista de tamaño:"+dimension);
                        Inicio.tableroLogico.crearMatriz(dimension, dimension);
                        Inicio.tableroLogico.graficarMatriz();
			bdimension = false;
		}
                if (bx) {
                    System.out.println("coordenada x : " + new String(ch, start, length));
                    x=Integer.parseInt(new String(ch, start, length));
                    bx=false;
                }
                if (by) {
                    System.out.println("coordenada y : " + new String(ch, start, length));
                    y=Integer.parseInt(new String(ch, start, length));
                    if (bdobles) {
                        Inicio.tableroLogico.establecerMult(x, y, 2);
                        //Inicio.tableroLogico.buscarCasilla(x-1, y-1);
                    }
                    if(btriples){
                        Inicio.tableroLogico.establecerMult(x, y, 3);
                        //Inicio.tableroLogico.buscarCasilla(x-1, y-1);
                    }
                    by=false;
                }

	}

     };

       saxParser.parse(path, handler);

     } catch (Exception e) {
       e.printStackTrace();
     }
    
    } 
    
    
}
