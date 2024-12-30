/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ad_tarea_4;

import java.io.File;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/**
 *
 * @author amjpa
 */
public class consultarBDOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
          //Creo la ruta en la carpeta del proyecto.
        String rutaDb = System.getProperty("user.dir");

        //Abro conexión con la BDOO
        ODB odb = ODBFactory.open(rutaDb + File.separator + "gestionLaboral");

        System.out.println("Conexion a la base de datos creada en: " + rutaDb + File.separator + "gestionLaboral.neodatis");

        //Consulto todos los empleados de ba BDOO.
        IQuery query = new CriteriaQuery(Empleados.class);
        
        //Hago la consulta.
        Objects <Empleados> lista =odb.getObjects(query);
        
        while (lista.hasNext()) {            
            Empleados empleado = lista.next();
            System.out.println(""
                    + "Codigo Empleado: " + empleado.getCodEmpleado()
                    + "\tNombre: " + empleado.getCodEmpleado()
                    + "\tApellidos: " + empleado.getApellidos()
                    + "\tPuesto: " + empleado.getDepartamento()
                    + "\tSalario: " + empleado.getSalario()
            );
            
        }
        
        //Cierro la conexión.
        odb.close();

 
    }
}
