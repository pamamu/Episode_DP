/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personajes;

import edd.Grafo;
import estructura.EstacionPuerta;
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
public class Imperial extends Personaje {

// ATRIBUTOS ###############################################################
    /**
     * ED con la ruta inicial del personaje que ayudará a restaurarla
     */
    private LinkedList<Camino> rutaInicial;
// CONSTRUCTORES ###########################################################

    /**
     * Constructor parametrizado de la clase Personaje
     *
     * @param marcaClase Marca de clase con la que inicializar el Personaje
     * @param nombre Nombre con el que inicializar al personaje
     * @param estacionPosicion ID de la estación donde se quiere insertar el
     * personaje
     * @param turnoInicio Turno en el que se empieza a mover al personaje
     * @pre -
     * @post Instacia de Imperial inicializada con marcaClase y estacionPosicion
     * por parámetros y midiclorianos como nueva ArrayList. Inserta en la
     * estacionPosicion al personaje. rutaInicial es una nueva LinkedList
     * @complex O(1)
     */
    public Imperial(char marcaClase, String nombre, int estacionPosicion, int turnoInicio) {
        super(marcaClase, nombre, estacionPosicion, turnoInicio);
        rutaInicial = new LinkedList<>();
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
     * personaje. Antes del movimiento se reinicia la ruta.
     * @complex O(n)
     */
    @Override
    public void accionPuerta() {
        EstacionPuerta puerta = (EstacionPuerta) estacionPosicion;
        puerta.cerradura.reiniciar();
        setRuta((LinkedList<Camino>)rutaInicial.clone());
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
            if (midicloriano != null) {
                estacionPosicion.insertarMidicloriano(midicloriano);
            }
        }
    }
    
    @Override
    public void fin(){
        
    }

    /**
     * Método para generar un camino utilizando el recorrido por caminos mínimos
     *
     * @param grafo ED donde se encuentran las conexiones entre las distintas
     * estaciones
     * @param solucion ED donde se va almacenando las posibles soluciones
     * @param estacionOrigen Variable que indica la estacion de origen de la
     * ruta.
     * @param estacionDestino Variable que indica la estacion de destino de la
     * ruta.
     * @pre Grafo, solucion y personaje inicializado con éxito
     * @post Almacena en solucion el recorrido de estaciones(ID) por las que hay
     * que pasar para llegar desde la estacionOrigen a la estacionDestino
     * @complex O(n)
     */
    private void generarCaminoBT(Grafo grafo, ArrayList<Integer> solucion, int estacionOrigen, int estacionDestino) {
        int estacionsiguiente = grafo.siguiente(estacionOrigen, estacionDestino);
        solucion.add(estacionsiguiente);
        if (estacionsiguiente == estacionDestino) {
//            solucion.add(estacionDestino);
            return;
        }
        generarCaminoBT(grafo, solucion, estacionsiguiente, estacionDestino);
    }

    /**
     * Método para generar un camino de un personaje
     *
     * @pre Personaje inicializado con éxito
     * @post Desde la galaxia, se recupera el grafo que une las estaciones y se
     * usa para calcular los caminos. En este caso, el personaje Imperial
     * recorre las estaciones en el orden: EstacionPuerta - Estacion NE -
     * Estacion NO - Estacion SO - EstacionPuerta. Inserta la secuencia de
     * estaciones al personaje a través del método setruta() y a su vez, para
     * que el perssonaje no llegue a algún momento donde se le acaben las
     * orientaciones del camino, se guarda la ruta del personaje en rutaInicial
     * para poder recuperar la
     * @complex O(n)
     */
    @Override
    public void generarCamino() {
        Galaxia galaxia = Galaxia.obtenerInstancia();
        ArrayList<Integer> solucion = new ArrayList<>();
        int estaciondestino, estacioninicio;
        //Desde estacionPosicion a estacion NE
        estacioninicio = estacionPosicion.getID();
        estaciondestino = galaxia.getDimY() - 1;
        generarCaminoBT(galaxia.getGrafo(), solucion, estacioninicio, estaciondestino);
        //Desde estacion NE a estacion NO
        estacioninicio = estaciondestino;
        estaciondestino = 0;
        generarCaminoBT(galaxia.getGrafo(), solucion, estacioninicio, estaciondestino);
        //Desde estacion NE a estacion SO
        estacioninicio = estaciondestino;
        estaciondestino = galaxia.getDimY() * (galaxia.getDimY() - 1);
        generarCaminoBT(galaxia.getGrafo(), solucion, estacioninicio, estaciondestino);
        //Desde estacion SO a estacion SE
        estacioninicio = estaciondestino;
        estaciondestino = galaxia.getIdEstacionPuerta();
        generarCaminoBT(galaxia.getGrafo(), solucion, estacioninicio, estaciondestino);
        //Añade la ruta al personaje
        setRuta(solucion);
        //Recupera la ruta  en rutaInicial
        rutaInicial = getRuta();
    }

}
