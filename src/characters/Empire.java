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
    Empire(char iD, String name){
        super(iD, name);
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
     *
     */
    public void onGate(){}

}