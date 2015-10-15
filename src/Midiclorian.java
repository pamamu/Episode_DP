/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author naker & Pablo
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
	public int compareTo(Midiclorian o) {
		return this.ID.compareTo(o.getID());
	}

	public boolean equals(Object obj) {
		if (obj instanceof Midiclorian) {
			Midiclorian aux = (Midiclorian) obj;
			return this.getID() == aux.getID();
		}
		return false;
	}
}