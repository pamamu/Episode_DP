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
import java.util.logging.Level;
import java.util.logging.Logger;

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
     * @param nombre Nombre con el que inicializar al personaje
     * @param estacionPosicion ID de la estación donde se quiere insertar el
     * personaje
     * @param turnoInicio Turno en el que se empieza a mover al personaje
     * @pre -
     * @post Instacia de LightSide inicializada con marcaClase y
     * estacionPosicion por parámetros y midiclorianos como nueva ArrayList.
     * Inserta en la estacionPosicion al personaje. Inicializa rutaInicial como
     * nueva LinkedList.
     * @complex O(1)
     */
    public LightSide(char marcaClase, String nombre, int estacionPosicion, int turnoInicio) {
        super(marcaClase, nombre, estacionPosicion, turnoInicio);
    }

// Getter & Setter #########################################################
// PRIVADOS ################################################################
// PÚBLICOS #################################################################
    /**
     * Método que comprueba si una estacion ha sido vistada ya.
     *
     * @param solucion ED donde se almacenan las estaciones visitadas
     * @param estacionActual Variable que almacena la estacionActual (hasta
     * donde se va a comprobar)
     * @param estacionComprobar Variable que almacena la estacion que se va a
     * comprobar
     * @return Devuelve valor booleano : TRUE -> Visitada FALSE-> No visitada
     * @pre Familia real y solucion inicializada con éxito
     * @post Devuelve si la estacionComprobar se encuentra en solucion (hasta
     * estacionActual)
     * @complex O(n)
     */
    public boolean estacionvisitada(ArrayList<Integer> solucion, int estacionActual, int estacionComprobar) {
        boolean encontrada = false;
        for (int i = 0; i < estacionActual && !encontrada; i++) {
            if (solucion.get(i) == estacionComprobar) {
                encontrada = true;
            }
        }
        return encontrada;
    }

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
            try {
                puerta.cerradura.probarMidicloriano(midicloriano);
            } catch (InterruptedException ex) {
                Logger.getLogger(LightSide.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        moverA(estacionPosicion);

        if (puerta.cerradura.Abierta()) {
            puerta.fin();
        }
    }

    @Override
    public void fin() {
        moverA(Galaxia.obtenerInstancia().getEstacionLiberty());
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

    /**
     * Método que comprueba si estando en una determinada estación se puede
     * hacer un moviemiento a una orientación
     *
     * @param grafo ED donde se encuentra las conexiones entre las distintas
     * estaciones
     * @param estacion Estacion desde la que se quiere comprobar el posible
     * movimiento
     * @param orientacion Orientación hacia donde se desea realizar el
     * movimiento
     * @param siguienteEstacion (Parámetro de salida) - Devuelve el ID de la
     * estacion que hay a continuación de estacion con la orientación hacia una
     * determinada dirección.
     * @return Devuelve si es posible el movimiento entre estacion y la estación
     * contigua indicada por la orientación en el entorno del grafo.
     * @pre Galaxia y grafo inicializado correctamente
     * @post Se obtienen las coordenadas de origen y destino (con ayuda de la
     * orientacion introducida por parámetros), se obtiene el ID destino y se
     * devuelve en siguienteEstacion[0]
     * @complex O(1)
     */
    private boolean movimientoPosible(Grafo grafo, int estacion, Camino orientacion, int[] siguienteEstacion) {
        int[] coordorigen = Galaxia.obtenerInstancia().IDtoCoordenadas(estacion);
        int[] coordestino = new int[]{coordorigen[0] + orientacion.getAlto(), coordorigen[1] + orientacion.getAncho()};
        int idDestino = Galaxia.obtenerInstancia().coordenadastoID(coordestino[0], coordestino[1]);
        siguienteEstacion[0] = idDestino;
        return grafo.adyacente(estacion, idDestino);
    }

    /**
     * Método para generar un camino de un personaje utilizando el algoritmo de
     * la mano derecha
     *
     * @param grafo ED donde se encuentra las conexiones entre las distintas
     * estaciones
     * @param solucion ED donde se almacenan las estaciones (ID) por los que va
     * pasando
     * @param estacionOrigen Variable que indica la estacion de origen de la
     * ruta.
     * @param estacionDestino Variable que indica la estación de destino de la
     * ruta
     * @param orientacion Orientacion con la que empieza en la enésima etapa del
     * método.
     * @pre Galaxia y grafo inicializado con con éxito
     * @post SI la estacionOrigen es distinta a la estacionDestino se comprueban
     * los 4 caminos posibles dependiendo de la orientación (siempre gira a la
     * derecha cuando hay posibilidad)
     * @complex O()
     */
    private void generarCaminoBT(Grafo grafo, ArrayList<Integer> solucion, int estacionOrigen, int estacionDestino, Camino orientacion) {
        if (estacionOrigen != estacionDestino) {
            boolean caminoencontrado = false;
            for (int i = 0; i < 4 && !caminoencontrado; i++) {
                Camino caminocomprobar = null;
                switch (orientacion) {
                    case ESTE:
                        caminocomprobar = Camino.SUR;
                        break;
                    case SUR:
                        caminocomprobar = Camino.OESTE;
                        break;
                    case OESTE:
                        caminocomprobar = Camino.NORTE;
                        break;
                    case NORTE:
                        caminocomprobar = Camino.ESTE;
                        break;
                    default:
                        throw new AssertionError(orientacion.name());
                }
                int[] siguienteEstacion = new int[1];
                if (movimientoPosible(grafo, estacionOrigen, caminocomprobar, siguienteEstacion)) {
                    if (solucion.size() > 1 && solucion.get(solucion.size() - 2) == siguienteEstacion[0]) {
                        orientacion = caminocomprobar;
                    } else {
                        solucion.add(siguienteEstacion[0]);
                        generarCaminoBT(grafo, solucion, siguienteEstacion[0], estacionDestino, caminocomprobar);
                        caminoencontrado = true;

                    }
                } else {
                    if (movimientoPosible(grafo, estacionOrigen, orientacion, siguienteEstacion)) {
                        solucion.add(siguienteEstacion[0]);
                        generarCaminoBT(grafo, solucion, siguienteEstacion[0], estacionDestino, orientacion);
                        caminoencontrado = true;
                    }
                    orientacion = caminocomprobar;
                }
            }
        }
    }

    @Override
    public void generarCamino() {
        Galaxia galaxia = Galaxia.obtenerInstancia();
        ArrayList<Integer> solucion = new ArrayList<>();
        solucion.add(estacionPosicion.getID());
        generarCaminoBT(galaxia.getGrafo(), solucion, estacionPosicion.getID(), galaxia.getIdEstacionPuerta(), Camino.NORTE);
        solucion.remove(0);
        setRuta(solucion);
    }

    @Override
    public String getTipo() {
        return "lighside";
    }

}
