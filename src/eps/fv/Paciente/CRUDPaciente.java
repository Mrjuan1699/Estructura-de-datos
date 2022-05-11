package eps.fv.Paciente;

import eps.fv.Hospital.CRUDHospital;
import eps.fv.Hospital.Hospital;
import eps.fv.Validaciones;

import static eps.fv.Validaciones.*;

public class CRUDPaciente {
    public CRUDPaciente() {

    }

    public void IngresarMedico(Validaciones.Archivo objArchivo, String id, String ruta) {
        Paciente objP = new Paciente();
        if (!Buscar(objArchivo, id, ruta)) {
            objP = objP.lecturaDatos(id);
            Grabar(objArchivo, objP, ruta);

        } else {
            System.out.println("El médico ya existe en el archivo.");
        }
    }

    public void Grabar(Validaciones.Archivo objArchivos, Paciente objP, String ruta) {
        String texto = "";
        objArchivos.abrirModoEscritura(ruta);
        texto = objP.EstructuraReg();//con este metodo se da la estructura al registro
        objArchivos.escribir(texto); //se graba o escribe o imprime el registro fisicamente en el archivo
        objArchivos.cerrarModoEscritura();
    }//fin  GrabarHospital

    public boolean Buscar(Validaciones.Archivo objArch, String id, String ruta) {
        boolean sw = false;
        String ide;
        try {
            Paciente objP = new Paciente();
            int tamaño = objArch.contadorLineas(ruta);
            objArch.abrirModoLectura(ruta);
            Paciente vPac[] = new Paciente[tamaño];
            vPac = objArch.leerP();//retorna el vector tipo objeto y se le asigna al vector definido en esta clase
            int i = 0;
            int cantRegistros = objArch.contadorLineas(ruta);
            while (i <= cantRegistros) {
                objP = vPac[i];
                ide = objP.getId();
                if (ide.equals(id)) {
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
        Paciente objP = new Paciente();
        int tamaño;
        try {
            tamaño = objArch.contadorLineas(ruta);
            Paciente vPac[] = new Paciente[tamaño];
            objArch.abrirModoLectura(ruta);

            vPac = objArch.leerP();//retorna el vector tipo objeto y se le asigna al definido en esta clase
            int i = 0;
            int suma = 0;
            int cantRegistros = objArch.contadorLineas(ruta);

            while (i <= cantRegistros)//mientras no llegue hasta la última línea del archivo
            {
                objP = vPac[i];


                cadena = cadena + "[ " + objP.toString() + " ]\n";//se anexan cada registro a la cadena
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
        String ni;
        try {
            int tamaño = objArch.contadorLineas(ruta);
            Paciente vPac[] = new Paciente[tamaño];
            Paciente objP = new Paciente();
            objArch.abrirModoLectura(ruta);
            vPac = objArch.leerP();//retorna el vector tipo objeto y se le asigna al vector definido en esta clase
            int i = 0;
            int cantRegistros = objArch.contadorLineas(ruta);
            while (i <= cantRegistros) //mientras no llegue hasta la última línea del archivo
            {
                objP = vPac[i];
                ni = objP.getId();
                if (ni.equals(id)) {
                    cadena = cadena + "[ " + objP.toString() + " ]\n";

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

    public void grabarActualizacion(Paciente[] vPac, Validaciones.Archivo objArchCopy, String ruta) {
        Paciente objP;
        objArchCopy.eliminaArchivo(ruta); // se elimina el archivo original
        for (int i = 0; i < vPac.length; i++) {
            objArchCopy.abrirModoEscritura(ruta);
            objP = vPac[i];
            String texto = "";
            texto = objP.EstructuraReg();//con este metodo se da la estructura al registro
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
                Paciente objP = new Paciente();
                Paciente vPac[] = new Paciente[cantLineas];
                // Hospital vReg[];
                vPac = objArchivos.leerP();//Almacenamos cada registro del archivo en un vector tipo hospital
                int i = 0, cont = 0;
                while (i < cantLineas) {
                    objP = vPac[i];
                    iden = objP.getId();
                    if (!iden.equals(id)) {
                        cont += 1;
                    }
                    i++;
                }
                Paciente vReg[];
                vReg = new Paciente[cont];

                if (cont == 0) {
                    cadena = "No hay registro a imprimir";
                } else {
                    i = 0;
                    int c = 0;
                    while (i < cantLineas) {
                        objP = vPac[i];
                        iden = objP.getId();
                        if (!iden.equals(id)) {
                            vReg[c] = objP;
                            System.out.println("***vector en la posición *****" + vReg[c].toString());
                            c = c + 1;
                            sw = true;
                        } else {
                            cadena = cadena + "[ " + objP.toString() + " ]\n";
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
        String id2, nombre, apellido, idmed;
        int edad, estrato;
        double Copago;
        objArchivos.abrirModoLectura(ruta);
        int op;
        if (objArchivos.archivo.exists() == true) {
            int cantLineas = objArchivos.contadorLineas(ruta);
            Paciente vPac[] = new Paciente[cantLineas];
            try {
                boolean sw = false;
                int regV = 0;
                Paciente objP = new Paciente();
                vPac = objArchivos.leerP();//Almacenamos cada registro del archivo en un vector tipo hospital
                int i = 0;
                while (i < cantLineas) {
                    objP = vPac[i];
                    id2 = objP.getId();
                    nombre = objP.getNombre();
                    apellido = objP.getApellido();
                    edad = objP.getEdad();
                    idmed = objP.getIdMedico();
                    estrato = objP.getEstSocial();
                    Copago = objP.getCopago();
                    if (id2.equals(id)) {
                        sw = true;
                        System.out.println("Se actualizará el registro cuyo valor de id es: " + id);
                        do {
                            op = leerEntero(" 1. id, 2. Nombre, 3.Apellido, 4. Edad, 5. Id Médico, 6. Estrato, 7. copago, 8. Terminar");
                            switch (op) {
                                case 1:
                                    id = leerString("Ingrese el nuevo id del paciente: ");
                                    break;
                                case 2:
                                    nombre = leerString("Ingrese el nuevo nombre del paciente: ");
                                    break;
                                case 3:
                                    apellido = leerString("Ingrese el nuevo apellido del paciente: ");
                                    break;
                                case 4:
                                    edad = leerEntero("Ingrese la nueva edad del paciente: ");
                                    break;
                                case 5:
                                    idmed = leerString("Ingrese el id del médico del paciente: ");
                                    break;
                                case 6:
                                    estrato = leerEntero("Ingrese el nuevo estrato del paciente: ");
                                    break;
                                case 7:
                                    Copago = leerReal("Ingrese el nuevo copago del paciente: ");
                                    break;

                            }
                        } while (op < 7);
                        objP = new Paciente(id, nombre, apellido, edad, estrato, idmed, Copago);
                        vPac[i] = objP;
                        System.out.println(" registro actualizado" + objP.toString());
                    } else {
                        vPac[i] = objP;
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
            grabarActualizacion(vPac, objArchivos, ruta);
        } else {
            System.out.println("No existe un archivo para actualizar");
        }

    }
}
