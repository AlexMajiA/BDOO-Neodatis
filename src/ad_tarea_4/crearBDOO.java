/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ad_tarea_4;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

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
        String rutaDb = System.getProperty("user.dir");
        
        //Abro conexión con la BDOO
        ODB odb = ODBFactory.open(rutaDb + File.separator + "gestionLaboral");
        
        System.out.println("Conexión a la base de datos creada en: " + rutaDb + File.separator + "gestionLaboral.neodatis");
         
        //Almaceno los objetos.
        ArrayList <Empleados> lista = new ArrayList <Empleados>();
        lista.add(new Empleados(1, "Alejandro", "Martinez", "Desarrollador", 1750));
        lista.add(new Empleados(2, "Manuel", "Jimenez", "Contable", 1200));
        lista.add(new Empleados(3, "Silvia", "Marzo", "Desarrollador", 1600));
        lista.add(new Empleados(4, "Migue", "Cerezo", "Analista", 1500));
        lista.add(new Empleados(5, "Sara", "Toro", "Gerente", 1800));
       
        for (Empleados empleados : lista) {
            Objects<Empleados> empleadosExistentes = odb.getObjects(Empleados.class);
            boolean duplicado = false;
            while (empleadosExistentes.hasNext()) {                
                Empleados empExistente = empleadosExistentes.next();
                if (empExistente.getCodEmpleado() == empleados.getCodEmpleado()) {
                    duplicado = true;
                    break;
                }
            }if (!duplicado) {
                odb.store(empleados);
            }
            
            
        }
          //Cierro la conexión.
            odb.close();
  /*      
        rutaDb = System.getProperty("user.dir") + "gestionLaboral";
                
                //reabro la ruta para verificar los duplicados.
                odb = ODBFactory.open(rutaDb);
                
                //Recupero los objetos de la clase Empleado.
                //Objects<Empleados> empleados = odb.getObjects(Empleados.class);
                
                //Uso un set para identificar los duplicados.
                Set<String> identificadorUnico = new HashSet<>();
                int eliminados = 0;
                
                while(empleados.hasNext()){
                    Empleados empleado = empleados.next();
                
                //Uso atributo único como criterio para identificar duplicados.
                    if (!identificadorUnico.add(String.valueOf(empleado.getCodEmpleado()))) {
                        odb.delete(empleado); //Elimino el duplicado.
                        eliminados++;
                    }
                System.out.println("Se han eliminado " + eliminados + " registros duplicados.");
                odb.close();
                }
                */
            }
}
