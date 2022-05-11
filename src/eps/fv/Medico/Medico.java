
package eps.fv.Medico;

import eps.fv.Hospital.Hospital;
import eps.fv.Persona;

import javax.swing.JOptionPane;

import static eps.fv.Validaciones.*;
import static eps.fv.Validaciones.leerReal;

public class Medico extends Persona {
    private double salBase, incentivo;
    Medico siguiente;

    public Medico() {
        siguiente = null;
    }

    public Medico(String id, String nombre, String apellido, int edad, double salBase, double incentivo) {
        super(id, nombre, apellido, edad);
        this.salBase = salBase;
        this.incentivo = incentivo;
    }

    public double getSalBase() {
        return salBase;
    }

    public void setSalBase(double salBase) {
        this.salBase = salBase;
    }

    public double getIncentivo() {
        return incentivo;
    }

    public void setIncentivo(double incentivo) {
        this.incentivo = incentivo;
    }

    public Medico getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Medico siguiente) {
        this.siguiente = siguiente;
    }

    public Medico lecturaDatos(String id) {

        //variables locales y auxiliares para poder crear el objeto y llevar los datos a quien los necesite
        String nombre, ape;
        int e;
        double sBase, inc;
        nombre = leerString("Digite el nombre: ");
        ape = leerString("Digite el apellido: ");
        e = leerEntero("Digite la edad: ");
        sBase = leerReal("Ingrese el salario del médico: ");

        inc = 0; // ojo crear método incentivo
        //invocamos al método que nos calcula el presupuesto extra y le mandamos el estrato social y el # de médicos

        //con las auxiliares creamos el objeto y lo retornamos
        Medico objM = new Medico(id, nombre, ape, e, sBase, inc);
        return objM;
    }//fin de lectura de datos

    @Override
    public String toString() {
        return "Medico{" + "Id=" + getId() + ", Nombre=" + getNombre() + ", Apellido=" + getApellido() + ", Edad=" + getEdad() + ", salBase=" + salBase + ", incentivo=" + incentivo + '}';
    }

    public String EstructuraReg() {
        //System.out.println(getNit()+"-"+getNombre()+"-"+getEstratoSoc()+"-"+getPresupuesto()+"-"+getDireccion()+"-"+getNumMed());
        return (getId() + "|" + getNombre() + "|" + getApellido() + "|" + getEdad() + "|" + getSalBase() + "|" + getIncentivo());
    }


}
