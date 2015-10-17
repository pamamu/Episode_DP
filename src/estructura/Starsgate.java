package estructura;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import estructura.Midiclorian;
import java.util.ArrayList;

/**
 *
 * @author naker & Pablo
 */
public class Starsgate {

	/** Cerradura de la StarsGate */
	private GateLock gateLock;

	// PUBLIC METHODS

	/**
	 * Constructor parametrizado
	 * 
	 * @param deepCombination
	 *            Cimbinación de desbloqueo de cerradura
	 * @pre deepCombination > 0
	 * @post Se crea una instancia de StarsGate compuesta por una cerradura con
	 *       profundidad dada.
	 * @complex O(1)
	 */
	public Starsgate(int deepCombination) {
		gateLock = new GateLock(deepCombination);
	}

	/**
	 * Constructor por defecto
	 * 
	 * @pre
	 * @post Se crea una instancia de StarsGate compuesta por una cerradura con
	 *       profundiad 0.
	 * @complex O(1)
	 */
	public Starsgate() {
		gateLock = new GateLock(0);
	}

	/**
	 * Introduce una deepCombination
	 * 
	 * @param deepCombination
	 *            Combinación de desbloqueo que se desea poner
	 * @pre deepCombination > 0
	 * @post DeepCombination de la cerradura se modifica por el valor de
	 *       status(parámetro)
	 * @complex O(1)
	 */
	public void setDeepCombination(int deepCombination) {
		this.gateLock.setDeepCombination(deepCombination);
	}

	/**
	 * Cerrar puerta
	 * 
	 * @pre
	 * @post Cierra la cerradura
	 * @complex O(1)
	 */
	public void close() {
		gateLock.setStatus(false);
	}

	/**
	 * Abre la puerta
	 * 
	 * @pre
	 * @post Abre la cerradura
	 * @complex O(1)
	 */
	public void open() {
		gateLock.setStatus(true);
	}

	/**
	 * Comprueba si la puerta está abierta
	 * 
	 * @return Develve el estado de la puerta. TRUE = Abierto FALSE = Cerrado
	 * @pre
	 * @post Devuelve si la puerta está abierta
	 * @complex O(1)
	 */
	public boolean isOpen() {
		return gateLock.isOpen();
	}

	/**
	 * Comprueba el estado de la puerta
	 * 
	 * @return Devuelve si la puerta está abierta o no al comprobar su estado
	 * @pre
	 * @post Comprueba si se cumplen las condiciones de apertura en la
	 *       cerradura. Devuelve el estado de la cerradura.
	 * @complex O(n)
	 */
	public boolean checkStatus() {
		gateLock.checkStatus();
		return gateLock.isOpen();

	}

	/**
	 * Prueba un midicloriano en la cerradura
	 * 
	 * @param midiclorian
	 *            Midicloriano a probar
	 * @pre midiclorian inicializado correctamente.
	 * @post Si el midicloriano ya se ha probado salta la alarma. Sino, se
	 *       muestra información sobre la prueba en la cerradura y se comprueba
	 *       el estado de apertura.
	 * @complex O(n)
	 */
	public void testMidiclorian(Midiclorian midiclorian) {
		if (!gateLock.testMidiclorian(midiclorian))
			System.out.println("ALARMA: EL MIDICLORIANO SE HA PROBADO POR SEGUNDA VEZ.");
		else
			System.out.println("MIDICLORIANO CON ID: " + midiclorian.getID() + " PROBADO CON EXITO.");
		checkStatus();
		System.out.println(this.gateLock.getInfoGateLock());

	}

	/**
	 * COnfigura la cerradura de la puerta
	 * 
	 * @param midiclorians
	 * Midiclorianos para la configuración de la puerta
	 * @pre midiclorians inicializado correctamente
	 * @post COnfigura la cerradura con los midiclorianos introducidos por parámetros y cierra la puerta.
	 * @complex O(n)
	 */
	public void configure(ArrayList<Midiclorian> midiclorians) {
		this.gateLock.configure(midiclorians);
		this.gateLock.setStatus(false);
	}

	/**
	 * Metodo toString sobrescrito
	 * 
	 * @return String con los datos del tipo(Starsgate) y la cerradura
	 * @pre
	 * @post Devuelve el tipo y toda la información de la cerradura.
	 * @complex O(n)
	 */
	@Override
	public String toString() {

		return getType() + '\n' + this.gateLock.getInfoGateLock();

	}

	/**
	 * Devuelve tipo
	 * 
	 * @return Devuelve el tipo de objeto que es.
	 * @pre
	 * @post Devuelve el string "StarsGate"
	 * @complex O(1)
	 */
	public String getType() {
		return "StarsGate";
	}

}
