package eps.fv.Medico;

import eps.fv.Validaciones;

import javax.swing.*;

public class PilasM {
    private Medico UltimoRegistroIngresado;
    static int tamano = 0;
    String Lista = "";
    Validaciones.Archivo objArchivo = new Validaciones.Archivo();

    public PilasM() {
        UltimoRegistroIngresado = null;
        tamano = 0;
    }

    public boolean PilaVacia() {
        return UltimoRegistroIngresado == null;
    }

    public void InsertarNodo(String id) {
        if (!buscar(id)) {
            Medico objMed = new Medico();
            objMed = objMed.lecturaDatos(id);
            if (PilaVacia()) {
                UltimoRegistroIngresado = objMed;
            } else {
                objMed.setSiguiente(UltimoRegistroIngresado);
                UltimoRegistroIngresado = objMed;
            }
        } else {
            System.out.println("El médico ya existe.");
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
        Medico Recorrido = UltimoRegistroIngresado;

        while (Recorrido != null) {

            Lista += "{" + Recorrido.toString() + "}\n";
            Recorrido = Recorrido.getSiguiente();
        }
        System.out.println((String) Lista);
        //JOptionPane.showMessageDialog(null,(String)Lista);
        // Grabar(Lista);
        Lista = "";
        return Lista;
    }

    public String ConvertirPilaArchivo() {
        Medico Recorrido = UltimoRegistroIngresado;

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

        objArchivo.abrirModoEscritura("Medicos.txt");
        //  Lista = objM.EstructuraReg();//con este metodo se da la estructura al registro
        objArchivo.escribir(Lista); //se graba o escribe o imprime el registro fisicamente en el archivo
        objArchivo.cerrarModoEscritura();
    }//fin  GrabarHospital


    public void buscarPorNombre(String nombre) {
        Medico aux = UltimoRegistroIngresado;
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
        Medico aux = UltimoRegistroIngresado;
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
        Medico aux = UltimoRegistroIngresado;
        int op = 0;
        String Ide, Nom, Apellido;
        int Edad;
        double SalBase, Incentivo;
        while (aux != null) {
            if (aux.getId().equals(id)) {
                System.out.println("Se actualizará el registro del médico cuyo id es: " + id);
                do {
                    op = Validaciones.leerEntero("""
                             1. Nombre
                             2. Apellido
                             3. Edad
                             4. Salario base
                             5. Incentivo
                             6. Terminar
                            """);
                    switch (op) {
                        case 1 -> {
                            Nom = Validaciones.leerString("Ingrese el nuevo nombre del médico: ");
                            aux.setNombre(Nom);
                        }
                        case 2 -> {
                            Apellido = Validaciones.leerString("Ingrese el nuevo apellido del médico: ");
                            aux.setApellido(Apellido);
                        }
                        case 3 -> {
                            Edad = Validaciones.leerEntero("Ingrese la nueva edad del médico: ");
                            aux.setEdad(Edad);
                        }
                        case 4 -> {
                            SalBase = Validaciones.leerReal("Ingrese el nuevo salario del médico: ");
                            aux.setSalBase(SalBase);
                        }
                        case 5 -> {
                            Incentivo = Validaciones.leerReal("Ingrese el nuevo incentivo del médico: ");
                            aux.setIncentivo(Incentivo);
                        }
                        default -> System.out.println("Opción incorrecta.");
                    }
                } while (op != 6);
            }

            aux = aux.getSiguiente();
        }
    }


}



