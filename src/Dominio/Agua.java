package Dominio;

public class Agua extends Hechizos implements Hechizo{
	private int cantHeal;
	private int presionAgua;
	
	public Agua(String nombreHechizo, String tipo, int damage, int cantHeal, int presionAgua) 
	{
		super(nombreHechizo, tipo, damage);
		this.cantHeal = cantHeal;
		this.presionAgua = presionAgua;
	}
	
	public int getCantHeal() 
	{
		return cantHeal;
	}

	public int getPresionAgua() 
	{
		return presionAgua;
	}

	@Override
	public double calcularPuntaje() 
	{
		double puntaje = (getDamage() + cantHeal + presionAgua)*2;
		return puntaje;
	}
}
