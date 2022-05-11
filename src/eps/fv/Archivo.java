//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package eps.fv;

import eps.fv.Hospital.Hospital;
import eps.fv.Medico.Medico;
import eps.fv.Paciente.Paciente;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;



public class Archivo {
    Scanner sc;
    File archivo;
    FileReader lectura;
    BufferedReader buffer;
    BufferedWriter bufferW;
    BufferedReader bufferNEW;
    FileWriter escritura;
    PrintWriter impresion;

    public Archivo() {
        this.sc = new Scanner(System.in);
    }

    public String escribir(String registro) {
        String mensaje = "grabará un registro";

        try {
            this.impresion.println(registro);
        } catch (Exception var4) {
            mensaje = var4.getMessage();
        }

        return mensaje;
    }
    public Paciente[] leerP(String ruta){
        int cl = this.contadorLineas(ruta);
        Paciente[] vecP = new Paciente[cl];
        String[] vec = new String[6];
        try {
            for(int i = 0; cl > 0; --cl) {
                String registro = this.buffer.readLine();

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
                ++i;
            }

            this.buffer.close();
        } catch (Exception var15) {
            var15.getMessage();
        }
        return vecP;

    }

    public Medico[] leerM(String ruta){
        int cl = this.contadorLineas(ruta);
        Medico[] vecM = new Medico[cl];
        String[] vec = new String[6];
        try {
            for(int i = 0; cl > 0; --cl) {
                String registro = this.buffer.readLine();
                String separador = Pattern.quote("|");
                vec = registro.split(separador);
                String id = vec[0];
                String nombre = vec[1];
                String apellido = vec[2];
                int edad =Integer.parseInt(vec[3]);
                double salbase = Double.parseDouble(vec[4]);
                double incentivo = Double.parseDouble(vec[5]);


                Medico objM = new Medico(id, nombre, apellido, edad, salbase, incentivo);
                vecM[i] = objM;
                ++i;
            }

            this.buffer.close();
        } catch (Exception var15) {
            var15.getMessage();
        }
        return vecM;

    }

    public Hospital[] leer(String ruta) {
        int cl = this.contadorLineas(ruta);
        Hospital[] vecH = new Hospital[cl];
        String[] vec = new String[6];

        try {
            for(int i = 0; cl > 0; --cl) {
                String registro = this.buffer.readLine();
                String separador = Pattern.quote("|");
                vec = registro.split(separador);
                String nit = vec[0];
                String nom = vec[1];
                int estSoc = Integer.parseInt(vec[2]);
                double ppto = Double.parseDouble(vec[3]);
                String dire = vec[4];
                int nm = Integer.parseInt(vec[5]);
                Hospital objH = new Hospital(nit, nom, dire, nm, estSoc, ppto);
                vecH[i] = objH;
                ++i;
            }

            this.buffer.close();
        } catch (Exception var15) {
            var15.getMessage();
        }

        return vecH;
    }





    public String abrirModoLectura(String ruta) {
        String mensaje = "El archivo esta en  **Modo lectura**";

        try {
            this.archivo = new File(ruta);
            this.lectura = new FileReader(this.archivo);
            this.buffer = new BufferedReader(this.lectura);
        } catch (Exception var4) {
            mensaje = var4.getMessage();
        }

        return mensaje;
    }

    public String cerrarModoLectura() {
        String mensaje = "¡El archivo en Modo lectura se cierra";

        try {
            this.lectura.close();
        } catch (Exception var3) {
            mensaje = var3.getMessage();
        }

        return mensaje;
    }

    public String abrirModoEscritura(String ruta) {
        String mensaje = "¡El archivo se abrirá de Modo escritura!";

        try {
            this.archivo = new File(ruta);
            this.escritura = new FileWriter(this.archivo, true);
            this.impresion = new PrintWriter(this.escritura);
        } catch (Exception var4) {
            mensaje = var4.getMessage();
        }

        System.out.println("mensaje método abrirModoEscritura: " + mensaje);
        return mensaje;
    }

    public String cerrarModoEscritura() {
        String mensaje = "¡El archivo en **Modo escritura** se cierra!";

        try {
            this.impresion.close();
            this.buffer.close();
        } catch (Exception var3) {
            mensaje = var3.getMessage();
        }

        return mensaje;
    }

    public boolean eliminaArchivo(String ruta) {
        System.out.println("cual es el valor de Ruta:" + ruta);

        try {
            this.archivo = new File(ruta);
            if (this.archivo.exists()) {
                System.out.println("****Archivo Eliminado****");
                System.out.println("****: " + this.archivo.getAbsolutePath());
                this.archivo.delete();
                this.archivo.deleteOnExit();
                return true;
            } else {
                return false;
            }
        } catch (Exception var3) {
            System.out.println("ERROR: " + var3.getMessage());
            return false;
        }
    }

    public int contadorLineas(String arch) {
        int numLineas = 0;

        try {
            if (!this.archivo.isFile()) {
                return 0;
            } else {
                this.lectura = new FileReader(arch);

                BufferedReader br;
                for(br = new BufferedReader(this.lectura); br.readLine() != null; ++numLineas) {
                }

                br.close();
                return numLineas;
            }
        } catch (IOException var4) {
            var4.printStackTrace();
            return numLineas;
        }
    }

    public void renombrarArchivo(String nuevoNombre,String rutam) {
        try {
            String nombreActual = rutam;
            File oldfile = new File(nombreActual);
            File newfile = new File(nuevoNombre);
            if (oldfile.renameTo(newfile)) {
                System.out.println("El archivo fue renombrado");
            } else {
                System.out.println("no se puede renombrar el archivo");
            }
        } catch (Exception var5) {
            System.out.println("***Archivo leído y cerrado correctamente*****");
        }

    }
}
