package org.generation.hackathon.clases;

public class Contacto {

	private String nombre;
	private String telefono;

	public Contacto(String name, String telefono) {
		this.nombre = name;
		this.telefono = telefono;
	}// Constructor

	public String getName() {
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
	}// setTelefono

	// -----------------para que HashMap no acepte elementos con el mismo nombre--------
	@Override
	public boolean equals(Object objeto) {
		if (this == objeto)
			return true;
		if (!(objeto instanceof Contacto))
			return false;
		Contacto contacto = (Contacto) objeto;
		return nombre.equalsIgnoreCase(contacto.nombre);
	}

	@Override
	public int hashCode() {
		return nombre.toLowerCase().hashCode();
	}
}// contacto
