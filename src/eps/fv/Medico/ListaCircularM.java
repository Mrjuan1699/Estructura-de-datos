package eps.fv.Medico;
import eps.fv.Nodo;
import eps.fv.Validaciones;

import java.util.Scanner;

public class ListaCircularM {
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
            Medico objM = new Medico();
            objM = (Medico) aux.getDato();
            n1 = objM.getId();
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
        op = Validaciones.leerEntero("¿Ingresar un médico?\n 1. Si.\n 2.No.");
        while (op != 2) {
            String id = Validaciones.leerString("Ingrese el id del médico: ");
            Medico objM = new Medico();
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
            op = Validaciones.leerEntero("¿Ingresar un médico?\n 1. Si.\n 2.No.");
        }

    }

    public void IngresarAlFinal() {

        op = Validaciones.leerEntero("¿Ingresar un médico?\n 1. Si.\n 2.No.");
        while (op != 2) {
            String id = Validaciones.leerString("Ingrese el id del médico: ");
            Medico objM = new Medico();
            objM = objM.lecturaDatos(id);
            Nodo nuevo = new Nodo();

            nuevo.setDato(objM);

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
            op = Validaciones.leerEntero("¿Ingresar un médico?\n 1. Si.\n 2.No.");
        }
    }

    public void IngresarPorReferencia(ListaCircularM objLC, int referencia) {

        Nodo nuevo = new Nodo();
        String id, n1;
        int n, sw = 0;
        Medico objM = new Medico();
        id = Validaciones.leerString("Ingrese el id del médico: ");
        objM = objM.lecturaDatos(id);
        nuevo.setDato(objM);

        if (!esVacia()) {
            if (buscar(referencia)) {
                Nodo aux = inicio;
                objM = (Medico) aux.getDato();
                id = objM.getId();
                n = Integer.parseInt(id);
                while (n != referencia) {
                    objM = (Medico) aux.getDato();
                    n1 = objM.getId();
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

    public void IngresarPorPosicion(ListaCircularM objLC, int posicion) {
        if (posicion >= 0 && posicion <= tamano) {
            Nodo nuevo = new Nodo();
            Medico objM = new Medico();
            String id;
            id = Validaciones.leerString("Digite el id del médico: ");
            objM = objM.lecturaDatos(id);
            nuevo.setDato(objM);
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

    public Object getValor(ListaCircularM objLC, int posicion) throws Exception {
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

    public int obtenerPosicion(ListaCircularM objLC, int referencia) throws Exception
    {
        String n1;
        int n, sw = 0;
        if (buscar(referencia)) {
            Nodo aux = inicio;
            int cont = 0;
            Medico objM = new Medico();
            objM = (Medico) aux.getDato();
            n1 = objM.getId();
            n = Integer.parseInt(n1);
            while (referencia != n) {
                cont++;
                objM = (Medico) aux.getDato();
                n1 = objM.getId();
                n = Integer.parseInt(n1);

                aux = aux.getSiguiente();
            }
            return cont;
        } else {
            throw new Exception("El médico no existe en la lista.");
        }
    }

    public Medico actualizarItem(Medico objM) {
        String id, nombre, apellido;
        int op = 0, edad = 0;
        double SalBase = 0,Incentivo=0;
        boolean sw2 = false;
        Scanner sc = new Scanner(System.in);// nos permite ingresar a un swicth para actualizar algunos de los datos
        nombre = objM.getNombre();
        apellido = objM.getApellido();
        edad = objM.getEdad();
        SalBase = objM.getSalBase();
        Incentivo = objM.getIncentivo();
        while (op < 6) {
            System.out.println("" + Menu());
            op = sc.nextInt();
            switch (op) {
                case 1:
                    nombre = Validaciones.leerString("Ingrese el nuevo nombre del médico: ");
                    objM.setNombre(nombre);
                    break;
                case 2:
                    apellido = Validaciones.leerString("Ingrese el nuevo apellido del médico: ");
                    objM.setApellido(apellido);
                    break;
                case 3:
                    edad = Validaciones.leerEntero("Ingrese la nueva edad del médico: ");
                    objM.setEdad(edad);
                    break;
                case 4:
                    SalBase = Validaciones.leerReal("Ingrese el nuevo salario del médico: ");
                    objM.setSalBase(SalBase);
                    break;
                case 5:
                    Incentivo = Validaciones.leerReal("Ingrese el nuevo incentivo del médico: ");
                    objM.setIncentivo(Incentivo);
                    break;
            }
        }
            System.out.println("Los datos del médico fueron actualizados correctamente");
        return objM;
    }

    public ListaCircularM editarPorReferencia(ListaCircularM objLC, int referencia) {
        int n, sw = 0;
        String id;
        boolean sw2 = false;
        Scanner sc = new Scanner(System.in);
        Medico objM = new Medico();
        if (buscar(referencia)) {
            Nodo aux = inicio;
            while (sw == 0) {
                objM = (Medico) aux.getDato();
                id = objM.getId();
                n = Integer.parseInt(id);
                if (n != referencia) {
                    aux = aux.getSiguiente();
                } else {
                    sw = 1;
                    objM = actualizarItem(objM);
                    aux.setDato(objM);
                }
            }
        }
        return objLC;
    }

    public void editarPorPosicion(ListaCircularM objLC, int posicion){
        Medico objH = new Medico();
        if(posicion>=0 && posicion<tamano){
            if(posicion == 0)
            {
                objH =(Medico) inicio.getDato();
                objH = actualizarItem(objH);
                inicio.setDato(objH);
            }
            else{
                Nodo aux = inicio.getSiguiente();
                for (int i = 0; i < posicion; i++)
                {
                    aux = aux.getSiguiente();
                }
                // Alctualiza el valor del nodo.
                objH =(Medico) aux.getDato();
                objH = actualizarItem(objH);
                aux.setDato(objH);
            }
        }

    }

    public void EliminarPorReferencia(ListaCircularM objLC,int referencia)
    {
        String id;
        int n;

        Medico objM = new Medico();
        if (buscar(referencia))
        {
            Nodo aux = inicio;
            objM =(Medico) inicio.getDato();
            id = objM.getId();
            n = Integer.parseInt(id);

            if((n == referencia)&&(inicio==aux))
            {
                inicio = inicio.getSiguiente();
                ultimo.setSiguiente(inicio);
            }
            else
                while(n != referencia)
                {
                    objM =(Medico) aux.getDato();
                    id = objM.getId();
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


    public void EliminarPorPosicion(ListaCircularM objLC, int posicion){
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
        return (" MENU Actualización médico\n"
                + "1. Cambiar nombre\n"
                + "2. Cambiar apellido\n"
                + "3. Cambiar edad\n"
                + "4. Cambiar salario\n"
                + "5. Cambiar incentivo\n"
                + "6. Terminar\n");
    }
}
