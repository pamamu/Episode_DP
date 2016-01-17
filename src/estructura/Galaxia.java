/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura;

import edd.Grafo;
import etc.GenAleatorios;
import etc.Logger;
import java.util.ArrayList;
import java.util.Arrays;
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
public class Galaxia {

// ATRIBUTOS ###############################################################
    /**
     * Atributo que representa la única instancia que existirá de la clase
     * Galaxia(Singleton)
     */
    private static Galaxia instancia = null;
    /**
     * Número de filas de la galaxia
     */
    private final int dimX;
    /**
     * Número de columnas de la galaxia
     */
    private final int dimY;
    /**
     * Variable que indica el número de turno de la Galaxia
     */
    private int turno;
    /**
     * ID de la estacion con Puerta
     */
    private final int idEstacionPuerta;
    /**
     * ID de la estacion de libertad(personajes ganadores)
     */
    private final int idLibertyStation;
    /**
     * Starsgate o puerta de salida de la galaxia
     */
    private final EstacionPuerta starsgate;
    /**
     * Estación con los personajes que han salido
     */
    private final EstacionBase LibertyStation;
    /**
     * Estaciones que forman una galaxia
     */
    private final EstacionBase[][] Estaciones;
    /**
     * Personajes de la Galaxia
     */
    private ArrayList<Personaje> personajes;
    /**
     * Estructura de datos que almacena las conexiones entre las galaxias
     */
    private final Grafo grafo;
    /**
     * Estructura de datos que almacena las paredes
     */
    private final ArrayList<Pared> paredes;
    /**
     * Array de enteros que indica cuantas veces se ha pasado por una
     * determinada estación
     */
    private ArrayList<Integer> pasosPorEstaciones;

    /**
     * Clase donde se especifica e implementa el objeto Pared Usado en la
     * creación del laberinto de la Galaxia.
     */
    private class Pared {

        /**
         * Entero que indica la estación de origen de la puerta
         */
        private final int origen;
        /**
         * Entero que indica la estación de destino de la puerta
         */
        private final int destino;

        /**
         * Constructor parametrizado de la clase Pared
         *
         * @param origen ID de la estacion de origen de la puerta
         * @param destino ID de la estación de destino de la puerta
         * @pre -
         * @post Pared creada con valores de parámetros
         * @complex O(1)
         */
        public Pared(int origen, int destino) {
            this.origen = origen;
            this.destino = destino;

        }
    }
// CONSTRUCTORES ###########################################################

    /**
     * Constructor parametrizado de la clase Galaxia
     *
     * @param idEstacionPuerta ID de la estación con puerta
     * @param starsgate Estación con puerta a insertar en la Galaxia
     * @param dimX Dimensión X de la galaxia (número de filas)
     * @param dimY Dimensión Y de la galaxia (número de columnas)
     * @pre -
     * @post Galaxia inicializado con parámetros dados
     * @complex O(n^2)
     */
    private Galaxia(int idEstacionPuerta, EstacionPuerta starsgate, int dimX, int dimY) {

        this.dimX = dimX;
        this.dimY = dimY;
        this.turno = 0;
        this.idEstacionPuerta = idEstacionPuerta;

        this.starsgate = starsgate;
        this.Estaciones = new EstacionBase[dimX][dimY];
        this.idLibertyStation = 1111;
        this.LibertyStation = new EstacionBase(idLibertyStation);

        int idaux;
        for (int i = 0; i < dimX; i++) {
            for (int j = 0; j < dimY; j++) {
                idaux = j + i * dimY;
                if (idEstacionPuerta != idaux) {
                    Estaciones[i][j] = new EstacionBase(idaux);
                } else {
                    Estaciones[i][j] = starsgate;
                }
            }
        }
        paredes = new ArrayList<>();
        grafo = new Grafo();
        pasosPorEstaciones = new ArrayList<>();
        personajes = new ArrayList<>();
    }

// Getter & Setter #########################################################
    /**
     * Método sobrecargado que devuelve la única instancia de la Galaxia. Los
     * parámetros se utilizan para construir la Galaxia inicial.
     *
     * @param idEstacionPuerta ID de la estacionpuerta(salida de la galaxia)
     * @param starsgate EstacionPuerta de la Galaxia
     * @param dimX Número de filas de la Galaxia
     * @param dimY Número de columnas de la Galaxia
     * @return Devuelve una instancia de Galaxia.
     * @pre -
     * @post Devuelve la instancia de Galaxia. Si no esta inicializada se crea
     * una con parámetros dados
     * @complex O(n^2)
     */
    public static Galaxia obtenerInstancia(int idEstacionPuerta, EstacionPuerta starsgate, int dimX, int dimY) {
        if (instancia == null) {
            instancia = new Galaxia(idEstacionPuerta, starsgate, dimX, dimY);
        }
        return instancia;
    }

