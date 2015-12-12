/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personajes;

import estructura.EstacionBase;
import estructura.Midicloriano;
import etc.Camino;
import java.util.ArrayList;
import java.util.LinkedList;

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
public class Personaje implements Comparable<Personaje> {

// ATRIBUTOS ###############################################################
    private char marcaClase;

    private ArrayList<Midicloriano> midiclorianos;

    private LinkedList<Camino> ruta;

    private int turno;

    private EstacionBase estacionPosicion;

// CONSTRUCTORES ###########################################################
    /**
     * Constructor parametrizado de la clase Personaje
     *
     * @param marcaClase Marca de clase con la que inicializar el Personaje
     * @param estacionPosicion Estación donde se quiere insertar el personaje
     * @pre EstacionPosicion inicializada con éxito
     * @post Instacia de Personaje inicializada con marcaClase y
     * estacionPosicion por parámetros y midiclorianos como nueva ArrayList.
     * Inserta en la estacionPosicion al personaje.
     * @complex O(1)
     */
    public Personaje(char marcaClase, EstacionBase estacionPosicion) {
        this.marcaClase = marcaClase;
        this.midiclorianos = new ArrayList<>();
        this.estacionPosicion = estacionPosicion;
        this.estacionPosicion.insertarPersonaje(this);
        this.turno = 0;
    }

    // Getter & Setter #########################################################
    /**
     * Método que devuelve el turno del Personaje
     *
     * @return Devuelve el turno de la instancia del Personaje
     * @pre Personaje inicializado correctamente
     * @post -
     * @complex O(1)
     */
    public int getTurno() {
        return turno;
    }

    /**
     * Método que devuelve la estacion donde se encuentra el personaje
     *
     * @return Devuelve la estacion donde actualmente está el personaje
     * @pre Personaje inicializado correctamente
     * @post -
     * @complex O(1)
     */
    public EstacionBase getEstacionPosicion() {
        return estacionPosicion;//TODO Posible Excepción
    }

    /**
     * Método que inserta un conjunto de Midiclorianos en el Personaje
     *
     * @param midiclorianos Midiclorianos a poner en el personaje
     * @pre Personaje inicializado correctamente
     * @post ED de Personaje con midiclorianos = ED por parámetros
     * @complex O(1)
     */
    public void setMidiclorianos(ArrayList<Midicloriano> midiclorianos) {
        this.midiclorianos = midiclorianos;
    }

    /**
     * Método que inserta una ruta al Personaje
     *
     * @param ruta Ruta a insertar en el personaje
     * @pre Personaje inicializado correctamente
     * @post Ruta del Personaje = RUta por parámetros
     * @complex O(1)
     */
    public void setRuta(LinkedList<Camino> ruta) {
        this.ruta = ruta;
    }

    /**
     * Método que pone en el Personaje una estacion actual (posición)
     *
     * @param estacion Estacion donde actualmente se quiere insertar al
     * personaje
     * @pre Personaje inicializado correctamente
     * @post Estacion por parámetros: Nuevo Personaje(instacia actual del
     * personaje)
     * @complex O(1)
     */
    public void setEstacionPosicion(EstacionBase estacion) {
        this.estacionPosicion = estacion;
        this.estacionPosicion.insertarPersonaje(this);
    }

// PRIVADOS ################################################################
    // PÚBLICOS #################################################################
    public void accion() {
        if (enPuerta()) {
            accionPuerta();
        } else {
            accionEstacion();
            mover();
        }
        turno++;
    }
    
    public boolean 

    @Override
    public int compareTo(Personaje o) {
        return 1;
    }
}
