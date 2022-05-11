package eps.fv.Hospital;

import eps.fv.Hospital.Hospital;
import eps.fv.Medico.Medico;
import eps.fv.Validaciones;

import javax.swing.*;

import static eps.fv.Validaciones.*;

public class CRUDHospital {
    //constructor void
    public CRUDHospital() {
    }//fin 

    /*recibe el nit y el objeto archivo, el nit lo busca, si no lo encuentra, lee los
    demás datos y graba el hospital*/
    public void IngresarHospital(Validaciones.Archivo objArchivo, String nit, String ruta) {
        Hospital objH = new Hospital();
        if (Buscar(objArchivo, nit, ruta) == false)//si no lo encuentra
        {
            objH = objH.lecturaDatos(nit);//lee toda la informacion y recibe el objeto
            Grabar(objArchivo, objH, ruta);  //metodo que graba fisicamente el registro en memoria
        } else {
            System.out.println("*****Hospital YA existe en el archivo*****");
        }//Fin if
    }//fin  de ingresar Hospital

    public void Grabar(Validaciones.Archivo objArchivos, Hospital objH, String ruta) {
        String texto = "";
        objArchivos.abrirModoEscritura(ruta);
        texto = objH.EstructuraReg();//con este metodo se da la estructura al registro
        objArchivos.escribir(texto); //se graba o escribe o imprime el registro fisicamente en el archivo
        objArchivos.cerrarModoEscritura();
    }//fin  GrabarHospital

    public void grabarActualizacion(Hospital[] vHos, Validaciones.Archivo objArchCopy, String ruta) {
        Hospital objH;
        objArchCopy.eliminaArchivo(ruta); // se elimina el archivo original
        for (int i = 0; i < vHos.length; i++) {
            objArchCopy.abrirModoEscritura(ruta);
            objH = vHos[i];
            String texto = "";
            texto = objH.EstructuraReg();//con este metodo se da la estructura al registro
            System.out.println("a ver que imprime por aquí:" + texto);
            objArchCopy.escribir(texto); //se graba o escribe o imprime el registro fisicamente en el archivo
            objArchCopy.cerrarModoEscritura();
        }

    } //fin  GrabarHospital    */

    public String Mostrar_Optimizado(Validaciones.Archivo ObjArchivo) {
        int i = 0;
        int cant = 0;
        int tamano = 0;
        String info = "";
        try {
            Hospital VHos[] = new Hospital[tamano];
            ObjArchivo.abrirModoLectura("Hospitales.txt");
            VHos = ObjArchivo.leerH();

            Hospital objH = new Hospital();
            for (i = 0; i < VHos.length; i++) {
                objH = VHos[i];
                info = info + "[" + objH.toString() + "]\n";

            }
            ObjArchivo.cerrarModoLectura();

        } catch (Exception e) {
            System.out.println("***Archivo leído y cerrado correctamente*****");
        }
        return info;


    }

    public String Mostrar(Validaciones.Archivo objArch, String ruta) {
        String cadena = "";//cadena para el almacenamiento de todos los registros
        String cadena2 = "";
        Hospital objH = new Hospital();
        int tamaño;
        try {
            tamaño = objArch.contadorLineas(ruta);
            Hospital vHos[] = new Hospital[tamaño];
            objArch.abrirModoLectura(ruta);

            vHos = objArch.leerH();//retorna el vector tipo objeto y se le asigna al definido en esta clase
            int i = 0;
            int suma = 0;
            int cantRegistros = objArch.contadorLineas(ruta);

            while (i <= cantRegistros)//mientras no llegue hasta la última línea del archivo
            {
                objH = vHos[i];


                cadena = cadena + "[ " + objH.toString() + " ]\n";//se anexan cada registro a la cadena
                i++;
            }//fin mientras */


            objArch.cerrarModoLectura();

        } catch (Exception e) {
            System.out.println("***Archivo leído y cerrado correctamente*****");
        }
        return cadena;
    }//fin de mostrar productos

    public int cantidadMedicos(Validaciones.Archivo objArch) {
        int cant = 0;
        int tamaño = 0;
        Hospital vHos[] = new Hospital[tamaño];
        objArch.abrirModoLectura("Hospitales.txt");

        vHos = objArch.leerH();//retorna el vector tipo objeto y se le asigna al definido en esta clase
        for (int i = 0; i < vHos.length; i++) {
            cant += vHos[i].getNumMed();
        }
        return cant;
    }


