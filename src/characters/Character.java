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
public abstract class Character {

    /**
     * Marca identificativa
     */
    private char iD;

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
     * Constructor por defecto
     */
    public Character() {
        this.iD = ' ';
        this.name = "";
        this.midiclorians = new ArrayList<Midiclorian>();
    }

    /**
     * Constructor parametrizado
     *
     * @param iD   marca identificativa del personaje
     * @param name nombre del personaje
     */
    public Character(char iD, String name) {
        this.iD = iD;
        this.name = name;
        this.midiclorians = new ArrayList<Midiclorian>();
    }

    /**
     * @param midiclorians El/La midiclorianos a poner
     */
    public void setMidiclorianos(ArrayList<Midiclorian> midiclorians) {
        this.midiclorians = midiclorians;
    }

    public abstract void onStation(BaseStation station);

    public abstract void onGate(GateStation station);

    /**
     * Mueve el personaje desde una estación(dada por parámetro) a otra estación de
     * una galaxia(dada por parámetro)
     *
     * @param originStation Estación en la que está acutalmente el personaje
     * @param galaxy        Galaxia en donde se encuentran las estaciones y los personajes
     * @pre El personaje debe de estar sacado de
     */
    public boolean move(BaseStation originStation, Galaxy galaxy) {
        turn++;
        //En way se guarda el siguiente camino y se vuelve a insertar en la cola
        Way way = route.poll();
        route.add(way);
        //Se calculan las coordenadas del destino a partir del ID de la estación de origen
        int[] coord = new int[2];
        galaxy.IDtoCoordinates(originStation.getID(), coord);
        int row = coord[0] + way.getWidth();
        int column = coord[1] + way.getHeight();
        //Si las coordenadas son permitidas se mueve el personaje
        if (galaxy.stationPermitted(row, column)) {
            BaseStation destinationStation = galaxy.getStation(row, column);
            destinationStation.insertCharacter(this);
            return true;
        }
        return false;
    }

    public void simulate(BaseStation originStation, Galaxy galaxy) {
        if (originStation instanceof GateStation)
            this.onGate(originStation);
        else
            this.onStation(originStation);
    }
}
