package characters;

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

public enum Way {

    NORTH("NORTH", 0, -1), SOUTH("SOUTH", 0, 1), EAST("EAST", 1, 0), WEST("WEST", -1, 0);

    private String Way;
    private int width;
    private int height;

    Way(String way, int width, int height) {
        Way = way;
        this.width = width;
        this.height = height;
    }
}
