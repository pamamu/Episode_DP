/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura;

import edd.Arbol;
import java.util.ArrayList;

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
public class Cerradura {

// ATRIBUTOS ###############################################################
    /**
     * EDD con midiclorianos almacenados sin combinar.
     */
    ArrayList<Midicloriano> midiclorianosIniciales;
    /**
     * EDD con midiclorianos almacenados con la configuración
     * inicial(combinados).
     */
    ArrayList<Midicloriano> combinacionInicio;
    /**
     * EDD con la combinación de midiclorianos de la cerradura.
     */
    Arbol<Midicloriano> combinacionCerradura;
    /**
     * EDD con los midiclorianos probados.
     */
    Arbol<Midicloriano> midiclorianosProbados;
    /**
     * Estado de la puerta - Abierta(TRUE) o Cerrada(FALSE).
     */
    private boolean estado;
    /**
     * Altura de la combinación con la que se desbloquea la puerta.
     */
    private final int alturaDesbloqueo;

// CONSTRUCTORES ###########################################################
    /**
     * Constructor parametrizado de la clase Cerradura.
     *
     * @param alturaDesbloqueo Altura de desbloqueo con la que inicializar la
     * Cerradura
     * @pre -
     * @post Inicializa la cerradura con alturaDesbloqueo por parámetros,
     * combinacionInicio con nueva ArrayList de Midiclorianos,
     * combinacionMidiclorianos con nuevo Arbol de Midiclorianos y
     * midiclorianosProbados con nuevo Arbol de Midiclorianos.
     * @complex O()
     */
    public Cerradura(int alturaDesbloqueo) {
        this.combinacionInicio = new ArrayList<>();
        this.combinacionCerradura = new Arbol<>();
        this.midiclorianosProbados = new Arbol<>();
        this.alturaDesbloqueo = alturaDesbloqueo;
        this.estado = true;
    }

// Getter & Setter #########################################################
    /**
     * Método para comprobar estado de la cerradura
     *
     * @return Devuelve TRUE(Cerradura abierta) o FALSE(Cerradura cerrada)
     * @pre Cerradura inicializada correctamente
     * @post Cerradura actualiza su estado
     * @complex O(n)
     */
    public boolean Abierta() {
        comprobarEstado();
        return estado;
    }

    /**
     * Método para instroducir estado de la puerta
     *
     * @param estado Estado que se quiere dar a la puerta. TRUE: Abierta FALSE:
     * Cerrada
     * @pre Cerradura inicializada correctamente
     * @post Estado de la cerradura con el valor del parámetro
     * @complex O(1)
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * Método para introducir la combinación inicial de midiclorianos.
     *
     * @param midiclorianosIniciales ArrayList con midiclorianos que se desean
     * combinar para la cerradura.
     */
    public void setCombinacion(ArrayList<Midicloriano> midiclorianosIniciales) {
        this.midiclorianosIniciales = midiclorianosIniciales;
    }
// PRIVADOS ################################################################

    /**
     * Método para calcular la profundidad de un arbol de Midiclorianos
     *
     * @param arbol Arbol sobre el que se quiere calcular la profundidad
     * @return Devuelve la profundidad del arbol por parámetro
     * @pre -
     * @post -
     * @complex O(n)
     */
    private int profundidad(Arbol<Midicloriano> arbol) {
        if (arbol.vacio()) {
            return 0;
        }
        int leftDepth = (arbol.getHijoIzq() != null) ? profundidad(arbol.getHijoIzq()) : 0;
        int rightDepth = (arbol.getHijoDer() != null) ? profundidad(arbol.getHijoDer()) : 0;
        return (rightDepth > leftDepth) ? rightDepth + 1 : leftDepth + 1;
    }

    /**
     * Método para calcular los nodos internos de una arbol de Midiclorianos
     *
     * @param arbol Arbol sobre el que se desea calcular los nodos internos
     * @return Devuelve los nodos internos del arbol por párametro
     * @pre -
     * @post -
     * @complex O(n)
     */
    private int nodosInternos(Arbol<Midicloriano> arbol) {
        if (arbol.vacio() || (arbol.getHijoIzq() == null && arbol.getHijoDer() == null)) {
            return 0;
        }
        int interiorNodes = 1;
        interiorNodes += (arbol.getHijoIzq() != null) ? nodosInternos(arbol.getHijoIzq()) : 0;
        interiorNodes += (arbol.getHijoDer() != null) ? nodosInternos(arbol.getHijoDer()) : 0;
        return interiorNodes;
    }

    /**
     * Método para calcular nodos externos de un arbol de Midiclorianos
     *
     * @param arbol Arbol sobre el que se desea calcular los nodos externos
     * @return Devuelve los nodos externos del arbol por parámetro
     * @pre -
     * @post -
     * @complex O(n)
     */
    private int nodosExternos(Arbol<Midicloriano> arbol) {
        if (arbol.vacio()) {
            return 0;
        }
        int exteriorNodes = 0;
        if (arbol.getHijoIzq() == null && arbol.getHijoDer() == null) {
            exteriorNodes++;
        }
        exteriorNodes += (arbol.getHijoIzq() != null) ? nodosExternos(arbol.getHijoIzq()) : 0;
        exteriorNodes += (arbol.getHijoDer() != null) ? nodosExternos(arbol.getHijoDer()) : 0;
        return exteriorNodes;
    }

    /**
     * Método para vaciar un arbol de Midiclorianos
     *
     * @param arbol Arbol sobre el que se desea vaciar su contenido
     * @pre -
     * @post -
     * @complex O(1)
     */
    private void vaciarArbol(Arbol<Midicloriano> arbol) {
        arbol = new Arbol<>();
        System.gc();
    }

