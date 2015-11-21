package estructura;

import java.util.ArrayList;

/**
 * <p color="#01DF01">
 * Este codigo es parte del proyecto StarsWars - DP desarrollado en la
 * Universidad<br/>
 * de Extremadura en el curso 2015 - 2016 en la asignatura Desarrollo de
 * Programas
 * </p>
 * <br/>
 * <p>
 * La clase galaxia es un tablero bidimensional compuesto de X Y elementos de la
 * clase<br/>
 * Station, cuando llamamos al contructor de Galaxy, este nos genera un tablero
 * X Y<br/>
 * que por defecto tendra 8x8 estaciones, si no se especifican el numero de
 * filas<br/>
 * y columnas, reasignando aleatoriamente la puerta o estacion de entrada y la
 * <br/>
 * puerta o estacion de salida
 *
 * @author Fernando.G & Pablo Macias
 * @version 1.0 ALFA
 * @since <p color="red">
 * by: Fernando G. & Pablo Macias<br/>
 * Revenge of the Sith™ 2015
 * <p>
 * </p>
 */

public class Galaxy {

    // ATRIBUTOS ############################################################

    /**
     * Número de filas de la galaxia
     */
    private int dimX;
    /**
     * Número de columnas de la galaxia
     */
    private int dimY;
    /**
     * Starsgate o puerta de salida de la galaxia
     */
    private Starsgate starsgate;
    /**
     * Estación con los personajes que han salido
     */
    private BaseStation LibertyStation;
    /**
     * Estaciones que forman una galaxia
     */
    private BaseStation[][] Stations;

    // CONSTRUCTORES ########################################################

    /**
     * Constructor parametrizado de una galaxia
     *
     * @param gateStation Estacion donde se coloca la puerta
     * @param dimX        Dimension X de la galaxia(numero de filas)
     * @param dimY        Dimension Y de la galaxia(numero de columnas)
     * @pre gateStation > 0 && dimX > 0 && dimY > 0
     * @post Atributos con valores de parámetros && starsgate = null && Matriz
     * de dimX x dimY creada con estaciones. Creada estación de salida con ID = 111
     * @complex O(n^2)
     */
    public Galaxy(int gateStation, int dimX, int dimY) {

        this.dimX = dimX;
        this.dimY = dimY;

        this.starsgate = null;
        this.Stations = new BaseStation[dimX][dimY];
        this.LibertyStation = new BaseStation(1111);

        for (int i = 0; i < dimX; i++) {
            for (int j = 0; j < dimY; j++) {
                if (gateStation != j + i * dimY)
                    Stations[i][j] = new BaseStation(j + i * dimY);
                else
                    Stations[i][j] = new GateStation(j + i * dimY, starsgate);
            }
        }
    }

    // PRIVADOS #############################################################

    /**
     * Algoritmo recursivo que balancea los valores de un array y los almacena
     * en otro
     *
     * @param midiclorians         ArrayList de midiclorianos que se quieren balancear
     * @param combinedMidiclorians ArrayList de midiclorianos balanceados
     * @param low                  Indica la cota superior sobre la que se quiere balancear
     * @param top                  Indica la cota inferior sobre la que se quiere balancear
     * @pre <i>midiclorians</i> inicializado correctamente &&
     * <i>combinedMidiclorians</i> inicializado correctamente && <i>low</i>
     * > 0 && <i>top</i> > 0
     * @post midiclorianos de <i>midiclorians</i> insertados de forma balanceada
     * en <i>combinedMidiclorians</i>
     * @complex O(n)
     */
    private void combine(ArrayList<Midiclorian> midiclorians, ArrayList<Midiclorian> combinedMidiclorians, int low,
                         int top) {
        int middle = (low + top) / 2;
        /*
         * Inserta en combinedMidiclorians el midicloriano de la posicion
		 * intermedia de midiclorians
		 */
        combinedMidiclorians.add(midiclorians.get(middle));

        if (low != top) {
            /*
             * Recursivo con low=mitad+1 y top igual
			 */
            combine(midiclorians, combinedMidiclorians, middle + 1, top);
            /*
             * Recursivo con low=low y top=mitad-1
			 */
            combine(midiclorians, combinedMidiclorians, low, middle - 1);
        }
    }

    // PUBLICOS #############################################################

    /**
     * Método para generar un ArrayList de Midiclorianos balanceados a partir
     * del ArrayList de entrada con una combinación dada.
     *
     * @param midiclorians ArrayList de Midiclorianos usado para generar la combinación.
     * @return Devuelve ArrayList de midiclorianos con midiclorianos ordenados
     * según combinación dada.
     * @pre <i>midiclorians</i> inicializado correctamente
     * @post devuelve ArrayList de tipo Midiclorianos con los valores ordenados
     * de forma balanceada
     * @complex O(n)
     */
    public ArrayList<Midiclorian> generateCombination(ArrayList<Midiclorian> midiclorians) {
        ArrayList<Midiclorian> combinedMidiclorians = new ArrayList<>();
        combine(midiclorians, combinedMidiclorians, 0, midiclorians.size() - 1);
        return combinedMidiclorians;
    }

