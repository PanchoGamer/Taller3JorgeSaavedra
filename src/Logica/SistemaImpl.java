package Logica;

import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

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
		String hechizosPropios = partes[1];
		String[] partes2 = hechizosPropios.split("|");
		for (int i = 0; i < partes2.length; i++)
		{
			for(Hechizos hec: hechizos)
			{
				if (hec.getNombreHechizo().equalsIgnoreCase(partes2[i]))
				{
					Hechizos h = hec;
					m.agregarHechizos(h);
					break;
				}
			}
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

	@Override
	public String encontrarHechizos(int index) 
	{
		
		List<Hechizos> hecTemp = new ArrayList<>();
		
		for(Hechizos h: hechizos)
		{
			hecTemp.add(h);
		}
		
		for(int a = 0; a < hecTemp.size() - 1;a++)
		{
			for(int b = a + 1; b < hecTemp.size(); b++ )
			{
				if (hecTemp.get(a).calcularPuntaje() < hecTemp.get(b).calcularPuntaje())
				{
					Hechizos temp = hecTemp.get(a);
					hecTemp.set(a, hecTemp.get(b));
					hecTemp.set(b, temp);
				}
			}
		}
		return hechizos.get(index).getNombreHechizo();
	}

	@Override
	public void mejoresMagos() 
	{
		
	}
	
	@Override
	public void agregarHechizosMagos(String nombre, String hechizo)
	{
		Hechizos hec = null;
		Magos m = null;
		
		for (Hechizos h: hechizos)
		{
			if (h.getNombreHechizo().equalsIgnoreCase(hechizo))
			{
				hec = h;
				break;
			}
		}
		
		for (Magos mag: maguitos)
		{
			if(mag.getNombre().equalsIgnoreCase(nombre))
			{
				m = mag;
			}
		}
		
		if (hec != null)
		{
			m.agregarHechizos(hec);
		}
	}
	
	@Override
	public void agregarMago(String nombre)
	{
		Magos m = new Magos(nombre);
		maguitos.add(m);
		escribirNuevoMago(nombre);
	}
	
	public void escribirNuevoMago(String mago)
	{
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("txts/Magos.txt"));
		} catch (IOException e) {
			
		}
		
		
	}
}