    public String infoHospitales1y2(Validaciones.Archivo objArch) {
        int i = 0;
        int cant = 0;
        int tamaño = 0;
        Hospital vHos[] = new Hospital[tamaño];
        objArch.abrirModoLectura("Hospitales.txt");

        vHos = objArch.leerH();//retorna el vector tipo objeto y se le asigna al definido en esta clase
        String info = "";
        Hospital objH = new Hospital();

        for (i = 0; i < vHos.length; i++) {
            objH = vHos[i];
            if ((vHos[i].getEstSocial() == 1) || (vHos[i].getEstSocial() == 2)) {
                // info = vHos.toString();
                info = info + "[ " + objH.toString() + " ]\n";
            }
        }
        return info;
    }

    public double NominaTotal(Validaciones.Archivo objArch) {
        int tamaño = 0;
        Hospital vHos[] = new Hospital[tamaño];
        objArch.abrirModoLectura("Hospitales.txt");

        vHos = objArch.leerH();//retorna el vector tipo objeto y se le asigna al definido en esta clase
        double cant = 0;
        for (int i = 0; i < vHos.length; i++) {
            cant += vHos[i].getNominaBasTotal();
        }
        return cant;
    }


    public String HospitalCompararcantidad(Validaciones.Archivo objArch) {
        String cadena = "";//cadena para el almacenamiento de todos los registros
        String cadena2 = "";
        Hospital objH = new Hospital();
        int tamaño;
        int suma = 0;
        try {
            tamaño = objArch.contadorLineas("Hospitales.txt");
            Hospital vHos[] = new Hospital[tamaño];
            objArch.abrirModoLectura("Hospitales.txt");

            vHos = objArch.leerH();//retorna el vector tipo objeto y se le asigna al definido en esta clase
            int i = 0;

            int cantRegistros = objArch.contadorLineas("Hospitales.txt");

            while (i <= cantRegistros)//mientras no llegue hasta la última línea del archivo
            {
                objH = vHos[i];


                for (i = 0; i < vHos.length; i++) {
                    if (vHos[i].getNumMed() > 1 && vHos[i].getNumMed() <= 5) {
                        cadena = cadena + "[ " + objH.toString() + " ]\n";


                    }
                }
            }//fin mientras */


            objArch.cerrarModoLectura();

        } catch (Exception e) {
            System.out.println("***Archivo leído y cerrado correctamente*****");
        }
        return cadena;

    }

