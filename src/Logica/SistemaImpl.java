package Logica;

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
		String[] partes = linea.split(";");
		String nomHechizo = partes[0];
		String tipoHechizo = partes[1];
		int damage = Integer.parseInt(partes[2]);
		
		if (tipoHechizo.equalsIgnoreCase("Fuego"))
		{
			int duracionQuemadura = Integer.parseInt(partes[3]);
			Hechizos h = new Fuego(nomHechizo,tipoHechizo,damage,duracionQuemadura);
			hechizos.add(h);
		}
		else if (tipoHechizo.equalsIgnoreCase("Tierra"))
		{
			int mejorarDefensa = Integer.parseInt(partes[3]);
			Hechizos h = new Tierra(nomHechizo,tipoHechizo,damage,mejorarDefensa);
			hechizos.add(h);
		}
		else if (tipoHechizo.equalsIgnoreCase("Planta"))
		{
			String[] partes2 = partes[3].split(",");
 			int duracionStun = Integer.parseInt(partes2[0]);
			int cantidadPlantas = Integer.parseInt(partes2[1]);
			Hechizos h = new Planta(nomHechizo,tipoHechizo,damage,duracionStun,cantidadPlantas);
			hechizos.add(h);
		}
		else if (tipoHechizo.equalsIgnoreCase("Agua"))
		{
			String[] partes2 = partes[3].split(",");
			int cantidadHeal = Integer.parseInt(partes2[0]);
			int presionAgua = Integer.parseInt(partes2[1]);
			Hechizos h = new Agua(nomHechizo,tipoHechizo,damage,cantidadHeal,presionAgua);
			hechizos.add(h);
		}
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

	@Override
	public String encontrarHechizos(int index) 
	{
		for(int a = 0; a < hechizos.size() - 1;a++)
		{
			for(int b = a + 1; b < hechizos.size(); b++ )
			{
				if (hechizos.get(a).calcularPuntaje() < hechizos.get(b).calcularPuntaje())
				{
					Hechizos temp = hechizos.get(a);
					hechizos.set(a, hechizos.get(b));
					hechizos.set(b, temp);
				}
			}
		}
		return hechizos.get(index).getNombreHechizo();
	}

	@Override
	public void mejoresMagos() 
	{
		
	}
}
