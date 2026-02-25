package org.generation.hackathon.contactos;

import java.util.HashSet;
import java.util.Set;
import org.generation.hackathon.clases.Contacto;

public class Agenda {
	private Set<Contacto> contactos;
    private final int MAX_CONTACTOS = 10;

    public Agenda() {
        contactos = new HashSet<>();
	}

	
	
	
	
	//----------------------------------Metodos----------------------------------------
	
	
	//-------------------------------A;adir contacto----------------------------------
    public void añadirContacto(Contacto c) {
		if (agendaLlena()) {
			System.out.println("La agenda está llena, no se puede añadir el contacto.");
			return;
		}
		if (existeContacto(c)) {
			System.out.println("El contacto ya existe. No se pueden agregar duplicados.");
			return;
		}
		contactos.add(c);
		System.out.println("Contacto añadido.");
	}
	
	//-------------------------------Existe Contacto----------------------------------
    public boolean existeContacto(Contacto c) {
		return contactos.contains(c);
	}
	
	//-------------------------------Listar Contactos----------------------------------
	
	
	//-------------------------------Buscar contacto----------------------------------
	
	
	
	//-------------------------------Eliminar Contactos----------------------------------
	
	
	
	//-------------------------------Agenda Llena----------------------------------
	 public boolean agendaLlena() {
        return contactos.size() >= MAX_CONTACTOS;
    }//agendaLlena

	//-------------------------------Espacios Libres----------------------------------
	
 public int espaciosLibres() {
        return MAX_CONTACTOS - contactos.size();
    }//espaciosLibres
	
}//Agenda


