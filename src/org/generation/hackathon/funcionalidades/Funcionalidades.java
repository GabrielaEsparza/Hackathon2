package org.generation.hackathon.funcionalidades;

import java.util.Scanner;

import org.generation.hackathon.clases.Agenda;
import org.generation.hackathon.clases.Contacto;

public class Funcionalidades {
	private Scanner scanner;
	private Agenda agenda;

	public Funcionalidades() {
		this.scanner = new Scanner(System.in);
	}

	public void iniciar() {
		configurarAgenda();
		iniciarMenu();
		scanner.close();
	}// iniciar

	public void configurarAgenda() {
		System.out.print("¿Desea especificar el tamaño de la agenda? (S/N): ");
		String respuesta = scanner.nextLine();

		if (respuesta.equalsIgnoreCase("s")) {
			System.out.print("Ingrese el tamaño de la agenda: ");
			int tamaño = Integer.parseInt(scanner.nextLine());
			agenda = new Agenda(tamaño);
		} else {
			agenda = new Agenda();
		}
	}// configurarAgenda

	public void iniciarMenu() {
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
			scanner.nextLine();//limpiar buffer del enter

			switch (opcion) {

			case 1:
				añadirContacto();
				break;

			case 2:
				verificarContacto();
				break;

			case 3:
				agenda.listarContactos();
				break;

			case 4:
				buscarContacto();
				break;

			case 5:
				eliminarContacto();
				break;

			case 6:
				agendaLlena();
				break;

			case 7:
				verEspaciosLibres();
				break;

			case 8:
				System.out.println("Saliendo del programa...");
				break;

			default:
				System.out.println("Opción inválida. Intenta de nuevo.");
			}

		} while (opcion != 8);
	}

	private void añadirContacto() {
		System.out.print("Ingresa el nombre: ");
		String nombre = scanner.nextLine();

		System.out.print("Ingresa el teléfono: ");
		String telefono = scanner.nextLine();

		Contacto nuevo = new Contacto(nombre, telefono);
		agenda.añadirContacto(nuevo);
	}//añadirContacto

	private void verificarContacto() {
		System.out.print("Ingresa el nombre del contacto: ");
		String nombreExiste = scanner.nextLine();

		Contacto contactoExiste = new Contacto(nombreExiste, "");
		boolean existe = agenda.existeContacto(contactoExiste);

		if (existe) {
			System.out.println("El contacto " + nombreExiste.toUpperCase() + " SÍ existe en la agenda.");
		} else {
			System.out.println("El contacto " + nombreExiste.toUpperCase() + " NO existe en la agenda.");
		}
	}//verificarContacto

	private void buscarContacto() {
		System.out.print("Ingresa el nombre a buscar: ");
		String nombreBuscar = scanner.nextLine();
		agenda.buscaContacto(nombreBuscar);
	}//buscarContacto

	private void eliminarContacto() {
		System.out.print("Ingresa el nombre del contacto a eliminar: ");
		String nombreEliminar = scanner.nextLine();

		Contacto contactoEliminar = new Contacto(nombreEliminar, "");
		agenda.eliminarContacto(contactoEliminar);
	}//eliminarContacto

	private void agendaLlena() {
		if (agenda.agendaLlena()) {
			System.out.println("La agenda está llena.");
		} else {
			System.out.println("La agenda NO está llena. Le quedan " + agenda.espaciosLibres() + " espacios libres.");
		}
	}//agendaLlena

	private void verEspaciosLibres() {
		System.out.println("Espacios libres: " + agenda.espaciosLibres() + "/" + agenda.getSize());
	}//verEspaciosLibres

}// Funcionalidades