/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura;

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
    private int ID;

    /**
     * EDD con personajes en cada estación - Ordenados históricamente
     */
    private PriorityQueue<Personaje> personajes;
    /**
     * EDD con midiclorianos de cada estacion
     */
    PriorityQueue<Midicloriano> midiclorianos;

// CONSTRUCTORES ###########################################################
    /**
     * Constructor parametrizado de la clase EstacionBase. Inicializa la
     * estacion con ID por parámetros y personajes con una nueva PriorityQueue
     *
     * @param ID ID con el que inicializar la estación
     * @pre -
     * @post Instancia de EstacionBase creada con ID pasado por parámetros y
     * personajes como una nueva PriorityQueue por defecto.
     * @complex O(1)
     */
    public EstacionBase(int ID) {
        this.ID = ID;
        this.personajes = new PriorityQueue<>();
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

// PRIVADOS ################################################################
// PUBLICOS #################################################################
    /**
     * Método que inserta un midicloriano en la ED de la estación
     *
     * @param midicloriano Midicloriano a insertar en la estación
     * @pre EstaciónBase inicializada correctamente.
     * @post Inserta un midicloriano (parametrizado) en la ED(ordenada)
     * @complex O(n)
     */
    public void insertarMidicloriano(Midicloriano midicloriano) {
        midiclorianos.add(midicloriano);
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
        return midiclorianos.poll();
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
     * @return Deuvelve valor booleano con información sobre si la pestacion es
     * una puerta o no. Devuelve false.
     * @pre EstacionBase inicializada correctamente
     * @post Devuelve false
     * @complex O(1)
     */
    public boolean esPuerta() {
        return false;
    }

    /**
     * Devuelve información sobre la Estación
     *
     * @return Devuelve string con información sobre la estación
     * @pre EstacionBase inicializada correctamente
     * @post Devuelve el ID y toda la información de la estación.
     * @complex O(1)
     */
    @Override
    public String toString() {
        String output = "Station Info: \n";
        output += "ID " + ID + "\n";
        output += "Personajes: \n" + personajes.toString();
        return output;
    }

    /**
     * Método que devuelve que tipo es
     *
     * @return Devuelve el string "BaseStation"
     * @pre EstaciónBase inicializada correctamente.
     * @post Devuelve el string "BaseStation"
     * @complex O(1)
     */
    public String getType() {
        return "BaseStation";
    }

    /**
     * Método que devuelve todos los Midiclorianos en String
     *
     * @return String con todos los midiclorianos actuales en la ED
     */
    public String imprimirMidiclorianos() {
        String output = "";

        if (!midiclorianos.isEmpty()) {
            output += midiclorianos.toString();
            if (midiclorianos.size() < 2) {
                output += "\t\t";
            }
        } else {
            output += "\t";
        }

        return output;
    }

    /**
     * Método que devuelve todos los Personajes en String
     * 
     * @return String con todos los personajes actuales en la ED
     */
    public String imprimirPersonajes() {
        String output = "";

        if (!personajes.isEmpty()) {
            output += personajes.toString();
            if (personajes.size() < 2) {
                output += "\t";
            }
        } else {
            output += "\t";
        }

        return output;
    }

}
