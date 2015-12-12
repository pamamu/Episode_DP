/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura;

import java.util.PriorityQueue;

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
public class EstacionNormal extends EstacionBase {

// ATRIBUTOS ###############################################################
    /**
     * EDD con midiclorianos de cada estacion
     */
    PriorityQueue<Midicloriano> midiclorianos;

// CONSTRUCTORES ###########################################################
    /**
     * Constructor parametrizado de la clase EstacionNormal.
     *
     * @param ID ID con el que inicializar la estación
     * @pre -
     * @post Inicializa la estacion con ID por parámetros y midiclorianos con
     * una nueva PriorityQueue. Llamada a constructor parametrizado de
     * EstacionBase
     * @complex O()
     */
    public EstacionNormal(int ID) {
        super(ID);
        midiclorianos = new PriorityQueue<>();
    }

// Getter & Setter #########################################################
// PRIVADOS ################################################################
// PÚBLICOS #################################################################
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
        String output = "";
        output += super.toString();
        output += midiclorianos.toString();

        return output;
    }

    /**
     * Devuelve que tipo es
     *
     * @return Devuelve el string "Station"
     * @pre
     * @post Devuelve el string "Station"
     * @complex O(1)
     */
    @Override
    public String getType() {
        return "Station";
    }
}
