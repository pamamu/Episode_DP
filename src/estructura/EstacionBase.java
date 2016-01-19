/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura;

import etc.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import personajes.Personaje;

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
public class EstacionBase {

// ATRIBUTOS ###############################################################
    /**
     * Identificador de la Estación
     */
    private final int ID;

    /**
     * EDD con personajes en cada estación - Ordenados históricamente
     */
    protected PriorityQueue<Personaje> personajes;
    /**
     * EDD con midiclorianos de cada estacion
     */
    private ArrayList<Midicloriano> midiclorianos;

// CONSTRUCTORES ###########################################################
    /**
     * Constructor parametrizado de la clase EstacionBase. Inicializa la
     * estacion con ID por parámetros y personajes con una nueva PriorityQueue
     *
     * @param ID ID con el que inicializar la estación
     * @pre -
     * @post Instancia de EstacionBase creada con ID pasado por parámetros y
     * personajes como una nueva ArrayList por defecto.
     * @complex O(1)
     */
    public EstacionBase(int ID) {
        this.ID = ID;
        this.personajes = new PriorityQueue<>();
        this.midiclorianos = new ArrayList<>();
    }
// Getter & Setter #########################################################

    /**
     * Método que devuelve el ID de la Estación
     *
     * @return Devuelve el ID de la instancia de EstaciónBase
     * @pre EstaciónBase inicializada correctamente
     * @post -
     * @complex O(1)
     */
    public int getID() {
        return ID;
    }
    
    /**
     * Método que devuelve la EDD de los personajes
     * @return Devuelve un vector de Object con los personajes de la estación.
     * @pre EstaciónBase inicializada correctamente
     * @post -
     * @complex O(1)
     */
    public Object[] getPersonajes(){
        return this.personajes.toArray();
    }

    /**
     * Método que devuelve los midiclorianos de la Estacion
     * @return EDD con midiclorianos de la estación
     * @pre EstacionBase inicializada con éxito
     * @post -
     * @complex O(1)
     */
    public ArrayList<Midicloriano> getMidiclorianos() {
        return midiclorianos;
    }
    
    

// PRIVADOS ################################################################
// PUBLICOS ################################################################
    /**
     * Método accion implementa la accion llamando al método acción de cada
     * personaje existente en su estructura de almacenamiento de personajes
     *
     * @param turno Turno actual de la simulacion
     * @pre EstaciónBase inicializada correctamente.
     * @post Ejecuta la accion del personaje o vuelve a meterlo en el final
     * @complex O(n)
     */
    public void accion(int turno) {

        if (!personajes.isEmpty()) {
            int npersonajes = personajes.size();
            for (int i = 0; i < npersonajes; i++) {
                if (this.esPuerta() && ((EstacionPuerta) this).cerradura.Abierta()) {
                    break;
                }
                Personaje actual = sacarPersonaje();

                if (actual.getTurno() == turno) {
                    actual.accion();
                } else {
                    insertarPersonaje(actual);
                }

            }
        }
    }

    /**
     * Método que inserta un midicloriano en la ED de la estación
     *
     * @param midicloriano Midicloriano a insertar en la estación
     * @pre EstaciónBase inicializada correctamente.
     * @post Inserta un midicloriano (parametrizado) en la ED(ordenada)
     * @complex O(1)
     */
    public void insertarMidicloriano(Midicloriano midicloriano) {
        midiclorianos.add(midicloriano);
        Collections.sort(midiclorianos);
    }

    /**
     * Método que saca el primer midicloriano de la ED de la estación
     *
     * @return Devuelve el 1º Midicloriano de la ED
     * @pre EstaciónBase inicializada correctamente.
     * @post ED de midiclorianos con un elemento menos
     * @complex O(1)
     */
    public Midicloriano sacarMidicloriano() {
        if (!midiclorianos.isEmpty()) {
            return midiclorianos.remove(0);
        }

        return null;
    }

    /**
     * Método para insertar un personaje en la ED de la Estación
     *
     * @param personaje Personaje a insertar en la ED
     * @pre EstaciónBase inicializada con éxito
     * @post ED de la Base con un personaje más en la última posición
     * @complex O(1)
     */
    public void insertarPersonaje(Personaje personaje) {
        personajes.add(personaje);
    }

    /**
     * Método para sacar el primer personaje de la ED de la Estación
     *
     * @return Devuelve el primer Personaje de la ED de la Estación
     * @pre EstacionBase inicializada correctamente
     * @post ED de la Estación con un personaje menos
     * @complex O(1)
     */
    public Personaje sacarPersonaje() {
        return personajes.poll();//TODO Lanzar excepción si ED vacia
    }

    /**
     * Método que devuelve si una estacion es de tipo puerta o no
     *
     * @return Devuelve valor booleano con información sobre si la pestacion es
     * una puerta o no. Devuelve false.
     * @pre EstacionBase inicializada correctamente
     * @post Devuelve false
     * @complex O(1)
     */
    public boolean esPuerta() {
        return false;
    }

    /**
     * Método similar al imprimirPersonajesMini pero con la caracteristica de
     * que solo devuelve la marca de personaje o espacio en blanco
     *
     * @return String con todos los personajes actuales en la ED
     * @pre Estación inicializad con éxito
     * @post Si hay mas de un personaje muestra el numero de personajes que hay
     * @complex O(1)
     *
     */
    public String imprimirPersonajesMarca() {
        String output = "";

        if (!personajes.isEmpty()) {

            if (personajes.size() > 1) {
                output += personajes.size();
            } else {
                output += personajes.peek().getMarcaClase();
            }
        } else {
            output += " ";
        }

        output += "";

        return output;
    }

    /**
     * Método para convertir midiclorianos de la estación en un cadena
     *
     * @return Devuelve cadena con información de todos los midiclorianos que
     * contiene en ella.
     * @pre EstacionBase inicializada con éxito
     * @post Recorre todos los midiclorianos y los va almacenando en una cadena
     * @complex O(n)
     */
    public String midiclorianosToString() {
        String smidiclorianos = "";
        ArrayList<Midicloriano> midis = new ArrayList<>(midiclorianos);
        for (int i = 0; i < midis.size(); i++) {
            smidiclorianos += " " + midis.get(i).getID();
        }
        return smidiclorianos;
    }

    /**
     * Método que escribe en el log información sobre la EstacionBase
     *
     * @pre EstacionBase inicializada con éxito
     * @post Escribe en el log información sobre el ID y los midiclorianos que
     * contiene la estación
     * @complex O(n)
     */
    public void toLog() {
        String info = "";
        info += "(estacion:";//Parentesis inicio
        info += String.valueOf(ID) + ":";//Tipo personaje
        info += midiclorianosToString();
        info += ")";//Parentesis fin

        Logger.obtenerInstancia().escribeLog(info, 4);
    }

    /**
     * Método que escribe en el log información sobre los personajes que existen en la estación
     *
     * @pre EstacionBase inicializada con éxito
     * @post Llama a toLog de todos los personajes que existen en esa estación
     * @complex O(n)
     */
    public void toLogPersonajes() {
        if (!personajes.isEmpty()) {
            for (int i = 0; i < personajes.size(); i++) {
                Personaje personaje = personajes.poll();
                personaje.toLog();
                personajes.add(personaje);
            }
        }
    }

}
