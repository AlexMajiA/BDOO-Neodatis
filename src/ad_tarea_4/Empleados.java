/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad_tarea_4;

import java.util.HashSet;
import java.util.Set;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

/**
 *
 * @author amjpa
 */
public class Empleados {
    
    
    //Atributos de la clase.
    private int codEmpleado;
    private String nombre;
    private String apellidos;
    private String departamento;
    private double salario;
    
    //Constructores.

    public Empleados() {
    }

    public Empleados(int codEmpleado, String nombre, String apellidos, String departamento, double salario) {
        this.codEmpleado = codEmpleado;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.departamento = departamento;
        this.salario = salario;
    }
    
    //Getter y setter.   

    public int getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(int codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    
    public class EliminarDuplicados{
            public static void main(String[] args) {
                
                String rutaBd = System.getProperty("user.dir") + "gestionLaboral";
                
                ODB odb = ODBFactory.open(rutaBd);
                
                //Recupero los objetos de la clase Empleado.
                Objects<Empleados> empleados = odb.getObjects(Empleados.class);
                
                //Uso un set para identificar los duplicados.
                Set<String> identificadorUnico = new HashSet<>();
                int eliminados = 0;
                
                while(empleados.hasNext()){
                    Empleados empleado = empleados.next();
                
                //Uso atributo único como criterio para identificar duplicados.
                    if (!identificadorUnico.add(String.valueOf(empleado.codEmpleado))) {
                        odb.delete(empleado); //Elimino el duplicado.
                        eliminados++;
                    }
                System.out.println("Se han eliminado " + eliminados + " registros duplicados.");
                }
            }
        }
    
}
