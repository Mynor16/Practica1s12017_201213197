/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scrabble;

/**
 *
 * @author Mynor
 */
public class GeneradorJPG {
    GeneradorJPG(){
        
    }
    public static void generarGrafo(String pathTXT,String pathJPG){
         try {
              
      String dotPath = "C:\\sers\\Mynor\\Documents\\software\\graphviz\\bin\\dot.exe";
      
      String fileInputPath = pathTXT;
      String fileOutputPath = pathJPG;
      
      String tParam = "-Tjpg";
      String tOParam = "-o";
        
      String[] cmd = new String[5];
      cmd[0] = dotPath;
      cmd[1] = tParam;
      cmd[2] = fileInputPath;
      cmd[3] = tOParam;
      cmd[4] = fileOutputPath;
                  
      Runtime rt = Runtime.getRuntime();
      
      rt.exec( cmd );
      
    } catch (Exception ex) {
        System.out.println("Error al compliar con dot :"+ex.toString());
    }   
    
    }
    
}
