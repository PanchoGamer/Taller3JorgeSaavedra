package Logica;

public interface Sistema {
	
	void crearMagos(String linea);
	void crearHechizos(String linea);
	String encontrarMejoresHechizos(int index);
	String mejoresMagos(int index);
	void agregarHechizosMagos(String nombre, String hechizo);
	void agregarMago(String nombre);
	int cantidadDeHechizos();
	String mostrarHechizos(int index);
	int cantidadDeMagos();
	String mostrarMagos(int index);
	String mostrarHechizosConPuntaje(int index);
	String mostrarMagosConPuntaje(int index);
}
