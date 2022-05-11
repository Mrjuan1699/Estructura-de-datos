package eps.fv.Medico;

import eps.fv.Hospital.CRUDHospital;
import eps.fv.Hospital.Hospital;
import eps.fv.Validaciones;

import static eps.fv.Validaciones.*;

public class CRUDMedico {
    public CRUDMedico() {
    }

    public void IngresarMedico(Validaciones.Archivo objArchivo, String id, String ruta) {
        Medico objM = new Medico();
        if (!Buscar(objArchivo, id, ruta)) {
            objM = objM.lecturaDatos(id);
            Grabar(objArchivo, objM, ruta);
        } else {
            System.out.println("El médico ya existe en el archivo.");
        }
    }

    public void Grabar(Validaciones.Archivo objArchivos, Medico objM, String ruta) {
        String texto = "";
        objArchivos.abrirModoEscritura(ruta);
        texto = objM.EstructuraReg();//con este metodo se da la estructura al registro
        objArchivos.escribir(texto); //se graba o escribe o imprime el registro fisicamente en el archivo
        objArchivos.cerrarModoEscritura();
    }//fin  GrabarHospital

    public boolean Buscar(Validaciones.Archivo objArch, String nt, String ruta) {
        boolean sw = false;
        String ni;
        try {
            Medico objM = new Medico();
            int tamaño = objArch.contadorLineas(ruta);
            objArch.abrirModoLectura(ruta);
            Medico vMed[] = new Medico[tamaño];
            vMed = objArch.leerM();//retorna el vector tipo objeto y se le asigna al vector definido en esta clase
            int i = 0;
            int cantRegistros = objArch.contadorLineas(ruta);
            while (i <= cantRegistros) {
                objM = vMed[i];
                ni = objM.getId();
                if (ni.equals(nt)) {
                    sw = true;
                    break;
                }
                i++;
            }//fin mientras
            objArch.cerrarModoLectura();
        } catch (Exception e) {
            System.out.println("***Archivo leido y cerrado correctamente*****");
        }
        return sw;

    }//fin de buscar*/

    public String Mostrar(Validaciones.Archivo objArch, String ruta) {
        String cadena = "";//cadena para el almacenamiento de todos los registros
        String cadena2 = "";
        Medico objM = new Medico();
        int tamaño;
        try {
            tamaño = objArch.contadorLineas(ruta);
            Medico vMed[] = new Medico[tamaño];
            objArch.abrirModoLectura(ruta);

            vMed = objArch.leerM();//retorna el vector tipo objeto y se le asigna al definido en esta clase
            int i = 0;
            int suma = 0;
            int cantRegistros = objArch.contadorLineas(ruta);

            while (i <= cantRegistros)//mientras no llegue hasta la última línea del archivo
            {
                objM = vMed[i];
                cadena = cadena + "[ " + objM.toString() + " ]\n";//se anexan cada registro a la cadena
                i++;
            }//fin mientras */
            objArch.cerrarModoLectura();
        } catch (Exception e) {
            System.out.println("***Archivo leído y cerrado correctamente*****");
        }
        return cadena;
    }//fin de mostrar productos

    public String Consultar(Validaciones.Archivo objArch, String id, String ruta) {
        String cadena = "";
        String nide;
        try {
            int tamaño = objArch.contadorLineas(ruta);
            Medico vMed[] = new Medico[tamaño];
            Medico objM = new Medico();
            objArch.abrirModoLectura(ruta);
            vMed = objArch.leerM();//retorna el vector tipo objeto y se le asigna al vector definido en esta clase
            int i = 0;
            int cantRegistros = objArch.contadorLineas(ruta);
            while (i <= cantRegistros) //mientras no llegue hasta la última línea del archivo
            {
                objM = vMed[i];
                nide = objM.getId();
                if (nide.equals(id)) {
                    cadena = cadena + "[ " + objM.toString() + " ]\n";
                }
                i++;
            }//fin mientras */
            objArch.cerrarModoLectura();
        } catch (Exception e) {
            System.out.println("***Archivo leído y cerrado correctamente*****");
        }

        if (cadena.equals("")) {
            return cadena = "NO SE ENCONTRÓ EL HOSPITAL";
        }
        return cadena;
    }

    public void grabarActualizacion(Medico[] vMed, Validaciones.Archivo objArchCopy, String ruta) {
        Medico objM;
        objArchCopy.eliminaArchivo(ruta); // se elimina el archivo original
        for (int i = 0; i < vMed.length; i++) {
            objArchCopy.abrirModoEscritura(ruta);
            objM = vMed[i];
            String texto = "";
            texto = objM.EstructuraReg();//con este metodo se da la estructura al registro
            //System.out.println("a ver que imprime por aquí:"+ texto);
            objArchCopy.escribir(texto); //se graba o escribe o imprime el registro fisicamente en el archivo
            objArchCopy.cerrarModoEscritura();
        }

    }

