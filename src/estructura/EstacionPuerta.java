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
public class EstacionPuerta extends EstacionBase {

// ATRIBUTOS ###############################################################
    /**
     * Cerradura de la Estación
     */
    public Cerradura cerradura;

// CONSTRUCTORES ###########################################################
    /**
     * Constructor parametrizado de la clase EstacionPuerta
     *
     * @param ID ID con el que inicializar la Estacion
     * @param cerradura Cerradura con la inicializar la estación
     * @pre -
     * @post Estacion inicializada con parámetros dados. Llamada a clase padre
     * ESTACIONBASE
     * @complex O(1)
     */
    public EstacionPuerta(int ID, Cerradura cerradura) {
        super(ID);
        this.cerradura = cerradura;
    }
// Getter & Setter #########################################################
// PRIVADOS ################################################################
// PÚBLICOS ################################################################

    /**
     * Método que devuelve si una estacion es de tipo puerta o no
     *
     * @return Deuvelve valor booleano con información sobre si la pestacion es
     * una puerta o no. Devuelve false.
     * @pre EstacionBase inicializada correctamente
     * @post Devuelve true
     * @complex O(1)
     */
    @Override
    public boolean esPuerta() {
        return true;
    }

    /**
     * Devuelve información sobre la Estación
     *
     * @return Devuelve string con información sobre la estación
     * @pre
     * @post Devuelve el ID y toda la información de la estación.
     * @complex O(1)
     */
    @Override
    public String toString() {
        String output = "EstacionPuerta Info: \n";
        output += super.toString();
        if (this.cerradura != null) {
            cerradura.toString();
        }

        return output;
    }

    /**
     * Devuelve de que tipo es la EstacionPuerta
     *
     * @return Devuelve el string "GateStation"
     * @pre
     * @post Devuelve el string "GateStation"
     * @complex O(1)
     */
    @Override
    public String getType() {
        return "GateStation";
    }

}
