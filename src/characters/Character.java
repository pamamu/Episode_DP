package characters;

import estructura.BaseStation;
import estructura.Galaxy;
import estructura.GateStation;
import estructura.Midiclorian;

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
 * @author Fernando.G & Pablo Macias
 * @version 1.0 ALFA
 * @since <p color="red">
 * by: Fernando G. & Pablo Macias<br/>
 * Revenge of the Sith™ 2015
 * <p>
 * </p>
 */
public abstract class Character implements Comparable<Character> {

    /**
     * Marca identificativa
     */
    private char classMark;

    /**
     * Variable que indica el nombre del personaje
     */
    private String name;

    /**
     * ArrayList de los midiclorianos que porta el personaje
     */
    protected ArrayList<Midiclorian> midiclorians;

    /**
     * ArrayList de Caminos
     */
    private LinkedList<Way> route;

    /**
     * Turno del personaje
     */
    private int turn;

    /**
     * Estacion de origen del personaje
     */
    //Se utilizara, para que el personaje conozca su posicion de origen, en cada 
    //movimiento y asi liberar al main de este tipo de control (se autogestiona)
    private BaseStation originStation;

    /**
     * Constructor por defecto
     */
    public Character() {
        this.classMark = ' ';
        this.name = "";
        this.midiclorians = new ArrayList<Midiclorian>();
        this.originStation = null;
    }

    /**
     * Constructor parametrizado
     *
     * @param iD marca identificativa del personaje
     * @param name nombre del personaje
     */
    public Character(char iD, String name, BaseStation originStation) {
        this.classMark = iD;
        this.name = name;
        this.midiclorians = new ArrayList<Midiclorian>();
        this.originStation = originStation;
        this.originStation.insertCharacter(this);
    }

    public BaseStation getOriginStation(){
        return this.originStation;
    }
    /**
     * TODO DOCUMENTAR
     *
     * @return
     */
    public int getTurn() {
        return turn;
    }
    
    public void showmidiclorians(){
        System.out.println(this.midiclorians);
    }

    /**
     * @param midiclorians El/La midiclorianos a poner
     */
    public void setMidiclorianos(ArrayList<Midiclorian> midiclorians) {
        //CUIDADO ALOMEJOR HAY QUE CLONAR POR LOS PUNTEROS
        this.midiclorians = midiclorians;
    }

    /**
     * @param route ruta a seguir
     */
    public void setRoute(LinkedList<Way> route) {
        this.route = route;
    }

    public void setOriginStation(BaseStation station) {
        this.originStation = station;
        originStation.insertCharacter(this);
    }
    
    public char getClassMark(){
        return this.classMark;
    }
    
    public String getName(){
        return this.name;
    }

    public abstract void onStation(Galaxy galaxy);

    public abstract void onGate(Galaxy galaxy);

    public void action(Galaxy galaxy){
        
        //Comprobamos donde estamos
        if(this.originStation instanceof GateStation){
            //Si estamos en puerta
            onGate(galaxy);
        }else{
            //Si no
            //Mueve
            this.move(galaxy);
            //Ejecuta su accion personalizada
            onStation(galaxy);
        }
        
        //Aumenta el turno del personaje
        this.turn++;
        
    }
    
    /**
     * Mueve el personaje desde una estación de origen a otra estación de una
     * galaxia(dada por parámetro)
     *
     * @param galaxy Galaxia en donde se encuentran las estaciones y los
     *      personajes
     * @pre El personaje debe de estar sacado de
     */
    public boolean move(Galaxy galaxy) {
        //En way se guarda el siguiente camino y se vuelve a insertar en la cola
        Way way = route.poll();
        route.add(way);
        //Se calculan las coordenadas del destino a partir del ID de la estación de origen
        int[] coord = new int[2];
        galaxy.IDtoCoordinates(this.originStation.getID(), coord);
        int row = coord[0] + way.getHeight();
        int column = coord[1] + way.getWidth();
        //Si las coordenadas son permitidas se mueve el personaje
        if (galaxy.stationPermitted(row, column)) {
            BaseStation destinationStation = galaxy.getStation(row, column);
            destinationStation.insertCharacter(this);
            originStation.delete(this);
            this.originStation = destinationStation;
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Character o) {
        return 1;
    }

    /**
     *
     *
     * @pre @post @complex O()
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Character) {
            Character aux = (Character) obj;
            return this == aux;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.midiclorians.toString();
    }
    
    
}
