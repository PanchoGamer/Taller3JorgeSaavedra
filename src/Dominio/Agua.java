package Dominio;

public class Agua extends Hechizos{
	private int cantHeal;
	private int presionAgua;
	
	public Agua(String nombreHechizo, String tipo, int damage, int cantHeal, int presionAgua) 
	{
		super(nombreHechizo, tipo, damage);
		this.cantHeal = cantHeal;
		this.presionAgua = presionAgua;
	}
}
