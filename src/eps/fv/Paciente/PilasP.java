package eps.fv.Paciente;

import eps.fv.Medico.Medico;
import eps.fv.Validaciones;

import javax.swing.*;

public class PilasP {
    private Paciente UltimoRegistroIngresado;
    static int tamano = 0;
    String Lista = "";
    Validaciones.Archivo objArchivo = new Validaciones.Archivo();

    public PilasP() {
        UltimoRegistroIngresado = null;
        tamano = 0;
    }

    public boolean PilaVacia() {
        return UltimoRegistroIngresado == null;
    }

    public void InsertarNodo(String id) {
        if (!buscar(id)) {
            Paciente objPac = new Paciente();
            objPac = objPac.lecturaDatos(id);
            if (PilaVacia()) {
                UltimoRegistroIngresado = objPac;
            } else {
                objPac.setSiguiente(UltimoRegistroIngresado);
                UltimoRegistroIngresado = objPac;
            }
        } else {
            System.out.println("El paciente ya existe.");
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
        Paciente Recorrido = UltimoRegistroIngresado;

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
        Paciente aux = UltimoRegistroIngresado;
        String cadena = "pila\n";

        while (aux != null) {
            if (aux.getNombre().equals(nombre)) {
                cadena += "{" + aux.toString() + "}\n";
            }

            aux = aux.getSiguiente();
        }
        System.out.println(cadena);

    }

    public boolean buscar(String id) {
        Paciente aux = UltimoRegistroIngresado;
        boolean se = false;
        while (aux != null) {
            if (aux.getId().equals(id)) {
                se = true;
            }

            aux = aux.getSiguiente();
        }
        return se;
    }

    public void Actualizar(String id) {
        Paciente aux = UltimoRegistroIngresado;
        int op = 0;
        String Ide, Nom, Apellido, IdMedico;
        int Edad, EstSocial;
        double CoPago;
        while (aux != null) {
            if (aux.getId().equals(id)) {
                System.out.println("Se actualizará el registro del médico cuyo id es: " + id);
                do {
                    op = Validaciones.leerEntero("""
                             1. Nombre
                             2. Apellido
                             3. Edad
                             4. Estrato social
                             5. IdMedico
                             6. Copago
                            """);
                    switch (op) {
                        case 1 -> {
                            Nom = Validaciones.leerString("Ingrese el nuevo nombre del paciente: ");
                            aux.setNombre(Nom);
                        }
                        case 2 -> {
                            Apellido = Validaciones.leerString("Ingrese el nuevo apellido del paciente: ");
                            aux.setApellido(Apellido);
                        }
                        case 3 -> {
                            Edad = Validaciones.leerEntero("Ingrese la nueva edad del médico: ");
                            aux.setEdad(Edad);
                        }
                        case 4 -> {
                            EstSocial = Validaciones.leerEstrato("Ingrese el nuevo estrato social del paciente: ");
                            aux.setEstSocial(EstSocial);
                        }
                        case 5 -> {
                            IdMedico = Validaciones.leerString("Ingrese el nuevo IdMedico del paciente: ");
                            aux.setIdMedico(IdMedico);
                        }
                        case 6 -> {
                            CoPago = Validaciones.leerReal("Ingrese el nuevo copago del paciente: ");
                            aux.setCopago(CoPago);
                        }
                        default -> System.out.println("Opción incorrecta.");
                    }
                } while (op != 7);
            }

            aux = aux.getSiguiente();
        }
    }

    public String ConvertirPilaArchivo() {
        Paciente Recorrido = UltimoRegistroIngresado;

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

        objArchivo.abrirModoEscritura("Pacientes.txt");
        //  Lista = objM.EstructuraReg();//con este metodo se da la estructura al registro
        objArchivo.escribir(Lista); //se graba o escribe o imprime el registro fisicamente en el archivo
        objArchivo.cerrarModoEscritura();
    }//fin  GrabarHospital


}



