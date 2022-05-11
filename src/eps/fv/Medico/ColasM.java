package eps.fv.Medico;

import eps.fv.Validaciones;

import javax.swing.*;

public class ColasM {
    private Medico InicioCola, FinalCola;
    String Cola = "";

    public ColasM() {
        InicioCola = null;
        FinalCola = null;
    }

    public boolean ColaVacia() {
        if (InicioCola == null) {
            return true;
        } else {
            return false;
        }
    }

    public void Insertar(String id) {
        if (!buscar(id)) {
            Medico Nuevo_Nodo = new Medico();
            Nuevo_Nodo = Nuevo_Nodo.lecturaDatos(id);
            Nuevo_Nodo.siguiente = null;

            if (ColaVacia()) {
                InicioCola = Nuevo_Nodo;
                FinalCola = Nuevo_Nodo;
            } else {
                FinalCola.siguiente = Nuevo_Nodo;
                FinalCola = Nuevo_Nodo;
            }
        } else {
            System.out.println("El médico ya existe.");
        }

    }


    public String desencolar() {
        String dato = " ";
        if (InicioCola != null) {
            dato = InicioCola.toString();
            InicioCola = InicioCola.getSiguiente();
        } else System.out.println("La cola está vacía");

        return dato;
    }

    public void desencolarTodo() {
        String dato = " ";
        if (InicioCola != null) {
            dato = InicioCola.toString();
            InicioCola = InicioCola.getSiguiente();
        } else System.out.println("La cola esta vacia");

        System.out.println(dato);

    }


    //Otro método
    /*public Hospital Extraer() {
        if (!ColaVacia()) {
            Hospital Dato = FinalCola;
            if (InicioCola == FinalCola) {
                InicioCola = null;
                FinalCola = null;
            } else {
                InicioCola = InicioCola.siguiente;
            }
            return Dato;
        } else {
            return null;
        }
    }
*/

    public void imprimirCola() {
        Medico aux = InicioCola;
        while (aux != null) {
            System.out.println(aux.toString());
            aux = aux.getSiguiente();
        }
    }

    public void buscarPorId(String id) {
        Medico aux = InicioCola;
        String cadena = "Cola\n";

        while (aux != null) {
            if (aux.getNombre().equals(id)) {
                cadena += "{" + aux.toString() + "}\n";
            }

            aux = aux.getSiguiente();
        }
        System.out.println(cadena);

    }

    public String MostrarUltimoDatoIngresado() {
        String info = FinalCola.toString();
        return info;
    }

    public void VaciarCola() {
        System.out.println("Se ha vaciado la cola con los valores: \n");
        while (!ColaVacia()) {
            desencolarTodo();
        }
    }

    public boolean buscar(String id) {
        Medico aux = InicioCola;
        boolean se = false;
        while (aux != null) {
            if (aux.getId().equals(id)) {
                se = true;
            }

            aux = aux.getSiguiente();
        }
        return se;
    }

    //acá me quedé
    public void Actualizar(String id) {
        Medico aux = InicioCola;
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
                        case 6 -> System.out.println("Saliendo");
                        default -> System.out.println("Opción incorrecta.");
                    }
                } while (op != 6);
            }

            aux = aux.getSiguiente();
        }
    }

}
