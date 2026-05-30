package Dominio;

public class Planta extends Hechizos{
	private int duracionStun;
	private int cantPlantas;
	
	public Planta(String nombreHechizo, String tipo, int damage, int duracionStun, int cantPlantas) 
	{
		super(nombreHechizo, tipo, damage);
		this.duracionStun = duracionStun;
		this.cantPlantas = cantPlantas;
	}

	public int getDuracionStun() 
	{
		return duracionStun;
	}

	public int getCantPlantas() 
	{
		return cantPlantas;
	}
}
