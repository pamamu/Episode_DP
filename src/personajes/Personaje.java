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
import etc.Logger;
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
     * Nombre del personaje
     */
    private final String nombre;
    /**
     * Bandera que indica si el personaje es ganador (TRUE) o no (FALSE)
     */
    protected boolean ganador = false;
    /**
     * ED con midilorianos que porta el personaje
     */
    protected ArrayList<Midicloriano> midiclorianos;
    /**
     * ED con la ruta del personaje
     */
    private LinkedList<Camino> ruta;
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
     * @param nombre Nombre del personaje con la que inicializar al Personaje
     * @param estacionPosicion ID de la estación donde se quiere insertar el
     * personaje
     * @param turnoInicio Turno en el que se empieza a mover al personaje
     * @pre -
     * @post Instacia de Personaje inicializada con marcaClase y
     * estacionPosicion por parámetros y midiclorianos como nueva ArrayList.
     * Inserta en la estacionPosicion al personaje.
     * @complex O(1)
     */
    public Personaje(char marcaClase, String nombre, int estacionPosicion, int turnoInicio) {
        this.marcaClase = marcaClase;
        this.nombre = nombre;
        this.midiclorianos = new ArrayList<>();
        this.turno = turnoInicio;
        this.ruta = new LinkedList<>();
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
     * Método que devuelve el nombre del Personaje
     *
     * @return Devuelve el valor del atributo nombre
     * @pre Personaje inicializado correctamente
     * @post -
     * @complex O(1)
     */
    public String getNombre() {
        return nombre;
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
     * Método que devuelve la marca de clase del personaje
     *
     * @return Devuelve marca de clase del personaje
     * @pre Personaje inicializado correctamente
     * @post -
     * @complex O(1)
     */
    public char getMarcaClase() {
        return marcaClase;
    }

    /**
     * Método que devuelve si el personaje es ganador
     *
     * @return Devuelve el vaalor del atributo ganador
     * @pre Personaje inicializado correctamente
     * @post -
     * @complex O(1)
     */
    public boolean isGanador() {
        return ganador;
    }

    /**
     * Método que devuelve la ruta del Personaje
     *
     * @return Devuelve ruta del personaje
     * @pre Personaje inicializado correctamente
     * @post -
     * @complex O(1)
     */
    public LinkedList<Camino> getRuta() {
        return ruta;
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
     * Método que inserta una secuencia de Estaciones(ID) como transformación a
     * una secuencia de Ordenes en formato de orientaciones
     *
     * @param camino ED donde se almacena secuenccia de Estaciones(ID)
     * @pre Personaje inicializado correctamente, estacionPosicion no se
     * encuentra en la ED camino
     * @post Se inserta en la ruta del personaje una serie de secuencia de
     * orientaciones acorde con la secuencia de estaciones introducida por
     * parámetro.
     * @complex O(n)
     */
    public void setRuta(ArrayList<Integer> camino) {
        int posicionactual = estacionPosicion.getID(), posicionsiguiente;
        int variacion;
        while (!camino.isEmpty()) {
            posicionsiguiente = camino.remove(0);
            variacion = posicionsiguiente - posicionactual;
            switch (variacion) {
                case 1:
                    ruta.add(Camino.ESTE);
                    break;
                case -1:
                    ruta.add(Camino.OESTE);
                    break;
                default:
                    if (variacion > 1) {
                        ruta.add(Camino.SUR);
                    } else {
                        ruta.add(Camino.NORTE);
                    }
            }
            posicionactual = posicionsiguiente;
        }
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
    protected void moverA(EstacionBase estacion) {
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
        Extrae el siguiente camino(E,N,O,S).
         */
        Camino camino = ruta.poll();
        if (camino == null) {
            return null;
        }
        //Calcula fila y columna de la esatcion destino
        Galaxia galaxia = Galaxia.obtenerInstancia();
        int[] coord = galaxia.IDtoCoordenadas(estacionPosicion.getID());
        int fila = coord[0] + camino.getAlto();
        int columna = coord[1] + camino.getAncho();
        //Devuelve estaciondestino
        return galaxia.getEstacion(fila, columna);

    }

    // PÚBLICOS #################################################################
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

        EstacionBase estacionDestino = getSiguienteEstacion();
        if (estacionDestino != null) {
            moverA(estacionDestino);
        } else {
            moverA(estacionPosicion);
        }
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
     * Método para saber si el perosonaje es Imperial
     *
     * @return Devuelve falso.
     * @pre Personaje inicializado correctamente
     * @post -
     * @complex O(1)
     */
    public boolean esImperial() {
        return false;
    }

    /**
     * Método que indica que el personaje ha ganado.
     *
     * @pre Personaje inicializado correctamente
     * @post Establece ganador a true y mueve al personaje a la estación de los
     * ganadores.
     * @complex O(1)
     */
    public void fin() {
        if (!esImperial()) {
            ganador = true;
            moverA(Galaxia.obtenerInstancia().getEstacionLiberty());
        }
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
     * Método que genera el camino del Personaje
     *
     * @see Imperial
     * @see LightSide
     */
    public abstract void generarCamino();

    /**
     * Método que devuelve el tipo del personaje
     *
     * @see Imperial
     * @see LightSide
     */
    public abstract String getTipo();

    /**
     * Método para comparar un Personaje con la instancia actual
     *
     * @param o Objeto Midicloriano con el que se desea comparar
     * @return Entero indicando si es menor(número negaativo), igual(0) o
     * mayor(número positivo)
     * @pre Personaje inicializado correctamente
     * @post Devuelve 1(mayor)
     * @complex O(1)
     */
    @Override
    public int compareTo(Personaje o) {
        return 1;
    }

    /**
     * Devuelve información sobre el personaje
     *
     * @return Devuelve string con información sobre el personaje
     * @pre Personaje inicializada correctamente
     * @post Devuelve marca de clase
     * @complex O(1)
     */
    @Override
    public String toString() {
        return String.valueOf(marcaClase) /*+ "\n" + ruta.toString()*/;
    }

    /**
     * Método que convierte la ruta del personaje en un String
     *
     * @return Devuelve la ruta tal que "N S E O N S E O"
     * @pre Personaje inicializada correctamente
     * @post -
     * @complex O(n)
     */
    public String rutaToString() {
        String sruta = "";
        int longruta = ruta.size();
        Camino camino;
        for (int i = 0; i < longruta; i++) {
            camino = ruta.poll();
            sruta += " " + camino.toString();
            ruta.add(camino);
        }
        return sruta;
    }

    /**
     * Método que convierte los midiclorianos del personaje en String
     *
     * @return Devuelve los midiclorianos tal que "1 2 3 4 5 6"
     * @pre Personaje inicializada correctamente
     * @post -
     * @complex O(n)
     */
    public String midicloriansToString() {
        String smidiclorianos = "";
        for (int i = 0; i < midiclorianos.size(); i++) {
            smidiclorianos += " " + midiclorianos.get(i).getID();
        }
        return smidiclorianos;
    }

    /**
     * Método que escribe en el Log información inicial sobre el personaje.
     *
     * @pre Personaje inicializada correctamente
     * @post -
     * @complex O(1)
     */
    public void toLogini() {
        String info = "";
        info += "(ruta:";//Sec inicio
        info += String.valueOf(marcaClase) + ":"; //Marca del personaje
        info += rutaToString();//Ruta del Personaje
        info += ")";//Parentesis fin

        Logger.obtenerInstancia().escribeLog(info, 4);
    }

    /**
     * Método que escribe en el Log información sobre el personaje.
     *
     * @pre Personaje inicializada correctamente
     * @post -
     * @complex O(n)
     */
    public void toLog() {
        String info = "";
        info += "(";//Parentesis inicio
        info += (ganador) ? "ganador:" : "";
        info += getTipo() + ":";//Tipo personaje
        info += String.valueOf(marcaClase) + ":"; //Marca del personaje
        info += String.valueOf(estacionPosicion.getID()) + ":";//Id de estacionposicion
        info += String.valueOf(turno) + ":";//Turno
        info += midicloriansToString();
        info += ")";//Parentesis fin

        Logger.obtenerInstancia().escribeLog(info, 4);
    }
}
