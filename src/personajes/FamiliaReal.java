/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personajes;

import edd.Grafo;
import estructura.Galaxia;
import etc.Camino;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
public class FamiliaReal extends LightSide {

// ATRIBUTOS ###############################################################
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
     * @post Instacia de Familia Real inicializada con marcaClase y
     * estacionPosicion por parámetros y midiclorianos como nueva ArrayList.
     * Inserta en la estacionPosicion al personaje.
     * @complex O(1)
     */
    public FamiliaReal(char marcaClase, String nombre, int estacionPosicion, int turnoInicio) {
        super(marcaClase, nombre, estacionPosicion, turnoInicio);
    }
// Getter & Setter #########################################################

// PRIVADOS ################################################################
    /**
     * Método para generar un camino utilizando un recorrido en profundidad
     *
     * @param grafo ED donde se encuentra las conexiones entre las distintas
     * estaciones
     * @param solucion ED donde se van almacenando las posibles soluciones
     * @param estacion Variable que indica la etapa (estacion) en la que se
     * encuentra el método
     * @param estacionOrigen Variable que indica la estacion de origen de la
     * ruta.
     * @param estacionDestino Variable que indica la estación de destino de la
     * ruta
     * @param tam Tamaño de la ED que almacena las estaciones
     * @return Devuelve si ha sido posible encontrar un camino desde la estacion
     * de origen a la estacion destino.
     * @pre Grafo y solucion inicializadas con éxito
     * @post Devuelve false si la estacion(etapa) es mayor que el tamaño de la
     * ED de estaciones o si la estacion de origen es distinta a la de destino y
     * no se encuentra camino posible habiendo hecho una eleccion anterior.
     * Devuelve TRUE si la estacion de origen es igual a la estación de destino
     * o si habiendo elegido una estacion, se encuentra solucion en la siguiente
     * llamada (con estacionOrigen=estacionAdyacente y estcion+1)
     * @complex O(n^2)
     */
    private boolean generarCaminoBT(Grafo grafo, ArrayList<Integer> solucion, int estacion, int estacionOrigen, int estacionDestino, int tam) {
        if (estacion >= tam) {
            return false;
        }
        if (estacionOrigen == estacionDestino) {
            return true;
        } else {
            HashSet<Integer> adyacenteset = new HashSet<>();
            grafo.adyacentes(estacionOrigen, adyacenteset);
            Object[] adyacentes = adyacenteset.toArray();
            for (int i = 0; i < adyacenteset.size(); i++) {
                int estacionadyacente = (int) adyacentes[i];
                solucion.add(estacion, estacionadyacente);
                if (!estacionvisitada(solucion, estacion, estacionadyacente) && generarCaminoBT(grafo, solucion, estacion + 1, estacionadyacente, estacionDestino, tam)) {
                    return true;
                } else {
                    solucion.remove(estacion);
                }
            }

            return false;
        }
    }

// PÚBLICOS #################################################################
    /**
     * Método para generar un camino del personaje
     *
     * @pre Personaje y galaxia inicializada con éxito
     * @post Se genera un camino utilizando generarCaminoBT, se introduce en el
     * personaje con setRuta y se introduce el camino en el parámetro de Galaxia
     * pasosPorEstacion.
     * @complex O()
     */
    @Override
    public void generarCamino() {
        Galaxia galaxia = Galaxia.obtenerInstancia();
        ArrayList<Integer> solucion = new ArrayList<>();
        int tamaniogalaxia = galaxia.getDimX() * galaxia.getDimY();
        generarCaminoBT(galaxia.getGrafo(), solucion, 0, estacionPosicion.getID(), galaxia.getIdEstacionPuerta(), tamaniogalaxia);
        setRuta((ArrayList<Integer>) solucion.clone());
        solucion.add(0, estacionPosicion.getID());
        solucion.remove(solucion.size()-1);
        galaxia.setPasosPorEstaciones(solucion);
    }
    
        @Override
    public String getTipo() {
        return "familiareal";
    }

}
