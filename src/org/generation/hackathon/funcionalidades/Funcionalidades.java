package org.generation.hackathon.funcionalidades;

import java.util.Scanner;

import org.generation.hackathon.clases.Agenda;
import org.generation.hackathon.clases.Colores;
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
		System.out.print(Colores.CYAN + "¿Desea especificar el tamaño de la agenda? (S/N): " + Colores.RESET);
		String respuesta = scanner.nextLine();

		if (respuesta.equalsIgnoreCase("s")) {
			try {
				System.out.print(Colores.CYAN + "Ingrese el tamaño de la agenda: " + Colores.RESET);
				int tamaño = Integer.parseInt(scanner.nextLine());
				if (tamaño <= 0) {
					System.out.println(
							Colores.warning("El tamaño debe ser mayor a 0. Se usará tamaño por defecto (10)."));
					agenda = new Agenda();
				} else {
					agenda = new Agenda(tamaño);
					System.out.println(Colores.success("Agenda creada con tamaño " + tamaño));
				}
			} catch (NumberFormatException e) {
				System.out.println(Colores.warning("Entrada inválida. Se usará tamaño por defecto (10)."));
				agenda = new Agenda();
			}
		} else {
			agenda = new Agenda();
			System.out.println(Colores.success("Agenda creada con tamaño por defecto (10)"));
		}
	}// configurarAgenda

	public void iniciarMenu() {
		int opcion;

		do {
			System.out.println("\n" + Colores.CYAN_BOLD + "╔═══════════════════════════════╗" + Colores.RESET);
			System.out.println(Colores.CYAN_BOLD + "║      " + Colores.WHITE_BOLD + "AGENDA TELEFÓNICA"
					+ Colores.CYAN_BOLD + "        ║" + Colores.RESET);
			System.out.println(Colores.CYAN_BOLD + "╚═══════════════════════════════╝" + Colores.RESET);
			System.out.println(Colores.YELLOW + "1." + Colores.RESET + " Añadir contacto");
			System.out.println(Colores.YELLOW + "2." + Colores.RESET + " Verificar si existe contacto");
			System.out.println(Colores.YELLOW + "3." + Colores.RESET + " Listar contactos");
			System.out.println(Colores.YELLOW + "4." + Colores.RESET + " Buscar contacto por nombre");
			System.out.println(Colores.YELLOW + "5." + Colores.RESET + " Eliminar contacto");
			System.out.println(Colores.YELLOW + "6." + Colores.RESET + " Ver si la agenda está llena");
			System.out.println(Colores.YELLOW + "7." + Colores.RESET + " Ver espacios libres");
			System.out.println(Colores.RED + "8." + Colores.RESET + " Salir");
			System.out.print(Colores.CYAN + "Elige una opción: " + Colores.RESET);

			try {
				opcion = scanner.nextInt();
				scanner.nextLine();
			} catch (Exception e) {
				System.out.println(Colores.error("Por favor ingrese un número válido."));
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
				System.out.println(Colores.info("Saliendo del programa... ¡Hasta pronto!"));
				break;

			default:
				System.out.println(Colores.error("Opción inválida. Intenta de nuevo."));
			}

		} while (opcion != 8);
	}

	private void añadirContacto() {
		if (agenda.agendaLlena()) {
			System.out.println(Colores.error("La agenda está llena, no se puede añadir más contactos."));
			return;
		}

		System.out.print(Colores.CYAN + "Ingresa el nombre: " + Colores.RESET);

		String nombre = scanner.nextLine();

		if (nombre.trim().isEmpty()) {
			System.out.println(Colores.error("El nombre no puede estar vacío."));
			return;
		}

		System.out.print(Colores.CYAN + "Ingresa el teléfono: " + Colores.RESET);

		String telefono = scanner.nextLine();

		if (telefono.trim().isEmpty()) {
			System.out.println(Colores.error("El teléfono no puede estar vacío."));
			return;
		}

		Contacto nuevo = new Contacto(nombre, telefono);

		if (agenda.existeContacto(nuevo)) {
			System.out.println(Colores.warning("El contacto ya existe. No se pueden agregar duplicados."));
			return;
		}

		agenda.añadirContacto(nuevo);
		System.out.println(Colores.success("Contacto añadido exitosamente."));
	}//añadirContacto

	private void verificarContacto() {
		if (agenda.agendaVacia()) {
			System.out.println(Colores.warning("No hay contactos en la agenda."));
			return;
		}

		System.out.print(Colores.CYAN + "Ingresa el nombre del contacto: " + Colores.RESET);
		String nombreExiste = scanner.nextLine();

		if (nombreExiste.trim().isEmpty()) {
			System.out.println(Colores.error("El nombre no puede estar vacío."));
			return;
		}

		Contacto contactoExiste = new Contacto(nombreExiste, "");
		boolean existe = agenda.existeContacto(contactoExiste);

		if (existe) {
			System.out
					.println(Colores.success("El contacto " + nombreExiste.toUpperCase() + " SÍ existe en la agenda."));
		} else {
			System.out
					.println(Colores.warning("El contacto " + nombreExiste.toUpperCase() + " NO existe en la agenda."));
		}
	}//verificarContacto

	private void listarContactos() {
		if (agenda.agendaVacia()) {
			System.out.println(Colores.warning("La agenda está vacía."));
		} else {
			System.out.println(Colores.title("\n═══ LISTA DE CONTACTOS ═══"));
			agenda.listarContactos();
		}
	}

	private void buscarContacto() {
		if (agenda.agendaVacia()) {
			System.out.println(Colores.warning("No hay contactos en la agenda para buscar."));
			return;
		}

		System.out.print(Colores.CYAN + "Ingresa el nombre a buscar: " + Colores.RESET);

		String nombreBuscar = scanner.nextLine();

		if (nombreBuscar.trim().isEmpty()) {
			System.out.println(Colores.error("El nombre no puede estar vacío."));
			return;
		}

		agenda.buscaContacto(nombreBuscar);
	}//buscarContacto

	private void eliminarContacto() {
		if (agenda.agendaVacia()) {
			System.out.println(Colores.warning("No hay contactos en la agenda para eliminar."));
			return;
		}

		System.out.print(Colores.CYAN + "Ingresa el nombre del contacto a eliminar: " + Colores.RESET);
		String nombreEliminar = scanner.nextLine();

		if (nombreEliminar.trim().isEmpty()) {
			System.out.println(Colores.error("El nombre no puede estar vacío."));
			return;
		}

		Contacto contactoEliminar = new Contacto(nombreEliminar, "");

		if (!agenda.existeContacto(contactoEliminar)) {
			System.out.println(Colores.warning("El contacto no existe en la agenda."));
			return;
		}

		System.out.print(Colores.YELLOW + "⚠ ¿Estás seguro de eliminar a " + nombreEliminar.toUpperCase() + "? (S/N): "
				+ Colores.RESET);
		String confirmacion = scanner.nextLine();

		if (confirmacion.equalsIgnoreCase("s")) {
			agenda.eliminarContacto(contactoEliminar);
			System.out.println(Colores.success("Contacto eliminado exitosamente."));
		} else {
			System.out.println(Colores.info("Eliminación cancelada."));
		}
	}//eliminarContacto

	private void agendaLlena() {
		if (agenda.agendaLlena()) {
			System.out.println(Colores.warning("La agenda está llena."));
		} else {
			System.out.println(Colores
					.success("La agenda NO está llena. Le quedan " + agenda.espaciosLibres() + " espacios libres."));
		}
	}//agendaLlena

	private void verEspaciosLibres() {
		int libres = agenda.espaciosLibres();
		int total = agenda.getSize();
		int usados = total - libres;

		System.out.println(Colores.title("\n═══ ESTADO DE LA AGENDA ═══"));
		System.out.println(Colores.GREEN + "Espacios libres: " + libres + "/" + total + Colores.RESET);
		System.out.println(Colores.BLUE + "Contactos guardados: " + usados + Colores.RESET);

		// Progress bar
		System.out.print(Colores.CYAN + "[" + Colores.RESET);
		int barLength = 20;
		int filled = (usados * barLength) / total;
		for (int i = 0; i < barLength; i++) {
			if (i < filled) {
				System.out.print(Colores.GREEN + "█" + Colores.RESET);
			} else {
				System.out.print(Colores.WHITE + "░" + Colores.RESET);
			}
		}
		System.out.println(Colores.CYAN + "]" + Colores.RESET);
	}//verEspaciosLibres

}// Funcionalidades