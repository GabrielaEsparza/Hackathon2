package org.generation.hackathon.clases;

import java.util.HashSet;
import java.util.Set;

public class Agenda {
	private Set<Contacto> contactos;
	private int tamañoMaximo;

	public Agenda() {
		this(10);
	}// Constructor Default

	public Agenda(int tamañoMaximo) {
		this.tamañoMaximo = tamañoMaximo;
		contactos = new HashSet<>();
	}// Constructor Variable

	public int getSize() {
		return this.tamañoMaximo;
	}//getSize

	//----------------------------------Metodos----------------------------------------
	public void añadirContacto(Contacto c) {
		if (agendaLlena()) {
			System.out.println(Colores.error("La agenda está llena, no se puede añadir el contacto."));
			return;
		}
		if (existeContacto(c)) {
			System.out.println(Colores.warning("El contacto ya existe. No se pueden agregar duplicados."));
			return;
		}
		contactos.add(c);
		System.out.println(Colores.success("Contacto añadido."));
	}//añadirContacto

	public boolean existeContacto(Contacto c) {
		return contactos.contains(c);
	}//existeContacto

	public void listarContactos() {
		int count = 1;
		for (Contacto contacto : contactos) {
			System.out.println(Colores.YELLOW + count + ". " + Colores.RESET + Colores.WHITE_BOLD
					+ contacto.getName().toUpperCase() + Colores.RESET + Colores.CYAN + " → " + Colores.RESET
					+ Colores.GREEN + contacto.getTelefono() + Colores.RESET);
			count++;
		}
	}//listarContactos

	public void buscaContacto(String nombre) {
		boolean encontrado = false;

		for (Contacto c : contactos) {
			if (c.getName().equalsIgnoreCase(nombre)) {
				System.out.println(Colores.success("Contacto encontrado:"));
				System.out.println(Colores.WHITE_BOLD + "  Nombre: " + Colores.RESET + c.getName().toUpperCase());
				System.out.println(Colores.WHITE_BOLD + "  Teléfono: " + Colores.RESET + Colores.GREEN + c.getTelefono()
						+ Colores.RESET);
				encontrado = true;
				break; //para que deje de buscar si ya lo encontro
			} //if
		} //for

		if (!encontrado) {
			System.out.println(Colores.warning("El contacto no existe."));
		} //for
	}//buscarContacto

	public void eliminarContacto(Contacto c) {
		if (contactos.contains(c)) {
			contactos.remove(c);
			System.out.println(Colores.success("El contacto ha sido eliminado."));
		} else {
			System.out.println(Colores.error("El contacto no pudo eliminarse porque no existía."));
		}
	}//eliminarContacto

	public boolean agendaLlena() {
		return contactos.size() >= tamañoMaximo;
	}//agendaLlena

	public int espaciosLibres() {
		return tamañoMaximo - contactos.size();
	}//espaciosLibres

	public boolean agendaVacia() {
		return contactos.isEmpty();
	}//agendaVacia

}//Agenda