package Logica;

public interface Sistema {
	
	void crearMagos(String linea);
	void crearHechizos(String linea);
	String encontrarHechizos(int index);
	void mejoresMagos();
	void agregarHechizosMagos(String nombre, String hechizo);
	void agregarMago(String nombre);
}
