package Logica;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import Dominio.*;

public class SistemaImpl implements Sistema{
	
	public static List<Magos> maguitos = new ArrayList<>();
	public static List<Hechizos> hechizos = new ArrayList<>();
	
	public void crearMagos(String linea)
	{
		String[] partes = linea.split(";");
		String nombre = partes[0];
		Magos m = new Magos(nombre);
		maguitos.add(m);
		String hechizos = partes[1];
		String[] partes2 = hechizos.split("|");
		for (int i = 0; i < partes2.length; i++)
		{
			Hechizos h = buscarHechizos(partes2[i]);
			m.agregarHechizos(h);
		}
		
	}
	
	public void crearHechizos(String linea)
	{
		
	}
	
	public static Hechizos buscarHechizos(String nomHechizo) 
	{
		for(Hechizos hechizoTest: hechizos)
		{
			if (hechizoTest.getNombreHechizo().equalsIgnoreCase(nomHechizo))
			{
				return hechizoTest;
			}
		}
		return null;
	}
}
