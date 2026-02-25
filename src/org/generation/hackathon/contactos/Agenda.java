package org.generation.hackathon.contactos;
import org.generation.hackathon.clases.Contacto;
public class Agenda {
	private Contacto[] contactos = new Contacto[10];

	
	
	
	
	//----------------------------------Metodos----------------------------------------
	
	
	//-------------------------------A;adir contacto----------------------------------
	
	
	//-------------------------------Existe Contacto----------------------------------
	
	
	//-------------------------------Listar Contactos----------------------------------
	
	
	//-------------------------------Buscar contacto----------------------------------
	
	
	
	//-------------------------------Eliminar Contactos----------------------------------
	
	
	
	//-------------------------------Agenda Llena----------------------------------
	public boolean agendaLlena() {
	    for (Contacto c : contactos) {
	        if (c == null) {
	            return false; // esto si hay espacio libre
	        }
	    }
	    return true; // esto si esta llena
	}//agendaLlena
	
	//-------------------------------Espacios Libres----------------------------------
	
	public int espaciosLibres() {
	    int contador = 0;

	    for (Contacto c : contactos) {
	        if (c == null) {
	            contador++;
	        }
	    }

	    return contador;
	}//espaciosLibres
	
}//Agenda

