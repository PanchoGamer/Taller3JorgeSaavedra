/// Nombre: Jorge Andrés Saavedra Sanchez  
/// Rut: 22.347.590-6  
/// Carrera: Ingenieria en Tecnologias de Informacion

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

	// Funcion que reconoce el archvio de hechizos y los lee
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
	
	// Funcion que reconoce el archivo de magos y los lee
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
	
	// Menu principal para acceder al menu de analisis o al menu de administrador
	public static void menu()
	{
		Scanner s = new Scanner(System.in);
		int opcion = 0;
		
		do
		{
			System.out.println("\n1. Menu Administrador");
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
	
	// Manejo principal del menu de analisis
	public static void menuAnalisis(Scanner s)
	{
		System.out.println("Menu Analisis");
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
	
	// Manejo principal del menu administrador
	public static void menuAdmin(Scanner s)
	{
		System.out.println("\nMenu Administrador");
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
				crearMago(s);
			}
			
			else if(option == 2)
			{
				modificarMago(s);
			}
			
			else if (option == 3)
			{
				eliminarMago(s);
			}
			
			else if (option == 4)
			{
				agregarHechizo(s);
			}
			
		} while (option != 7);
	}
	
	// Crea los magos que sean hechos por el menu administrador
	public static void crearMago(Scanner s) {
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
		
		int hechizosActuales = sistema.cantidadDeHechizos();
		

		for(int i = 1; i < cantHechizos+1; i++)
		{
			System.out.print("\nElija el hechizo " + i + ": \n");
			
			int eleccion = 0;
			
			for(int j = 0; j < hechizosActuales;j++)
			{
				System.out.println(j+1 + ") " + sistema.mostrarHechizos(j));
			}
			
			String hechizo = s.nextLine();
			
			try
			{
				eleccion = Integer.parseInt(hechizo);
			} catch (NumberFormatException e)
			{
				System.out.println("Ingrese un numero correcto");
				break;
			}
			
			if (eleccion < 1 || eleccion > hechizosActuales)
			{
				System.out.println("Error ingrese solo entre los numeros mostrados");
				sistema.eliminarMago(nombre);
			}
			
			else
			{
				String nomHechizo = sistema.mostrarHechizos(eleccion-1);
				sistema.agregarHechizosMagos(nombre, nomHechizo);
			}
		}
		
		sistema.reescribirMagos();
	}
	
	// Modifica los atributod del mago deseado
	public static void modificarMago(Scanner s)
	{
		
		int eleccion = 0;
		
		for (int i = 0; i < sistema.cantidadDeMagos(); i++)
		{
			System.out.println(i+1 + ")" + sistema.mostrarMagos(i));
		}
		
		System.out.print("> ");
		int magoElegido = 0;
		
		String magoSeleccion = s.nextLine();
		try
		{
			magoElegido = Integer.parseInt(magoSeleccion);
		} catch (NumberFormatException e)
		{
			System.out.println("Ingrese solo numeros");
		}
		
		if (magoElegido < 1 || magoElegido > sistema.cantidadDeMagos())
		{
			System.out.println("Elija solo entre los magos mostrados");
		}
		
		else
		{
			do {
				System.out.println("\nQue desea modificar?");
				System.out.println("\n1) Nombre");
				System.out.println("2) Eliminar un hechizo");
				System.out.println("3) Agregar un hechizo");
				System.out.println("4) Cancelar");
				System.out.print("> ");
				
				String entry1 = s.nextLine();
				
				try
				{
					eleccion = Integer.parseInt(entry1);
				} catch (NumberFormatException e)
				{
					System.out.println("Ingrese una opcion valida");
				}
				
				if (eleccion == 1)
				{
					System.out.print("Elija un nuevo nombre: ");
					String nuevoNombre = s.nextLine();
					sistema.cambiarNombre(magoElegido-1, nuevoNombre);
				}
				
				else if (eleccion == 2)
				{
					System.out.println("Que hechizo quieres eliminar?");
					int cantHechizos = sistema.hechizosMago(magoElegido-1);
					///sistema.cambiarHechizo(magoElegido-1);
				}
				
				else if (eleccion == 3)
				{
					
				}
				
			} while (eleccion != 4);
			
		}
		
		
	}
	
	// Elimina un mago deseado
	public static void eliminarMago(Scanner s)
	{
		System.out.println("Que mago quieres eliminar:");
		for (int i = 0; i < sistema.cantidadDeMagos(); i++)
		{
			System.out.println(i+1 + ")" + sistema.mostrarMagos(i));
		}
		
	}
	
	// Agrega un hechizo desde el menu administrador
	public static void agregarHechizo(Scanner s)
	{
		System.out.print("\nIngrese el nombre del hechizo: ");
		String nombreHechizoNuevo = s.nextLine();
		System.out.print("Ingresa el tipo de hechizo: ");
		String tipoHechizoNuevo = s.nextLine();
		
		if (tipoHechizoNuevo.equalsIgnoreCase("Fuego") || tipoHechizoNuevo.equalsIgnoreCase("Tierra")
			|| tipoHechizoNuevo.equalsIgnoreCase("Planta") || tipoHechizoNuevo.equalsIgnoreCase("Agua"))
		{
			if (tipoHechizoNuevo.equalsIgnoreCase("Fuego"))
			{
				System.out.print("Ingresa el daño que hara el hechizo (entero): ");
				String daño = s.nextLine();
				System.out.print("Ingresa el tiempo de quemadura (entero): ");
				String tiempoDeQuemadura = s.nextLine();
				
				int nuevoDaño = 0;
				int nuevoTiempoDeQuemadura = 0;
				
				try
				{
					nuevoDaño = Integer.parseInt(daño);
					nuevoTiempoDeQuemadura = Integer.parseInt(tiempoDeQuemadura);
				} catch (NumberFormatException e)
				{
					System.out.println("Algun valor incorrecto. Vuelva a ingresar");
				}
				
				sistema.crearNuevoHechizoSimple(nombreHechizoNuevo,tipoHechizoNuevo, tiempoDeQuemadura);
			}
		}
		
		else
		{
			System.out.println("Ese tipo no existe");
		}
			
	}
	
	// Funcion que perimite encontrar los diez mejores hechizos
	public static void encontrarDiezHechizos() 
	{
		System.out.println("Los 10 mejores hechizos!");
		for(int i = 0; i < 10; i++)
		{
			String m = sistema.encontrarMejoresHechizos(i);
			System.out.println(i+1 + ") " + m);
		}
	}
	
	// Funcion que permite encontrar los tres mejores magos
	public static void encontrarTresMagos()
	{
		System.out.println("Los 3 mejores Magos!");
		for(int i = 0; i < 3; i++)
		{
			String mago = sistema.mejoresMagos(i);
			System.out.println(i+1 + ") " + mago);
		}
	}
	
	// Funcion que permite mostrar los hechizos tanto con o sin puntaje
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
	
	// Funcion que permite mostrar los magos tanto con o sin puntajes totales
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
