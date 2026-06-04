package Dominio;

public class Fuego extends Hechizos implements Hechizo{
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
	
	@Override
	public double calcularPuntaje() 
	{
		double puntaje = (getDamage() * tiempoQuemadura);
		return puntaje;
	}
}
