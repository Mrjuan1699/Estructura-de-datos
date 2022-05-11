package eps.fv.Hospital;

import eps.fv.Medico.Medico;
import eps.fv.Validaciones;

import javax.swing.*;

public class PilasH {
    Validaciones.Archivo objArchivo = new Validaciones.Archivo();

    private Hospital UltimoRegistroIngresado;
    static int tamano = 0;
    String Lista = "";

    public PilasH() {
        UltimoRegistroIngresado = null;
        tamano = 0;
    }

    public boolean PilaVacia() {
        return UltimoRegistroIngresado == null;
    }

    public void InsertarNodo(String nit) {
        if (!buscar(nit)) {
            Hospital objHos = new Hospital();
            objHos = objHos.lecturaDatos(nit);
            if (PilaVacia()) {
                UltimoRegistroIngresado = objHos;
            } else {
                objHos.setSiguiente(UltimoRegistroIngresado);
                UltimoRegistroIngresado = objHos;
            }
        } else {
            System.out.println("El hospital ya existe.");
        }
        tamano++;
    }

    public void InsertarArchivoNodo(String nit) {
        if (!buscar(nit)) {
            Hospital objHos = new Hospital();
            objHos = objHos.lecturaDatos(nit);
            if (PilaVacia()) {
                UltimoRegistroIngresado = objHos;
            } else {
                objHos.setSiguiente(UltimoRegistroIngresado);
                UltimoRegistroIngresado = objHos;
            }
        } else {
            System.out.println("El hospital ya existe.");
        }
        tamano++;
    }

    public void EliminarNodo() {
        if (!PilaVacia()) {
            System.out.println(MostrarUltimoDatoIngresado());
            UltimoRegistroIngresado = UltimoRegistroIngresado.getSiguiente();
            tamano--;
        } else {
            System.out.println("La pila está vacía.");
        }
    }

    public String MostrarUltimoDatoIngresado() {
        String info = UltimoRegistroIngresado.toString();
        return info;
    }

    public Object TamanoPila() {
        return tamano;
    }

    public void EliminarNodoVaciarPila() {
        if (!PilaVacia()) {
            System.out.println("Se ha desapilado la pila: ");
            System.out.println(MostrarUltimoDatoIngresado() + "\n");
            UltimoRegistroIngresado = UltimoRegistroIngresado.getSiguiente();
            tamano--;
        }
    }

    public void VaciarPila() {
        System.out.println("Se ha vaciado la pila con los valores:");
        while (!PilaVacia()) {
            EliminarNodo();
        }
        System.out.println("\n");
    }

    public String MostrarValores() {
        Hospital Recorrido = UltimoRegistroIngresado;

        while (Recorrido != null) {

            Lista += "{" + Recorrido.toString() + "}\n";
            Recorrido = Recorrido.getSiguiente();
        }
        System.out.println((String) Lista);
        //JOptionPane.showMessageDialog(null,(String)Lista);
        Lista = "";
        return Lista;
    }


    public void buscarPorNombre(String nombre) {
        Hospital aux = UltimoRegistroIngresado;
        String cadena = "pila\n";

        while (aux != null) {
            if (aux.getNombre().equals(nombre)) {
                cadena += "{" + aux.toString() + "}\n";
            }

            aux = aux.getSiguiente();
        }
        System.out.println(cadena);

    }

    public boolean buscar(String nit) {
        Hospital aux = UltimoRegistroIngresado;
        boolean se = false;
        while (aux != null) {
            if (aux.getNit().equals(nit)) {
                se = true;
            }

            aux = aux.getSiguiente();
        }
        return se;
    }

    public void Actualizar(String nt) {
        Hospital aux = UltimoRegistroIngresado;
        int op = 0;
        String nit, dire, nom;
        int estSoc, nm;
        double ppto;
        while (aux != null) {
            if (aux.getNit().equals(nt)) {
                System.out.println("Se actualizará el registro cuyo valor de NIT es: " + nt);
                do {
                    op = Validaciones.leerEntero("""
                             1. Nombre
                             2. Estrato social legal de 1 a 6
                             3. Presupuesto
                             4. Dirección
                             5. Número de   médicos de este hospital
                             6. Terminar
                            """);
                    switch (op) {
                        case 1 -> {
                            nom = Validaciones.leerString("Ingrese el nuevo nombre del hospital: ");
                            aux.setNombre(nom);
                        }
                        case 2 -> {
                            estSoc = Validaciones.leerEstrato("Ingrese el nuevo Estrato Social del hospital: ");
                            aux.setEstSocial(estSoc);
                        }
                        case 3 -> {
                            ppto = Validaciones.leerReal("Ingrese el nuevo presupuesto del hospital: ");
                            aux.setPresupuesto(ppto);
                        }
                        case 4 -> {
                            dire = Validaciones.leerString("Ingrese la nueva dirección del hospital: ");
                            aux.setDireccion(dire);
                        }
                        case 5 -> {
                            nm = Validaciones.leerEstrato("Ingrese la nueva cantidad de médicos: ");
                            aux.setNumMed(nm);
                        }
                    }
                } while (op < 6);
            }

            aux = aux.getSiguiente();
        }
    }

    public String ConvertirPilaArchivo() {
        Hospital Recorrido = UltimoRegistroIngresado;

        while (Recorrido != null) {

            Lista += Recorrido.EstructuraReg() + "\n";
            Recorrido = Recorrido.getSiguiente();
        }
        System.out.println((String) Lista);
        //JOptionPane.showMessageDialog(null,(String)Lista);
        Grabar(Lista.trim());
        Lista = "";
        return Lista;
    }


    public void Grabar(String Lista) {

        objArchivo.abrirModoEscritura("Hospitales.txt");
        //  Lista = objM.EstructuraReg();//con este metodo se da la estructura al registro
        objArchivo.escribir(Lista); //se graba o escribe o imprime el registro fisicamente en el archivo
        objArchivo.cerrarModoEscritura();
    }//fin  GrabarHospital


}



