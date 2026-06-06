package Dominio;

import java.util.ArrayList;
import java.util.List;

public class Magos {
	private String nombre;
	private double puntajeTotal;
	
	private List<Hechizos> hechizosPropios = new ArrayList<>();
	
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
		hechizosPropios.add(h);
	}
	
	public double calcularPuntajeTotal()
	{
		this.puntajeTotal = 0;
		for (Hechizos h: hechizosPropios)
		{
			this.puntajeTotal += h.calcularPuntaje();
		}
		return this.puntajeTotal;
	}

	@Override
	public String toString() {
		return "Nombre: " + getNombre() + "Hechizos: \n";
	}
}
