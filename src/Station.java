/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author naker
 */
public class Station {

	private int ID;

	/**
	 * Constructor por defecto
	 */
	public Station() {
		this.ID = 0;
	}

	/**
	 * Constructor parametrizado
	 * 
	 * @param iD
	 *            ID de la estaci�n
	 */
	public Station(int iD) {
		this.ID = iD;
	}

	/**
	 * Get the ID
	 * 
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Set the ID
	 * 
	 * @param iD
	 *            the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
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
