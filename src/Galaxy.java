/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author naker
 */

import java.util.ArrayList;

/**
*
* @author naker & Pablo
*/

/*
 * La clase galaxia es un tablero bidimensional compuesto de X Y elementos de la clase
 * Station, cuando llamamos al contructor de Galaxy, este nos genera un tablero X Y
 * que por defecto tendra 8x8 estaciones, si no se especifican el numero de filas
 * y columnas, reasignando aleatoriamente la puerta o estacion de entrada y la
 * puerta o estacion de salida
 */
public class Galaxy {

	private int dimX;
	private int dimY;
	private int deepCombination;
	private int gateStation;
	private Station[][] Stations;
	private Starsgate StarsGate;

	/**
	 * Algoritmo recursivo que balancea los valores de un array y los almacena
	 * en otro
	 * 
	 * @param midiclorians
	 *            ArrayList de midiclorianos que se quieren balancear
	 * @param combinedMidiclorians
	 *            ArrayList de midiclorianos balanceados
	 * @param low
	 *            Indica la cota superior sobre la que se quiere balancear
	 * @param top
	 *            Indica la cota inferior sobre la que se quiere balancear
	 */
	private void combine(ArrayList<Midiclorian> midiclorians, ArrayList<Midiclorian> combinedMidiclorians, int low,
			int top) {
		int middle = (low + top) / 2;
		combinedMidiclorians.add(midiclorians.get(middle)); // Inserta en
															// combinedMidiclorians
															// el midicloriano
															// de la posicion
															// intermedia de
															// midiclorians
		if (low != top) {
			combine(midiclorians, combinedMidiclorians, middle + 1, top);// Recursivo
																			// con
																			// low=mitad+1
																			// y
																			// top
																			// igual
			combine(midiclorians, combinedMidiclorians, low, middle - 1); // recursico
																			// con
																			// low=low
																			// y
																			// top=mitad-1
		}

	}

	/**
	 * Constructor parametrizado de una galaxia
	 * 
	 * @param gateStation
	 *            Estacion donde se coloca la puerta
	 * @param dimX
	 *            Dimension X de la galaxia(número de filas)
	 * @param dimY
	 *            Dimension Y de la galaxia(número de columnas)
	 * @param deepCombination
	 *            Pronfundidad de desbloqueo de la combinación
	 */
	public Galaxy(int gateStation, int dimX, int dimY, int deepCombination) {
		this.dimX = dimX;
		this.dimY = dimY;
		this.deepCombination = deepCombination;
		this.gateStation = gateStation;
		this.Stations = new Station[dimX][dimY];
		this.StarsGate = null;
		for (int i = 0; i < dimX; i++) {
			for (int j = 0; j < dimY; j++) {
				if (gateStation != j + i * dimY)
					Stations[i][j] = new Station(j + i * dimY);
				else
					Stations[i][j] = new Starsgate(gateStation, deepCombination);
			}
		}
	}
	
	public void setStarsGate(Starsgate StarsGate){
		StarsGate.setID(gateStation);
		StarsGate.setDeepCombination(deepCombination);
		this.StarsGate = StarsGate;
	}

	/**
	 * Método para generar un ArrayList de Midiclorianos balanceados a partir
	 * del ArrayList de entrada con una combinación dada.
	 * 
	 * @param midiclorians
	 *            ArrayList<Midiclorian> usado para generar la combinación.
	 * @return Devuelve ArrayList<Midiclorian> con midiclorianos ordenados según
	 *         combinación dada.
	 */
	public ArrayList<Midiclorian> generateCombination(ArrayList<Midiclorian> midiclorians) {
		ArrayList<Midiclorian> combinedMidiclorians = new ArrayList<Midiclorian>();
		combine(midiclorians, combinedMidiclorians, 0, midiclorians.size() - 1);
		return combinedMidiclorians;
	}

