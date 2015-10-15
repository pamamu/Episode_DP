package com.dp.proyecto.puerta;

import java.util.ArrayList;

import com.dp.proyecto.edd.Arbol;
import com.dp.proyecto.midiclorians.Midiclorian;

public class GateLock {

	ArrayList<Midiclorian> initialCombination;
	Arbol<Midiclorian> midicloriansCombination;
	Arbol<Midiclorian> testedMidiclorians;

	/** Estado de la cerradura. FALSE = CERRADA ; TRUE = ABIERTA */
	private boolean status;

	/** Profundidad de desbloqueo de la combinación */
	private int deepCombination;

	//PRIVATE METHODS

	/**
	 * Método que calcula la profundidad de un arbol
	 * 
	 * @param arbol
	 *            Arbol sobre el que se quiere clacular la profundidad
	 * @return Devuelve la profundidad del arbol
	 */
	private int getDeep(Arbol<Midiclorian> arbol) {
		if (arbol.vacio())
			return 0;
		int leftDepth = 0, rightDepth = 0;
		leftDepth = (arbol.getHijoIzq() != null) ? getDeep(arbol.getHijoIzq()) : 0;
		rightDepth = (arbol.getHijoDer() != null) ? getDeep(arbol.getHijoDer()) : 0;
		return (rightDepth > leftDepth) ? rightDepth + 1 : leftDepth + 1;
	}

	/**
	 * Método que calcula el número de nodos internos que tiene un arbol
	 * 
	 * @param arbol
	 *            Arbol sobre el que se quiere calcular los nodos internos
	 * @return Devuelve el número de nodos internos del Arbol
	 */
	private int getInteriorNodes(Arbol<Midiclorian> arbol) {
		if (arbol.vacio() || (arbol.getHijoIzq() == null && arbol.getHijoDer() == null))
			return 0;
		int interiorNodes = 1;
		interiorNodes += (arbol.getHijoIzq() != null) ? getInteriorNodes(arbol.getHijoIzq()) : 0;
		interiorNodes += (arbol.getHijoDer() != null) ? getInteriorNodes(arbol.getHijoDer()) : 0;
		return interiorNodes;
	}

	private void cleanTree(Arbol<Midiclorian> arbol) {
		while (!arbol.vacio())
			arbol.borrar(arbol.getRaiz());
	}

	/**
	 * Método que calcula el número de nodos externos que tiene un arbol
	 * 
	 * @param arbol
	 *            Arbol sobre el que se quiere calcular los nodos externos
	 * @return Devuelve el número de nodos externos del Arbol
	 */

	private int getExteriorNodes(Arbol<Midiclorian> arbol) {
		if (arbol.vacio())
			return 0;
		int exteriorNodes = 0;
		if (arbol.getHijoIzq() == null && arbol.getHijoDer() == null)
			exteriorNodes++;
		exteriorNodes += (arbol.getHijoIzq() != null) ? getExteriorNodes(arbol.getHijoIzq()) : 0;
		exteriorNodes += (arbol.getHijoDer() != null) ? getExteriorNodes(arbol.getHijoDer()) : 0;
		return exteriorNodes;
	}

	//PUBLIC METHODS

	public GateLock(int deepCombination) {
		this.deepCombination = deepCombination;
		this.midicloriansCombination = new Arbol<Midiclorian>();
		this.testedMidiclorians = new Arbol<Midiclorian>();
		this.initialCombination = new ArrayList<Midiclorian>();
		this.status = true;
	}

	/**
	 * @return Devuelve true si está abierta
	 */
	public boolean isOpen() {
		return status;
	}

	/**
	 * @param status
	 *            El estado a poner. FALSE = CERRADA ; TRUE = ABIERTA
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * @return Devuelve la profundidad de la combinación.
	 */
	public int getDeepCombination() {
		return deepCombination;
	}

	/**
	 * @param deepCombination
	 *            La profundidad de la combinación
	 */
	public void setDeepCombination(int deepCombination) {
		this.deepCombination = deepCombination;
	}

	public boolean testMidiclorian(Midiclorian midiclorian) {
		if (testedMidiclorians.pertenece(midiclorian))
			return false;
		if (midicloriansCombination.pertenece(midiclorian))
			midicloriansCombination.borrar(midiclorian);
		this.testedMidiclorians.insertar(midiclorian);
		return true;

	}

	public void restart() {
		cleanTree(midicloriansCombination);
		cleanTree(testedMidiclorians);
		configure(initialCombination);

	}

	public void configure(ArrayList<Midiclorian> midiclorians) {
		this.initialCombination.clear();
		for (int i = 0; i < midiclorians.size(); i++) {
			Midiclorian m = midiclorians.get(i);
			this.midicloriansCombination.insertar(m);
			this.initialCombination.add(m);
		}
	}

	public void checkStatus() {
		System.out.println(getDeep(midicloriansCombination) + "prof");
		System.out.println(this.deepCombination + "deepcombination");
		System.out.println(getInteriorNodes(midicloriansCombination) + "interior");
		System.out.println(getExteriorNodes(midicloriansCombination) + "exterior");
		if (getDeep(midicloriansCombination) < this.deepCombination && getInteriorNodes(midicloriansCombination) >= getExteriorNodes(midicloriansCombination))
			status = true;

	}

	public String getInfoGateLock() {
		String output = "";
		output += "Estado de la puerta: " + ((this.status) ? "ABIERTA" : "CERRADA");
		output += "\n\tAltura Cerradura: " + getDeep(midicloriansCombination);
		output += "\n\tMidiclorianos Internos: " + getInteriorNodes(midicloriansCombination);
		output += "\n\tMidiclorianos Externos: " + getExteriorNodes(midicloriansCombination);
		return output;
	}

	public static void main(String[] args) {
		GateLock cerradura = new GateLock(5);
		System.out.println(cerradura.getInfoGateLock());
		//		
		//		Midiclorian m = new Midiclorian(5);
		//		cerradura.testMidiclorian(m);
		//		m = new Midiclorian(2);
		//		cerradura.testMidiclorian(m);
		//		m = new Midiclorian(1);
		//		cerradura.testMidiclorian(m);
		//		m = new Midiclorian(4);
		//		cerradura.testMidiclorian(m);
		//		m = new Midiclorian(6);
		//		cerradura.testMidiclorian(m);
		//		m = new Midiclorian(8);
		//		cerradura.testMidiclorian(m);
		//		m = new Midiclorian(7);
		//		cerradura.testMidiclorian(m);
		//		m = new Midiclorian(9);
		//		cerradura.testMidiclorian(m);
		//		System.out.println(cerradura.getInteriorNodes(cerradura.testedMidiclorians));
		//		
	}

}