package estructura;

import java.util.ArrayList;

/**
 *  <p color="#01DF01">
 *     Este codigo es parte del proyecto StarsWars - DP desarrollado en la Universidad<br/>
 *     de Extremadura en el curso 2015 - 2016 en la asignatura Desarrollo de Programas
 *  </p>
 * <br/>
 *  
 *  La clase galaxia es un tablero bidimensional compuesto de X Y elementos de la clase<br/>
 *  Station, cuando llamamos al contructor de Galaxy, este nos genera un tablero X Y<br/>
 *  que por defecto tendra 8x8 estaciones, si no se especifican el numero de filas<br/>
 *  y columnas, reasignando aleatoriamente la puerta o estacion de entrada y la<br/>
 *  puerta o estacion de salida
 * 
 *  @since <p color="red">
 *     by: Fernando G. & Pablo Macias<br/>
 *         Revenge of the Sith™ 2015 
 *      
 * </p>
 *  @author Fernando.G & Pablo Macias
 *  @version 1.0 ALFA
 */

public class Galaxy {

	private int dimX;
	private int dimY;
	private Starsgate starsgate;
	private Station[][] Stations;
        
        /**
	 * Constructor parametrizado de una galaxia
	 * 
	 * @param gateStation
	 *            Estacion donde se coloca la puerta
	 * @param dimX
	 *            Dimension X de la galaxia(numero de filas)
	 * @param dimY
	 *            Dimension Y de la galaxia(numero de columnas)
	 */
	public Galaxy(int gateStation, int dimX, int dimY) {
		
            this.dimX = dimX;
            this.dimY = dimY;
            
            this.starsgate = null;
            this.Stations = new Station[dimX][dimY];

            for (int i = 0; i < dimX; i++) {
                    for (int j = 0; j < dimY; j++) {
                            if (gateStation != j + i * dimY)
                                    Stations[i][j] = new Station(j + i * dimY);
                            else
                                    Stations[i][j] = new Station(j + i * dimY, starsgate);
                    }
            }
	}

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
	private void combine(ArrayList<Midiclorian> midiclorians, ArrayList<Midiclorian> combinedMidiclorians, int low, int top) {
            int middle = (low + top) / 2;
            combinedMidiclorians.add(midiclorians.get(middle)); //Inserta en combinedMidiclorians el midicloriano de la posicion intermedia de midiclorians
            if (low != top) {
                    combine(midiclorians, combinedMidiclorians, middle + 1, top);//Recursivo con low=mitad+1 y top igual
                    combine(midiclorians, combinedMidiclorians, low, middle - 1); //recursico con low=low y top=mitad-1
            }

	}
        

	/**
	 * M�todo para generar un ArrayList de Midiclorianos balanceados a partir
	 * del ArrayList de entrada con una combinaci�n dada.
	 * 
	 * @param midiclorians
	 *            ArrayList<Midiclorian> usado para generar la combinaci�n.
	 * @return Devuelve ArrayList<Midiclorian> con midiclorianos ordenados seg�n
	 *         combinaci�n dada.
	 */
	public ArrayList<Midiclorian> generateCombination(ArrayList<Midiclorian> midiclorians) {
		ArrayList<Midiclorian> combinedMidiclorians = new ArrayList<Midiclorian>();
		combine(midiclorians, combinedMidiclorians, 0, midiclorians.size() - 1);
		return combinedMidiclorians;
	}

	/**
	 * M�todo que inserta una puerta en la galaxia en la posicion fijada.
	 * 
	 * @param starsgate
	 *            Puerta a insertar
	 */
	public void insertGate(Starsgate starsgate) {
		//TODO insertar puerta en la galaxia
//		Station aux = Stations[gateStation / this.dimY][gateStation % this.dimY];
//		if (aux instanceof Starsgate){
//			((Starsgate) aux).copy(starsgate);
//		}
	}
        
        public void setStarsGate(Starsgate StarsGate, int deepCombination){
		//StarsGate.setID(gateStation);
		StarsGate.setDeepCombination(deepCombination);
		this.starsgate = StarsGate;
	}

	@Override
	public String toString() {
		String output = "";

		for (int i = 0; i < Stations.length; i++) {
			output += "|";
			for (int e = 0; e < Stations[i].length; e++) {
                                if(Stations[i][e].haveGate())
                                    output += "STARSGATE ";
				output += Stations[i][e].getID() + "|";
			}
			output += "\n";
		}

		return output;
	}
	
	/**
	 * Devuelve informacion sobre todas las estaciones de la galaxia
	 * 
	 * @return Devuelve String con informacion sobre la galaxia en cuadriculas(estaciones)
	 */

	public String getInfoStations() {
		String output = "";

		for (int i = 0; i < Stations.length; i++) {
			for (int j = 0; j < Stations[i].length; j++) {
				output += " _______________";
			}
			output += "\n";
			//Linea del id de celda
			for (int e = 0; e < Stations[i].length; e++) {
				output += "|" + Stations[i][e].getID() + "\t\t|";
			}
			output += "\n";
			//Linea del tipo
			for (int e = 0; e < Stations[i].length; e++) {
				output += "|" + Stations[i][e].getType() + "\t|";
			}
			output += "\n";
			//Linea de espacio | y si tiene puerta
			for (int e = 0; e < Stations[i].length; e++) {
				if(Stations[i][e].haveGate())
                                    output += "|"+"STARGATE" +"\t|";
                                else
                                    output += "|\t\t|";
			}
			output += "\n";
			//Linea de espacio
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
}