
import estructura.Galaxy;
import estructura.Starsgate;
import estructura.Midiclorian;
import java.util.ArrayList;

/**
 *  <p color="#01DF01">
 *     Este codigo es parte del proyecto StarsWars - DP desarrollado en la Universidad<br/>
 *     de Extremadura en el curso 2015 - 2016 en la asignatura Desarrollo de Programas
 *  </p>
 * <br/>
 * 
 *  @since <p color="red">
 *     by: Fernando G. & Pablo Macias<br/>
 *         Revenge of the Sith™ 2015 
 *      
 * </p>
 *  @author Fernando.G & Pablo Macias
 *  @version 1.0 ALFA
 *
 */
public class Main {
    /**
	 * M�todo main donde se inicializan los objetos y se simula el sistema
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
            // CreaciÛn de la lista de identificadores impares
		// {1,3,5,7,9,11,13,15,17,19,21,23,25,27,29}

		int numMidis = 15;
                int deepCombination = 4;
                
		ArrayList<Midiclorian> midicloriansList = new ArrayList<Midiclorian>();
		int j = 1;
		for (int i = 0; i < numMidis; i++) {
			Midiclorian m = new Midiclorian(j);
			System.out.println(j + " - " + (midicloriansList.add(m) ? "insertado" : "error"));
			j += 2;
		}
		
		// CreaciÛn del tablero de la galaxia
		// Par·metros: estaciÛn de la puerta, n∫ columnas, n∫ filas y
		// profundidad de combinaciÛn secreta

		int dimX = 6;
		int dimY = 6;
		int gateStation = (dimX * dimY) - 1;
		
		Galaxy galaxy = new Galaxy(gateStation, dimX, dimY);

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
		galaxy.setStarsGate(starsgate, deepCombination);

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