    /**
     * Método sobrecargado que devuelve la única instancia de la Galaxia.
     *
     * @return Devuelve la instancia de la Galaxia.
     * @pre -
     * @post Devuelve la instancia de Galaxia.
     * @complex O(1)
     */
    public static Galaxia obtenerInstancia() {
        return instancia;
    }

    /**
     * Método que devuelve el numero de filas de la Galaxia
     *
     * @return Devuelve número de filas de la Galaxia
     * @pre Galaxia inicializada con éxito
     * @post -
     * @complex O(1)
     */
    public int getDimX() {
        return dimX;
    }

    /**
     * Método que devuelve el número de columnas de la Galaxia
     *
     * @return Devuelve el número de columnas de la galaxia
     *
     * @pre Galaxia inicializada con éxito
     * @post -
     * @complex O(1)
     */
    public int getDimY() {
        return dimY;
    }

    /**
     * Método que devuelve el grafo de conexiones
     *
     * @return Devuelve el grafo
     * @pre Galaxia inicializada con éxito
     * @post -
     * @complex O(1)
     */
    public Grafo getGrafo() {
        return grafo;
    }

    /**
     * Método que devuelve el ID de la estacion conpuerta
     *
     * @return Devuelve ID de Starsgate
     * @pre Galaxia inicializada con éxito
     * @post -
     * @complex O(1)
     */
    public int getIdEstacionPuerta() {
        return idEstacionPuerta;
    }

    /**
     * Método que devuelve la estacion de Libertad
     *
     * @return Devuelve la estacion LibertyStation
     * @pre Galaxia inicializada con éxito
     * @post -
     * @complex O(1)
     */
    public EstacionBase getEstacionLiberty() {
        return LibertyStation;
    }

    /**
     * Método que devuelve la estacion Puerta - Starsgate
     *
     * @return Devuelve el ID de Starsgate
     * @pre Galaxia inicializada con éxito
     * @post -
     * @complex O(1)
     */
    public EstacionPuerta getStarsgate() {
        return starsgate;
    }

    /**
     *  TODO
     * @return
     */
    public ArrayList<Personaje> getPersonajes(){
        return personajes;
    }
    
    /**
     * Método que introduce ED con ruta desde la estacion de inicio hasta
     * estación de fin.
     *
     * @param pasosPorEstaciones ED con ruta desde la estacion de inicio hasta
     * la estacion de fin o salida.
     * @pre Galaxia inicializada con éxito
     * @post pasosPorEstaciones toma el valor del parámetro de entrada.
     * @complex O(1)
     *
     */
    public void setPasosPorEstaciones(ArrayList<Integer> pasosPorEstaciones) {
        this.pasosPorEstaciones = (ArrayList<Integer>) pasosPorEstaciones.clone();
    }