    public String Consultar(Validaciones.Archivo objArch, String nt, String ruta) {
        String cadena = "";
        String ni;
        try {
            int tamaño = objArch.contadorLineas(ruta);
            Hospital vHos[] = new Hospital[tamaño];
            Hospital objH = new Hospital();
            objArch.abrirModoLectura(ruta);
            vHos = objArch.leerH();//retorna el vector tipo objeto y se le asigna al vector definido en esta clase
            int i = 0;
            int cantRegistros = objArch.contadorLineas(ruta);
            while (i <= cantRegistros) //mientras no llegue hasta la última línea del archivo
            {
                objH = vHos[i];
                ni = objH.getNit();
                if (ni.equals(nt)) {
                    cadena = cadena + "[ " + objH.toString() + " ]\n";

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

/*OJO este metodo solo retorna falso o verdadero en caso de encontrar el nit del 
hospital que estamos buscando NO DEJA NINGUNA MARCA O APINTADOR EN EL REGISTRO
solo averigua si el hospital esta o no en el archivo*/

    public boolean Buscar(Validaciones.Archivo objArch, String nt, String ruta) {
        boolean sw = false;
        String ni;
        try {
            Hospital objH = new Hospital();
            int tamaño = objArch.contadorLineas(ruta);
            objArch.abrirModoLectura(ruta);
            Hospital vHos[] = new Hospital[tamaño];
            vHos = objArch.leerH();//retorna el vector tipo objeto y se le asigna al vector definido en esta clase
            int i = 0;
            int cantRegistros = objArch.contadorLineas(ruta);
            while (i <= cantRegistros) {
                objH = vHos[i];
                ni = objH.getNit();
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

    public void Actualizar(Validaciones.Archivo objArchivos, String nt, String ruta) {
        String ni, dire, nom;
        int estSoc, nm;
        double ppto;
        objArchivos.abrirModoLectura(ruta);
        int op;
        if (objArchivos.archivo.exists() == true) {
            int cantLineas = objArchivos.contadorLineas(ruta);
            Hospital vHos[] = new Hospital[cantLineas];
            try {
                boolean sw = false;
                int regV = 0;
                Hospital objH = new Hospital();
                vHos = objArchivos.leerH();//Almacenamos cada registro del archivo en un vector tipo hospital
                int i = 0;
                while (i < cantLineas) {
                    objH = vHos[i];
                    ni = objH.getNit();
                    nom = objH.getNombre();
                    estSoc = objH.getEstSocial();
                    ppto = objH.getPresupuesto();
                    dire = objH.getDireccion();
                    nm = objH.getNumMed();
                    if (ni.equals(nt)) {
                        sw = true;
                        System.out.println("Se actualizará el registro cuyo valor de NIT es: " + nt);
                        do {
                            op = leerEntero(" 1. Nombre, 2. Estrato social legal de 1 a 6, 3.Presupuesto, 4. Dirección, 5. Número de   médicos de este hospital 6. Terminar");
                            switch (op) {
                                case 1:
                                    nom = leerString("Ingrese el nuevo nombre del hospital: ");
                                    break;
                                case 2:
                                    estSoc = leerEstrato("Ingrese el nuevo Estrato Social del hospital: ");
                                    break;
                                case 3:
                                    ppto = leerReal("Ingrese el nuevo presupuesto del hospital: ");
                                    break;
                                case 4:
                                    dire = leerString("Ingrese la nueva dirección del hospital: ");
                                    break;
                                case 5:
                                    nm = leerEstrato("Ingrese la nueva cantidad de médicos: ");
                                    break;
                            }
                        } while (op < 6);
                        objH = new Hospital(nt, nom, dire, nm, estSoc, ppto);
                        vHos[i] = objH;
                        System.out.println(" registro actualizado" + objH.toString());
                    } else {
                        vHos[i] = objH;
                    }
                    i++;
                }
                if (sw == false) {
                    System.out.println("El Hospital No existe");
                }
                objArchivos.cerrarModoEscritura();
            } catch (Exception e) {
                System.out.println("***Archivo leido y cerrado correctamente*****");
                objArchivos.cerrarModoEscritura();
            }
            grabarActualizacion(vHos, objArchivos, ruta);
        } else {
            System.out.println("No existe un archivo para actualizar");
        }

    }

    public String Eliminar(Validaciones.Archivo objArchivos, String nt, String ruta) {
        String ni;
        String cadena = "";
        objArchivos.abrirModoLectura(ruta);
        int op;
        if (objArchivos.archivo.exists() == true) {
            int cantLineas = objArchivos.contadorLineas(ruta);

            try {
                boolean sw = false;
                // int regV = 0;
                Hospital objH = new Hospital();
                Hospital vHos[] = new Hospital[cantLineas];
                // Hospital vReg[];
                vHos = objArchivos.leerH();//Almacenamos cada registro del archivo en un vector tipo hospital
                int i = 0, cont = 0;
                while (i < cantLineas) {
                    objH = vHos[i];
                    ni = objH.getNit();
                    if (!ni.equals(nt)) {
                        cont += 1;
                    }
                    i++;
                }
                Hospital vReg[];
                vReg = new Hospital[cont];

                if (cont == 0) {
                    cadena = "No hay registro a imprimir";
                } else {
                    i = 0;
                    int c = 0;
                    while (i < cantLineas) {
                        objH = vHos[i];
                        ni = objH.getNit();
                        if (!ni.equals(nt)) {
                            vReg[c] = objH;
                            System.out.println("***vector en la posición *****" + vReg[c].toString());
                            c = c + 1;
                            sw = true;
                        } else {
                            cadena = cadena + "[ " + objH.toString() + " ]\n";
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
            System.out.println("No existe un archivo en el cual se pueda eliminar el regisro");
        }
        return cadena;
    }


}//fin clase crud
