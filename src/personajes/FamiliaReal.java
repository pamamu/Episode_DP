/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package personajes;

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
public class FamiliaReal extends LightSide{

// ATRIBUTOS ###############################################################

// CONSTRUCTORES ###########################################################
 /**
     * Constructor parametrizado de la clase Personaje
     *
     * @param marcaClase Marca de clase con la que inicializar el Personaje
     * @param nombre Nombre del personaje
     * @param estacionPosicion ID de la estación donde se quiere insertar el
     * personaje
     * @param turnoInicio Turno en el que se empieza a mover al personaje
     * @pre -
     * @post Instacia de Familia Real inicializada con marcaClase y
     * estacionPosicion por parámetros y midiclorianos como nueva ArrayList.
     * Inserta en la estacionPosicion al personaje.
     * @complex O(1)
     */
    public FamiliaReal(char marcaClase, String nombre, int estacionPosicion, 
            int turnoInicio) {
        super(marcaClase, nombre, estacionPosicion, turnoInicio);
    }
// Getter & Setter #########################################################

// PRIVADOS ################################################################

// PÚBLICOS #################################################################

    /**
     * Método que indica si es objeto de clase Jedi
     * 
     * @return boolean
     */
    @Override
    public boolean esJedi(){
        return false;
    }
    
    /**
     * Método que indica si es objeto de clase Contrabandista
     * 
     * @return boolean
     */
    @Override
    public boolean esContrabandista(){
        return false;
    }
    
    /**
     * Método que indica si es objeto de clase FamiliaReal
     * 
     * @return boolean
     */
    @Override
    public boolean esFamiliaReal(){
        return true;
    }
}