    /**
     * Introduce una Stargate con una profundidad de combinación determinada en
     * la Galaxia
     *
     * @param StarsGate       Stargate que se quiere introducir en la Galaxia
     * @param deepCombination Profundidad de combinación con la que se desbloquea la
     *                        cerradura de la galaxia
     * @pre <i>StarsGate</i> inicicializada correctamente &&
     * <i>deepCombination</i> > 0
     * @post Se inserta una nueva starsgate en la galaxia con los parametros
     * introducidos. Se ejecuta el recolector de basura por si hubiera
     * alguna puerta insertada anteriormente.
     * @complex O(1)
     */
    public void setStarsGate(Starsgate StarsGate, int deepCombination) {
        StarsGate.setDeepCombination(deepCombination);
        this.starsgate = StarsGate;
        
        GateStation nuevaPuerta = new GateStation(dimX*dimY -1, StarsGate);
        Stations[dimX-1][dimY-1] = nuevaPuerta;
        
        System.gc();
    }

    /**
     * Reparte midiclorianos por las estaciones de la galaxia de 5 en 5
     *
     * @param midiclorians        ED con midiclorianos que se desean insertar en la galaxia
     * @param stationMidiclorians Entero que indica cuantos midiclorianos se desaean insertar por cada estación
     */
    public void dispenseMidiclorians(ArrayList<Midiclorian> midiclorians, int stationMidiclorians) {
        for (int i = 0; i < dimY; i++) {
            for (int j = 0; j < dimX; j++) {
                for (int k = 0; k < stationMidiclorians; k++) {
                    if(!midiclorians.isEmpty()){
                        Stations[i][j].insertMidiclorian(midiclorians.get(0));
                        midiclorians.remove(0);
                    }else{
                        return;
                    }
                }
            }
        }
    }

//    /**
//     * Método que simula una partida real con movimiento prefijados y 50 turnos. EC2.
//     *
//     * @param turns turnos que se quieren jugar
//     */
//    public void simulate(int turns) {
//        boolean openGate = false;
//        for (int turn = 0; turn < turns && !openGate; turn++)
//            for (int i = 0; i < dimY && !openGate; i++)
//                for (int j = 0; j < dimX && !openGate; j++) {
//                    Stations[i][j].simulate(this, turn);
//                }
//
//    }

    /**
     * Dado la fila y la columna comprueba si son "legales" en la galaxia creada
     *
     * @param row    fila que se quiere comprobar
     * @param column columna que se quiere comprobar
     * @return TRUE: La fila y la columna son compatibles con las dimensiones de la galaxia
     * FALSE: La fila y la columna no son compatibles con las dimensiones de la galaxia
     */
    public boolean stationPermitted(int row, int column) {
        if (row >= dimX || column >= dimY || row < 0 || column < 0)
            return false;
        return true;
    }

    /**
     * TODO DOCUMENTAR
     *
     * @param row
     * @param column
     * @return
     */
    public BaseStation getStation(int row, int column) {
        return Stations[row][column];
    }

    /**
     * @param ID    ID que se quiere convertir a fila y columna
     * @param coord Parámetro de salida donde coord[0] es el número de fila y coord[1] el número de columnas
     */
    public void IDtoCoordinates(int ID, int[] coord) {
        coord[0] = ID / dimY;
        coord[1] = ID % dimY;
    }

    /**
     * Metodo toString sobrescrito
     *
     * @return String con los datos de la Galaxia
     * @pre
     * @post Devuelve string con los ID de las estaciones de la galaxia
     * indicando en su caso , cuando es la puerta de salida.
     * @complex O(n^2)
     */
    @Override
    public String toString() {
        String output = "";

        for (int i = 0; i < Stations.length; i++) {
            output += "|";
            for (int e = 0; e < Stations[i].length; e++) {
                if (Stations[i][e].getType().equals("GateStation"))
                    output += "STARSGATE ";
                output += Stations[i][e].getID() + "|";
            }
            output += "\n";
        }

        return output;
    }

    /**
     * Devuelve informacion sobre todas las estaciones de la galaxia
     *
     * @return Devuelve String con informacion sobre la galaxia en
     * cuadriculas(estaciones)
     * @pre
     * @post Devuelve string con mapa de la galaxia indicando tipos e ID.
     * @complex O(n^2)
     */
    public String getInfoStations() {
        String output = "";

        for (int i = 0; i < Stations.length; i++) {
            for (int j = 0; j < Stations[i].length; j++) {
                output += " _______________";
            }
            output += "\n";
            // Linea del id de celda
            for (int e = 0; e < Stations[i].length; e++) {
                output += "|" + Stations[i][e].getID() + "\t\t|";
            }
            output += "\n";
            // Linea del tipo
            for (int e = 0; e < Stations[i].length; e++) {
                output += "|" + Stations[i][e].getType() + "\t|";
            }
            output += "\n";
            // Linea de espacio | y si tiene puerta
            for (int e = 0; e < Stations[i].length; e++) {
                if (Stations[i][e].getType().equals("GateStation"))
                    output += "|" + "STARGATE" + "\t|";
                else
                    output += "|\t\t|";
            }
            output += "\n";
            // Linea de Personajes
            for (int e = 0; e < Stations[i].length; e++) {
                output += "|"+Stations[i][e].getCharacter() + "\t|";
            }
            output += "\n";
            // Linea de midiclorianos
            for (int e = 0; e < Stations[i].length; e++) {
                output += "|";
                    if(!Stations[i][e].getMidiclorians().equals("\t"))
                        output+= "*\t\t|";
                    else
                        output+= "\t\t|";
            }
            output += "\n";
            for (int j = 0; j < Stations[i].length; j++) {
                output += "| ______________";
            }
            output += "\n";
        }

        return output;
    }

}