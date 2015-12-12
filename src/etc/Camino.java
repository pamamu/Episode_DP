package etc;

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
 * <p color="red">
 * by: Fernando G. & Pablo Macias<br/>
 * Revenge of the Sith™ 2015
 *
 * </p>
 * @author Fernando.G & Pablo Macias
 * @version 1.0 ALFA
 *
 */
public enum Camino {

    NORTE("NORTE", 0, -1), SUR("SUR", 0, 1), ESTE("ESTE", 1, 0), OESTE("OESTE", -1, 0);

    private String camino;
    private int ancho;
    private int alto;

    private Camino(String camino, int ancho, int alto) {
        this.camino = camino;
        this.ancho = ancho;
        this.alto = alto;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }
}
