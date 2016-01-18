/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura;

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
public class EstacionPuerta extends EstacionBase {

// ATRIBUTOS ###############################################################
    /**
     * Cerradura de la Estación
     */
    public Cerradura cerradura;

// CONSTRUCTORES ###########################################################
    /**
     * Constructor parametrizado de la clase EstacionPuerta
     *
     * @param ID ID con el que inicializar la Estacion
     * @pre -
     * @post Estacion inicializada con parámetros dados. Llamada a clase padre
     * ESTACIONBASE
     * @complex O(1)
     */
    public EstacionPuerta(int ID) {
        super(ID);
        this.cerradura = null;
    }
// Getter & Setter #########################################################

    /**
     * Método para insertar una cerradura en la Estación
     * @param cerradura Cerradura a insertar en la estación
     * @pre EstacionPuerta inicializada con éxito
     * @post EstaciónPuerta con cerradura = cerradura parámetro
     * @complex O(1)
     */
    public void setCerradura(Cerradura cerradura) {
        this.cerradura = cerradura;
    }

// PRIVADOS ################################################################
// PÚBLICOS ################################################################
    /**
     * Método finaliza la estación
     *
     * @pre EstacionPuerta inicializada correctamente
     * @post Saca a todos los personajes de las estación y se llama al método
     * fin de cada uno de ellos
     * @complex O(n)
     */
    public void fin() {
        Personaje personaje;
        while (!personajes.isEmpty()) {
            personaje = this.sacarPersonaje();
            personaje.fin();
        }
    }

    /**
     * Método que devuelve si una estacion es de tipo puerta o no
     *
     * @return Devuelve valor booleano con información sobre si la pestacion es
     * una puerta o no. Devuelve false.
     * @pre EstacionBase inicializada correctamente
     * @post Devuelve true
     * @complex O(1)
     */
    @Override
    public boolean esPuerta() {
        return true;
    }
}
