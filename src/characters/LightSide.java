package characters;

import estructura.BaseStation;
import estructura.GateStation;
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
    LightSide(char iD, String name, BaseStation originStation) {
        super(iD, name, originStation);
    }

    /**
     * Inserta un midicloriano en la primera prosición de la ED
     *
     * @param midiclorian midicloriano a insertar en la ED
     */
    void takeMidiclorian(Midiclorian midiclorian) {
        midiclorians.add(0, midiclorian);
    }

    /**
     * Borra y devuelve el primer midicloriano almacenado en la estructura de control
     *
     * @return Devuelve el primer midicloriano que tiene almacenado
     */
    Midiclorian getMidiclorian() {
        return midiclorians.remove(0);
    }


    /**
     * Simula la acción del personaje en una estacion normal.
     * El personaje coge un midicloriano que hubiera en la estacion;
     *
     * @param station
     */
    @Override
    public void onStation(BaseStation station) {
        this.takeMidiclorian(station.collectMidiclorian());
    }

    /**
     * TODO IMPLEMENTAR COMPORTAMIENTO EN ESTACIÓN CON PUERTA
     * @param station
     */
    @Override
    public void onGate(GateStation station) {
        station.starsgate.testMidiclorian(this.getMidiclorian());
    }

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
