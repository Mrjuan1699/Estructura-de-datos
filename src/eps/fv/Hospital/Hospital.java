package eps.fv.Hospital;

import static eps.fv.Validaciones.*;

import javax.swing.JOptionPane;

public class Hospital {
    private double presupuesto, nominaBasTotal;
    private int numMed, estSocial, acumed;
    private String nit, nombre, direccion;
    Hospital siguiente, InicioCola, FinalCola;

    public Hospital(String nit, String nombre, String direccion, int numMed, int estSocial, double presupuesto) {
        this.presupuesto = presupuesto;
        this.numMed = numMed;
        this.estSocial = estSocial;
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Hospital() {
        siguiente = null;
        InicioCola = null;
        FinalCola = null;
    }


    public Hospital getInicioCola() {
        return InicioCola;
    }

    public void setInicioCola(Hospital inicioCola) {
        InicioCola = inicioCola;
    }

    public Hospital getFinalCola() {
        return FinalCola;
    }

    public void setFinalCola(Hospital finalCola) {
        FinalCola = finalCola;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public double getNominaBasTotal() {
        return nominaBasTotal;
    }

    public void setNominaBasTotal(double nominaBasTotal) {
        this.nominaBasTotal = nominaBasTotal;
    }

    public int getNumMed() {
        return numMed;
    }

    public void setNumMed(int numMed) {
        this.numMed = numMed;
    }

    public int getEstSocial() {
        return estSocial;
    }

    public void setEstSocial(int estSocial) {
        this.estSocial = estSocial;
    }

    public int getAcumed() {
        return acumed;
    }

    public void setAcumed(int acumed) {
        this.acumed = acumed;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Hospital getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Hospital siguiente) {
        this.siguiente = siguiente;
    }

    public Hospital lecturaDatos(String nit) {
        //variables locales y auxiliares para poder crear el objeto y llevar los datos a quien los necesite
        String nom, dire;
        int estSoc, nm;
        double ppto;
        nom = leerString("Digite el Nombre: ");
        estSoc = leerEstrato("Digite el Estrato social legal de 1 a 6: ");
        dire = leerString("Digite la dirección: ");
        nm = leerEntero("Digite el número de médicos de este hospital: ");
        ppto = leerReal("Ingrese el presupuesto del hospital");
        //invocamos al método que nos calcula el presupuesto extra y le mandamos el estrato social y el # de médicos
        ppto = aumentarPpto(estSoc, nm) + ppto;
        //con las auxiliares creamos el objeto y lo retornamos
        Hospital objH = new Hospital(nit, nom, dire, nm, estSoc, ppto);
        return objH;
    }//fin de lectura de datos

    @Override
    public String toString() {
        return "Hospital{" + "presupuesto=" + presupuesto + ", nominaBasTotal=" + nominaBasTotal + ", numMed=" + numMed + ", estSocial=" + estSocial + ", acumed=" + acumed + ", nit=" + nit + ", nombre=" + nombre + ", direccion=" + direccion + '}';
    }

    public String EstructuraReg() {
        //System.out.println(getNit()+"-"+getNombre()+"-"+getEstratoSoc()+"-"+getPresupuesto()+"-"+getDireccion()+"-"+getNumMed());
        return (getNit() + "|" + getNombre() + "|" + getEstSocial() + "|" + getPresupuesto() + "|" + getDireccion() + "|" + getNumMed());
    }

    public double aumentarPpto(int e, int nm) {
        double p = 0;//variable para asignar presupuesto y retornar
        if (e == 1 || e == 2) {
            if (nm < 20) {
                p = 300000000;
            } else {
                p = 250000000;
            }
        } else {
            if (e == 3 || e == 4) {
                if (nm < 20) {
                    p = 150000000;
                } else {
                    p = 100000000;
                }
            } else {
                p = 0;
            }

        }
        return p;
    }//fin de aumentar presupuesto


    //Nomina Total de todos los hospitales

    public double NominaTotal(Hospital vHos[]) {
        double cant = 0;
        for (int i = 0; i < vHos.length; i++) {
            cant += vHos[i].getNominaBasTotal();
        }
        return cant;
    }


}
