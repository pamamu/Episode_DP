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

public class Midiclorian implements Comparable<Midiclorian> {

	private Integer ID;

	/**
	 * @param iD
	 */
	public Midiclorian(Integer iD) {
		ID = iD;
	}

	/**
	 * @return the iD
	 */
	public Integer getID() {
		return ID;
	}

	/**
	 * @param iD
	 *            the iD to set
	 */
	public void setID(Integer iD) {
		ID = iD;
	}

        @Override
        public String toString(){
            
            return this.ID.toString();
        }
        
	@Override
	public int compareTo(Midiclorian o) {
		return this.ID.compareTo(o.getID());
	}

        @Override
	public boolean equals(Object obj) {
		if (obj instanceof Midiclorian) {
			Midiclorian aux = (Midiclorian) obj;
			return this.getID() == aux.getID();
		}
		return false;
	}
}