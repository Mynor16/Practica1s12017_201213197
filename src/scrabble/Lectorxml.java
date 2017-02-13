/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scrabble;

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
    
    public static void main(String[] args) {
        
        

   }

    Lectorxml(String path) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         try {

	SAXParserFactory factory = SAXParserFactory.newInstance();
	SAXParser saxParser = factory.newSAXParser();

	DefaultHandler handler = new DefaultHandler() {

	boolean bpalabra = false;
        boolean bcasilla = false;

	public void startElement(String uri, String localName,String qName,
                Attributes attributes) throws SAXException {

		System.out.println("Start Element :" + qName);

		if (qName.equalsIgnoreCase("palabra")) {
			bpalabra = true;
		}

		if (qName.equalsIgnoreCase("casilla")) {
			bcasilla = true;
		}


	}

	public void endElement(String uri, String localName,
		String qName) throws SAXException {

		System.out.println("End Element :" + qName);

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

	}

     };

       saxParser.parse(path, handler);

     } catch (Exception e) {
       e.printStackTrace();
     }
    
    } 
    
    
}
