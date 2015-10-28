package estructura;

import java.util.LinkedList;
import java.util.List;

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
public class NormalStation extends BaseStation{
    
    // ATRIBUTOS ###############################################################
        /** Lista de midiclorianos que posee la estacion*/
        private List<Midiclorian> midiclorians; //TODO ¿cola?
        
        //TODO EDD de personajes en la estación
        
    // CONSTRUCTORES ###########################################################
        /**
	 * <p color="red">
	 * Constructor parametrizado
	 * </p>
	 * 
	 * @param ID<br/>
	 *            ID de la estacion<br/>
	 * @pre ID >= 0
	 * @post ID con valor de parámetro y starsgate = null
	 * @complex O(1)
	 */
        public NormalStation(int ID) {
            super(ID);
            this.midiclorians = new LinkedList<>();
        }
        
        /**
	 * <p color="red">
	 * Constructor parametrizado
	 * </p>
	 * 
	 * @param ID<br/>
	 *            ID de la estacion<br/>
         * @param midiclorians <br/>
	 *            Lista de midiclorianos<br/>
	 * @pre ID >= 0
         * @pre midiclorians Lista definida de midiclorianos
	 * @post ID con valor de parámetro
	 * @complex O(1)
	 */
        public NormalStation(int ID, LinkedList<Midiclorian> midiclorians) {
            super(ID);
            this.midiclorians = midiclorians;
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
		String output = "";
		output += super.toString();
                output += midiclorians.toString();

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
        @Override
	public String getType() {
		return "Station";
	}
        
    //TODO Metodo simular() Sesion03
    
    
}
