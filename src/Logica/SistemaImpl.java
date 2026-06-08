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
	
	// Crea los objetos magos y los guarda en la lista correspondiente
	public void crearMagos(String linea)
	{
		String[] partes = linea.split(";");
		String nombre = partes[0];
		Magos m = new Magos(nombre);
		maguitos.add(m);
		String hechizosPropios = partes[1];
		String[] partes2 = hechizosPropios.split("\\|");
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

	// Crea los objetos hechizos y los guarda en la lista correspondiente
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

	// Lee la lista, crea una copia, la ordena y retorna los nombres de ciertos hechizos
	@Override
	public String encontrarMejoresHechizos(int index) 
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
	
	// Lee la lista, crea una copia, la ordena y retorna los nombres de ciertos magos
	@Override
	public String mejoresMagos(int index) 
	{
		List<Magos> mTemp = new ArrayList<>();
		
		for(Magos m: maguitos)
		{
			mTemp.add(m);
		}
		
		for(int a = 0; a < mTemp.size() - 1;a++)
		{
			for(int b = a + 1; b < mTemp.size(); b++)
			{
				if (mTemp.get(a).calcularPuntajeTotal() < mTemp.get(b).calcularPuntajeTotal())
				{
					Magos temp = mTemp.get(a);
					mTemp.set(a, mTemp.get(b));
					mTemp.set(b, temp);
				}
			}
		}
		return mTemp.get(index).getNombre();
	}
	
	// Permite agregar mas hechizos a otros magos
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
	
	// Crea un mago y lo agrega a la lista
	@Override
	public void agregarMago(String nombre)
	{
		Magos m = new Magos(nombre);
		maguitos.add(m);
	}
	
	// Retorna el nombre de un hechizo en especifico
	public String mostrarHechizos(int index)
	{
		return hechizos.get(index).getNombreHechizo();
	}

	// Retorna la cantidad de hechizos que hay hasta el momento
	@Override
	public int cantidadDeHechizos() 
	{
		int cantHechizos = hechizos.size();
		return cantHechizos;
	}
	
	// Retorna la cantidad de magos que hay hasta el momento
	@Override
	public int cantidadDeMagos()
	{
		int cantMagos = maguitos.size();
		return cantMagos;
	}
	
	// Retorna el nombre del mago del indice que indiqua
	@Override
	public String mostrarMagos(int index)
	{
		return maguitos.get(index).getNombre();
	}
	
	// Retorna el nombre del mago junto al puntaje que tiene
	@Override
	public String mostrarMagosConPuntaje(int index)
	{
		String linea = maguitos.get(index).getNombre() + " | Puntaje Total: " + maguitos.get(index).calcularPuntajeTotal();
		return linea;
	}
	
	// Retorna el nombre del hechizo junto al puntaje que tiene
	@Override
	public String mostrarHechizosConPuntaje(int index)
	{
		String linea = hechizos.get(index).getNombreHechizo() + " | Puntaje: " + hechizos.get(index).calcularPuntaje();
		return linea;
	}

	// Elimina el mago que haya sido pedido cuando hay un error al momento de crear este mismo
	@Override
	public void eliminarMago(String nomMago)
	{
		for (Magos m: maguitos)
		{
			if (m.getNombre().equalsIgnoreCase(nomMago))
			{
				maguitos.remove(m);
 			}
		}
	}
	
	// Permite cambiar el nombre de un mago
	@Override
	public void cambiarNombre(int index, String nuevoNombre)
	{
		maguitos.get(index).setNombre(nuevoNombre);
		reescribirMagos();
	}
	
	// Permite eliminar un mago por el menu administrador y lo saca de la lista
	@Override
	public void eliminarMagoMenu(int index)
	{
		 maguitos.remove(index);
		 reescribirMagos();
	}
	
	// Permite crear un nuevo hechizo con solo 4 variables y agregarlo a la lista
	@Override
	public void crearNuevoHechizoSimple(String nombre, String tipo, int daño, int variado)
	{
		if (tipo.equalsIgnoreCase("Fuego"))
		{
			Hechizos h = new Fuego(nombre,tipo,daño,variado);
			hechizos.add(h);
		}
		else if (tipo.equalsIgnoreCase("Tierra"))
		{
			Hechizos h = new Tierra(nombre,tipo,daño,variado);
			hechizos.add(h);
		}
		
		reescribirHechizos();
	}
	
	// Permite crear hechizos con 5 atributios
	@Override
	public void crearNuevoHechizoComplejo(String nombre, String tipo, int damage, int variado, int variado2)
	{
		if (tipo.equalsIgnoreCase("Planta"))
		{
			Hechizos h = new Planta(nombre,tipo,damage,variado,variado2);
			hechizos.add(h);
		}
		else if (tipo.equalsIgnoreCase("Agua"))
		{
			Hechizos h = new Agua(nombre,tipo,damage,variado,variado2);
			hechizos.add(h);
		}
		
		reescribirHechizos();
	}
	
	@Override
	public void eliminarHechizo(int index)
	{
		hechizos.remove(index);
		reescribirHechizos();
	}
	
	// Permite reescribir el archivo de magos
	@Override
	public void reescribirMagos()
	{
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("txts/Magos.txt"));
			for (Magos m: maguitos)
			{
				String linea = m.getNombre() + ";";
				for (int i = 0; i < m.cantidadHechizos(); i++)
				{
					String hechizo = m.nombreHechizoPropio(i);
					if (i != m.cantidadHechizos()-1)
					{
						linea += hechizo + "|";
					}
					else 
					{
						linea += hechizo;
					}
				}
				bw.write(linea);
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) 
		{
			System.out.println("error 1");
		}
		
		
	}
	
	// Permite reescribir el archivo de hechizos
	@Override
	public void reescribirHechizos()
	{
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("txts/Hechizos.txt"));
			for (Hechizos h: hechizos)
			{
				String linea = "";
				if (h.getTipo().equalsIgnoreCase("Fuego"))
				{
					linea = h.getNombreHechizo() + ";" + h.getTipo() + ";" + h.getDamage() + ";" + h.getTiempoQuemadura();
				}
				else if (h.getTipo().equalsIgnoreCase("Tierra"))
				{
					linea = h.getNombreHechizo() + ";" + h.getTipo() + ";" + h.getDamage() + ";" + h.getMejoraDefensa();
				}
				else if (h.getTipo().equalsIgnoreCase("Planta"))
				{
					linea = h.getNombreHechizo() + ";" + h.getTipo() + ";" + h.getDamage() + ";" + h.getDuracionStun() + ";" + h.getCantPlantas();
				}
				else if (h.getTipo().equalsIgnoreCase("Agua"))
				{
					linea = h.getNombreHechizo() + ";" + h.getTipo() + ";" + h.getDamage() + ";" + h.getDuracionStun() + ";" + h.getCantPlantas();
				}
				
				bw.write(linea);
				bw.newLine();
			}
			bw.close();
		} catch (IOException e)
		{
		}
		
	}
	
	// Retorna el nombre de un hechizo que tenga un mago en especifico
	@Override
	public String mostrarHechizosDeMago(int index, int magoElegido)
	{
		String hechizo = maguitos.get(magoElegido).getHechizo(index);
		return hechizo;
	}
	
	// Retorna la cantidad de hechizos que tiene un mago en especifico
	@Override
	public int hechizosMago(int magoElegido)
	{
		return maguitos.get(magoElegido).cantidadHechizos();
	}
}
