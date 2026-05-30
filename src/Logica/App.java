package Logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
	
	static Sistema sistema = new SistemaImpl();
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		leerHechizos();
		leerMagos();
		menu();
	}
	
	public static void leerHechizos() throws FileNotFoundException
	{
		File f = new File("txts/Hechizos.txt");
		Scanner sArch1 = new Scanner(f);
		
		while (sArch1.hasNextLine())
		{
			String linea = sArch1.nextLine();
			
			sistema.crearHechizos(linea);
		}
		sArch1.close();
	}
	
	public static void leerMagos() throws FileNotFoundException
	{
		File f1 = new File("txts/Magos.txt");
		Scanner sArch = new Scanner(f1);
		
		while (sArch.hasNextLine())
		{
			String linea = sArch.nextLine();
			
			sistema.crearMagos(linea);
		}
		sArch.close();
	}
	
	public static void menu()
	{
		int opcion = 0;
		
		do
		{
			
			
			
		} while (opcion == 3);
	}
}	
