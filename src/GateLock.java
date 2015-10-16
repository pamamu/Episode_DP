package dp.proyecto.structures;

import java.util.ArrayList;

import dp.proyecto.edd.Arbol;

public class GateLock {

	/** Midiclorianos ordenados con la configuraci�n inicial */
	ArrayList<Midiclorian> initialCombination;
	/** Combinaci�n de midiclorianos de la cerradura */
	Arbol<Midiclorian> midicloriansCombination;
	/** Midiclorianos probados */
	Arbol<Midiclorian> testedMidiclorians;

	/** Estado de la cerradura. FALSE = CERRADA ; TRUE = ABIERTA */
	private boolean status;

	/** Profundidad de desbloqueo de la combinaci�n */
	private int deepCombination;

	// PRIVATE METHODS

	/**
	 * M�todo que calcula la profundidad de un arbol
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
	 * M�todo que calcula el n�mero de nodos internos que tiene un arbol
	 * 
	 * @param arbol
	 *            Arbol sobre el que se quiere calcular los nodos internos
	 * @return Devuelve el n�mero de nodos internos del Arbol
	 */
	private int getInteriorNodes(Arbol<Midiclorian> arbol) {
		if (arbol.vacio() || (arbol.getHijoIzq() == null && arbol.getHijoDer() == null))
			return 0;
		int interiorNodes = 1;
		interiorNodes += (arbol.getHijoIzq() != null) ? getInteriorNodes(arbol.getHijoIzq()) : 0;
		interiorNodes += (arbol.getHijoDer() != null) ? getInteriorNodes(arbol.getHijoDer()) : 0;
		return interiorNodes;
	}

	/**
	 * M�todo para inicializar un arbol
	 * 
	 * @param arbol
	 *            Arbol que se quiere inicializar
	 */

	private void cleanTree(Arbol<Midiclorian> arbol) {
		arbol = new Arbol<Midiclorian>();
	}

	/**
	 * M�todo que calcula el n�mero de nodos externos que tiene un arbol
	 * 
	 * @param arbol
	 *            Arbol sobre el que se quiere calcular los nodos externos
	 * @return Devuelve el n�mero de nodos externos del Arbol
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

	// PUBLIC METHODS

	/**
	 * Constructor param�trizado de GateLock
	 * 
	 * @param deepCombination
	 *            Profundidad de desbloqueo de la combinaci�n
	 */

	public GateLock(int deepCombination) {
		this.deepCombination = deepCombination;
		this.midicloriansCombination = new Arbol<Midiclorian>();
		this.testedMidiclorians = new Arbol<Midiclorian>();
		this.initialCombination = new ArrayList<Midiclorian>();
		this.status = true;
	}

	/**
	 * M�todo para saber si la cerradura est� abierta
	 * 
	 * @return Devuelve true si est� abierta
	 */
	public boolean isOpen() {
		return status;
	}

	/**
	 * Set de estado.
	 * 
	 * @param status
	 *            El estado a poner. FALSE = CERRADA ; TRUE = ABIERTA
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * Get de Profundidad de desbloqueo de la cerradura
	 * 
	 * @return Devuelve la profundidad de la combinaci�n.
	 */
	public int getDeepCombination() {
		return deepCombination;
	}

	/**
	 * Set de Profundidad de desbloqueo de la cerradura
	 * 
	 * @param deepCombination
	 *            La profundidad de la combinaci�n
	 */
	public void setDeepCombination(int deepCombination) {
		this.deepCombination = deepCombination;
	}

	/**
	 * M�todo para probar un midicloriano en la cerradura
	 * 
	 * @param midiclorian
	 *            Midicloriano que se quiere probar
	 * @return Devuelve FALSE si el midicloriano no se encuentra en la combinaci�n, TRUE si
	 */
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
		if (getDeep(midicloriansCombination) < this.deepCombination
				&& getInteriorNodes(midicloriansCombination) >= getExteriorNodes(midicloriansCombination))
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
		// GateLock cerradura = new GateLock(5);
		// System.out.println(cerradura.getInfoGateLock());
		//
		// Midiclorian m = new Midiclorian(5);
		// cerradura.testMidiclorian(m);
		// cerradura.checkStatus();
		// m = new Midiclorian(2);
		// cerradura.testMidiclorian(m);
		// m = new Midiclorian(1);
		// cerradura.testMidiclorian(m);
		// m = new Midiclorian(4);
		// cerradura.testMidiclorian(m);
		// m = new Midiclorian(6);
		// cerradura.testMidiclorian(m);
		// m = new Midiclorian(8);
		// cerradura.testMidiclorian(m);
		// m = new Midiclorian(7);
		// cerradura.testMidiclorian(m);
		// m = new Midiclorian(9);
		// cerradura.testMidiclorian(m);
		// System.out.println(cerradura.getInteriorNodes(cerradura.testedMidiclorians));
		//
	}

}