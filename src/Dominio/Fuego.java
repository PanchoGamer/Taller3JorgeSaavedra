package Dominio;

public class Fuego extends Hechizos{
	private int tiempoQuemadura;

	public Fuego(String nombreHechizo, String tipo, int damage, int tiempoQuemadura) 
	{
		super(nombreHechizo, tipo, damage);
		this.tiempoQuemadura = tiempoQuemadura;
	}

	public int getTiempoQuemadura() 
	{
		return tiempoQuemadura;
	}
}
