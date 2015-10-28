package characters;

import estructura.Midiclorian;
import java.util.ArrayList;

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
public class Character {

	/** Marca identificativa */
	private char iD;

	/** Variable que indica el nombre del personaje */
	private String name;

	/** ArrayList de los midiclorianos que porta el personaje */
	private ArrayList<Midiclorian> midiclorians;

	/** */
	private ArrayList<String> route;

	/** */
	private int position;

	/**
	 * Constructor por defecto
	 */
	public Character() {
		this.iD = ' ';
		this.name = "";
		this.midiclorians = new ArrayList<Midiclorian>();
	}

	/**
	 * Constructor parametrizado
	 *
	 * @param iD
	 *            marca identificativa del personaje
	 * @param name
	 *            nombre del personaje
	 */
	public Character(char iD, String name) {
		this.iD = iD;
		this.name = name;
		this.midiclorians = new ArrayList<Midiclorian>();
	}

	/**
	 * @param midiclorianos
	 *            El/La midiclorianos a poner
	 */
	public void setMidiclorianos(ArrayList<Midiclorian> midiclorians) {
		this.midiclorians = midiclorians;
	}

	/**
	 * Introduce un midicloriano en la ED del personaje
	 * 
	 * @param midiclorian
	 */
	public void cogerMidicloraino(Midiclorian midiclorian) {
		this.midiclorians.add(midiclorian);
	}

	/**
	 * Elimina el ultimo midicloriano que tiene almacenado el personaje en la ED
	 */
	public void tirarMidicloriano() {
		this.midiclorians.remove(midiclorians.size() - 1);
	}

	public void onGate() {

	}

	public void catchMidiclorian() {

	}

	public void move() {

	}
}
