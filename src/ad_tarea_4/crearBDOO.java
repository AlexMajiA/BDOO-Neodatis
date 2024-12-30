/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ad_tarea_4;

import java.io.File;
import org.neodatis.odb.ODB;
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
      
        //Creo la ruta en la carpeta del proyecto.
        String rutaDesktop = System.getProperty("user.dir");
        
        //Abro conexión con la BDOO
        ODB odb = ODBFactory.open(rutaDesktop + File.separator + "gestionLaboral");
        
        System.out.println("Conexión a la base de datos creada en: " + rutaDesktop + File.separator + "gestionLaboral.neodatis");
            
        
        Empleados emp1 = new Empleados(1, "Alejandro", "Martinez", "Desarrollador", 1750);
        Empleados emp2 = new Empleados(2, "Manuel", "Jimenez", "Contable", 1200);
        Empleados emp3 = new Empleados(3, "Silvia", "Marzo", "Desarrollador", 1600);
        Empleados emp4 = new Empleados(4, "Migue", "Cerezo", "Analista", 1500);
        Empleados emp5 = new Empleados(5, "Sara", "Toro", "Gerente", 1800);
        
        //Almaceno los objetos.
        odb.store(emp1);
        odb.store(emp2);
        odb.store(emp3);
        odb.store(emp4);
        odb.store(emp5);
        
        //Cierro la conexión.
        odb.close();
        
        
    }
    
}
