package characters;

import estructura.BaseStation;

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

public class Contrabandist extends LightSide {
    
    private char classMark = 'C';
    
    public Contrabandist(char iD, String name, BaseStation originStation) {
        super(iD, name, originStation);
    }
    
    @Override
    public String toString() {
        return ""+classMark+"";
    }
}