    /**
     * Método que inserta un ArrayList de personajes en la Galaxia
     *
     * @param personajes ArrayList que contiene los personajes que se encuentran
     * en la galaxia
     * @pre Galaxia inicializada con éxito
     * @post parámetro se convierte a ArrayList de personajes y se inserta en
     * personajes
     * @complex O(n)
     */
    public void setPersonajes(ArrayList<Object> personajes) {
        Personaje[] array = personajes.toArray(new Personaje[personajes.size()]);
        this.personajes = new ArrayList<>(Arrays.asList(array));
    }

// PRIVADOS ################################################################
    /**
     * Método para construir las paredes iniciales - Conectar todas las
     * estaciones con sus estacion más próximas.
     *
     * @pre DimX y DimY con valores válidos, Grafo y paredes inicialiadas con
     * éxito.
     * @post Grafo con todos los arcos que unen las estaciones con sus
     * estaciones vecinas (N,S,E,O) y todas las paredes almacenadas en ED
     * paredes, la cual ayudará a implementar algoritmo de Kruskal.
     * @complex O(n)
     */
    private void construirParedesIni() {
        int destino;
        for (int estacion = 0; estacion < dimX * dimY; estacion++) {
            //ESTACIÓN NORTE
            if (estacion >= dimY) {
                destino = estacion - dimY;
                paredes.add(new Pared(estacion, destino));
            }
            //ESTACIÓN ESTE
            if ((estacion % dimY != dimY - 1)) {
                destino = estacion + 1;
                paredes.add(new Pared(estacion, destino));
            }
            //ESTACIÓN SUR
            if ((estacion / dimY) < dimX - 1) {
                destino = estacion + dimY;
                paredes.add(new Pared(estacion, destino));
            }
            //ESTACIÓN OESTE
            if ((estacion % dimY) != 0) {
                destino = estacion - 1;
                paredes.add(new Pared(estacion, destino));
            }
        }
    }

    /**
     * Expande un ID a todos los IDs con valor = varinicial
     *
     * @param nodos ED con nodos de enteros
     * @param valorinicial Valor el cual se quiere modificar
     * @param valorfinal Valor al cual se va a modificar
     * @pre Galaxia inicializada con éxito
     * @post Todos los nodos de la matriz que sean iguales al parámetro
     * valorinicial se convierten en valorfinal
     * @complex O(n^2)
     */
    private void expandirConexion(int[][] nodos, int valorinicial, int valorfinal) {
        for (int i = 0; i < nodos.length; i++) {
            for (int j = 0; j < nodos[i].length; j++) {
                if (nodos[i][j] == valorinicial) {
                    nodos[i][j] = valorfinal;
                }
            }
        }
    }

// PÚBLICOS #################################################################
    /**
     * Método para construir una Galaxia inicial.
     *
     * @pre Galaxia inicializada con éxito
     * @post Se crean todos los nodos (ID de estaciones) y se llama a
     * construirParedesIni()
     * @complex O(n)
     */
    public void construirGalaxia() {
        //CREACION DE NODOS
        for (int i = 0; i < dimX * dimY; i++) {
            grafo.nuevoNodo(i);
        }
        //CREACION DE PAREDES
        construirParedesIni();
    }

    /**
     * Método para generar un laberinto.
     *
     * @pre Galaxia inicializada con éxito
     * @post Genera un laberinto a través del Algoritmo de Kruskal ayudandose de
     * una matriz de enteros haciendo referencia a los IDS de las galaxias.
     * Sobre esta matriz se realizan los cálculos del ALgoritmo de Kruskal.
     * Sobre el grafo de la gaxia se insertan arcos de las estaciones adyacentes
     * según el Algoritmo.
     * @complex O(n^3)
     *
     */
    public void generarLaberinto() {
        //Nodos auxiliares con ID de estaciones
        int[][] nodos = new int[dimX][dimY];
        for (int i = 0; i < nodos.length; i++) {
            for (int j = 0; j < nodos[i].length; j++) {
                nodos[i][j] = Estaciones[i][j].getID();
            }
        }
        int npared; //Enesima pared
        Pared pared; //Variable para alamecenar pared
        //Variables para almacenar coordenadas de origen y destino
        int[] coordorigen, coordestino;
        int nodorigen, nododestino;
        while (!paredes.isEmpty()) {
            npared = GenAleatorios.generarNumero(paredes.size());
            pared = paredes.remove(npared);
            coordorigen = IDtoCoordenadas(pared.origen);
            coordestino = IDtoCoordenadas(pared.destino);
            nodorigen = nodos[coordorigen[0]][coordorigen[1]];
            nododestino = nodos[coordestino[0]][coordestino[1]];
            if (nodorigen != nododestino) {
                grafo.nuevoArco(pared.origen, pared.destino, 1);
                grafo.nuevoArco(pared.destino, pared.origen, 1);
                expandirConexion(nodos, nododestino, nodorigen);
            }
        }
        grafo.floyd();
        grafo.warshall();
    }

