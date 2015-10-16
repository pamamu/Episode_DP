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

	private GateLock gateLock;

	// PUBLIC METHODS

	public Starsgate(int deepCombination) {
            gateLock = new GateLock(deepCombination);
	}

	public Starsgate() {
            gateLock = new GateLock(0);
	}

	public void setDeepCombination(int deepCombination){
            this.gateLock.setDeepCombination(deepCombination);		
	}
        
        
	/**
	 * 
	 */
	public void close() {
                gateLock.setStatus(false);
	}

	/**
	 * 
	 */
	public void open() {
		gateLock.setStatus(true);
	}

	/**
	 * TODO
	 * 
	 * @return
	 */
	public boolean isOpen() {
		return gateLock.isOpen();
	}

	/**
	 * TODO
	 * 
	 * @return
	 */
	public boolean checkStatus() {
                gateLock.checkStatus();
		return gateLock.isOpen();

	}

	/**
	 * TODO
	 * 
	 * @param midiclorian
	 */
	public void testMidiclorian(Midiclorian midiclorian) {
		if (!gateLock.testMidiclorian(midiclorian))
			System.out.println("ALARMA: EL MIDICLORIANO SE HA PROBADO POR SEGUNDA VEZ.");
		else
			System.out.println("MIDICLORIANO CON ID: " + midiclorian.getID() + " PROBADO CON EXITO.");
		checkStatus();
		System.out.println(this.gateLock.getInfoGateLock());

	}

	public void configure(ArrayList<Midiclorian> midiclorians) {
		this.gateLock.configure(midiclorians);
		this.gateLock.setStatus(false);
	}

	@Override
	public String toString() {

		return getType() + '\n' + this.gateLock.getInfoGateLock();

	}

	/**
	 * Devuelve que tipo es
	 * 
	 * @return Devuelve el string "StarsGate"
	 */
	public String getType() {
		return "StarsGate";
	}


}
