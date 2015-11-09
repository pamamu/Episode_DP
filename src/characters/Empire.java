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

public class Empire extends Character{

    /**
     * Constructor parametrizado
     *
     * @param iD
     *      iD del personaje
     * @param name
     *      Nombre del personaje
     */
    Empire(char iD, String name, BaseStation originStation){
        super(iD, name, originStation);
    }

    /**
     * Elimina y devuelve el primer midicloriano que tiene almacenado
     * @return
     * Devuelve el primer midicloriano de la ED
     */
    Midiclorian throwMidiclorian(){
        return super.midiclorians.remove(0);
    }

    /**
     * TODO IMPLEMENTAR COMPORTAMIENTO EN ESTACIÓN NORMAL
     *
     * @param station
     */
    @Override
    public void onStation(BaseStation station) {
        station.insertMidiclorian(this.throwMidiclorian());
    }

    /**
     * TODO IMPLEMENTAR COMPORTAMIENTO EN ESTACION CON PUERTA
     * @param station
     */
    @Override
    public void onGate(GateStation station) {
    }

}