    /**
     * Algoritmo recursivo que balancea los valores de un array y los almacena
     * en otro
     *
     * @param midiclorianos ArrayList de midiclorianos que se quieren balancear
     * @param midiclorianosCombinados ArrayList de midiclorianos balanceados
     * @param min Indica la cota superior sobre la que se quiere balancear
     * @param max Indica la cota inferior sobre la que se quiere balancear
     * @pre <i>midiclorians</i> inicializado correctamente &&
     * <i>combinedMidiclorians</i> inicializado correctamente && <i>low</i>
     * > 0 && <i>top</i> > 0
     * @post midiclorianos de <i>midiclorians</i> insertados de forma balanceada
     * en <i>combinedMidiclorians</i>
     * @complex O(n)
     */
    private void combine(ArrayList<Midicloriano> midiclorianos, ArrayList<Midicloriano> midiclorianosCombinados, int min,
            int max) {
        int mitad = (min + max) / 2;
        /*
         * Inserta en combinedMidiclorians el midicloriano de la posicion
		 * intermedia de midiclorians
         */
        midiclorianosCombinados.add(midiclorianos.get(mitad));

        if (min != max) {
            /*
             * Recursivo con low=mitad+1 y top igual
             */
            combine(midiclorianos, midiclorianosCombinados, mitad + 1, max);
            /*
             * Recursivo con low=low y top=mitad-1
             */
            combine(midiclorianos, midiclorianosCombinados, min, mitad - 1);
        }
    }

    /**
     * Método para configurar la cerradura con una combinación
     * 
     * @param midiclorianos Estructura de midiclorianos que se quieren insertar en la cerradura
     * @pre Cerradura inicializada correctamente
     * @post Combinación cerradura con datos de midiclorianos (párametro entrada)
     * @complex O(n)
     */
    public void configurarCerradura(ArrayList<Midicloriano> midiclorianos) {
        vaciarArbol(this.combinacionCerradura);
        for (int i = 0; i < midiclorianos.size(); i++) {
            Midicloriano get = midiclorianos.get(i);
            this.combinacionCerradura.insertar(get);
        }
    }

// PÚBLICOS #################################################################
    /**
     * Método para generar combinación de midiclorianos a partir de los
     * midiclorianos iniciales guardados.
     *
     * @pre Cerradura inicializada correctamente
     * @post - CombinacionIncio con la combinación inicial de la cerradura y
     * CombinacionCerradura con midiclorianos balanceados
     * @complex O(n)
     */
    public void generarCombinacion() {
        //Genera combinación de midiclorianos y la guarda en midiclorianosCombinados
        ArrayList<Midicloriano> midiclorianosCombinados = new ArrayList<>();
        combine(this.midiclorianosIniciales, midiclorianosCombinados, 0, this.midiclorianosIniciales.size() - 1);
        this.combinacionInicio = midiclorianosCombinados;
        //Introduce la combinación generada en el arbol de la cerradura
        configurarCerradura(combinacionInicio);
    }

    /**
     * Método para probar un midicloriano en la cerradura
     *
     * @param midicloriano Midicloriano a probar en la cerradura
     * @return Devuelve FALSE si el midicloriano ya ha sido probado en la
     * cerradura, TRUE si no ha sido probado
     * @pre Cerradura inicializada correctamente
     * @post Midicloriano probado en la puerta. ED de midiclorianos probado con
     * un elemento más si no había sido probado anteriormente
     * @complex O(n)
     */
    public boolean probarMidicloriano(Midicloriano midicloriano) {
        if (midiclorianosProbados.pertenece(midicloriano)) {
            return false;
        }
        if (combinacionCerradura.pertenece(midicloriano)) {
            combinacionCerradura.borrar(midicloriano);
        }
        midiclorianosProbados.insertar(midicloriano);
        return true;
    }

    /**
     * Método para reiniciar la cerradura a su combinación inicial
     *
     * @pre Cerradura inicializada correctamente
     * @post Cerradura inicializada con configuración inicial
     * @complex O(n)
     */
    public void reiniciar() {
        vaciarArbol(combinacionCerradura);
        vaciarArbol(midiclorianosProbados);
        configurarCerradura(combinacionInicio);
    }

    /**
     * Método para comprobar estado de la puerta según condiciones de apertura
     *
     * @pre Cerradura inicializada correctamente
     * @post Actualiza el estado de la puerta según condiciones de apertura
     * @complex O(n)
     */
    public void comprobarEstado() {
        if (profundidad(combinacionCerradura) < alturaDesbloqueo
                && nodosInternos(combinacionCerradura) >= nodosExternos(combinacionCerradura)) {
            estado = true;
        }
    }

    /**
     * Método que devuelve información de la cerradura
     *
     * @return Devuelve String con toda la información de la cerradura
     * @pre Cerradura inicializada correctamente
     * @post -
     * @complex O(n)
     */
    public String informacionCerradura() {
        String output = "";
        output += "Estado de la puerta: " + ((estado) ? "ABIERTA" : "CERRADA");
        output += "\n\tAltura Cerradura: " + profundidad(combinacionCerradura);
        output += "\n\tMidiclorianos Internos: " + nodosInternos(combinacionCerradura);
        output += "\n\tMidiclorianos Externos: " + nodosExternos(combinacionCerradura);
        return output;
    }
    
    public static void main(String[] args) {
        Cerradura cerradura = new Cerradura(4);
        ArrayList<Midicloriano> midiclorianos = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            midiclorianos.add(new Midicloriano(i));
        }
        cerradura.configurarCerradura(midiclorianos);
        cerradura.generarCombinacion();
        cerradura.setEstado(false);
        System.out.println(cerradura.informacionCerradura());
    }

}
