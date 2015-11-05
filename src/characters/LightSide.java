package characters;

import estructura.Midiclorian;

/**
 * <p color="#01DF01">
 * Este codigo es parte del proyecto StarsWars - DP desarrollado en la
 * Universidad<br/>
 * de Extremadura en el curso 2015 - 2016 en la asignatura Desarrollo de
 * Programas
 * </p>
 * <br/>
 *
 *  @since
 * 		<p color="red">
 *        by: Fernando G. & Pablo Macias<br/>
 *        Revenge of the Sith™ 2015
 *
 *        </p>
 *
 * @author Fernando.G & Pablo Macias
 * @version 1.0 ALFA
 * @since <p color="red">
 * by: Fernando G. & Pablo Macias<br/>
 * Revenge of the Sith™ 2015
 * <p>
 * </p>
 */

public class LightSide extends Character {

    /**
     * Constructor parametrizado
     *
     * @param iD   iD del personaje
     * @param name Nombre del personaje
     */
    LightSide(char iD, String name) {
        super(iD, name);
    }

    /**
     * Inserta un midicloriano en la primera prosición de la ED
     *
     * @param midiclorian midicloriano a insertar en la ED
     */
    void takeMidiclorian(Midiclorian midiclorian) {
        super.midiclorians.add(0, midiclorian);
    }

    /**
     * Borra y devuelve el primer midicloriano almacenado en la estructura de control
     *
     * @return Devuelve el primer midicloriano que tiene almacenado
     */
    Midiclorian getMidiclorian() {
        return super.midiclorians.remove(0);
    }

    /**
     *
     */
    public void onGate(){}

    /**
     * Devuelve tipo
     *
     * @return Devuelve el tipo de objeto que es.
     * @pre
     * @post Devuelve el string "LightSide"
     * @complex O(1)
     */
    public String getType() {
        return "LightSide";
    }
}
