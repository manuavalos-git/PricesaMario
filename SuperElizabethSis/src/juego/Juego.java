package juego;


import java.util.LinkedList;

import entorno.Entorno;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	private Princesa prin;
	private Obstaculos obs;
	private Soldados sold;
	private Boladefuego bola;
	private LinkedList <Boladefuego> listaBol;

	
	
	
	// Variables y métodos propios de cada grupo
	// ...
	
	Juego()
	{
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Super Elizabeth Sis - Grupo 13", 800, 600);
		this.prin = new Princesa(150,500,60,30);
		this.obs= new Obstaculos(825,500,20,30);
		this.sold= new Soldados(750,500,60,30);
		this.bola= new Boladefuego(prin.getX(),prin.getY(),20);
		listaBol = new LinkedList <Boladefuego>();
		
		
	
	

		// Inicia el juego!
		this.entorno.iniciar();
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick()
	{
		// Procesamiento de un instante de tiempo
		// ...

		prin.dibujar(this.entorno);
		if(this.entorno.estaPresionada(this.entorno.TECLA_DERECHA) && prin.getX()<this.entorno.ancho()/2) {
			prin.moverDerecha();
		}
		if(this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA)&& prin.getX()>20) {
			prin.moverIzquierda();
		}
		if(this.entorno.sePresiono(this.entorno.TECLA_ESPACIO)) {
			listaBol.add(new Boladefuego(prin.getX(),prin.getY(),20));
		}
		
		for(Boladefuego bola:listaBol) {
			bola.dibujar(entorno);
			bola.moverDerecha();
		}
		for(Boladefuego bola:listaBol) {
			if ((bola.getX()== sold.getX())|| bola.getX()==800) {
				listaBol.remove(bola);
			}
			
		
		}
		obs.dibujar(this.entorno);
		obs.moverIzquierda();
		sold.dibujar(this.entorno);
		sold.moverIzquierda() ;
		
	}

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
