package estructura;

import java.util.LinkedList;
import java.util.Queue;


/**
 * <p color="#01DF01">
 * Este codigo es parte del proyecto StarsWars - DP desarrollado en la
 * Universidad<br/>
 * de Extremadura en el curso 2015 - 2016 en la asignatura Desarrollo de
 * Programas
 * </p>
 * <br/>
 * 
 * @since
 * 		<p color="red">
 *        by: Fernando G. & Pablo Macias<br/>
 *        Revenge of the Sith™ 2015
 * 
 *        </p>
 * @author Fernando.G & Pablo Macias
 * @version 1.0 ALFA
 *
 */
public class BaseStation {
    // ATRIBUTOS ###############################################################

	// Privados
	/** Identificador de la Estación */
	private int ID;
        /** Cola de personajes*/
        private Queue<personajes.Personaje> personajes;

    // CONSTRUCTORES ###########################################################
	/**
	 * <p color="red">
	 * Constructor parametrizado
	 * </p>
	 * 
	 * @param ID<br/>
	 *            ID de la estacion<br/>
	 * @pre ID >= 0
	 * @post ID con valor de parámetro
	 * @complex O(1)
	 */
	public BaseStation(int ID) {
		this.ID = ID;
                this.personajes = new LinkedList<>();
	}
        
    // Getter & Setter #########################################################
	/**
	 * Get ID
	 * 
	 * @return int iD
	 * @pre 
	 * @post Devuelve el ID de la estación
	 * @complex O(1)
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Set ID
	 * 
	 * @param iD<br/>
	 *            the iD to set
	 * @pre ID >=0
	 * @post Introduce el parámetro como valor en un atributo de la instancia
	 * @complex O(1)
	 */
	public void setID(int iD) {
		ID = iD;
	}

    // PRIVADOS ################################################################

    //PUBLICOS #################################################################
        /**
	 * Devuelve información sobre la Estación
	 * 
	 * @return Devuelve string con información sobre la estación
	 * @pre 
	 * @post Devuelve el ID y toda la información de la estación.
	 * @complex O(1)
	 */
	@Override
	public String toString() {
		String output = "Station Info: \n";
		output += "ID " + ID + "\n";
                output += "Personajes: \n" + personajes.toString();

		return output;
	}

	/**
	 * Devuelve que tipo es
	 * 
	 * @return Devuelve el string "BaseStation"
	 * @pre 
	 * @post Devuelve el string "BaseStation"
	 * @complex O(1)
	 */
	public String getType() {
		return "BaseStation";
	}

}
