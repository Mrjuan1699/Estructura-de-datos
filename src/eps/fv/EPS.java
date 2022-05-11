
package eps.fv;

import eps.fv.Hospital.*;
import eps.fv.Medico.*;
import eps.fv.Paciente.CRUDPaciente;
import eps.fv.Paciente.ColasP;
import eps.fv.Paciente.ListaCircularP;
import eps.fv.Paciente.PilasP;

import java.util.Scanner;

public class EPS {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int referencia= 0, posicion=0,opH, opE, opM, opP, opPila, opPrin, opPilaH, opPilaM, opPilaP, opColas, opColaMedico, opColaPaciente, opMenuColas, opArcPila, opLCH, opMenuLC,opLCM,opLCP;
        String nit, nom, id;
        String rutah = "Hospitales.txt";
        String rutam = "Medicos.txt";
        String rutaP = "Pacientes.txt";

        Hospital objHos, objH;
        objHos = new Hospital();
        Medico objMed, objM;
        objMed = new Medico();
        /*Archivo de hospital*/
        Validaciones.Archivo objArchivo = new Validaciones.Archivo();
        CRUDHospital crud = new CRUDHospital();
        CRUDMedico crudM = new CRUDMedico();
        CRUDPaciente crudP = new CRUDPaciente();
        EPS obj = new EPS();
        PilasH pilaH = new PilasH();
        PilasM pilaM = new PilasM();
        PilasP pilaP = new PilasP();
        ColasH colaH = new ColasH();
        ColasM colaM = new ColasM();
        ColasP colaP = new ColasP();
        ListaCircularH ListaCircularH = new ListaCircularH();
        ListaCircularM ListaCircularM = new ListaCircularM();
        ListaCircularP ListaCircularP = new ListaCircularP();


