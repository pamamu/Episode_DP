/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura;

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
public class Midicloriano implements Comparable<Midicloriano> {

// ATRIBUTOS ###############################################################
    /**
     * Identificador del Midicloriano
     */
    private final int ID;

// CONSTRUCTORES ###########################################################
    /**
     * Constructor parametrizado del objeto Midicloriano
     *
     * @param ID ID del midicloriano que se crea
     * @pre -
     * @post - Midicloriano creado con ID del parámetro
     * @complex O(1)
     */
    public Midicloriano(int ID) {
        this.ID = ID;
    }

// Getter & Setter #########################################################
    /**
     * Método que devuelve el ID del midicloriano
     *
     * @return ID del midicloriano
     * @pre Midicloriano inicializado correctamente
     * @post -
     * @complex O(1)
     */
    public int getID() {
        return ID;
    }

// PRIVADOS ################################################################
// PÚBLICOS #################################################################
    /**
     * Método para devolver información del midicloriano
     *
     * @return Devuelve String con ID del midicloriano
     * @pre Midicloriano inicializado correctamente
     * @post -
     * @complex O(1)
     */
    @Override
    public String toString() {
        return String.valueOf(ID);
    }

    /**
     * Método para comparar un Midicloriano con la instancia actual
     *
     * @param o Objeto Midicloriano con el que se desea comparar
     * @return Entero indicando si es menor(número negativo), igual(0) o
     * mayor(número positivo)
     * @pre Midicloriano inicializado correctamente
     * @post -
     * @complex O(1)
     */
    @Override
    public int compareTo(Midicloriano o) {
        return Integer.compare(ID, o.getID());
    }

}
