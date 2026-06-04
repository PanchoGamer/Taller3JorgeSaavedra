package Dominio;

public class Hechizos implements Hechizo{
	private String nombreHechizo;
	private String tipo;
	private int damage;
	
	public Hechizos(String nombreHechizo, String tipo, int damage) 
	{
		this.nombreHechizo = nombreHechizo;
		this.tipo = tipo;
		this.damage = damage;
	}

	public String getNombreHechizo() 
	{
		return nombreHechizo;
	}

	public String getTipo() 
	{
		return tipo;
	}

	public int getDamage() 
	{
		return damage;
	}

	@Override
	public String toString() {
		return "Hechizo: " + getNombreHechizo();
	}

	@Override
	public double calcularPuntaje() 
	{
		return 0;
	}
	
}