	@Override
	public String toString() {
		String output = "";

		for (int i = 0; i < Stations.length; i++) {
			output += "|";
			for (int e = 0; e < Stations[i].length; e++) {

				output += Stations[i][e].getID() + "|";

			}
			output += "\n";
		}

		return output;
	}

	/**
	 * Devuelve información sobre todas las estaciones de la galaxia
	 * 
	 * @return Devuelve String con información sobre la galaxia en
	 *         cuadriculas(estaciones)
	 */

	public String getInfoStations() {
		String output = "";

		for (int i = 0; i < Stations.length; i++) {
			for (int j = 0; j < Stations[i].length; j++) {
				output += " _______________";
			}
			output += "\n";
			// Linea del id de celda
			for (int e = 0; e < Stations[i].length; e++) {
				output += "|" + Stations[i][e].getID() + "\t\t|";
			}
			output += "\n";
			// Linea del tipo
			for (int e = 0; e < Stations[i].length; e++) {
				output += "|" + Stations[i][e].getType() + "\t|";
			}
			output += "\n";
			// Linea de espacio
			for (int e = 0; e < Stations[i].length; e++) {
				output += "|\t\t|";
			}
			output += "\n";
			// Linea de espacio
			for (int e = 0; e < Stations[i].length; e++) {
				output += "|\t\t|";
			}
			output += "\n";
			for (int e = 0; e < Stations[i].length; e++) {
				output += "|\t\t|";
			}
			output += "\n";
			for (int j = 0; j < Stations[i].length; j++) {
				output += "| ______________";
			}
			output += "\n";
		}

		return output;
	}

	/**
	 * Método main donde se inicializan los objetos y se simula el sistema
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Creación de la lista de identificadores impares
		// {1,3,5,7,9,11,13,15,17,19,21,23,25,27,29}

		int numMidis = 15;
		ArrayList<Midiclorian> midicloriansList = new ArrayList<Midiclorian>();
		int j = 1;
		for (int i = 0; i < numMidis; i++) {
			Midiclorian m = new Midiclorian(j);
			System.out.println(j + " - " + (midicloriansList.add(m) ? "insertado" : "error"));
			j += 2;
		}
		
		// Creación del tablero de la galaxia
		// Parámetros: estación de la puerta, nº columnas, nº filas y
		// profundidad de combinación secreta

		int dimX = 6;
		int dimY = 6;
		int gateStation = (dimX * dimY) - 1;
		int deepCombination = 4;
		Galaxy galaxy = new Galaxy(gateStation, dimX, dimY, deepCombination);

		// Algoritmo que reordena los identificadores para crear los
		// midiclorianos en el orden correcto

		System.out.println("SIN ORDENAR");

		for (Midiclorian midiclorian : midicloriansList) {
			System.out.println(midiclorian.getID());
		}

		midicloriansList = galaxy.generateCombination(midicloriansList);

		System.out.println("ORDENADOS");

		for (Midiclorian midiclorian : midicloriansList) {
			System.out.println(midiclorian.getID());
		}


		
		// Crear la puerta de la galaxia

		Starsgate starsgate = new Starsgate();
		System.out.println(starsgate);
		starsgate.configure(midicloriansList);
		starsgate.close();
		galaxy.setStarsGate(starsgate);

		Midiclorian mid;
		mid = new Midiclorian(1);
		starsgate.testMidiclorian(mid);
		mid = new Midiclorian(5);
		starsgate.testMidiclorian(mid);
		mid = new Midiclorian(9);
		starsgate.testMidiclorian(mid);
		mid = new Midiclorian(13);
		starsgate.testMidiclorian(mid);
		mid = new Midiclorian(17);
		starsgate.testMidiclorian(mid);
		mid = new Midiclorian(21);
		starsgate.testMidiclorian(mid);
		mid = new Midiclorian(25);
		starsgate.testMidiclorian(mid);
		mid = new Midiclorian(29);
		starsgate.testMidiclorian(mid);
		mid = new Midiclorian(3);
		starsgate.testMidiclorian(mid);

	}
}
