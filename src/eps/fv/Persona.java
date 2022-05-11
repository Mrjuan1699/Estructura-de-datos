package eps.fv;


public class Persona 
{
   private String id,nombre, apellido;
   private int edad;

    public Persona() 
    {
        
    }

    public Persona(String id, String nombre, String apellido, int edad) 
    {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    
    public String getId() 
    {
        return id;
    }

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) 
    {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad)
    {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + '}';
    }
    
      
   public String imprimirDatos()
   {
       return "|"+getId()+"-"+getNombre()+"-"+getApellido()+"-"+getEdad()+"|";
   }
}
