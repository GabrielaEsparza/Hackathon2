package org.generation.hackathon;

import java.util.Scanner;
import org.generation.hackathon.contactos.Agenda;
import org.generation.hackathon.clases.Contacto;

public class Main {

    public static void main(String[] args) {
        Menu();
    }//main
    
    public static void Menu() {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();
        int opcion;

        do {
            System.out.println("\n===== AGENDA TELEFÓNICA =====");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Verificar si existe contacto");
            System.out.println("3. Listar contactos");
            System.out.println("4. Buscar contacto por nombre");
            System.out.println("5. Eliminar contacto");
            System.out.println("6. Ver si la agenda está llena");
            System.out.println("7. Ver espacios libres");
            System.out.println("8. Salir");
            System.out.print("Elige una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer del enter

            switch (opcion) {

                case 1:
                    // Añadir contacto
                    System.out.print("Ingresa el nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingresa el teléfono: ");
                    String telefono = scanner.nextLine();

                    Contacto nuevo = new Contacto(nombre, telefono);
                    agenda.añadirContacto(nuevo);
                    break;

                case 2:
                    // Verificar si existe contacto
                    System.out.print("Ingresa el nombre del contacto: ");
                    String nombreExiste = scanner.nextLine();

                    Contacto contactoExiste = new Contacto(nombreExiste, "");
                    boolean existe = agenda.existeContacto(contactoExiste);

                    if (existe) {
                        System.out.println("El contacto SÍ existe en la agenda.");
                    } else {
                        System.out.println("El contacto NO existe en la agenda.");
                    }
                    break;

                case 3:
                    // Listar contactos
                    agenda.listarContactos();
                    break;

                case 4:
                    // Buscar contacto por nombre
                    System.out.print("Ingresa el nombre a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    agenda.buscaContacto(nombreBuscar);
                    break;

                case 5:
                    // Eliminar contacto
                    System.out.print("Ingresa el nombre del contacto a eliminar: ");
                    String nombreEliminar = scanner.nextLine();

                    Contacto contactoEliminar = new Contacto(nombreEliminar, "");
                    agenda.eliminarContacto(contactoEliminar);
                    break;

                case 6:
                    // Agenda llena
                    if (agenda.agendaLlena()) {
                        System.out.println("La agenda está llena.");
                    } else {
                        System.out.println("La agenda NO está llena.");
                    }
                    break;

                case 7:
                    // Espacios libres
                    System.out.println("Espacios libres: " + agenda.espaciosLibres());
                    break;

                case 8:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }

        } while (opcion != 8);

        scanner.close();
    }
    
}//Main
