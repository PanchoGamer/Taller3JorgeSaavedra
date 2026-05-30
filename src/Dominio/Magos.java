package Dominio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Magos {
	private String nombre;
	private static List<Hechizos> hechizos = new ArrayList<>();
	
	public Magos(String nombre) 
	{
		this.nombre = nombre;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public void agregarHechizos(Hechizos h)
	{
		hechizos.add(h);
	}
	
	public static void buscarHechizos() throws FileNotFoundException
	{
		File f = new File("txts/Hechizos.txt");
		Scanner s = new Scanner(f);
		boolean encontrado = false;
		
		while (!encontrado)
		{
			String linea = s.nextLine();
		}
		
	}
}
