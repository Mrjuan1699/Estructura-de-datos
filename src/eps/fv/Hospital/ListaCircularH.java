package eps.fv.Hospital;

import eps.fv.Nodo;
import eps.fv.Validaciones;

import java.util.Scanner;

public class ListaCircularH {
    private Nodo inicio;
    private Nodo ultimo;
    private int tamano;
    int op = 0;

    public void Lista() {
        inicio = null;
        ultimo = null;
        tamano = 0;
    }

    public boolean esVacia() {
        return inicio == null;
    }

    public int getTamano() {
        return tamano;
    }

    public boolean buscar(int referencia) {
        Nodo aux = inicio;
        String n1;
        int n;
        boolean encontrado = false;
        do {
            Hospital objh = new Hospital();
            objh = (Hospital) aux.getDato();
            n1 = objh.getNit();
            n = Integer.parseInt(n1);
            if (referencia == n) {
                encontrado = true;
            } else {
                aux = aux.getSiguiente();
            }
        } while (aux != inicio && !encontrado);
        return encontrado;
    }

    public void IngresarAlInicio() {
        op = Validaciones.leerEntero("¿Ingresar un hospital?\n 1. Si.\n 2.No.");
        while (op != 2) {
            String nit = Validaciones.leerString("Ingrese el nit del hospital: ");
            Hospital objH = new Hospital();
            objH = objH.lecturaDatos(nit);
            Nodo nuevo = new Nodo();

            nuevo.setDato(objH);
            if (esVacia()) {
                inicio = nuevo;
                ultimo = nuevo;
                ultimo.setSiguiente(inicio);
            } else {
                nuevo.setSiguiente(inicio);
                inicio = nuevo;
                ultimo.setSiguiente(inicio);
            }
            tamano++;
            op = Validaciones.leerEntero("¿Ingresar un hospital?\n 1. Si.\n 2.No.");
        }

    }

    public void IngresarAlFinal() {

        op = Validaciones.leerEntero("¿Ingresar un hospital?\n 1. Si.\n 2.No.");
        while (op != 2) {
            String nit = Validaciones.leerString("Ingrese el nit del hospital: ");
            Hospital objH = new Hospital();
            objH = objH.lecturaDatos(nit);
            Nodo nuevo = new Nodo();

            nuevo.setDato(objH);

            if (esVacia()) {
                inicio = nuevo;
                ultimo = nuevo;
                ultimo.setSiguiente(inicio);
            } else {
                ultimo.setSiguiente(nuevo);
                nuevo.setSiguiente(inicio);
                ultimo = nuevo;
            }
            tamano++;
            op = Validaciones.leerEntero("¿Ingresar un hospital?\n 1. Si.\n 2.No.");
        }
    }

    public void IngresarPorReferencia(ListaCircularH objLC, int referencia) {

        Nodo nuevo = new Nodo();
        Hospital objh;
        String nit, n1;
        int n, sw = 0;
        Hospital objH = new Hospital();
        nit = Validaciones.leerString("Ingrese el nit del hospital: ");
        objH = objH.lecturaDatos(nit);
        nuevo.setDato(objH);

        if (!esVacia()) {
            if (buscar(referencia)) {
                Nodo aux = inicio;
                objH = (Hospital) aux.getDato();
                nit = objH.getNit();
                n = Integer.parseInt(nit);
                while (n != referencia) {
                    objh = (Hospital) aux.getDato();
                    n1 = objh.getNit();
                    n = Integer.parseInt(n1);
                    if (n == referencia) {
                        break;
                    }
                    aux = aux.getSiguiente();
                }
                if (aux == ultimo) {
                    aux.setSiguiente(nuevo);
                    nuevo.setSiguiente(inicio);
                    ultimo = nuevo;
                } else {
                    Nodo siguiente = aux.getSiguiente();
                    aux.setSiguiente(nuevo);
                    nuevo.setSiguiente(siguiente);
                }
                tamano++;
            }
        }
    }

    public void IngresarPorPosicion(ListaCircularH objLC, int posicion) {
        if (posicion >= 0 && posicion <= tamano) {
            Nodo nuevo = new Nodo();
            Hospital objHos = new Hospital();
            String nit;
            nit = Validaciones.leerString("Digite el nit del hospital: ");
            objHos = objHos.lecturaDatos(nit);
            nuevo.setDato(objHos);
            if (posicion == 0) {
                nuevo.setSiguiente(inicio);
                inicio = nuevo;
                ultimo.setSiguiente(inicio);
            } else {
                if (posicion == tamano) {
                    ultimo.setSiguiente(nuevo);
                    nuevo.setSiguiente(inicio);
                    ultimo = nuevo;
                } else {
                    Nodo aux = inicio;
                    for (int i = 0; i < (posicion - 1); i++) {
                        aux = aux.getSiguiente();
                    }
                    Nodo siguiente = aux.getSiguiente();
                    aux.setSiguiente(nuevo);
                    nuevo.setSiguiente(siguiente);
                }
            }
            tamano++;
        }
    }

