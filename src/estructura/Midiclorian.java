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

public class Midiclorian implements Comparable<Midiclorian> {

	/** Atributo que representa el identificador de un midicloriano */
	private Integer ID;

	/**
	 * Constructor parametrizado
	 * 
	 * @param iD
	 * @pre id > 0
	 * @post A una nueva instancia de midicloriano se le asigna un ID.
	 * @complex O(1)
	 */
	public Midiclorian(Integer iD) {
		ID = iD;
	}

	/**
	 * @return the iD
	 * @pre 
	 * @post 
	 * @complex O()
	 */
	public Integer getID() {
		return ID;
	}

	/**
	 * @param iD
	 *            the iD to set
	 * @pre 
	 * @post 
	 * @complex O()
	 */
	public void setID(Integer iD) {
		ID = iD;
	}

	/**
	 * 
	 * 
	 * @pre 
	 * @post 
	 * @complex O()
	 */
	@Override
	public String toString() {

		return this.ID.toString();
	}

	/**
	 * 
	 * 
	 * @pre 
	 * @post 
	 * @complex O()
	 */
	@Override
	public int compareTo(Midiclorian o) {
		return this.ID.compareTo(o.getID());
	}

	/**
	 * 
	 * 
	 * @pre 
	 * @post 
	 * @complex O()
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Midiclorian) {
			Midiclorian aux = (Midiclorian) obj;
			return this.getID() == aux.getID();
		}
		return false;
	}
}