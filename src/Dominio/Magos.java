package Dominio;

import java.util.ArrayList;
import java.util.List;

public class Magos {
	private String nombre;
	private double puntajeTotal;
	
	private static List<Hechizos> hechizos = new ArrayList<>();
	
	public Magos(String nombre) 
	{
		this.nombre = nombre;
	}

	public String getNombre() 
	{
		return nombre;
	}
	
	public double getPuntajeTotal()
	{
		return puntajeTotal;
	}

	public void agregarHechizos(Hechizos h)
	{
		hechizos.add(h);
	}
	
	public void calcularPuntajeTotal()
	{
		puntajeTotal = 0;
		for (Hechizos h: hechizos)
		{
			puntajeTotal += h.calcularPuntaje();
		}
	}

	@Override
	public String toString() {
		return "Nombre: " + getNombre() + "Hechizos: \n" ;
	}
}