    public Object getValor(ListaCircularH objLC, int posicion) throws Exception {
        if (posicion >= 0 && posicion < tamano) {
            if (posicion == 0) {
                return inicio.getDato();
            } else {
                Nodo aux = inicio;
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getSiguiente();
                }
                aux = aux.getAnterior();
                return aux.getDato();
            }
        } else {
            throw new Exception("La posición no existe en la lista.");
        }
    }

    public int obtenerPosicion(ListaCircularH objLC, int referencia) throws Exception {
        String n1;
        int n, sw = 0;
        if (buscar(referencia)) {
            Nodo aux = inicio;
            int cont = 0;
            Hospital objh = new Hospital();
            objh = (Hospital) aux.getDato();
            n1 = objh.getNit();
            n = Integer.parseInt(n1);
            while (referencia != n) {
                cont++;
                objh = (Hospital) aux.getDato();
                n1 = objh.getNit();
                n = Integer.parseInt(n1);

                aux = aux.getSiguiente();
            }
            return cont;
        } else {
            throw new Exception("El hospital no existe en la lista.");
        }
    }

    public Hospital actualizarItem(Hospital objH) {
        String nit, nom, dir;
        int op = 0, estSocial = 0, numMedicos = 0;
        double ppto = 0;
        boolean sw2 = false;
        Scanner sc = new Scanner(System.in);
        nom = objH.getNombre();
        dir = objH.getDireccion();
        estSocial = objH.getEstSocial();
        numMedicos = objH.getNumMed();
        ppto = objH.getPresupuesto();
        while (op < 5) {
            System.out.println("" + Menu());
            op = sc.nextInt();
            switch (op) {
                case 1:
                    nom = Validaciones.leerString(" ingrese el nuevo nombre del hospital: ");
                    objH.setNombre(nom);
                    break;
                case 2:
                    dir = Validaciones.leerString(" ingrese la nueva dirección del hospital: ");
                    objH.setDireccion(dir);
                    break;
                case 3:
                    estSocial = Validaciones.leerEntero(" ingrese el nuevo estrato social del hospital: ");
                    objH.setEstSocial(estSocial);
                    break;
                case 4:
                    numMedicos = Validaciones.leerEntero(" ingrese el nuevo número de médicos del hospital: ");
                    objH.setNumMed(numMedicos);
                    break;
            }
            ppto = objH.aumentarPpto(estSocial, numMedicos);
            objH.setPresupuesto(ppto);
        }
        System.out.println("Los datos del hospital fueron actualizados exitosamente");
        return objH;
    }

    public ListaCircularH editarPorReferencia(ListaCircularH objLC, int referencia) {
        int n, sw = 0;
        String nit;
        boolean sw2 = false;
        Scanner sc = new Scanner(System.in);
        Hospital objH = new Hospital();
        if (buscar(referencia)) {
            Nodo aux = inicio;
            while (sw == 0) {
                objH = (Hospital) aux.getDato();
                nit = objH.getNit();
                n = Integer.parseInt(nit);
                if (n != referencia) {
                    aux = aux.getSiguiente();
                } else {
                    sw = 1;
                    objH = actualizarItem(objH);
                    aux.setDato(objH);
                }
            }
        }
        return objLC;
    }

    public void editarPorPosicion(ListaCircularH objLC, int posicion) {
        Hospital objH = new Hospital();
        if (posicion >= 0 && posicion < tamano) {
            if (posicion == 0) {
                objH = (Hospital) inicio.getDato();
                objH = actualizarItem(objH);
                inicio.setDato(objH);
            } else {
                Nodo aux = inicio.getSiguiente();
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getSiguiente();
                }
                objH = (Hospital) aux.getDato();
                objH = actualizarItem(objH);
                aux.setDato(objH);
            }
        }
    }

    public void EliminarPorReferencia(ListaCircularH objLC, int referencia) {
        String nit;
        int n;

        Hospital objH = new Hospital();
        if (buscar(referencia)) {
            Nodo aux = inicio;
            objH = (Hospital) inicio.getDato();
            nit = objH.getNit();
            n = Integer.parseInt(nit);

            if ((n == referencia) && (inicio == aux)) {
                inicio = inicio.getSiguiente();
                ultimo.setSiguiente(inicio);
            } else
                while (n != referencia) {
                    objH = (Hospital) aux.getDato();
                    nit = objH.getNit();
                    n = Integer.parseInt(nit);
                    aux = aux.getSiguiente();
                }
            if (aux.getSiguiente() == ultimo) {
                aux.setSiguiente(inicio);
                ultimo = aux;
            } else {
                Nodo siguiente = aux.getSiguiente();
                aux.setSiguiente(siguiente.getSiguiente());
            }
        }
        tamano--;
    }


    public void EliminarPorPosicion(ListaCircularH objLC, int posicion) {
        if (posicion >= 0 && posicion < tamano) {
            if (posicion == 0) {
                inicio = inicio.getSiguiente();
                ultimo.setSiguiente(inicio);
            } else {
                Nodo aux = inicio;
                for (int i = 0; i < posicion - 1; i++) {
                    aux = aux.getSiguiente();
                }
                if (aux.getSiguiente() == ultimo) {
                    aux.setSiguiente(inicio);
                    ultimo = aux;
                } else {
                    Nodo siguiente = aux.getSiguiente();
                    aux.setSiguiente(siguiente.getSiguiente());
                }
            }
            tamano--;
        }
    }

    public void eliminar() {
        inicio = null;
        ultimo = null;
        tamano = 0;
    }

    public void listar() {
        if (!esVacia()) {
            Nodo aux = inicio;
            int i = 0;
            do {
                System.out.println("-> " + i + ".[ " + aux.getDato() + " ]");
                aux = aux.getSiguiente();
                i++;
            } while (aux != inicio);
        }
    }

    public String Menu() {
        return (" MENU Actualización Hospital\n"
                + "1. Cambiar Nombre\n"
                + "2. Cambiar Dirección\n"
                + "3. Cambiar Estrato Social\n"
                + "4. Cambiar Número de Médicos\n"
                + "5. Terminar\n");
    }
}
