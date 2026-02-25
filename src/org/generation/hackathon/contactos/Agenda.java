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
	
	
	//-------------------------------Existe Contacto----------------------------------
	
	
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


