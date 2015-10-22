package estructura;

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
 * @deprecated 
 * 
 *      Se desaconseja el uso de esta clase, ya que ha sido reestructurada la 
 *      estructura del proyecto siendo su uso el de NormalStation y GateStation
 * 
 * @see BaseStation
 * @see NormalStation
 * @see GateStation
 */
public class Station {

	// ATRIBUTOS ############################################################

	// Privados
	/** Identificador de la Estación */
	private int ID;

	// Publicos
	/** Starsgate */
	public Starsgate starsgate;

	// CONSTRUCTORES ########################################################
	/**
	 * <p color="red">
	 * Constructor parametrizado sin atributos especiales
	 * </p>
	 * <br/>
	 * No posee ni midicloriano, ni puerta
	 * 
	 * @param ID<br/>
	 *            ID de la estacion<br/>
	 * @pre ID >= 0
	 * @post ID con valor de parámetro y starsgate = null
	 * @complex O(1)
	 */
	public Station(int ID) {
		this.ID = ID;
		this.starsgate = null;
	}
	

	/**
	 * Constructor parametrizado con puerta.<br/>
	 * Al poseer puerta, dicha estacion no tendra midicloriano asociado
	 *
	 * @param ID
	 *            ID de la estacion
	 * @param starsgate
	 *            Starsgate asociada a una estacion, en caso de poseer
	 * @pre ID >=0, starsgate inicializada correctamente
	 * @post ID y starsgate con valores del parámetro
	 * @complex O(1)
	 */
	public Station(int ID, Starsgate starsgate) {
		this.ID = ID;
		this.starsgate = starsgate;
	}

	// Getter & Setter ######################################################
	/**
	 * Get ID
	 * 
	 * @return the iD
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
	 * @post Introduce el parámetro como valor en unn atributo de la instancia
	 * @complex O(1)
	 */
	public void setID(int iD) {
		ID = iD;
	}

	// PRIVADOS #############################################################

	// PUBLICOS #############################################################

	/**
	 * Comporbar si tiene puerta o no
	 * 
	 * @return Devuelve TRUE si tiene puerta, FALSE si no la tiene.
	 * @pre 
	 * @post Devuelve TRUE si la estación contiene una starsgate, FALSE en el otro caso.
	 * @complex O(1)
	 */
	public boolean haveGate() {
		return (this.starsgate != null);
	}

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

		return output;
	}

	/**
	 * Devuelve que tipo es
	 * 
	 * @return Devuelve el string "Station"
	 * @pre 
	 * @post Devuelve el string "Station"
	 * @complex O(1)
	 */
	public String getType() {
		return "Station";
	}

}
