/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ad_tarea_4;

import java.io.File;
import org.neodatis.odb.ODBFactory;

/**
 *
 * @author amjpa
 */
public class crearBDOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        String rutaDesktop = System.getProperty("user.home") + File.separator + "Desktop";
        ODBFactory.open(rutaDesktop + File.separator + "gestionLaboral");
  
        
        
    }
    
}
