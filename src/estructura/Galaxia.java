/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura;

import edd.Grafo;
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
    private int dimX;
    /**
     * Número de columnas de la galaxia
     */
    private int dimY;
    /**
     * Starsgate o puerta de salida de la galaxia
     */
    private EstacionPuerta starsgate;
    /**
     * Estación con los personajes que han salido
     */
    private EstacionBase LibertyStation;
    /**
     * Estaciones que forman una galaxia
     */
    private EstacionBase[][] Estaciones;
    /**
     * Estructura de datos que almacena las conexiones entre las galaxias
     */
    private Grafo grafo;
    /**
     * Estructura de datos que almacena las paredes
     */
    private ArrayList<Pared> paredes;

    /**
     * Clase donde se especifica e implementa el objeto Pared Usado en la
     * creación del laberinto de la Galaxia.
     */
    private class Pared {

        /**
         * Entero que indica la estación de origen de la puerta
         */
        private int origen;
        /**
         * Entero que indica la estación de destino de la puerta
         */
        private int destino;

        /**
         * Constructor parametrizado de la clase Pared
         *
         * @param origen ID de la estacion de origen de la puerta
         * @param destino ID de la estación de destino de la puerta
         */
        public Pared(int origen, int destino) {
            this.origen = origen;
            this.destino = destino;

        }

        /**
         * Método que devuelve el ID de la estación de origen de la puerta
         *
         * @return ID de origen de la puerta.
         */
        public int getOrigen() {
            return origen;
        }

        /**
         * Método que devuelve el ID de la estación de destino de la puerta
         *
         * @return ID de destino de la puerta
         */
        public int getDestino() {
            return destino;
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
     */
    private Galaxia(int idEstacionPuerta, EstacionPuerta starsgate, int dimX, int dimY) {

        this.dimX = dimX;
        this.dimY = dimY;

        this.starsgate = starsgate;
        this.Estaciones = new EstacionBase[dimX][dimY];
        this.LibertyStation = new EstacionBase(1111);

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
     */
    public static Galaxia obtenerInstancia() {
        return instancia;
    }

// PRIVADOS ################################################################
    /**
     * Método para construir una Galaxia inicial.
     *
     * @pre Galaxia inicializada con éxito
     * @post Se crean todos los nodos (ID de estaciones) y se llama a
     * construirParedesIni()
     * @complex O(n)
     */
    private void construirGalaxia() {
        //CREACION DE NODOS
        for (int i = 0; i < dimX * dimY; i++) {
            grafo.nuevoNodo(i);
        }
        //CREACION DE PAREDES
        construirParedesIni();
    }

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
                grafo.nuevoArco(estacion, destino, 1);
            }
            //ESTACIÓN ESTE
            if ((estacion % dimY != dimY - 1)) {
                destino = estacion + 1;
                paredes.add(new Pared(estacion, destino));
                grafo.nuevoArco(estacion, destino, 1);
            }
            //ESTACIÓN SUR
            if ((estacion / dimY) < dimY - 1) {
                destino = estacion + dimY;
                paredes.add(new Pared(estacion, destino));
                grafo.nuevoArco(estacion, destino, 1);
            }
            //ESTACIÓN OESTE
            if ((estacion % dimY) != 0) {
                destino = estacion - 1;
                paredes.add(new Pared(estacion, destino));
                grafo.nuevoArco(estacion, destino, 1);
            }
        }
    }
// PÚBLICOS #################################################################

    /**
     * Método que convierte un ID de la estación en coordenadas cartesianas
     *
     * @param ID ID que se desea convertir a coordenadas
     * @return Devuelve int[] de 2 posiciones donde: - int[0] = fila (eje x) -
     * int[1] = columnas (eje y)
     */
    public int[] IDtoCoordinates(int ID) {
        return new int[]{(ID / dimY), (ID % dimY)};
    }

    /**
     * Devuelve la estación situada en el ID por parámetros
     *
     * @param ID ID de la estación que se desea devolver
     * @return EstacionBase de la galaxia con ID (parámetro entrada)
     */
    public EstacionBase getEstacion(int ID) {
        int[] coordenadas = IDtoCoordinates(ID);
        return Estaciones[coordenadas[0]][coordenadas[1]];
    }

    /**
     * Método que devuelve la estación situado en las coordenadas dadas.
     *
     * @param fila Fila de la estacion a devolver
     * @param columna Columna de la estacion a devolver
     * @return Devuelve la estación en las coordenadas dadas
     */
    public EstacionBase getEstacion(int fila, int columna) {
        return Estaciones[fila][columna];
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
    public String imprimir() {
        String output = "";

        for (int i = 0; i < Estaciones.length; i++) {
            for (int j = 0; j < Estaciones[i].length; j++) {
                output += " _______________";
            }
            output += "\n";
            // Linea del id de celda
            for (int e = 0; e < Estaciones[i].length; e++) {
                output += "|" + Estaciones[i][e].getID() + "\t\t|";
            }
            output += "\n";
            // Linea del tipo
            for (int e = 0; e < Estaciones[i].length; e++) {
                output += "|" + Estaciones[i][e].getType() + "\t|";
            }
            output += "\n";
            // Linea de espacio | y si tiene puerta
            for (int e = 0; e < Estaciones[i].length; e++) {
                if (Estaciones[i][e].getType().equals("GateStation")) {
                    output += "|" + "STARGATE" + "\t|";
                } else {
                    output += "|\t\t|";
                }
            }
            output += "\n";
            // Linea de Personajes
            for (int e = 0; e < Estaciones[i].length; e++) {
                output += "|" + Estaciones[i][e].imprimirPersonajes() + "\t|";
            }
            output += "\n";
            // Linea de midiclorianos
            for (int e = 0; e < Estaciones[i].length; e++) {
                output += "|";
                if (!Estaciones[i][e].imprimirMidiclorianos().equals("\t")) {
                    output += "*\t\t|";
                } else {
                    output += "\t\t|";
                }
            }
            output += "\n";
            for (int j = 0; j < Estaciones[i].length; j++) {
                output += "| ______________";
            }
            output += "\n";
        }

        return output;
    }
}
