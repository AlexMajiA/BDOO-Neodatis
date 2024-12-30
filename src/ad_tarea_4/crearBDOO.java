package ad_tarea_4;

import java.io.File;
import java.util.ArrayList;
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

        System.out.println("Conexion a la base de datos creada en: " + rutaDb + File.separator + "gestionLaboral.neodatis");

        //Almaceno los objetos.
        ArrayList<Empleados> lista = new ArrayList<Empleados>();
        lista.add(new Empleados(1, "Alejandro", "Martinez", "Desarrollador", 1750));
        lista.add(new Empleados(2, "Manuel", "Jimenez", "Contable", 1200));
        lista.add(new Empleados(3, "Silvia", "Marzo", "Desarrollador", 1600));
        lista.add(new Empleados(4, "Migue", "Cerezo", "Analista", 1500));
        lista.add(new Empleados(5, "Sara", "Toro", "Gerente", 1800));

        //Inserto asegurando que solo se inserten si son nuevos los datos.
        for (Empleados empleados : lista) {
            Objects<Empleados> empleadosExistentes = odb.getObjects(Empleados.class);
            boolean duplicado = false;
            while (empleadosExistentes.hasNext()) {
                Empleados empExistente = empleadosExistentes.next();
                if (empExistente.getCodEmpleado() == empleados.getCodEmpleado()) {
                    duplicado = true;
                    break;
                }
            }
            if (!duplicado) {
                odb.store(empleados);
            }

        }
        //Cierro la conexión.
        odb.close();

    }
}
