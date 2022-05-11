package eps.fv;


public class Nodo {
    private Object Dato;
    private Nodo siguiente, Anterior;


    public void Nodo() {
        this.Dato = null;
        this.siguiente = null;
        this.Anterior = null;
    }

    public Object getDato() {
        return Dato;
    }

    public void setDato(Object Dato) {
        this.Dato = Dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAnterior() {
        return Anterior;
    }

    public void setAnterior(Nodo anterior) {
        Anterior = anterior;
    }
}
