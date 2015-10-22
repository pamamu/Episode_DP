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
 *
 */
public class GateStation extends BaseStation{

    // ATRIBUTOS ###############################################################
        /** Puerta de la estacion y de la galaxia*/
        public Starsgate starsgate;
        
    
    // CONSTRUCTORES ###########################################################
        /**
	 * <p color="red">
	 * Constructor parametrizado
	 * </p>
	 * 
	 * @param ID<br/>
	 *            ID de la estacion<br/>
         * @param starsgate<br/>
         *            Puerta de la estacion<br/>
	 * @pre ID >= 0
	 * @post ID con valor de parámetro y starsgate = null
	 * @complex O(1)
	 */
        public GateStation(int ID, Starsgate starsgate) {
            super(ID);
            this.starsgate = starsgate;
        }
       
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
		String output = "GateStation Info: \n";
		output += super.toString();
                output += starsgate.toString();

		return output;
	}

	/**
	 * Devuelve que tipo es
	 * 
	 * @return Devuelve el string "GateStation"
	 * @pre 
	 * @post Devuelve el string "GateStation"
	 * @complex O(1)
	 */
        @Override
	public String getType() {
		return "GateStation";
	}
        
}
