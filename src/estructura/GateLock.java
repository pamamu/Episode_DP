package estructura;

import edd.Arbol;
import java.util.ArrayList;

/**
 *  <p color="#01DF01">
 *     Este codigo es parte del proyecto StarsWars - DP desarrollado en la Universidad<br/>
 *     de Extremadura en el curso 2015 - 2016 en la asignatura Desarrollo de Programas
 *  </p>
 * <br/>
 * 
 *  @since <p color="red">
 *     by: Fernando G. & Pablo Macias<br/>
 *         Revenge of the Sith™ 2015 
 *      
 * </p>
 *  @author Fernando.G & Pablo Macias
 *  @version 1.0 ALFA
 *
 */

public class GateLock {

    /** Midiclorianos ordenados con la configuraciÛn inicial */
    ArrayList<Midiclorian> initialCombination;
    /** CombinaciÛn de midiclorianos de la cerradura */
    Arbol<Midiclorian> midicloriansCombination;
    /** Midiclorianos probados */
    Arbol<Midiclorian> testedMidiclorians;

    /** Estado de la cerradura. FALSE = CERRADA ; TRUE = ABIERTA */
    private boolean status;

    /** Profundidad de desbloqueo de la combinaciÛn */
    private int deepCombination;

    // PRIVATE METHODS

    /**
     * MÈtodo que calcula la profundidad de un arbol
     * 
     * @param arbol
     *            Arbol sobre el que se quiere clacular la profundidad
     * @return Devuelve la profundidad del arbol
     */
    private int getDeep(Arbol<Midiclorian> arbol) {
            if (arbol.vacio())
                    return 0;
            int leftDepth = 0, rightDepth = 0;
            leftDepth = (arbol.getHijoIzq() != null) ? getDeep(arbol.getHijoIzq()) : 0;
            rightDepth = (arbol.getHijoDer() != null) ? getDeep(arbol.getHijoDer()) : 0;
            return (rightDepth > leftDepth) ? rightDepth + 1 : leftDepth + 1;
    }

    /**
     * MÈtodo que calcula el n˙mero de nodos internos que tiene un arbol
     * 
     * @param arbol
     *            Arbol sobre el que se quiere calcular los nodos internos
     * @return Devuelve el n˙mero de nodos internos del Arbol
     */
    private int getInteriorNodes(Arbol<Midiclorian> arbol) {
            if (arbol.vacio() || (arbol.getHijoIzq() == null && arbol.getHijoDer() == null))
                    return 0;
            int interiorNodes = 1;
            interiorNodes += (arbol.getHijoIzq() != null) ? getInteriorNodes(arbol.getHijoIzq()) : 0;
            interiorNodes += (arbol.getHijoDer() != null) ? getInteriorNodes(arbol.getHijoDer()) : 0;
            return interiorNodes;
    }

    /**
     * MÈtodo para inicializar un arbol
     * 
     * @param arbol
     *            Arbol que se quiere inicializar
     */

    private void cleanTree(Arbol<Midiclorian> arbol) {
            arbol = new Arbol<Midiclorian>();
    }

    /**
     * MÈtodo que calcula el n˙mero de nodos externos que tiene un arbol
     * 
     * @param arbol
     *            Arbol sobre el que se quiere calcular los nodos externos
     * @return Devuelve el n˙mero de nodos externos del Arbol
     */

    private int getExteriorNodes(Arbol<Midiclorian> arbol) {
            if (arbol.vacio())
                    return 0;
            int exteriorNodes = 0;
            if (arbol.getHijoIzq() == null && arbol.getHijoDer() == null)
                    exteriorNodes++;
            exteriorNodes += (arbol.getHijoIzq() != null) ? getExteriorNodes(arbol.getHijoIzq()) : 0;
            exteriorNodes += (arbol.getHijoDer() != null) ? getExteriorNodes(arbol.getHijoDer()) : 0;
            return exteriorNodes;
    }

    // PUBLIC METHODS

    /**
     * Constructor paramÈtrizado de GateLock
     * 
     * @param deepCombination
     *            Profundidad de desbloqueo de la combinaciÛn
     */

    public GateLock(int deepCombination) {
            this.deepCombination = deepCombination;
            this.midicloriansCombination = new Arbol<Midiclorian>();
            this.testedMidiclorians = new Arbol<Midiclorian>();
            this.initialCombination = new ArrayList<Midiclorian>();
            this.status = true;
    }

    /**
     * MÈtodo para saber si la cerradura est· abierta
     * 
     * @return Devuelve true si est· abierta
     */
    public boolean isOpen() {
            return status;
    }

    /**
     * Set de estado.
     * 
     * @param status
     *            El estado a poner. FALSE = CERRADA ; TRUE = ABIERTA
     */
    public void setStatus(boolean status) {
            this.status = status;
    }

    /**
     * Get de Profundidad de desbloqueo de la cerradura
     * 
     * @return Devuelve la profundidad de la combinaciÛn.
     */
    public int getDeepCombination() {
            return deepCombination;
    }

    /**
     * Set de Profundidad de desbloqueo de la cerradura
     * 
     * @param deepCombination
     *            La profundidad de la combinaciÛn
     */
    public void setDeepCombination(int deepCombination) {
            this.deepCombination = deepCombination;
    }

    /**
     * MÈtodo para probar un midicloriano en la cerradura
     * 
     * @param midiclorian
     *            Midicloriano que se quiere probar
     * @return Devuelve FALSE si el midicloriano no se encuentra en la combinaciÛn, TRUE si
     */
    public boolean testMidiclorian(Midiclorian midiclorian) {
            if (testedMidiclorians.pertenece(midiclorian))
                    return false;
            if (midicloriansCombination.pertenece(midiclorian))
                    midicloriansCombination.borrar(midiclorian);
            this.testedMidiclorians.insertar(midiclorian);
            return true;

    }

    public void restart() {
            cleanTree(midicloriansCombination);
            cleanTree(testedMidiclorians);
            configure(initialCombination);

    }

    public void configure(ArrayList<Midiclorian> midiclorians) {
            this.initialCombination.clear();
            for (int i = 0; i < midiclorians.size(); i++) {
                    Midiclorian m = midiclorians.get(i);
                    this.midicloriansCombination.insertar(m);
                    this.initialCombination.add(m);
            }
    }

    public void checkStatus() {
            
            if (getDeep(midicloriansCombination) < this.deepCombination
                            && getInteriorNodes(midicloriansCombination) >= getExteriorNodes(midicloriansCombination)){
                    status = true;
            }

    }

    public String getInfoGateLock() {
            String output = "";
            output += "Estado de la puerta: " + ((this.status) ? "ABIERTA" : "CERRADA");
            output += "\n\tAltura Cerradura: " + getDeep(midicloriansCombination);
            output += "\n\tMidiclorianos Internos: " + getInteriorNodes(midicloriansCombination);
            output += "\n\tMidiclorianos Externos: " + getExteriorNodes(midicloriansCombination);
            return output;
    }

}