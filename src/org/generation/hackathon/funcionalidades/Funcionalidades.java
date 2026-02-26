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
			try {
				System.out.print("Ingrese el tamaño de la agenda: ");
				int tamaño = Integer.parseInt(scanner.nextLine());
				if (tamaño <= 0) {
					System.out.println("El tamaño debe ser mayor a 0. Se usará tamaño por defecto (10).");
					agenda = new Agenda();
				} else {
					agenda = new Agenda(tamaño);
				}
			} catch (NumberFormatException e) {
				System.out.println("Entrada inválida. Se usará tamaño por defecto (10).");
				agenda = new Agenda();
			}
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

			try {
				opcion = scanner.nextInt();
				scanner.nextLine();
			} catch (Exception e) {
				System.out.println("Por favor ingrese un número válido.");
				scanner.nextLine();
				opcion = -1;
			}

			switch (opcion) {

			case 1:
				añadirContacto();
				break;

			case 2:
				verificarContacto();
				break;

			case 3:
				listarContactos();
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
		if (agenda.agendaLlena()) {
			System.out.println("La agenda está llena, no se puede añadir más contactos.");
			return;
		}

		System.out.print("Ingresa el nombre: ");

		String nombre = scanner.nextLine();

		if (nombre.trim().isEmpty()) {
			System.out.println("El nombre no puede estar vacío.");
			return;
		}

		System.out.print("Ingresa el teléfono: ");

		String telefono = scanner.nextLine();

		if (telefono.trim().isEmpty()) {
			System.out.println("El teléfono no puede estar vacío.");
			return;
		}

		Contacto nuevo = new Contacto(nombre, telefono);
		agenda.añadirContacto(nuevo);
	}//añadirContacto

	private void verificarContacto() {
		if (agenda.agendaVacia()) {
			System.out.println("No hay contactos en la agenda.");
			return;
		}

		System.out.print("Ingresa el nombre del contacto: ");
		String nombreExiste = scanner.nextLine();

		if (nombreExiste.trim().isEmpty()) {
			System.out.println("El nombre no puede estar vacío.");
			return;
		}

		Contacto contactoExiste = new Contacto(nombreExiste, "");
		boolean existe = agenda.existeContacto(contactoExiste);

		if (existe) {
			System.out.println("El contacto " + nombreExiste.toUpperCase() + " SÍ existe en la agenda.");
		} else {
			System.out.println("El contacto " + nombreExiste.toUpperCase() + " NO existe en la agenda.");
		}
	}//verificarContacto

	private void listarContactos() {
		if (agenda.agendaVacia()) {
			System.out.println("La agenda está vacía.");
		} else {
			System.out.println("LISTA DE CONTACTOS:");
			agenda.listarContactos();
		}
	}

	private void buscarContacto() {
		if (agenda.agendaVacia()) {
			System.out.println("No hay contactos en la agenda para buscar.");
			return;
		}

		System.out.print("Ingresa el nombre a buscar: ");

		String nombreBuscar = scanner.nextLine();

		if (nombreBuscar.trim().isEmpty()) {
			System.out.println("El nombre no puede estar vacío.");
			return;
		}

		agenda.buscaContacto(nombreBuscar);
	}//buscarContacto

	private void eliminarContacto() {
		if (agenda.agendaVacia()) {
			System.out.println("No hay contactos en la agenda para eliminar.");
			return;
		}

		System.out.print("Ingresa el nombre del contacto a eliminar: ");
		String nombreEliminar = scanner.nextLine();

		if (nombreEliminar.trim().isEmpty()) {
			System.out.println("El nombre no puede estar vacío.");
			return;
		}

		Contacto contactoEliminar = new Contacto(nombreEliminar, "");

		if (!agenda.existeContacto(contactoEliminar)) {
			System.out.println("El contacto no existe en la agenda.");
			return;
		}

		System.out.print("¿Estás seguro de eliminar a " + nombreEliminar.toUpperCase() + "? (S/N): ");
		String confirmacion = scanner.nextLine();

		if (confirmacion.equalsIgnoreCase("s")) {
			agenda.eliminarContacto(contactoEliminar);
		} else {
			System.out.println("Eliminación cancelada.");
		}
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