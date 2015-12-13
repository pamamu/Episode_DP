/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personajes;

import estructura.EstacionBase;
import estructura.Galaxia;
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
public abstract class Personaje implements Comparable<Personaje> {

// ATRIBUTOS ###############################################################
    /**
     * Marca identificativa del Personaje
     */
    private final char marcaClase;
    /**
     * ED con midilorianos que porta el personaje
     */
    protected ArrayList<Midicloriano> midiclorianos;
    /**
     * ED con la ruta del personaje
     */
    private LinkedList<Camino> ruta;
    /**
     * Turno en el que empieza el personaje
     */
    private final int turnoInicio;
    /**
     * Turno actual del personaje
     */
    private int turno;
    /**
     * Estacion en la que está actualmente el personaje
     */
    protected EstacionBase estacionPosicion;

// CONSTRUCTORES ###########################################################
    /**
     * Constructor parametrizado de la clase Personaje
     *
     * @param marcaClase Marca de clase con la que inicializar el Personaje
     * @param estacionPosicion ID de la estación donde se quiere insertar el
     * personaje
     * @param turnoInicio Turno en el que se empieza a mover al personaje
     * @pre -
     * @post Instacia de Personaje inicializada con marcaClase y
     * estacionPosicion por parámetros y midiclorianos como nueva ArrayList.
     * Inserta en la estacionPosicion al personaje.
     * @complex O(1)
     */
    public Personaje(char marcaClase, int estacionPosicion, int turnoInicio) {
        this.marcaClase = marcaClase;
        this.midiclorianos = new ArrayList<>();
        this.turno = 0;
        this.turnoInicio = turnoInicio;
        this.estacionPosicion = Galaxia.obtenerInstancia().getEstacion(estacionPosicion);
        this.estacionPosicion.insertarPersonaje(this);

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
     * Método que devuelve el turno de inicio del Personaje
     *
     * @return Devuelve el turno de inicio del Personaje - Turno en el que se
     * empieza a mover
     * @pre Personaje inicializado correctamente
     * @post -
     * @complex O(1)
     */
    public int getTurnoInicio() {
        return turnoInicio;
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

// PRIVADOS ################################################################
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
    private void moverA(EstacionBase estacion) {
        this.estacionPosicion = estacion;
        this.estacionPosicion.insertarPersonaje(this);
    }

    /**
     * Método que devuelve la siguiente estación al personaje según ruta
     *
     * @return Devuelve siguiente estacion del personaje
     * @pre Personaje inicializado correctamente
     * @post Primera orientacion de la ruta es sacada y se vuelve a insertar en
     * la ED de la ruta, y se ejecutan los métodos para calcular siguiente
     * posicion con ayuda de dos variables (fila y columna).
     * @complex O(1)
     */
    private EstacionBase getSiguienteEstacion() {
        /*
        Extrae el siguiente camino(E,N,O,S)  y lo vuelve a insertar en la ED de 
        caminos para que nunca se quede pueda quedarse sin posibles 
        orientaciones para el siguiente movimiento.
         */
        Camino camino = ruta.poll();
        ruta.add(camino);
        //Calcula fila y columna de la esatcion destino
        Galaxia galaxia = Galaxia.obtenerInstancia();
        int[] coord = galaxia.IDtoCoordinates(estacionPosicion.getID());
        int fila = coord[0] + camino.getAlto();
        int columna = coord[1] + camino.getAncho();
        //Devuelve estaciondestino
        return galaxia.getEstacion(fila, columna);

    }

    // PÚBLICOS #################################################################
    /**
     * Devuelve el ultimo midicloriano que tiene el personaje en si ED
     *
     * @return Ultimo midicloriano de ED del personaje
     * @pre Personaje inicializado correctamente
     * @post ED de midiclorianos con un elemento menos (último)
     * @complex O(1)
     */
    public Midicloriano sacarMidicloriano() {
        return midiclorianos.remove(midiclorianos.size() - 1);
    }

    /**
     * Inserta en la ED el midicloriano por parámetros
     *
     * @param midicloriano Midicloriano a insertar en la ED del personaje
     * @pre Personaje inicializado correctamente
     * @post ED de midiclorianos con un elemento más (última posición)
     * @complex O(1)
     */
    public void recogerMidicloriano(Midicloriano midicloriano) {
        midiclorianos.add(midicloriano);
    }

    /**
     * Método que ejecuta la acción de mover de un personaje
     *
     * @pre Personaje inicializado correctamente
     * @post El personaje se mueve a la siguiente estación
     * @complex O(1)
     */
    public void mover() {
        moverA(getSiguienteEstacion());
    }

    /**
     * Método encargado de accionar-simular al personaje durante 1 turno.
     *
     * @pre Personaje inicializado correctamente e insertado dentro de la
     * Galaxia
     * @post Si el personaje está en una estación, se ejecuta accionEstacion().
     * SI el personaje está en una puerta, se ejecuta accionPuerta(). En
     * cualquiera de los casos se incrementa el turno en 1.
     * @complex O(1)
     */
    public void accion() {
        if (estacionPosicion.esPuerta()) {
            accionPuerta();
        } else {
            mover();
            accionEstacion();
        }
        turno++;
    }

    /**
     * Método que acciona el comportamiento de un personaje en una puerta
     *
     * @see Imperial
     * @see LightSide
     */
    public abstract void accionPuerta();

    /**
     * Método que acciona el comportamiento de un personaje en una estacion
     *
     * @see Imperial
     * @see LightSide
     */
    public abstract void accionEstacion();

    /**
     * Método para comparar un Personaje con la instancia actual
     *
     * @param o Objeto Midicloriano con el que se desea comparar
     * @return Entero indicando si es menor(número negaativo), igual(0) o
     * mayor(número positivo)
     * @pre Midicloriano inicializado correctamente
     * @post Devuelve 1(mayor)
     * @complex O(1)
     */
    @Override
    public int compareTo(Personaje o) {
        return 1;
    }
}
