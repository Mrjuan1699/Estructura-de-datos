package eps.fv.Paciente;
import eps.fv.Nodo;
import eps.fv.Validaciones;

import java.util.Scanner;

public class ListaCircularP {
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
            Paciente objP = new Paciente();
            objP = (Paciente) aux.getDato();
            n1 = objP.getId();
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
        op = Validaciones.leerEntero("¿Ingresar un paciente?\n 1. Si.\n 2.No.");
        while (op != 2) {
            String id = Validaciones.leerString("Ingrese el id del paciente: ");
            Paciente objM = new Paciente();
            objM = objM.lecturaDatos(id);
            Nodo nuevo = new Nodo();

            nuevo.setDato(objM);
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
            op = Validaciones.leerEntero("¿Ingresar un paciente?\n 1. Si.\n 2.No.");
        }

    }

    public void IngresarAlFinal() {

        op = Validaciones.leerEntero("¿Ingresar un paciente?\n 1. Si.\n 2.No.");
        while (op != 2) {
            String id = Validaciones.leerString("Ingrese el id del paciente: ");
            Paciente objP = new Paciente();
            objP = objP.lecturaDatos(id);
            Nodo nuevo = new Nodo();

            nuevo.setDato(objP);

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
            op = Validaciones.leerEntero("¿Ingresar un paciente?\n 1. Si.\n 2.No.");
        }
    }

    public void IngresarPorReferencia(ListaCircularP objLC, int referencia) {

        Nodo nuevo = new Nodo();
        String id, n1;
        int n, sw = 0;
        Paciente objP = new Paciente();
        id = Validaciones.leerString("Ingrese el id del paciente: ");
        objP = objP.lecturaDatos(id);
        nuevo.setDato(objP);

        if (!esVacia()) {
            if (buscar(referencia)) {
                Nodo aux = inicio;
                objP = (Paciente) aux.getDato();
                id = objP.getId();
                n = Integer.parseInt(id);
                while (n != referencia) {
                    objP = (Paciente) aux.getDato();
                    n1 = objP.getId();
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

    public void IngresarPorPosicion(ListaCircularP objLC, int posicion) {
        if (posicion >= 0 && posicion <= tamano) {
            Nodo nuevo = new Nodo();
            Paciente objP = new Paciente();
            String id;
            id = Validaciones.leerString("Digite el id del paciente: ");
            objP = objP.lecturaDatos(id);
            nuevo.setDato(objP);
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

    public Object getValor(ListaCircularP objLC, int posicion) throws Exception {
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

    public int obtenerPosicion(ListaCircularP objLC, int referencia) throws Exception
    {
        String n1;
        int n, sw = 0;
        if (buscar(referencia)) {
            Nodo aux = inicio;
            int cont = 0;
            Paciente objP = new Paciente();
            objP = (Paciente) aux.getDato();
            n1 = objP.getId();
            n = Integer.parseInt(n1);
            while (referencia != n) {
                cont++;
                objP = (Paciente) aux.getDato();
                n1 = objP.getId();
                n = Integer.parseInt(n1);

                aux = aux.getSiguiente();
            }
            return cont;
        } else {
            throw new Exception("El paciente no existe en la lista.");
        }
    }

    public Paciente actualizarItem(Paciente objP) {
        String id, nombre, apellido,IdMedico;
        int op = 0, edad = 0,EstSoc = 0;
        double CoPago = 0;
        boolean sw2 = false;
        Scanner sc = new Scanner(System.in);
        nombre = objP.getNombre();
        apellido = objP.getApellido();
        IdMedico = objP.getIdMedico();
        edad = objP.getEdad();
        EstSoc = objP.getEstSocial();
        CoPago = objP.getCopago();
        while (op < 7) {
            System.out.println("" + Menu());
            op = sc.nextInt();
            switch (op) {
                case 1:
                    nombre = Validaciones.leerString("Ingrese el nuevo nombre del paciente: ");
                    objP.setNombre(nombre);
                    break;
                case 2:
                    apellido = Validaciones.leerString("Ingrese el nuevo apellido del paciente: ");
                    objP.setApellido(apellido);
                    break;
                case 3:
                    edad = Validaciones.leerEntero("Ingrese la nueva edad del paciente: ");
                    objP.setEdad(edad);
                    break;
                case 4:
                    IdMedico = Validaciones.leerString("Ingrese el nuevo id del médico del paciente: ");
                    objP.setIdMedico(IdMedico);
                    break;
                case 5:
                    EstSoc = Validaciones.leerEntero("Ingrese el nuevo estrato del paciente: ");
                    objP.setEstSocial(EstSoc);
                case 6:
                    CoPago = Validaciones.leerReal("Ingrese el nuevo copago del paciente: ");
                    objP.setCopago(CoPago);
                    break;

            }
        }
        System.out.println("Los datos del paciente fueron actualizados correctamente");
        return objP;
    }

    public ListaCircularP editarPorReferencia(ListaCircularP objLC, int referencia) {
        int n, sw = 0;
        String id;
        boolean sw2 = false;
        Scanner sc = new Scanner(System.in);
        Paciente objP = new Paciente();
        if (buscar(referencia)) {
            Nodo aux = inicio;
            while (sw == 0) {
                objP = (Paciente) aux.getDato();
                id = objP.getId();
                n = Integer.parseInt(id);
                if (n != referencia) {
                    aux = aux.getSiguiente();
                } else {
                    sw = 1;
                    objP = actualizarItem(objP);
                    aux.setDato(objP);
                }
            }
        }
        return objLC;
    }

    public void editarPorPosicion(ListaCircularP objLC, int posicion){
        Paciente objP = new Paciente();
        if(posicion>=0 && posicion<tamano){
            if(posicion == 0)
            {
                objP =(Paciente) inicio.getDato();
                objP = actualizarItem(objP);
                inicio.setDato(objP);
            }
            else{
                Nodo aux = inicio.getSiguiente();
                for (int i = 0; i < posicion; i++)
                {
                    aux = aux.getSiguiente();
                }
                // Alctualiza el valor del nodo.
                objP =(Paciente) aux.getDato();
                objP = actualizarItem(objP);
                aux.setDato(objP);
            }
        }

    }

    public void EliminarPorReferencia(ListaCircularP objLC,int referencia)
    {
        String id;
        int n;

        Paciente objP = new Paciente();
        if (buscar(referencia))
        {
            Nodo aux = inicio;
            objP =(Paciente) inicio.getDato();
            id = objP.getId();
            n = Integer.parseInt(id);

            if((n == referencia)&&(inicio==aux))
            {
                inicio = inicio.getSiguiente();
                ultimo.setSiguiente(inicio);
            }
            else
                while(n != referencia)
                {
                    objP =(Paciente) aux.getDato();
                    id = objP.getId();
                    n = Integer.parseInt(id);
                    aux = aux.getSiguiente();
                }
            if (aux.getSiguiente() == ultimo)
            {
                aux.setSiguiente(inicio);
                ultimo = aux;
            }
            else
            {
                Nodo siguiente = aux.getSiguiente();
                aux.setSiguiente(siguiente.getSiguiente());
            }
        }
        tamano--;
    }


    public void EliminarPorPosicion(ListaCircularP objLC, int posicion){
        if(posicion>=0 && posicion<tamano){
            if(posicion == 0){
                inicio = inicio.getSiguiente();
                ultimo.setSiguiente(inicio);
            }
            else{
                Nodo aux = inicio;
                for (int i = 0; i < posicion-1; i++) {
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

    public String Menu()
    {
        return (" Menú actualización paciente\n"
                + "1. Cambiar nombre\n"
                + "2. Cambiar apellido\n"
                + "3. Cambiar edad\n"
                + "4. Cambiar Id Medico\n"
                + "5. Cambiar estrato social\n"
                + "6. Cambiar copago\n"
                + "7. Terminar\n");
    }
}