    /**
     * Método que genera ArrayList de Midiclorianos iniciales de la galaxia
     *
     * @return ArrayList de midiclorianos sin configurar
     * @pre Galaxia inicializada correctamente
     * @post Genera arraylist con midiclorianos con ID desde el 0 hasta el 30
     * @complex O(n)
     */
    public ArrayList<Midicloriano> generarMidiclorianosCerradura() {
        ArrayList<Midicloriano> midiclorianos = new ArrayList<>();
        for (int i = 0, j = 1; i < 15; i++) {
            midiclorianos.add(new Midicloriano(j));
            j += 2;
        }
        return midiclorianos;
    }

    /**
     * Método que genera ArrayList de Midiclorianos iniciales de la galaxia
     *
     * @return ArrayList de midiclorianos sin configurar
     * @pre Galaxia inicializada correctamente
     * @post Genera arraylist con midiclorianos con ID desde el 0 hasta el 30
     * @complex O(n)
     */
    public ArrayList<Midicloriano> generarMidiclorianosGalaxia() {
        ArrayList<Midicloriano> midiclorianos = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Midicloriano mid = new Midicloriano(i);
            midiclorianos.add(mid);
            if (i % 2 != 0) {
                midiclorianos.add(mid);
            }
        }
        return midiclorianos;
    }

    /**
     * Método para repartir midiclorianos por la galaxia
     *
     * @param midiclorianos ArrayList que contiene los midiclorianos a insertar
     * en la galaxia.
     * @pre Galaxia inicializada con éxito
     * @post Reparte los midiclorianos de 5 en 5 por las estacione almacenadas
     * en pasosPorEstacion (Recorrido de FamiliaReal)
     * @complex O(n^2)
     *
     */
    public void repartirMidiclorianos(ArrayList<Midicloriano> midiclorianos) {
        if (!pasosPorEstaciones.isEmpty()) {
            while (!midiclorianos.isEmpty()) {
                EstacionBase estacion = getEstacion(pasosPorEstaciones.remove(0));
                for (int i = 0; !midiclorianos.isEmpty() && i < 5; i++) {
                    Midicloriano mid = midiclorianos.remove(0);
                    estacion.insertarMidicloriano(mid);
                }
            }
        }
    }

    /**
     * Método que controla el movimiento de los personajes con el turno global
     *
     * @param turno indica el turno que se esta ejecutando
     * @pre Galaxia inicializada correctamente
     * @post Recorre todas las estaciones de la galaxia invocando al método
     * accion de cada una de ellas
     * @complex O(n^3)
     *
     */
    public void accion(int turno) {
        //Recorre todas las estaciones
        for (int i = 0; i < dimX; i++) {
            for (int j = 0; j < dimY; j++) {
                //Llama al accion de cada estacion
                Estaciones[i][j].accion(turno);
            }
        }

    }

    /**
     * Método que convierte un ID de la estación en coordenadas cartesianas
     *
     * @param ID ID que se desea convertir a coordenadas
     * @return Devuelve int[] de 2 posiciones donde: - int[0] = fila (eje x) -
     * int[1] = columnas (eje y)
     * @pre Galaxia inicializada con éxito
     * @post -
     * @complex O(1)
     */
    public int[] IDtoCoordenadas(int ID) {
        return new int[]{(ID / dimY), (ID % dimY)};
    }

    /**
     * Método que convierte unas coordenadas cartesianas en ID
     *
     * @param fila EJE Y coordenadas
     * @param columna EJE X coordenadas
     * @return Devuelve el ID correspondiente a las coordenadas según tamaño de
     * la Galaxia
     * @pre Galaxia inicializada con éxito
     * @post -
     * @complex O(1)
     */
    public int coordenadastoID(int fila, int columna) {
        return fila * dimY + columna;
    }

    /**
     * Devuelve la estación situada en el ID por parámetros
     *
     * @param ID ID de la estación que se desea devolver
     * @return EstacionBase de la galaxia con ID (parámetro entrada)
     * @pre Galaxia inicializada correctamente
     * @post Calcula las coordenadas según ID por parámetros y las devuelve en
     * un vector de 2 posiciones. Posicion 0: Coordenadas X Posicion 1 :
     * Coordenadas Y
     * @complex O(1)
     */
    public EstacionBase getEstacion(int ID) {
        int[] coordenadas = IDtoCoordenadas(ID);
        return Estaciones[coordenadas[0]][coordenadas[1]];
    }

    /**
     * Método que devuelve la estación situado en las coordenadas dadas.
     *
     * @param fila Fila de la estacion a devolver
     * @param columna Columna de la estacion a devolver
     * @return Devuelve la estación en las coordenadas dadas
     * @pre Galaxia inicializada correctamente
     * @post Devuelve la estacion localizada en la determinada fila y columna.
     * @complex O(1)
     */
    public EstacionBase getEstacion(int fila, int columna) {
        return Estaciones[fila][columna];
    }

    public void simular() {
        if (turno < 50 && !starsgate.cerradura.Abierta()) {
            accion(turno);
            toLog(turno);
            turno++;
        }
    }

    /**
     *
     * Devuelve informacion sobre todas las estaciones de la galaxia y
     * personajes que residen en cada una de las estaciones en forma de MINI
     * MAPA DEL GRAFO
     *
     * @return Devuelve String con informacion sobre la galaxia en
     * cuadriculas(estaciones) con forma de MAPA y los personajes exitentes
     * @pre Galaxia inicializada y cargada correctamente
     * @post Devuelve string con mapa de la galaxia
     * @complex O(n^2)
     */
    public String imprimirGalaxia() {
        String out = "";
        for (int i = 0; i < dimY; i++) {
            out += "----";
        }
        out += "--";
        out += "\n";
        for (int i = 0; i < dimX; i++) {
            out += "|";
            for (int j = 0; j < dimY; j++) {
                if (j == 0) {
                    if (grafo.adyacente((i * dimY) + j, (i * dimY) + j + 1)) {
                        out += " " + Estaciones[i][j].imprimirPersonajesMarca() + "  ";
                    } else {
                        out += " " + Estaciones[i][j].imprimirPersonajesMarca() + " |";
                    }

                } else if (j == dimY - 1) {
                    out += " " + Estaciones[i][j].imprimirPersonajesMarca() + "  ";
                } else if (grafo.adyacente((i * dimY) + j, (i * dimY) + j + 1)) {
                    out += " " + Estaciones[i][j].imprimirPersonajesMarca() + "  ";
                } else {
                    out += " " + Estaciones[i][j].imprimirPersonajesMarca() + " |";
                }
            }
            out += "|\n";
            for (int j = 0; j < dimY; j++) {
                if (grafo.adyacente((i * dimY) + j, ((i + 1) * dimY) + j)) {
                    out += "    ";
                } else {
                    out += "----";
                }
            }
            if (i != dimX - 1) {
                out += "\n";
            }

        }

        return out;
    }

    /**
     * Método que escribe en el Log información sobre la Galaxia
     *
     * @param turno Información sobre el turno que se desea escribir en el
     * @pre Galaxia inicializada con éxito
     * @post Se escribe en el log información sobre el turno, la estacion de la
     * puerta, llamada al toLog de cerradura de la puerta, información sobre el
     * mapa de la galaxia con imprimirGalaxia y llamda al log de todas las
     * estaciones que tengan midiclorianos.
     * @complex O(n^3)
     *
     */
    public void toLog(int turno) {

        Logger logger = Logger.obtenerInstancia();

        logger.escribeLog("(turno:" + turno + ")", 4);
        logger.escribeLog("(galaxia:" + this.getIdEstacionPuerta() + ")", 4);
        this.starsgate.cerradura.toLog();
        Logger.obtenerInstancia().escribeLog(this.imprimirGalaxia(), 4);
        for (int i = 0; i < dimX; i++) {
            for (int j = 0; j < dimY; j++) {
                EstacionBase estacion = Estaciones[i][j];
                if (!estacion.getMidiclorianos().isEmpty()) {
                    estacion.toLog();
                }
            }
        }
        for (int i = 0; i < personajes.size(); i++) {
            Personaje get = personajes.get(i);
            if (!get.isGanador()) {
                get.toLog();
            }
        }
        if (starsgate.cerradura.Abierta()) {
            String info = "(personajesganadores)";
            logger.escribeLog(info, 4);
            LibertyStation.toLogPersonajes();
        }
    }
}
