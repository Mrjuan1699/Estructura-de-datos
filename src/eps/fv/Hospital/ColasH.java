package eps.fv.Hospital;

import eps.fv.Validaciones;

import javax.swing.*;

public class ColasH {
    private Hospital InicioCola, FinalCola;
    String Cola = "";

    public ColasH() {
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

    public void Insertar(String nit) {
        if (!buscar(nit)) {
            Hospital Nuevo_Nodo = new Hospital();
            Nuevo_Nodo = Nuevo_Nodo.lecturaDatos(nit);
            Nuevo_Nodo.siguiente = null;

            if (ColaVacia()) {
                InicioCola = Nuevo_Nodo;
                FinalCola = Nuevo_Nodo;
            } else {
                FinalCola.siguiente = Nuevo_Nodo;
                FinalCola = Nuevo_Nodo;
            }
        } else {
            System.out.println("El hospital ya existe.");
        }

    }


    public String desencolar() {
        String dato = " ";
        if (InicioCola != null) {
            dato = InicioCola.toString();
            InicioCola = InicioCola.getSiguiente();
        } else System.out.println("La cola esta vacia");

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
        Hospital aux = InicioCola;
        while (aux != null) {
            System.out.println(aux.toString());
            aux = aux.getSiguiente();
        }
    }

    public void buscarPorNombre(String nombre) {
        Hospital aux = InicioCola;
        String cadena = "Cola\n";

        while (aux != null) {
            if (aux.getNombre().equals(nombre)) {
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

    public boolean buscar(String nit) {
        Hospital aux = InicioCola;
        boolean se = false;
        while (aux != null) {
            if (aux.getNit().equals(nit)) {
                se = true;
            }

            aux = aux.getSiguiente();
        }
        return se;
    }

    //acá me quedé
    public void Actualizar(String nt) {
        Hospital aux = InicioCola;
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
                             5. Número de médicos de este hospital
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
                        case 6 -> System.out.println("Saliendo");
                        default -> System.out.println("Opción incorrecta.");
                    }
                } while (op != 6);
            }

            aux = aux.getSiguiente();
        }
    }

}