    public String Eliminar(Validaciones.Archivo objArchivos, String id, String ruta) {
        String iden;
        String cadena = "";
        objArchivos.abrirModoLectura(ruta);
        int op;
        if (objArchivos.archivo.exists() == true) {
            int cantLineas = objArchivos.contadorLineas(ruta);
            try {
                boolean sw = false;
                // int regV = 0;
                Medico objM = new Medico();
                Medico vMed[] = new Medico[cantLineas];
                // Hospital vReg[];
                vMed = objArchivos.leerM();//Almacenamos cada registro del archivo en un vector tipo hospital
                int i = 0, cont = 0;
                while (i < cantLineas) {
                    objM = vMed[i];
                    iden = objM.getId();
                    if (!iden.equals(id)) {
                        cont += 1;
                    }
                    i++;
                }
                Medico vReg[];
                vReg = new Medico[cont];
                if (cont == 0) {
                    cadena = "No hay registro a imprimir";
                } else {
                    i = 0;
                    int c = 0;
                    while (i < cantLineas) {
                        objM = vMed[i];
                        iden = objM.getId();
                        if (!iden.equals(id)) {
                            vReg[c] = objM;
                            System.out.println("***vector en la posición *****" + vReg[c].toString());
                            c = c + 1;
                            sw = true;
                        } else {
                            cadena = cadena + "[ " + objM.toString() + " ]\n";
                        }
                        i++;
                    }
                    grabarActualizacion(vReg, objArchivos, ruta);
                }
                objArchivos.cerrarModoEscritura();
            } catch (Exception e) {
                System.out.println("***Archivo leido y cerrado correctamente*****");
                objArchivos.cerrarModoEscritura();
            }
        } else {
            System.out.println("No existe un archivo en el cual se pueda eliminar el registro");
        }
        return cadena;
    }

    public void Actualizar(Validaciones.Archivo objArchivos, String id, String ruta) {
        String id2, nombre, apellido;
        int edad;
        double salbase, incentivo;
        objArchivos.abrirModoLectura(ruta);
        int op;
        if (objArchivos.archivo.exists() == true) {
            int cantLineas = objArchivos.contadorLineas(ruta);
            Medico vMed[] = new Medico[cantLineas];
            try {
                boolean sw = false;
                int regV = 0;
                Medico objM = new Medico();
                vMed = objArchivos.leerM();//Almacenamos cada registro del archivo en un vector tipo hospital
                int i = 0;
                while (i < cantLineas) {
                    objM = vMed[i];
                    id2 = objM.getId();
                    nombre = objM.getNombre();
                    apellido = objM.getApellido();
                    edad = objM.getEdad();
                    salbase = objM.getSalBase();
                    incentivo = objM.getIncentivo();
                    if (id2.equals(id)) {
                        sw = true;
                        System.out.println("Se actualizará el registro cuyo valor de id es: " + id);
                        do {
                            op = leerEntero(" 1. id, 2. Nombre, 3.Apellido, 4. Edad, 5. Salario base 6. Incentivo 7. Terminar");
                            switch (op) {
                                case 1 -> id = leerString("Ingrese el nuevo id del médico: ");
                                case 2 -> nombre = leerString("Ingrese el nuevo nombre del médico: ");
                                case 3 -> apellido = leerString("Ingrese el nuevo apellido del médico: ");
                                case 4 -> edad = leerEntero("Ingrese la nueva edad del médico: ");
                                case 5 -> salbase = leerReal("Ingrese el nuevo salario del médico: ");
                                case 6 -> incentivo = leerReal("Ingrese el nuevo incentivo del médico: ");
                            }
                        } while (op < 7);
                        objM = new Medico(id, nombre, apellido, edad, salbase, incentivo);
                        vMed[i] = objM;
                        System.out.println(" registro actualizado" + objM.toString());
                    } else {
                        vMed[i] = objM;
                    }
                    i++;
                }
                if (sw == false) {
                    System.out.println("El médico No existe");
                }
                objArchivos.cerrarModoEscritura();
            } catch (Exception e) {
                System.out.println("***Archivo leido y cerrado correctamente*****");
                objArchivos.cerrarModoEscritura();
            }
            grabarActualizacion(vMed, objArchivos, ruta);
        } else {
            System.out.println("No existe un archivo para actualizar");
        }

    }


    public String Parcial(Validaciones.Archivo ObjArchivo) {
        int i = 0;
        int cant = 0;
        int tamano = 0;
        Medico Vmed[] = new Medico[tamano];
        ObjArchivo.abrirModoLectura("Medicos.txt");
        Vmed = ObjArchivo.leerM();
        String info = "";
        Medico objM = new Medico();
        for (i = 0; i < Vmed.length; i++) {
            objM = Vmed[i];
            if (Vmed[i].getSalBase() <= 5000000 && Vmed[i].getEdad() >= 26) {
                info = info + "[" + objM.toString() + "]\n";
            }
        }

        return info;

    }

    public String Mostrar_Optimizado(Validaciones.Archivo ObjArchivo) {
        int i = 0;
        int cant = 0;
        int tamano = 0;
        String info = "";
        try {
            Medico Vmed[] = new Medico[tamano];
            ObjArchivo.abrirModoLectura("Medicos.txt");
            Vmed = ObjArchivo.leerM();

            Medico objM = new Medico();
            for (i = 0; i < Vmed.length; i++) {
                objM = Vmed[i];
                info = info + "[" + objM.toString() + "]\n";

            }
            ObjArchivo.cerrarModoLectura();

        } catch (Exception e) {
            System.out.println("***Archivo leído y cerrado correctamente*****");
        }
        return info;


    }

    public void Grabar_Parcial(Validaciones.Archivo objArchivos, String info) {
        int op = 0;

        op = leerEntero("Desea guardar la información?\n" +
                "1. Si\n" +
                "2. No\n");
        if (op == 1) {
            objArchivos.eliminaArchivo("Medicos_Parcial.txt");
            String texto = "";
            objArchivos.abrirModoEscritura("Medicos_Parcial.txt");
            texto = info;//con este metodo se da la estructura al registro
            objArchivos.escribir(texto); //se graba o escribe o imprime el registro fisicamente en el archivo
            objArchivos.cerrarModoEscritura();
        }


    }//fin  GrabarHospital
}