        do {

            String MenuPrincipal = """
                    Menú principal
                    1. Menú Archivos
                    2. Menú Pilas
                    3. Menú Colas
                    4. Convertir
                    5. Menú Listas circulares
                    6. Salir
                    """;

            String MenuPilas = """
                    Menú pilas
                    1. Menú Hospital
                    2. Menú Médico
                    3. Menú Paciente
                    4. Salir
                    """;

            String MenuColas = """
                    Menú Colas
                    1. Menú Hospital
                    2. Menú Médico
                    3. Menú Paciente
                    4. Salir
                    """;


            String MenuEPS = """
                     Menú archivos
                    1. Menú Hospital.
                    2. Menú Médico.
                    3. Menú Paciente.
                    4. Salir.
                    """;

            String MenuHospital = """
                        Menú hospital
                    1. Ingresar un hospital
                    2. Imprimir todo el Archivo
                    3. Consultar Hospital
                    4. Eliminar un registro
                    5. actualizar un registro
                    6. Cambiar nombre al archivo
                    7. Eliminar un archivo
                    8. Finalizar Menu
                    """;

            String MenuMedico = """
                        Menú médico
                    1. Ingresar un médico
                    2. Imprimir todo el Archivo
                    3. Consultar médico
                    4. Eliminar un registro
                    5. actualizar un registro
                    6. Cambiar nombre al archivo
                    7. Eliminar un archivo
                    8. Finalizar Menu
                    """;

            String MenuPaciente = """
                        Menpu paciente
                    1. Ingresar un paciente
                    2. Imprimir todo el Archivo
                    3. Consultar paciente
                    4. Eliminar un registro
                    5. actualizar un registro
                    6. Cambiar nombre al archivo
                    7. Eliminar un archivo
                    8. Finalizar Menu
                    """;


            String MenuHospitalCola = """
                     Menú hospital
                    1. Ingresar un hospital
                    2. Mostrar hospitales
                    3. Consultar Hospital
                    4. Desencolar
                    5. Mostrar último hospital ingresado
                    6. Vaciar cola
                    7. Actualizar Registro
                    8. Finalizar Menu
                    """;

            String MenuMedicoCola = """
                     Menú médico
                    1. Ingresar un médico
                    2. Mostrar médicos
                    3. Consultar médico
                    4. Desencolar
                    5. Mostrar último médico ingresado
                    6. Vaciar cola
                    7. Actualizar Registro
                    8. Finalizar Menu
                    """;

            String MenuPacienteCola = """
                     Menú paciente
                    1. Ingresar un paciente
                    2. Mostrar pacientes
                    3. Consultar paciente
                    4. Desencolar
                    5. Mostrar último paciente ingresado
                    6. Vaciar cola
                    7. Actualizar Registro
                    8. Finalizar Menu
                    """;

            String MenuHospitalPila = """
                     Menú hospital
                    1. Ingresar un hospital
                    2. Mostrar hospitales
                    3. Consultar Hospital
                    4. Desapilar
                    5. Mostrar último hospital ingresado
                    6. Vaciar pila
                    7. Actualizar Registro
                    8. Finalizar Menu
                    """;

            String MenuMedicoPila = """
                     Menú médico
                    1. Ingresar un médico
                    2. Mostrar médicos
                    3. Consultar médicos
                    4. Desapilar
                    5. Mostrar último médico ingresado
                    6. Vaciar pila
                    7. Actualizar Registro
                    8. Finalizar Menu
                    """;

            String MenuPacientePila = """
                     Menú paciente
                    1. Ingresar un Paciente
                    2. Mostrar Pacientes
                    3. Consultar Paciente
                    4. Desapilar
                    5. Mostrar último paciente ingresado
                    6. Vaciar pila
                    7. Actualizar Registro
                    8. Finalizar Menu
                    """;

            String MenuLC = """
                    Menú principal
                    1. Menú hospital
                    2. Menú médico
                    3. Menú paciente
                    4. Salir
                    """;

            String MenuHospitalLC = """
                    Menú Hospital
                    1. Ingresar hospital por inicio.
                    2. Ingresar hospital por final.
                    3. Ingresar por referencia.
                    4. Ingresar por posición.
                    5. Mostrar por posición.
                    6. Obtener posición.
                    7. Actualizar por referencia.
                    8. Actualizar por posición.
                    9. Eliminar por referencia.
                    10. Eliminar por posición.
                    11. Eliminar la lista.
                    12. Listar.
                    13. Salir
                    """;

            String MenuMedicoLC = """
                    Menú médico
                    1. Ingresar médico por inicio.
                    2. Ingresar médico por final.
                    3. Ingresar por referencia.
                    4. Ingresar por posición.
                    5. Mostrar por posición.
                    6. Obtener posición.
                    7. Actualizar por referencia.
                    8. Actualizar por posición.
                    9. Eliminar por referencia.
                    10. Eliminar por posición.
                    11. Eliminar la lista.
                    12. Listar.
                    13. Salir
                    """;

            String MenuPacienteLC = """
                    Menú paciente
                    1. Ingresar paciente por inicio.
                    2. Ingresar paciente por final.
                    3. Ingresar por referencia.
                    4. Ingresar por posición.
                    5. Mostrar por posición.
                    6. Obtener posición.
                    7. Actualizar por referencia.
                    8. Actualizar por posición.
                    9. Eliminar por referencia.
                    10. Eliminar por posición.
                    11. Eliminar la lista.
                    12. Listar.
                    13. Salir
                    """;

            String ConvertirPilaArchivo = """
                    1. Convertir pila Hospital a archivo hospital.
                    2. Convertir pila médico a archivo médico.
                    3. Convertir pila paciente a archivo paciente.
                    4. Salir.
                    """;

            opPrin = Validaciones.leerEntero(MenuPrincipal);
            switch (opPrin) {
                case 1:
                    do {
                        opE = Validaciones.leerEntero(MenuEPS);
                        switch (opE) {
                            case 1:
                                do {
                                    opH = Validaciones.leerEntero(MenuHospital);
                                    switch (opH) {
                                        case 1: //ok
                                            crud.Mostrar_Optimizado(objArchivo);
                                            System.out.println("*******************************************\n");
                                            System.out.println("Digite el NIT del hospital a ingresar: ");
                                            nit = sc.next();
                                            crud.IngresarHospital(objArchivo, nit, rutah);
                                            break;
                                        case 2: //ok
                                            System.out.println("*******************************************\n");
                                            System.out.println("Los Registros del Archivo Hospital son: \n" + crud.Mostrar_Optimizado(objArchivo));
                                            //Muestra la nominabasetotal System.out.println(crud.NominaTotal(objArchivo));
                                            //Muestra la suma de medicos System.out.println(crud.cantidadMedicos(objArchivo));
                                            //Muestra los hospitales con estrado 1 y 2 System.out.println(crud.infoHospitales1y2(objArchivo));
                                            break;
                                        case 3: // ok
                                            System.out.println("*******************************************\n");
                                            System.out.println("Digite el NIT del hospital a consultar: ");
                                            nit = sc.nextLine();
                                            System.out.println("El Hospital es: " + crud.Consultar(objArchivo, nit, rutah));
                                            break;
                                        case 4: //ok
                                            System.out.println("*******************************************\n");
                                            System.out.println("Digite el NIT del hospital que desea eliminar: ");
                                            nit = sc.nextLine();
                                            System.out.println("El registro a Eliminar es: \n" + crud.Eliminar(objArchivo, nit, rutah));
                                            break;
                                        case 5: //ok
                                            System.out.println("*******************************************\n");
                                            System.out.println("Digite el NIT del hospital que desea actualizar: ");
                                            nit = sc.nextLine();
                                            crud.Actualizar(objArchivo, nit, rutah);
                                            break;
                                        case 6: //pendiente
                                            System.out.println("*******************************************\n");
                                            System.out.println("Ingrese el nuevo nombre del archivo: ");
                                            nom = sc.nextLine();
                                            // nom = nom +".txt";
                                            objArchivo.renombrarArchivo(nom + ".txt", rutah);
                                            break;
                                        case 7:
                                            //objArchivo.eliminaArchivo(rutah);
                                            break;
                                        case 8:
                                            System.out.println("Saliendo");
                                            break;

                                        default:
                                            System.out.println("Opción incorrecta.");
                                            break;

                                    }

                                } while (opH != 8);

                                break;
                            case 2:
                                do {
                                    opM = Validaciones.leerEntero(MenuMedico);
                                    switch (opM) {
                                        case 1 -> {
                                            crudM.Mostrar_Optimizado(objArchivo);
                                            System.out.println("*******************************************\n");
                                            System.out.println("Digite el Id del médico a ingresar: ");
                                            id = sc.next();
                                            crudM.IngresarMedico(objArchivo, id, rutam);
                                        }
                                        case 2 -> {
                                            System.out.println("*******************************************\n");
                                            //System.out.println("Los Registros del Archivo médico son: \n" + crudM.Mostrar(objArchivo, rutam)+ "\n");
                                            System.out.println("Los Registros del Archivo médico son: \n" + crudM.Mostrar_Optimizado(objArchivo) + "\n");
                                            System.out.println("Los médicos con salario menor a $5.000.000 y mayores de 27 años son: \n" +
                                                    crudM.Parcial(objArchivo));
                                            String infor = crudM.Parcial(objArchivo);
                                            crudM.Grabar_Parcial(objArchivo, infor);
                                        }
                                        case 3 -> {
                                            System.out.println("*******************************************\n");
                                            System.out.println("Digite el Id del médico a consultar: ");
                                            id = sc.nextLine();
                                            System.out.println("El Médico es: " + crudM.Consultar(objArchivo, id, rutam));
                                        }
                                        case 4 -> {
                                            System.out.println("*******************************************\n");
                                            System.out.println("Digite el Id del médico que desea eliminar: ");
                                            id = sc.nextLine();
                                            System.out.println("El registro a Eliminar es: \n" + crudM.Eliminar(objArchivo, id, rutam));
                                        }
                                        case 5 -> {
                                            System.out.println("*******************************************\n");
                                            System.out.println("Digite el id del médico que desea actualizar: ");
                                            id = sc.nextLine();
                                            crudM.Actualizar(objArchivo, id, rutam);
                                        }
                                        case 6 -> {
                                            System.out.println("*******************************************\n");
                                            System.out.println("Ingrese el nuevo nombre del archivo: ");
                                            nom = sc.nextLine();
                                            // nom = nom +".txt";
                                            objArchivo.renombrarArchivo(nom + ".txt", rutam);
                                        }
                                        case 7 -> objArchivo.eliminaArchivo(rutam);
                                        case 8 -> System.out.println("Saliendo");
                                        default -> System.out.println("Opción incorrecta");
                                    }
                                } while (opM != 8);
                                break;
                            case 3:
                                do {
                                    opP = Validaciones.leerEntero(MenuPaciente);
                                    switch (opP) {
                                        case 1 -> {
                                            crudP.Mostrar(objArchivo, rutaP);
                                            System.out.println("*******************************************\n");
                                            System.out.println("Digite el Id del paciente a ingresar: ");
                                            id = sc.nextLine();
                                            crudP.IngresarMedico(objArchivo, id, rutaP);
                                        }
                                        case 2 -> {
                                            System.out.println("*******************************************\n");
                                            System.out.println("Los Registros del Archivo paciente son: \n" + crudP.Mostrar(objArchivo, rutaP));
                                        }
                                        case 3 -> {
                                            System.out.println("*******************************************\n");
                                            System.out.println("Digite el Id del médico a consultar: ");
                                            id = sc.nextLine();
                                            System.out.println("El Médico es: " + crudP.Consultar(objArchivo, id, rutaP));
                                        }
                                        case 4 -> {
                                            System.out.println("*******************************************\n");
                                            System.out.println("Digite el Id del médico que desea eliminar: ");
                                            id = sc.nextLine();
                                            System.out.println("El registro a Eliminar es: \n" + crudP.Eliminar(objArchivo, id, rutaP));
                                        }
                                        case 5 -> {
                                            System.out.println("*******************************************\n");
                                            System.out.println("Digite el id del médico que desea actualizar: ");
                                            id = sc.nextLine();
                                            crudP.Actualizar(objArchivo, id, rutaP);
                                        }
                                        case 6 -> {
                                            System.out.println("*******************************************\n");
                                            System.out.println("Ingrese el nuevo nombre del archivo: ");
                                            nom = sc.nextLine();
                                            // nom = nom +".txt";
                                            objArchivo.renombrarArchivo(nom + ".txt", rutaP);
                                        }
                                        case 7 -> objArchivo.eliminaArchivo(rutaP);
                                        case 8 -> System.out.println("Saliendo");
                                        default -> System.out.println("Opción incorrecta");
                                    }
                                } while (opP != 8);
                                break;

                            case 4:
                                System.out.println("Saliendo.");
                                break;

                            default:
                                System.out.println("Opción incorrecta.");
                                break;
                        }
                    } while (opE != 4);
                    break;

                case 2:
                    do {
                        opPila = Validaciones.leerEntero(MenuPilas);
                        switch (opPila) {
                            case 1:

                                do {
                                    opPilaH = Validaciones.leerEntero(MenuHospitalPila);
                                    switch (opPilaH) {
                                        case 1 -> {
                                            System.out.println("Ingrese el nit del hospital: ");
                                            nit = sc.next();
                                            pilaH.InsertarNodo(nit);
                                        }
                                        case 2 -> pilaH.MostrarValores();
                                        case 3 -> {
                                            System.out.println("Ingrese el nombre del hospital: ");
                                            String nombre = sc.next();
                                            pilaH.buscarPorNombre(nombre);
                                        }
                                        case 4 -> pilaH.EliminarNodoVaciarPila();
                                        case 5 -> System.out.println(pilaH.MostrarUltimoDatoIngresado());
                                        case 6 -> pilaH.VaciarPila();
                                        case 7 -> {
                                            System.out.println("Ingrese el nit del hospital a actualizar: ");
                                            nit = sc.next();
                                            pilaH.Actualizar(nit);
                                        }
                                        default -> System.out.println("Opción incorrecta.");
                                    }

                                } while (opPilaH != 8);

                                break;

                            case 2:
                                do {
                                    opPilaM = Validaciones.leerEntero(MenuMedicoPila);
                                    switch (opPilaM) {
                                        case 1 -> {
                                            System.out.println("Ingrese el id del médico: ");
                                            id = sc.next();
                                            pilaM.InsertarNodo(id);
                                        }
                                        case 2 -> pilaM.MostrarValores();
                                        case 3 -> {
                                            System.out.println("Ingrese el nombre del médico: ");
                                            String nombre = sc.next();
                                            pilaM.buscarPorNombre(nombre);
                                        }
                                        case 4 -> pilaM.EliminarNodoVaciarPila();
                                        case 5 -> System.out.println(pilaM.MostrarUltimoDatoIngresado());
                                        case 6 -> pilaM.VaciarPila();
                                        case 7 -> {
                                            System.out.println("Ingrese el id del médico a actualizar: ");
                                            id = sc.next();
                                            pilaM.Actualizar(id);
                                        }
                                        default -> System.out.println("Opción incorrecta.");
                                    }

                                } while (opPilaM != 8);
                                break;
                            case 3:
                                do {
                                    opPilaP = Validaciones.leerEntero(MenuPacientePila);
                                    switch (opPilaP) {
                                        case 1 -> {
                                            System.out.println("Ingrese el id del paciente: ");
                                            id = sc.next();
                                            pilaP.InsertarNodo(id);
                                        }
                                        case 2 -> pilaP.MostrarValores();
                                        case 3 -> {
                                            System.out.println("Ingrese el nombre del paciente: ");
                                            String nombre = sc.next();
                                            pilaP.buscarPorNombre(nombre);
                                        }
                                        case 4 -> pilaP.EliminarNodoVaciarPila();
                                        case 5 -> System.out.println(pilaP.MostrarUltimoDatoIngresado());
                                        case 6 -> pilaP.VaciarPila();
                                        case 7 -> {
                                            System.out.println("Ingrese el id del paciente a actualizar: ");
                                            id = sc.next();
                                            pilaP.Actualizar(id);
                                        }
                                        default -> System.out.println("Opción incorrecta.");
                                    }

                                } while (opPilaP != 8);


                                break;
                            case 4:
                                System.out.println("Saliendo.");
                                break;
                            default:
                                System.out.println("Opción incorrecta.");
                                break;

                        }

                    } while (opPila != 4);

                    break;

                case 3:
                    do {
                        opMenuColas = Validaciones.leerEntero(MenuColas);
                        switch (opMenuColas) {
                            case 1:
                                do {
                                    opColas = Validaciones.leerEntero(MenuHospitalCola);
                                    switch (opColas) {
                                        case 1 -> {
                                            System.out.println("Ingrese el nit del hospital: ");
                                            nit = sc.next();
                                            colaH.Insertar(nit);
                                        }
                                        case 2 -> colaH.imprimirCola();
                                        case 3 -> {
                                            System.out.println("Ingrese el nombre del hospital: ");
                                            String nombre = sc.next();
                                            colaH.buscarPorNombre(nombre);
                                        }
                                        case 4 -> System.out.println(colaH.desencolar());
                                        case 5 -> System.out.println(colaH.MostrarUltimoDatoIngresado());
                                        case 6 -> colaH.VaciarCola();
                                        case 7 -> {
                                            System.out.println("Ingrese el nit del hopsital a actualizar: ");
                                            nit = sc.next();
                                            colaH.Actualizar(nit);
                                        }
                                        default -> System.out.println("Opción incorrecta");
                                    }
                                } while (opColas != 8);
                                break;
                            case 2:
                                do {
                                    opColaMedico = Validaciones.leerEntero(MenuMedicoCola);
                                    switch (opColaMedico) {
                                        case 1 -> {
                                            System.out.println("Ingrese el id del médico: ");
                                            id = sc.next();
                                            colaM.Insertar(id);
                                        }
                                        case 2 -> colaM.imprimirCola();
                                        case 3 -> {
                                            System.out.println("Ingrese el id del médico: ");
                                            id = sc.next();
                                            colaM.buscarPorId(id);
                                        }
                                        case 4 -> System.out.println(colaM.desencolar());
                                        case 5 -> System.out.println(colaM.MostrarUltimoDatoIngresado());
                                        case 6 -> colaM.VaciarCola();
                                        case 7 -> {
                                            System.out.println("Ingrese el id del médico a actualizar: ");
                                            id = sc.next();
                                            colaM.Actualizar(id);
                                        }
                                        default -> System.out.println("Opción incorrecta");

                                    }
                                } while (opColaMedico != 8);
                                break;
                            case 3:
                                do {
                                    opColaPaciente = Validaciones.leerEntero(MenuPacienteCola);
                                    switch (opColaPaciente) {
                                        case 1 -> {
                                            System.out.println("Ingrese el id del paciente: ");
                                            id = sc.next();
                                            colaP.Insertar(id);
                                        }
                                        case 2 -> colaP.imprimirCola();
                                        case 3 -> {
                                            System.out.println("Ingrese el id del paciente: ");
                                            id = sc.next();
                                            colaP.buscarPorId(id);
                                        }
                                        case 4 -> System.out.println(colaP.desencolar());
                                        case 5 -> System.out.println(colaP.MostrarUltimoDatoIngresado());
                                        case 6 -> colaP.VaciarCola();
                                        case 7 -> {
                                            System.out.println("Ingrese el id del paciente a actualizar: ");
                                            id = sc.next();
                                            colaP.Actualizar(id);
                                        }
                                        default -> System.out.println("Opción incorrecta.");
                                    }
                                } while (opColaPaciente != 8);
                                break;
                        }
                    } while (opMenuColas != 4);

                    break;
                case 4:
                    do {
                        opArcPila = Validaciones.leerEntero(ConvertirPilaArchivo);
                        switch (opArcPila) {
                            case 1 -> {
                                pilaH.ConvertirPilaArchivo();
                                System.out.println("Se ha guardado la información de la pila en el archivo.");
                            }
                            case 2 -> {
                                pilaM.ConvertirPilaArchivo();
                                System.out.println("Se ha guardado la información de la pila en el archivo.");
                            }
                            case 3 -> {
                                pilaP.ConvertirPilaArchivo();
                                System.out.println("Se ha guardado la información de la pila en el archivo.");
                            }
                            case 4 -> System.out.println("Saliendo.");
                            default -> System.out.println("Opción incorrecta");
                        }
                    } while (opArcPila != 4);

                    break;
                case 5:
                    do {
                        opLCH = Validaciones.leerEntero(MenuLC);
                        switch (opLCH) {
                            case 1:
                                do {
                                    opLCH=Validaciones.leerEntero(MenuHospitalLC);
                                    switch (opLCH){
                                        case 1:
                                            ListaCircularH.IngresarAlInicio();
                                            break;
                                        case 2:
                                            ListaCircularH.IngresarAlFinal();
                                            break;
                                        case 3:
                                            referencia = Validaciones.leerEntero("Ingrese el nit del hospital: ");
                                            ListaCircularH.IngresarPorReferencia(ListaCircularH, referencia);
                                            break;
                                        case 4:
                                            posicion = Validaciones.leerEntero("Ingrese la posición donde quiere ingresar el hospital: ");
                                            ListaCircularH.IngresarPorPosicion(ListaCircularH, posicion);
                                            break;
                                        case 5:
                                            System.out.println("Ingrese la posición del hospital que quiere mostrar: ");
                                            posicion = sc.nextInt();
                                            System.out.println("-> " + ListaCircularH.getValor(ListaCircularH, posicion) + "\n");

                                            break;
                                        case 6:
                                            referencia = Validaciones.leerEntero("Ingrese el nit del hospital: ");
                                            System.out.println("El hospital con el nit: " + referencia + " está en la posición: " + ListaCircularH.obtenerPosicion(ListaCircularH, referencia) + "\n");
                                            break;
                                        case 7:
                                            referencia = Validaciones.leerEntero("Ingrese el nit del hospital: ");
                                            ListaCircularH.editarPorReferencia(ListaCircularH, referencia);
                                            break;
                                        case 8:
                                            System.out.println("Ingrese la posición del hospital que quiere mostrar: ");
                                            posicion = sc.nextInt();
                                            ListaCircularH.editarPorPosicion(ListaCircularH, posicion);
                                            break;
                                        case 9:
                                            referencia = Validaciones.leerEntero("Ingrese el nit del hospital que quiere eliminar: ");
                                            ListaCircularH.EliminarPorReferencia(ListaCircularH, referencia);
                                            break;
                                        case 10:
                                            System.out.println("Ingrese la posición del hospital que quiere eliminar: ");
                                            posicion = sc.nextInt();
                                            ListaCircularH.EliminarPorPosicion(ListaCircularH, posicion);
                                            break;
                                        case 11:
                                            ListaCircularH.eliminar();
                                            break;
                                        case 12:
                                            try {
                                                ListaCircularH.listar();
                                                System.out.println("\n");
                                            } catch (Exception e) {
                                                //Erro aki
                                            }
                                            break;
                                        case 13:
                                            System.out.println("Saliendo");
                                            break;
                                        default:
                                            System.out.println("Opción incorrecta.");
                                            break;
                                    }

                                }while(opLCH !=13);
                                break;

                            case 2:
                                do {
                                    opLCM= Validaciones.leerEntero(MenuMedicoLC);
                                    switch (opLCM){
                                        case 1:
                                            ListaCircularM.IngresarAlInicio();
                                            break;
                                        case 2:
                                            ListaCircularM.IngresarAlFinal();
                                            break;
                                        case 3:
                                            referencia = Validaciones.leerEntero("Ingrese el id del médico: ");
                                            ListaCircularM.IngresarPorReferencia(ListaCircularM, referencia);
                                            break;
                                        case 4:
                                            posicion = Validaciones.leerEntero("Ingrese la posición donde quiere ingresar el médico: ");
                                            ListaCircularM.IngresarPorPosicion(ListaCircularM, posicion);
                                            break;
                                        case 5:
                                            System.out.println("Ingrese la posición del médico que quiere mostrar: ");
                                            posicion = sc.nextInt();
                                            System.out.println("-> " + ListaCircularM.getValor(ListaCircularM, posicion) + "\n");

                                            break;
                                        case 6:
                                            referencia = Validaciones.leerEntero("Ingrese el id del médico: ");
                                            System.out.println("El médico con el id: " + referencia + " está en la posición: " + ListaCircularM.obtenerPosicion(ListaCircularM, referencia) + "\n");
                                            break;
                                        case 7:
                                            referencia = Validaciones.leerEntero("Ingrese el id del médico: ");
                                            ListaCircularM.editarPorReferencia(ListaCircularM, referencia);
                                            break;
                                        case 8:
                                            System.out.println("Ingrese la posición del médico que quiere mostrar: ");
                                            posicion = sc.nextInt();
                                            ListaCircularM.editarPorPosicion(ListaCircularM, posicion);
                                            break;
                                        case 9:
                                            referencia = Validaciones.leerEntero("Ingrese el id del médico que quiere eliminar: ");
                                            ListaCircularM.EliminarPorReferencia(ListaCircularM, referencia);
                                            break;
                                        case 10:
                                            System.out.println("Ingrese la posición del médico que quiere eliminar: ");
                                            posicion = sc.nextInt();
                                            ListaCircularM.EliminarPorPosicion(ListaCircularM, posicion);
                                            break;
                                        case 11:
                                            ListaCircularM.eliminar();
                                            break;
                                        case 12:
                                            try {
                                                ListaCircularM.listar();
                                                System.out.println("\n");
                                            } catch (Exception e) {
                                                //Erro aki
                                            }
                                            break;
                                        case 13:
                                            System.out.println("Saliendo");
                                            break;
                                        default:
                                            System.out.println("Opción incorrecta.");
                                            break;
                                    }

                                }while (opLCM !=13);
                                break;
                            case 3:
                                do {
                                    opLCP = Validaciones.leerEntero(MenuPacienteLC);
                                    switch (opLCP){
                                        case 1:
                                            ListaCircularP.IngresarAlInicio();
                                            break;
                                        case 2:
                                            ListaCircularP.IngresarAlFinal();
                                            break;
                                        case 3:
                                            referencia = Validaciones.leerEntero("Ingrese el id del paciente: ");
                                            ListaCircularP.IngresarPorReferencia(ListaCircularP, referencia);
                                            break;
                                        case 4:
                                            posicion = Validaciones.leerEntero("Ingrese la posición donde quiere ingresar el paciente: ");
                                            ListaCircularP.IngresarPorPosicion(ListaCircularP, posicion);
                                            break;
                                        case 5:
                                            System.out.println("Ingrese la posición del paciente que quiere mostrar: ");
                                            posicion = sc.nextInt();
                                            System.out.println("-> " + ListaCircularP.getValor(ListaCircularP, posicion) + "\n");

                                            break;
                                        case 6:
                                            referencia = Validaciones.leerEntero("Ingrese el id del paciente: ");
                                            System.out.println("El paciente con el id: " + referencia + " está en la posición: " + ListaCircularP.obtenerPosicion(ListaCircularP, referencia) + "\n");
                                            break;
                                        case 7:
                                            referencia = Validaciones.leerEntero("Ingrese el id del paciente: ");
                                            ListaCircularP.editarPorReferencia(ListaCircularP, referencia);
                                            break;
                                        case 8:
                                            System.out.println("Ingrese la posición del paciente que quiere mostrar: ");
                                            posicion = sc.nextInt();
                                            ListaCircularP.editarPorPosicion(ListaCircularP, posicion);
                                            break;
                                        case 9:
                                            referencia = Validaciones.leerEntero("Ingrese el id del paciente que quiere eliminar: ");
                                            ListaCircularP.EliminarPorReferencia(ListaCircularP, referencia);
                                            break;
                                        case 10:
                                            System.out.println("Ingrese la posición del paciente que quiere eliminar: ");
                                            posicion = sc.nextInt();
                                            ListaCircularP.EliminarPorPosicion(ListaCircularP, posicion);
                                            break;
                                        case 11:
                                            ListaCircularP.eliminar();
                                            break;
                                        case 12:
                                            try {
                                                ListaCircularP.listar();
                                                System.out.println("\n");
                                            } catch (Exception e) {
                                                //Erro aki
                                            }
                                            break;
                                        case 13:
                                            System.out.println("Saliendo");
                                            break;
                                        default:
                                            System.out.println("Opción incorrecta.");
                                            break;
                                    }

                                }while(opLCP !=13);

                                break;
                        }
                    } while (opLCH != 4);

                    break;

                case 6:
                    System.out.println("Saliendo.");
                    break;

                default:
                    System.out.println("Opción incorrecta.");
                    break;

            }

        } while (opPrin != 6);
    }
}
