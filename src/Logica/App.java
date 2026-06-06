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
		Scanner s = new Scanner(System.in);
		int opcion = 0;
		
		do
		{
			System.out.println("1. Menu Administrador");
			System.out.println("2. Menu Analista");
			System.out.println("3. Salir");
			System.out.print("> ");
			
			String entrada = s.nextLine();
			
			try 
			{
				opcion = Integer.parseInt(entrada);
			} catch (NumberFormatException e)
			{
				System.out.println("Error. Ingrese una opcion valida");
			}
			
			if (opcion == 1)
			{
				menuAdmin(s);
			}
			
			else if (opcion == 2)
			{
				menuAnalisis(s);
			}
			
			
		} while (opcion != 3);
	}
	
	public static void menuAnalisis(Scanner s)
	{
		int option = 0;
		do
		{
			System.out.println("\n1. Top 10 mejores hechizos");
			System.out.println("2. Top 3 mejores magos");
			System.out.println("3. Mostrar todos los hechizos");
			System.out.println("4. Mostrar todos los magos");
			System.out.println("5. Mostrar todos los hechizos junto a su puntuacion");
			System.out.println("6. Mostrar todos los magos junto a su puntuacion");
			System.out.println("7. Salir");
			System.out.print("> ");
			
			String entry = s.nextLine();
			
			try
			{
				option = Integer.parseInt(entry);
			} catch (NumberFormatException e)
			{
				System.out.println("Ingrese una opcion valida.");
			}
			
			if (option == 1)
			{
				System.out.println();
				encontrarDiezHechizos();
			}
			
			else if (option == 2)
			{
				System.out.println();
				encontrarTresMagos();
			}
			
			else if (option == 3)
			{
				mostrarHechizos(0);
			}
			
			else if (option == 4)
			{
				mostrarMagos(0);
			}
			
			else if (option == 5)
			{
				mostrarHechizos(1);
			}
			
			else if (option == 6)
			{
				mostrarMagos(1);
			}
			
		} while (option != 7);
	}
	
	public static void menuAdmin(Scanner s)
	{
		int option = 0;
		do
		{
			System.out.println("1. Añadir Mago");
			System.out.println("2. Modificar Mago");
			System.out.println("3. Eliminar Mago");
			System.out.println("4. Agregar Hechizo");
			System.out.println("5. Modificar Hechizo");
			System.out.println("6. Eliminar Hechizo");
			System.out.println("7. Salir");
			System.out.print("> ");
			
			String entry = s.nextLine();
			
			try 
			{
				option = Integer.parseInt(entry);
			} catch (NumberFormatException e)
			{
				System.out.println("Error. Ingrese una opcion valida");
			}
			
			if (option == 1)
			{
				System.out.print("Ingrese el nombre del mago: ");
				String nombre = s.nextLine();
				
				sistema.agregarMago(nombre);
				
				System.out.print("\nIngrese cuantos hechizos tendra el mago:");
				int cantHechizos = 0;
				try 
				{
					cantHechizos = Integer.parseInt(s.nextLine());
				} catch (NumberFormatException e)
				{
					System.out.println("Ingrese un numero correcto.");
				}
				
				for(int i = 1; i < cantHechizos+1; i++)
				{
					System.out.print("\nHechizo " + i + ": ");
					String nombreHechizo = s.nextLine();
					
					sistema.agregarHechizosMagos(nombre, nombreHechizo);
				}
				
			}
		} while (option != 7);
	}
	
	public static void encontrarDiezHechizos() 
	{
		System.out.println("Los 10 mejores hechizos!");
		for(int i = 0; i < 10; i++)
		{
			String m = sistema.encontrarMejoresHechizos(i);
			System.out.println(i+1 + ") " + m);
		}
	}
	
	public static void encontrarTresMagos()
	{
		System.out.println("Los 3 mejores Magos!");
		for(int i = 0; i < 3; i++)
		{
			String mago = sistema.mejoresMagos(i);
			System.out.println(i+1 + ") " + mago);
		}
	}
	
	public static void mostrarHechizos(int tipo)
	{
		int cantHechizos = sistema.cantidadDeHechizos();
		System.out.println("\nHechizos!\n");
		for(int i = 0; i < cantHechizos;i++)
		{
			if (tipo == 0)
			{
				System.out.println(i+1 + ") " + sistema.mostrarHechizos(i));
			}
			else if (tipo == 1)
			{
				System.out.println(i+1 + ") " + sistema.mostrarHechizosConPuntaje(i));
			}
		}
	}
	
	public static void mostrarMagos(int tipo)
	{
		int cantMagos = sistema.cantidadDeMagos();
		System.out.println("\nMagos!\n");
		for(int i = 0; i < cantMagos;i++)
		{
			if(tipo == 0)
			{
				System.out.println(i+1 + ") " + sistema.mostrarMagos(i));
			}
			
			else if (tipo == 1)
			{
				System.out.println(i+1 + ") " + sistema.mostrarMagosConPuntaje(i));
			}
			
		}
	}
}	
