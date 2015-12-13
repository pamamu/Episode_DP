/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personajes;

import estructura.EstacionBase;
import estructura.EstacionPuerta;
import estructura.Midicloriano;

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
public class LightSide extends Personaje {

// ATRIBUTOS ###############################################################
// CONSTRUCTORES ###########################################################
    /**
     * Constructor parametrizado de la clase Personaje
     *
     * @param marcaClase Marca de clase con la que inicializar el Personaje
     * @param estacionPosicion ID de la estación donde se quiere insertar el
     * personaje
     * @param turnoInicio Turno en el que se empieza a mover al personaje
     * @pre -
     * @post Instacia de LightSide inicializada con marcaClase y
     * estacionPosicion por parámetros y midiclorianos como nueva ArrayList.
     * Inserta en la estacionPosicion al personaje.
     * @complex O(1)
     */
    public LightSide(char marcaClase, int estacionPosicion, int turnoInicio) {
        super(marcaClase, estacionPosicion, turnoInicio);
    }

// Getter & Setter #########################################################
// PRIVADOS ################################################################
// PÚBLICOS #################################################################
    /**
     * Método que acciona el comportamiento de un personaje en una puerta.
     *
     * @pre LightSide inicializado correctamente e insertado dentro de la
     * Galaxia
     * @post Saca un midicloriano del LightSide con scarMidicloriano(), guarda
     * la estacionPosicion como una EstacionPuerta, y si el midicloriano sacada
     * no es null, lo prueba en la cerradura la estacion con puerta.
     * @complex O(n)
     */
    @Override
    public void accionPuerta() {
        Midicloriano midicloriano = sacarMidicloriano();
        EstacionPuerta puerta = (EstacionPuerta) estacionPosicion;
        if (midicloriano != null) {
            puerta.cerradura.probarMidicloriano(sacarMidicloriano());
        }
    }

    /**
     * Método que acciona el comportamiento de un personaje en una puerta
     *
     * @pre LightSide inicializado correctamente e insertado dentro de la
     * Galaxia
     * @post Guarda la estacionPosicion, saca un midicloriano de la estacion con
     * sacarMidicloriano(), y si el midicloriano sacado es distinto de null, se
     * almacena en la ED de midiclorianos del LightSide con
     * recogerMidicloriano()
     * @complex O(1)
     */
    @Override
    public void accionEstacion() {
        Midicloriano midicloriano = estacionPosicion.sacarMidicloriano();
        if (midicloriano != null) {
            recogerMidicloriano(midicloriano);
        }
    }

}
