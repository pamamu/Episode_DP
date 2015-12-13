/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personajes;

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
public class Imperial extends Personaje {

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
     * @post Instacia de Imperial inicializada con marcaClase y
     * estacionPosicion por parámetros y midiclorianos como nueva ArrayList.
     * Inserta en la estacionPosicion al personaje.
     * @complex O(1)
     */
    public Imperial(char marcaClase, int estacionPosicion, int turnoInicio) {
        super(marcaClase, estacionPosicion, turnoInicio);
    }

// Getter & Setter #########################################################
// PRIVADOS ################################################################
// PÚBLICOS #################################################################
    /**
     * Método para acción del personaje Imperial en una puerta.
     *
     * @pre Imperial inicializado con éxito
     * @post Se guarda la estacionPosicion como EstacionPuerta, se reinicia la
     * puerta de la estación con puerta y se ejecuta el movimiento del
     * personaje.
     * @complex O(n)
     */
    @Override
    public void accionPuerta() {
        EstacionPuerta puerta = (EstacionPuerta) estacionPosicion;
        puerta.cerradura.reiniciar();
        mover();
    }

    /**
     * Método para acción del personaje Imperial en una estación normal.
     *
     * @pre Imperial inicializado con éxito
     * @post Si la estacionPosicion tiene identificador par, se inserta ultimo
     * midicloriano del personaje Imperial.
     * @complex O(1)
     */
    @Override
    public void accionEstacion() {
        if (estacionPosicion.getID() % 2 == 0) {
            Midicloriano midicloriano = sacarMidicloriano();
            estacionPosicion.insertarMidicloriano(midicloriano);
        }
    }
}
