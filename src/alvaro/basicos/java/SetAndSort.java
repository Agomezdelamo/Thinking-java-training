package alvaro.basicos.java;

import java.util.SortedSet;
import java.util.TreeSet;

public class SetAndSort {
	public static void main(String[] args) {
		
		Equipo e1 = new Equipo("Madrid","Zidane",59);
		Equipo e2 = new Equipo("Barsa","Luis",49);
		Equipo e3 = new Equipo("Atletico","Simeone",49);
		Equipo e4 = new Equipo("Sevilla","Sampaoli",30);
		Equipo e5No = new Equipo("Sevilla","Sampaoli",30);
		
		//Set es un interface, de el heredan otros como SortedSet
		//TrheeSet es una clase que implementa el interface y rellena
		//los métodos vacios de codigo, ordenando la coleccion.
		SortedSet<Equipo> equipos = new TreeSet<Equipo>();
		equipos.add(e1);
		equipos.add(e2);
		equipos.add(e3);
		equipos.add(e4);
		equipos.add(e5No);
		
	}
}

class Equipo {
	private String nombre;
	private String entrenador;
	private int puntos;
	
	public Equipo() {
		// TODO Auto-generated constructor stub
	}

	public Equipo(String nombre, String entrenador, int puntos) {
		super();
		this.nombre = nombre;
		this.entrenador = entrenador;
		this.puntos = puntos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(String entrenador) {
		this.entrenador = entrenador;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo other = (Equipo) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
}
 