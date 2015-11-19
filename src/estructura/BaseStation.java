package estructura;

import characters.Character;

import java.util.PriorityQueue;
import java.util.Queue;


/**
 * <p color="#01DF01">
 * Este codigo es parte del proyecto StarsWars - DP desarrollado en la
 * Universidad<br/>
 * de Extremadura en el curso 2015 - 2016 en la asignatura Desarrollo de
 * Programas
 * </p>
 * <br/>
 *
 * @author Fernando.G & Pablo Macias
 * @version 1.0 ALFA
 * @since <p color="red">
 * by: Fernando G. & Pablo Macias<br/>
 * Revenge of the Sith™ 2015
 * <p>
 * </p>
 */
public class BaseStation {
    // ATRIBUTOS ###############################################################

    // Privados
    /**
     * Identificador de la Estación
     */
    private int ID;
    /**
     * Cola de personajes
     */
    private PriorityQueue<Character> characters;
    /**
     * Cola de preferencias de midiclorianos obtenidos
     */
    private PriorityQueue<Midiclorian> midiclorians;
    // CONSTRUCTORES ###########################################################

    /**
     * <p color="red">
     * Constructor parametrizado
     * </p>
     *
     * @param ID<br/> ID de la estacion<br/>
     * @pre ID >= 0
     * @post ID con valor de parámetro
     * @complex O(1)
     */
    public BaseStation(int ID) {
        this.ID = ID;
        this.characters = new PriorityQueue<>();
        this.midiclorians = new PriorityQueue<>();
    }

    // Getter & Setter #########################################################

    /**
     * Get ID
     *
     * @return int iD
     * @pre
     * @post Devuelve el ID de la estación
     * @complex O(1)
     */
    public int getID() {
        return ID;
    }

    /**
     * Set ID
     *
     * @param iD<br/> the iD to set
     * @pre ID >=0
     * @post Introduce el parámetro como valor en un atributo de la instancia
     * @complex O(1)
     */
    public void setID(int iD) {
        ID = iD;
    }

    // PRIVADOS ################################################################

    //PUBLICOS #################################################################

    /**
     * Inserta un personaje en la ED de la Estación
     *
     * @param character personaje a insertar en la estación
     */
    public void insertCharacter(Character character) {
        characters.add(character); //TODO INSERTAR POR ORDEN HISTÓRICO
    }

    public Character takeCharacter() {
        return characters.poll();
    }

    /**
     * TODO DOCUMENTAR
     *
     * @param midiclorian
     */
    public void insertMidiclorian(Midiclorian midiclorian) {
        this.midiclorians.add(midiclorian);
    }

    /**
     * TODO DOCUMENTAR Y COMPROBAR SI EL MIDICLORIANO ES NULO NO LO DEVUELVE
     * TODO POSIBLE LANZAMIENTO DE EXCEPCIÓN
     *
     * @return
     */
    public Midiclorian collectMidiclorian() {
        return this.midiclorians.poll();
    }

//    /**
//     * Simula el juego dentro de una estación haciendo que los personajes realicen
//     * una acción en ese turno
//     *
//     * @param galaxy Galaxia en la que se está simulando el juego
//     * @param turn   Turno general de la partida
//     */
//    public boolean simulate(Galaxy galaxy, int turn) {
//        Character character = this.takeCharacter();
//        while (true) {
//            if (characters.peek().getTurn() < turn) {
//                characters.poll();
//                if (character.action(this, galaxy))
//                    return true;
//            } else
//                break;
//        }
//        return false;
//    }
    
    public String getMidiclorians(){
        String output = "";
        
        if(!midiclorians.isEmpty()){
            output += midiclorians.toString();
            if(midiclorians.size() < 2){
                output += "\t\t";
            }
        }else{
            output += "\t";
        }
        
        return output;
    }
    
    public String getCharacter(){
        String output = "";
        
        if(!characters.isEmpty()){
            output += characters.toString();
            if(characters.size() < 2){
                output += "\t";
            }
        }else{
            output += "\t";
        }
        
        return output;
    }
    
    public boolean delete(Character character){
        return this.characters.remove(character);
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
        output += "Personajes: \n" + characters.toString();
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
