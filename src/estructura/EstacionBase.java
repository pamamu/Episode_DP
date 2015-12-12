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

// CONSTRUCTORES ###########################################################
    /**
     * Constructor parametrizado de la clase EstacionBase. Inicializa la
     * estacion con ID por parámetros y personajes con una nueva PriorityQueue
     *
     * @param ID ID con el que inicializar la estación
     */
    public EstacionBase(int ID) {
        this.ID = ID;
        this.personajes = new PriorityQueue<>();
    }
// Getter & Setter #########################################################
// PRIVADOS ################################################################
// PUBLICOS #################################################################

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
     * Devuelve información sobre la Estación
     *
     * @return Devuelve string con información sobre la estación
     * @pre
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
     * Devuelve que tipo es
     *
     * @return Devuelve el string "BaseStation"
     * @pre
     * @post Devuelve el string "BaseStation"
     * @complex O(1)
     */
    public String getType() {
        return "BaseStation";
    }

}
