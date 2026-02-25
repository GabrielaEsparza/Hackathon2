package org.generation.hackathon.clases;

import java.util.Objects;

public class Contacto {

    private String name;
    private String telefono;

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
    }// setTelefono

	//-----------------para que HashMap no acepte elementos con el mismo nombre--------

    // 
    @Override
   @Override
public boolean equals(Object objeto) {
    if (this == objeto) return true;
    if (!(objeto instanceof Contacto)) return false;
    Contacto contacto = (Contacto) objeto;
    return name.equalsIgnoreCase(contacto.name);
}

    @Override
    public int hashCode() {
        return name.toLowerCase().hashCode();
    }
}//contacto
