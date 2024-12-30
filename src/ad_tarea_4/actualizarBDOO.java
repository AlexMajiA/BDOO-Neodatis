package ad_tarea_4;

import java.io.File;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/**
 *
 * @author amjpa
 */
public class actualizarBDOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Creo la ruta en la carpeta del proyecto.
        String rutaDb = System.getProperty("user.dir");
        //Abro conexión con la BDOO
        ODB odb = ODBFactory.open(rutaDb + File.separator + "gestionLaboral");
        System.out.println("Conexion a la base de datos creada en: " + rutaDb + File.separator + "gestionLaboral.neodatis");

        
        //Consulto todos los empleados de ba BDOO.
        ICriterion condicion = Where.lt("salario", 1600);
        IQuery query = new CriteriaQuery(Empleados.class, condicion);

        //Hago la consulta.
        Objects<Empleados> empleados = odb.getObjects(query);

        while (empleados.hasNext()) {            
            Empleados empleado = empleados.next();
            //Añado 200€ al salario
            empleado.setSalario(empleado.getSalario()+200);
            //Almaceno el objeto.
            odb.store(empleado);
        }

        //Cierro la conexión.
        odb.close();

    }
    
}
