package eps.fv;
import eps.fv.Hospital.Hospital;
import eps.fv.Medico.Medico;
import eps.fv.Paciente.Paciente;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validaciones 
{
   public static int leerEntero(String mensaje)
	{
             Scanner sc = new Scanner (System.in);
		int num = 0;
                do{
		try
		{
	      	   System.out.println(mensaje);
                   num = sc.nextInt();
                   if(num<=0)
                     System.out.println("ERROR, el Numero debe ser mayor que cero");
                 }
		catch (Exception e)
		{
		  System.out.println("ERROR:"+ e);
		}
                 }while(num<=0);
		return num;
	}
 
        public static int leerEstrato(String mensaje)
	{
            Scanner sc = new Scanner (System.in);
		int num = 0;
                do{
		try
		{
	      	   System.out.println(mensaje);
                   num = sc.nextInt();
                    if(num<=0||num>=7)
                      System.out.println("ERROR, el Numero debe ser de 1 a 6");       
                }
		catch (Exception e)
		{
	         System.out.println("ERROR:"+ e);
		}
                 }while(num<=0||num>=7);
		return num;
	}
 
        
	public static double leerReal(String mensaje)
	{
            Scanner sc = new Scanner (System.in);
	    double num = 0;
             do
             {
	      try
	       {
	      	 System.out.println(mensaje);
                 num = sc.nextDouble();
                 if(num<=0)
                   System.out.println("ERROR, el Numero debe ser mayor que cero");
               }
		catch (Exception e)
		{
		 System.out.println("ERROR: " + e);
		}
                 }while(num<=0);
                
		return (num);
	}
        
	public static String leerString(String mensaje)
	{
	  String cadena= "";
          Scanner sc = new Scanner (System.in);
          do
          {
	   try
	    {
              System.out.println(mensaje);
              cadena = sc.nextLine();
	       if(cadena.equals(""))
                  System.out.println("ERROR: debe ingresar informacion");
            }
	    catch (Exception e)
	      {
		System.out.println("ERROR: " + e);
	      }
           }while(cadena.equals(""));
	 return cadena;
	}
    
        public static int leer12(String mensaje)
	{
          Scanner sc = new Scanner(System.in);
	  int num = 0;
           do
           {
	    try
	     {
              System.out.println(mensaje);
              num = sc.nextInt();
	      if(num<=0||num>=3)
                System.out.println("ERROR, el Numero debe ser de 1 o 2");
             }
	     catch (Exception e)
	      {
               System.out.println("ERROR - OJO  " );
	      }
           }while(num<=0||num>=3);
	 return num;
        }

    public static class Archivo
    {
        Scanner sc = new Scanner(System.in);
        public File archivo;//archivo logico
        FileReader lectura;//objeto para modo lectura del archivo
        BufferedReader buffer;//objeto que reserva un espacio en memoria donde se guarda la informacion
        BufferedWriter bufferW;
        BufferedReader bufferNEW;
        FileWriter escritura;//objeto para modo escritura del archivo
        PrintWriter impresion;//objeto para grabar directamente en el texto


       public String escribir(String registro)//graba el texto se dice que lo imprime en el archivo
        {
            String mensaje="grabará un registro";

            try
            {
                impresion.println(registro);
               // impresion.println();
               //buffer.close();
             }
            catch(Exception objException)
             {
               mensaje = objException.getMessage();
             }

            return mensaje;
        }

        public Hospital[] leerH()
        {
            //Hospital objH = new Hospital();
            int cl = contadorLineas("Hospitales.txt");
            Hospital vecH[];
            vecH = new Hospital[cl];
            String registro;
            String vec[];
            vec = new String[6];
           try
            {
               int i =0;
                while(cl>0)
                {
                  registro = buffer.readLine();
                  String separador = Pattern.quote("|");
                  vec = registro.split(separador);
                   String nit = vec[0];
                   String nom = vec[1];
                   int estSoc = Integer.parseInt(vec[2]);
                   double ppto=Double.parseDouble(vec[3]);
                   String dire =vec[4];//se toma en todas las variables auxiliares la informacion de la linea de texto
                   int nm = Integer.parseInt(vec[5]);
                   Hospital objH = new Hospital(nit, nom, dire,nm,estSoc, ppto);
                   vecH[i] = objH;
                   i++;
                   cl--;
                }
                /*registro = buffer.readLine();
                String separador = Pattern.quote("|");
                vec = registro.split(separador);//split(",");*/
             buffer.close();
            }
            catch(Exception objException)
            {
             objException.getMessage();
            }
            return vecH;
        }

        public Medico[] leerM()
        {
            //Hospital objH = new Hospital();
            int cl = contadorLineas("Medicos.txt");
            Medico vecM[];
            vecM = new Medico[cl];
            String registro;
            String vec[];
            vec = new String[6];
            try
            {
                int i =0;
                while(cl>0)
                {
                    registro = buffer.readLine();
                    String separador = Pattern.quote("|");
                    vec = registro.split(separador);
                    String id = vec[0];
                    String nombre = vec[1];
                    String apellido = vec[2];
                    int edad =Integer.parseInt(vec[3]);
                    double salbase = Double.parseDouble(vec[4]);
                    double incentivo = Double.parseDouble(vec[5]);
                    Medico objM = new Medico(id, nombre, apellido,edad,salbase, incentivo);
                    vecM[i] = objM;
                    i++;
                    cl--;
                }
                /*registro = buffer.readLine();
                String separador = Pattern.quote("|");
                vec = registro.split(separador);//split(",");*/
                buffer.close();
            }
            catch(Exception objException)
            {
                objException.getMessage();
            }
            return vecM;
        }

        public Paciente[] leerP()
        {
            //Hospital objH = new Hospital();
            int cl = contadorLineas("Pacientes.txt");
            Paciente vecP[];
            vecP = new Paciente[cl];
            String registro;
            String vec[];
            vec = new String[6];
            try
            {
                int i =0;
                while(cl>0)
                {
                    registro = buffer.readLine();
                    String separador = Pattern.quote("|");
                    vec = registro.split(separador);
                    String id = vec[0];
                    String nombre = vec[1];
                    String apellido = vec[2];
                    int edad =Integer.parseInt(vec[3]);
                    String idMed =vec[4];
                    int Estrato = Integer.parseInt(vec[5]);
                    double copago = Double.parseDouble(vec[6]);
                    Paciente objP = new Paciente(id, nombre, apellido, edad, Estrato,idMed,copago);
                    vecP[i] = objP;
                    i++;
                    cl--;
                }
                /*registro = buffer.readLine();
                String separador = Pattern.quote("|");
                vec = registro.split(separador);//split(",");*/
                buffer.close();
            }
            catch(Exception objException)
            {
                objException.getMessage();
            }
            return vecP;
        }

       public String abrirModoLectura(String ruta)
        {
            String mensaje = "El archivo esta en  **Modo lectura**";
            try{
                archivo = new File(ruta);
                lectura = new FileReader(archivo);
                buffer  = new BufferedReader(lectura);
            }
            catch(Exception objException)
             {
                mensaje = objException.getMessage();
             }
             return mensaje;
        }

        public String cerrarModoLectura()
        {
            String mensaje="¡El archivo en Modo lectura se cierra";
            try
            {
             lectura.close();
            // buffer.close();
            }
            catch(Exception objException)
             {
                mensaje = objException.getMessage();
             }
            return mensaje;
        }

        public String abrirModoEscritura(String ruta)
        {
            String mensaje="¡El archivo se abrirá de Modo escritura!";
            try{
                archivo = new File(ruta);
                escritura= new FileWriter(archivo,true);
                impresion = new PrintWriter(escritura);
            }
            catch(Exception objException)
            {
             mensaje = objException.getMessage();
            }
            System.out.println("mensaje método abrirModoEscritura: "+mensaje);
            return mensaje;
        }

        public String cerrarModoEscritura()
        {
            String mensaje="¡El archivo en **Modo escritura** se cierra!";
            try
             {
              impresion.close();
              buffer.close();
             }
            catch(Exception objException)
            {
              mensaje = objException.getMessage();
            }
            return mensaje;
        }

        public boolean eliminaArchivo(String ruta)
        {
           System.out.println("cual es el valor de Ruta:"+ruta);
           try
           {
             archivo = new File(ruta);
             if(archivo.exists())
              {
               //impresion.close();
               //lectura.close();
               System.out.println("****Archivo Eliminado****");
               System.out.println("****: "+archivo.getAbsolutePath());
               archivo.delete();
               archivo.deleteOnExit();
               return true;
              }
              else
               {
                return false;
               }
           }catch(Exception e)
            {
                System.out.println("ERROR: " + e.getMessage());
                 return false;
            }
    }



       public int contadorLineas(String arch)
        {
          int numLineas=0;
          try
          {
           if(archivo.isFile()== false)
           {
             return 0;
           }
           else
            {
           lectura = new FileReader(arch);
           BufferedReader br = new BufferedReader(lectura);

            while (br.readLine()!=null)
              {
                numLineas++;
              }
            br.close();
            return numLineas;
           }
          }
          catch (IOException e)
          {
             e.printStackTrace();
          }
          return numLineas;
        }


       public void renombrarArchivo(String nuevoNombre, String rutam)
        {
          try
          {
            String nombreActual = "Hospitales.txt";
            File oldfile = new File(nombreActual);
            File newfile = new File(nuevoNombre);
             if (oldfile.renameTo(newfile))
            {
                System.out.println("El archivo fue renombrado");
            } else {
                System.out.println("no se puede renombrar el archivo");
            }
            //newfile.renameTo(oldfile);

          }catch(Exception e)
           {
            System.out.println("***Archivo leído y cerrado correctamente*****");
           }
        }
    }
}
