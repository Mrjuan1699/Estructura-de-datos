
package eps.fv.Paciente;

import eps.fv.Persona;

import javax.swing.JOptionPane;

import static eps.fv.Validaciones.*;

public class Paciente extends Persona {
    private double copago;
    private String idMedico;
    private int estSocial;
    Paciente siguiente;

    public Paciente() {
        siguiente = null;
    }

    public Paciente(String id, String nombre, String apellido, int edad, int estSocial, String idMedico, double copago) {
        super(id, nombre, apellido, edad);
        this.copago = copago;
        this.idMedico = idMedico;
        this.estSocial = estSocial;
    }


    public double getCopago() {
        return copago;
    }

    public void setCopago(double copago) {
        this.copago = copago;
    }

    public String getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(String idMedico) {
        this.idMedico = idMedico;
    }

    public int getEstSocial() {
        return estSocial;
    }

    public void setEstSocial(int estSocial) {
        this.estSocial = estSocial;
    }

    public Paciente getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Paciente siguiente) {
        this.siguiente = siguiente;
    }

    public Paciente lecturaDatos(String ide) {

        //variables locales y auxiliares para poder crear el objeto y llevar los datos a quien los necesite
        String nom, ape, idMed;
        int e, estSoc;
        double cop;
        nom = leerString("Digite el nombre del paciente: ");
        ape = leerString("Digite el apellido del paciente: ");
        idMed = leerString("Digite el id del médico: ");
        e = leerEntero("Ingrese la edad del paciente: ");
        estSoc = leerEstrato("Ingrese el estrato del paciente: ");
        cop = leerReal("Ingrese el copago del paciente: ");

        //invocamos al método que nos calcula el presupuesto extra y le mandamos el estrato social y el # de médicos

        //con las auxiliares creamos el objeto y lo retornamos
        Paciente objP = new Paciente(ide, nom, ape, e, estSoc, idMed, cop);
        return objP;
    }//fin de lectura de datos

    @Override
    public String toString() {
        return "Paciente{" + "Id=" + getId() + ", Nombre=" + getNombre() + ", Apellido=" + getApellido() + ", Id Médico=" + idMedico + ", edad=" + getEdad() + ", Estrato=" + estSocial + ", Copago=" + copago + '}';
    }

    public String EstructuraReg() {
        //System.out.println(getNit()+"-"+getNombre()+"-"+getEstratoSoc()+"-"+getPresupuesto()+"-"+getDireccion()+"-"+getNumMed());
        return (getId() + "|" + getNombre() + "|" + getApellido() + "|" + getEdad() + "|" + getIdMedico() + "|" + getEstSocial() + "|" + getCopago());
    }


}
