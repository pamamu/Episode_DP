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
     * ID de la estacion con Puerta
     */
    private int idEstacionPuerta;
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

        @Override
        public String toString() {
            return "[" + origen + "," + destino + "]";
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
        this.idEstacionPuerta = idEstacionPuerta;

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
        pasosPorEstaciones = new ArrayList<>();

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

    /**
     * Método que devuelve el numero de filas de la Galaxia
     *
     * @return Devuelve número de filas de la Galaxia
     */
    public int getDimX() {
        return dimX;
    }

    /**
     * Método que devuelve el número de columnas de la Galaxia
     *
     * @return Devuelve el número de columnas de la galaxia
     */
    public int getDimY() {
        return dimY;
    }

    /**
     * Método que devuelve el grafo de conexiones
     *
     * @return Devuelve el grafo
     */
    public Grafo getGrafo() {
        return grafo;
    }

    /**
     * Método que devuelve el ID de la estacion conpuerta
     *
     * @return Devuelve ID de Starsgate
     */
    public int getIdEstacionPuerta() {
        return idEstacionPuerta;
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
//                grafo.nuevoArco(estacion, destino, 1);
            }
            //ESTACIÓN ESTE
            if ((estacion % dimY != dimY - 1)) {
                destino = estacion + 1;
                paredes.add(new Pared(estacion, destino));
//                grafo.nuevoArco(estacion, destino, 1);
            }
            //ESTACIÓN SUR
            if ((estacion / dimY) < dimY - 1) {
                destino = estacion + dimY;
                paredes.add(new Pared(estacion, destino));
//                grafo.nuevoArco(estacion, destino, 1);
            }
            //ESTACIÓN OESTE
            if ((estacion % dimY) != 0) {
                destino = estacion - 1;
                paredes.add(new Pared(estacion, destino));
//                grafo.nuevoArco(estacion, destino, 1);
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
    }
    
    public ArrayList<Midicloriano> generarMidiclorianos(){
        ArrayList<Midicloriano> midiclorianos = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            midiclorianos.add(new Midicloriano(i));
        }
        return midiclorianos;
    }
    
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
     * Método que controla el movimiento de los personajes con el turno
     * global
     *
     * @param turno indica el turno que se esta ejecutando
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
        
        System.out.println("Combinacion inicio "+
                ((EstacionPuerta)this.getEstacion(this.getIdEstacionPuerta()))
                        .cerradura.combinacionInicio.toString());
        
        System.out.println("Midis Iniciales "+
                ((EstacionPuerta)this.getEstacion(this.getIdEstacionPuerta()))
                        .cerradura.midiclorianosIniciales.toString());
        
        System.out.println("Midis  Probados"+
                ((EstacionPuerta)this.getEstacion(this.getIdEstacionPuerta()))
                        .cerradura.midiclorianosProbados.toString());
        
        System.out.println("Cerradura info"+
                ((EstacionPuerta)this.getEstacion(this.getIdEstacionPuerta()))
                        .cerradura.informacionCerradura());
        
        Logger.obtenerInstancia().escribeLog("Turno: "+turno, 4);
        Logger.obtenerInstancia().escribeLog("Galaxia: "+this.getIdEstacionPuerta(), 4);
        Logger.obtenerInstancia().escribeLog(
                        "Puerta: "+this.starsgate.cerradura.informacionCerradura(), 4);
        
        Logger.obtenerInstancia().escribeLog(this.imprimirLaberinto2(), 4);
        
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
     */
    public EstacionBase getEstacion(int fila, int columna) {
        return Estaciones[fila][columna];
    }

    /**
     * Devuelve informacion sobre todas las estaciones de la galaxia
     *
     * @return Devuelve String con informacion sobre la galaxia en
     * cuadriculas(estaciones)
     * @pre Galaxia inicializada y cargada correctamente
     * @post Devuelve string con mapa de la galaxia indicando tipos e ID.
     * @complex O(n^2)
     */
    public String imprimir() {
        String output = "";

        for (int j = 0; j < Estaciones[0].length; j++) {
            output += " _______________";
        }
        output += "\n";
        for (int i = 0; i < Estaciones.length; i++) {
            // Linea del id de celda
            output += "|";
            for (int e = 0; e < Estaciones[i].length; e++) {
                output += Estaciones[i][e].getID() + "\t\t";
                if (e == Estaciones[i].length - 1) {
                    output += "|";
                } else if (grafo.adyacente((i * dimY) + e, (i * dimY) + e + 1)) {
                    output += " ";
                } else {
                    output += "|";
                }
            }
            output += "\n";
            // Linea del id de celda
            output += "|";
            for (int e = 0; e < Estaciones[i].length; e++) {
                if(Estaciones[i][e].esPuerta())
                    output += "Tatooine\t";
                else
                    output += "\t\t";
                if (e == Estaciones[i].length - 1) {
                    output += "|";
                } else if (grafo.adyacente((i * dimY) + e, (i * dimY) + e + 1)) {
                    output += " ";
                } else {
                    output += "|";
                }
            }
//            output += "\n";
//            // Linea del id de celda
//            output += "|";
            // Linea de espacio | y si tiene puerta
//            for (int e = 0; e < Estaciones[i].length; e++) {
//                if (Estaciones[i][e].getType().equals("GateStation")) {
//                    output += "" + "STARGATE" + "\t";
//                } else {
//                    output += "\t\t";
//                }
//                if (e == Estaciones[i].length - 1) {
//                    output += "|";
//                } else if (grafo.adyacente((i * dimY) + e, (i * dimY) + e + 1)) {
//                    output += " ";
//                } else {
//                    output += "|";
//                }
//            }
            output += "\n";
            // Linea del id de celda
            output += "|";
            for (int e = 0; e < Estaciones[i].length; e++) {
                output += Estaciones[i][e].imprimirPersonajes() + "\t";
                if (e == Estaciones[i].length - 1) {
                    output += "|";
                } else if (grafo.adyacente((i * dimY) + e, (i * dimY) + e + 1)) {
                    output += " ";
                } else {
                    output += "|";
                }
            }
            output += "\n";
            // Linea del id de celda
            output += "|";
            for (int e = 0; e < Estaciones[i].length; e++) {
                if (!Estaciones[i][e].imprimirMidiclorianos().equals("\t")) {
                    output += "*\t\t";
                } else {
                    output += "\t\t";
                }
                if (e == Estaciones[i].length - 1) {
                    output += "|";
                } else if (grafo.adyacente((i * dimY) + e, (i * dimY) + e + 1)) {
                    output += " ";
                } else {
                    output += "|";
                }
            }
            output += "\n";
            output += "|";
            for (int j = 0; j < Estaciones[i].length; j++) {
                if (i == Estaciones[i].length - 1) {
                    output += "________________";
                } else if (grafo.adyacente((i * dimY) + j, ((i + 1) * dimY) + j)) {
                    output += "                ";
                } else {
                    output += "________________";
                }
            }
            output += "\n";
        }

        return output;
    }

    /**
     * Devuelve informacion sobre todas las estaciones de la galaxia y los
     * personajes que residen en cada estacion en forma mini
     *
     * @return Devuelve String con informacion sobre la galaxia en
     *  cuadriculas(estaciones) y los personajes existentes en ellas
     * @pre  Galaxia inicializada y cargada correctamente
     * @post Devuelve string con el TABLERO de la galaxia y los personajes
     * @complex O(n^2)
     */
    public String imprimirMini() {
        String salida = "TABLERO GALAXIA MINI\n";

        for (int i = 0; i < Estaciones.length; i++) {
            for (int j = 0; j < Estaciones[i].length; j++) {
                salida += "---";
            }

            salida += "\n";
            salida += "|";

            for (int j = 0; j < Estaciones[i].length; j++) {
                salida += Estaciones[i][j].imprimirPersonajesMini();
                salida += "|";
            }

            salida += "\n";
        }

        for (int j = 0; j < getDimY(); j++) {
            salida += "---";
        }

        return salida;
    }

    public String imprimirLaberinto() {
        String out = "";
        for (int i = 0; i < dimY - 1; i++) {
            out += "----";
        }
        out += "\n";
        for (int i = 0; i < dimX; i++) {
            out += "|";
            for (int j = 0; j < dimY; j++) {
                if (j == 0) {
                    if (grafo.adyacente((i * dimY) + j, (i * dimY) + j + 1)) {
                        out += "    ";
                    } else {
                        out += "   |";
                    }

                } else if (j == dimY - 1) {
                    out += "   ";
                } else if (grafo.adyacente((i * dimY) + j, (i * dimY) + j + 1)) {
                    out += "    ";
                } else {
                    out += "   |";
                }
            }
            out += "|\n";
            //System.out.print(out);
            //out = "";
            for (int j = 0; j < dimY; j++) {
                if (grafo.adyacente((i * dimY) + j, ((i + 1) * dimY) + j)) {
                    out += "    ";
                } else {
                    out += "----";
                }
            }
            out += "\n";
            //System.out.print(out);
            //out = "";

        }

        return out;
    }

    /**
     * VARIACION DEL ANTERIOR POR INCOMPATIBILIDAD AL MOSTRARSE
     * 
     * Devuelve informacion sobre todas las estaciones de la galaxia y personajes
     * que residen en cada una de las estaciones en forma de MINI MAPA DEL GRAFO
     *
     * @return Devuelve String con informacion sobre la galaxia en
     * cuadriculas(estaciones) con forma de MAPA y los personajes exitentes
     * @pre Galaxia inicializada y cargada correctamente
     * @post Devuelve string con mapa de la galaxia
     * @complex O(n^2)
     */
    public String imprimirLaberinto2() {
        String out = "\n";
        for (int i = 0; i < dimY; i++) {
            out += "----";
        }
        out += "\n";
        for (int i = 0; i < dimX; i++) {
            out += "|";
            for (int j = 0; j < dimY; j++) {
                if (j == 0) {
                    if (grafo.adyacente((i * dimY) + j, (i * dimY) + j + 1)) {
                        //out += "  a  ";
                        out += " "+Estaciones[i][j].imprimirPersonajesMarca()+"  ";
                    } else {
                        out += " "+Estaciones[i][j].imprimirPersonajesMarca()+" |";
                    }

                } else if (j == dimY - 1) {
                    //out += "  b  ";
                    out += " "+Estaciones[i][j].imprimirPersonajesMarca()+"  ";
                } else if (grafo.adyacente((i * dimY) + j, (i * dimY) + j + 1)) {
                    //out += "  c  ";
                    out += " "+Estaciones[i][j].imprimirPersonajesMarca()+"  ";
                } else {
                    //out += "  g |";
                    out += " "+Estaciones[i][j].imprimirPersonajesMarca()+" |";
                }
            }
            out += "|\n";
            //System.out.print(out);
            //out = "";
            for (int j = 0; j < dimY; j++) {
                if (grafo.adyacente((i * dimY) + j, ((i + 1) * dimY) + j)) {
                    out += "    ";
                } else {
                    out += "----";
                }
            }
            out += "\n";
            //System.out.print(out);
            //out = "";

        }

        return out;
    }

}
