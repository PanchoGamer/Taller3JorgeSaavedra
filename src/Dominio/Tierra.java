package Dominio;

public class Tierra extends Hechizos implements Hechizo{
	private int mejoraDefensa;

	public Tierra(String nombreHechizo, String tipo, int damage, int mejoraDefensa) 
	{
		super(nombreHechizo, tipo, damage);
		this.mejoraDefensa = mejoraDefensa;
	}

	public int getMejoraDefensa() 
	{
		return mejoraDefensa;
	}
	
	@Override
	public double calcularPuntaje() 
	{
		double puntaje = (getDamage() * mejoraDefensa)/2;
		return puntaje;
	}
}
