package org.generation.hackathon.clases;

public class Contacto {
	String name;
	String telefono;

	public Contacto(String name, String telefono) {
		this.name = name;
		this.telefono = telefono;
	}// Constructor

	public String getName() {
		return name;
	}// getName

	public String getTelefono() {
		return telefono;
	}// getTelefono

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}// setTelefono

	@Override
	public String toString() {
		return name.toUpperCase() + ": " + telefono;
	}// toString

}// Contacto
