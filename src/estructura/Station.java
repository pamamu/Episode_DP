package estructura;

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
public class Station {
        
    
        //ATRIBUTOS ############################################################
    
        //Privados
	private int ID;
        private Midiclorian midicloriano;
        
        //Publicos
        public Starsgate starsgate;
        
        //CONSTRUCTORES ########################################################
	/**
	 * <p color="red">
         *      Constructor parametrizado sin atributos especiales
         * </p><br/>
         * No posee ni midicloriano, ni puerta
	 * 
	 * @param ID<br/>
         *      ID de la estacion<br/>
	 */
	public Station(int ID) {
		this.ID = ID;
                this.midicloriano = null;
                this.starsgate = null;
	}

	/**
	 * <p color="red">
         *      Constructor parametrizado con midicloriano
         * </p><br/>
         * Al poseer midicloriano, la estacion no tendra puerta
	 * 
	 * @param ID<br/>
                ID de la estacion<br/>
         * @param midicloriano<br/>
         *      Midicloriano asignado a la estacion, en caso de poseer<br/>
	 */
	public Station(int ID, Midiclorian midicloriano) {
		this.ID = ID;
                this.midicloriano = midicloriano;
                this.starsgate = null;
	}
        /**
         * Constructor parametrizado con puerta.<br/>
         * Al poseer puerta, dicha estacion no tendra midicloriano asociado
         *
         * @param ID
	 *      ID de la estacion
         * @param starsgate 
         *      Starsgate asociada a una estacion, en caso de poseer
         */
        public Station(int ID, Starsgate starsgate){
            this.ID = ID;
            this.midicloriano = null;
            this.starsgate = starsgate;
        }
        
        //Getter & Setter ######################################################
	/**
	 * Get ID
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Set ID
	 * @param iD<br/>
	 *      the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}
	
        
        //PRIVADOS #############################################################
        
        //PUBLICOS #############################################################
        
        public boolean haveGate(){
            return (this.starsgate != null);
        }
        
	/**
	 * Devuelve informaci�n sobre la Estaci�n
	 * 
	 * @return Devuelve string con informaci�n sobre la estaci�n
	 */
        @Override
        public String toString() {
            String output="Station Info: \n";

            output += "ID " + ID + "\n";

            return output;
        }

	/**
	 * Devuelve que tipo es
	 * 
	 * @return Devuelve el string "Station"
	 */
        public String getType(){
            return "Station ";
        }

}
