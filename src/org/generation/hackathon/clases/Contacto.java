package org.generation.hackathon.clases;

public class Contacto {
	String nombre;
	String telefono;

	public Contacto(String nombre, String telefono) {
		this.nombre = nombre;
		this.telefono = telefono;
	}// Constructor

	public String getNombre() {
		return nombre;
	}// getName

	public String getTelefono() {
		return telefono;
	}// getTelefono

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}// setTelefono

	@Override
	public String toString() {
		return nombre.toUpperCase() + ": " + telefono;
	}// toString

}// Contacto
