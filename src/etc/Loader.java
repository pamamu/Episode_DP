/*
 * Este codigo es parte del proyecto STAR WARS - DP desarrollado en la
 * Universidad de Extremadura curso 2015 - 2016 | 
 * Asignatura Desarrollo de Programas
 * 
 * @author Fernando.G & Pablo Macias
 * @version 1.0 ALFA The force Awakens™ 2015
 */
package etc;

import estructura.Cerradura;
import estructura.EstacionPuerta;
import estructura.Galaxia;
import estructura.Midicloriano;
import java.io.IOException;
import java.util.ArrayList;
import personajes.Contrabandista;
import personajes.FamiliaReal;
import personajes.Imperial;
import personajes.Jedi;

/**
 * <p color="#ffdd00">
 * -= STAR WARS DP DOCUMENTATION=-<br/>
 * <br/>
 * Este codigo es parte del proyecto StarsWars - DP desarrollado en la
 * Universidad de Extremadura curso 2015 - 2016 | asignatura Desarrollo de
 * Programas
 * </p>
 * <br/>
 *
 * Clase Loader<br/>
 * Se encarga de cargar los datos e inicializar las estructuras principales
 * galaxia y personajes
 *
 * @since
 * <p color="red">
 * by: Fernando G. & Pablo Macias<br/>
 * The force Awakens™ 2015
 * </p>
 * @author Fernando.G & Pablo Macias
 * @version 1.0 ALFA
 *
 */
public class Loader {

    // ATRIBUTOS ###############################################################
    /**
     * El lector o reader es un objeto que se encarga de obtener los datos o
     * leer de un fichero de configuracion inicial
     */
    private Reader lector;

    /**
     * Lista de personajes que se leen del fichero
     */
    private ArrayList<Object> personajes;   //Lista de personajes

    // CONSTRUCTORES ###########################################################
    /**
     * El contructor principal del loader se encarga de todo el proceso de
     * inicializado de los objetos y estructuras
     *
     * @throws IOException
     */
    public Loader() throws IOException {

        //Leer fichero de configuracion
        lector = new Reader();
        //Prepara la lista de personajes
        personajes = new ArrayList<>();

        //IMPORTANTE PRIMERO INICIALIZAR LA GALAXIA Y DESPUES LOS PERSONAJES 
        // YA QUE ESTOS DEPENDEN DE LA GALAXIA POR EL PARAMETRO ESTACION DE 
        // ORIGEN
        //Llamada para obtener los datos de la galaxia
        loadDataGalaxy();
        //Llamada a rellenar la lista de personajes
        loadDataCharacters();
        //Llamada para repartir los midiclorianos una vez ya se conocen los caminos
        Galaxia.obtenerInstancia().repartirMidiclorianos(
                Galaxia.obtenerInstancia().generarMidiclorianosGalaxia());

    }

    // GETTER & SETTER #########################################################
    /**
     * Devuelve la lista de personajes
     *
     * Puede usarse para obtener datos de las instancias
     *
     * @return Lista de Object (Son objetos de tipo Personaje, van meclados)
     */
    public ArrayList<Object> getPersonajes() {
        return personajes;
    }

    // PRIVADOS ################################################################
    /**
     * Carga los datos de la galaxia con la informacion proporcionada por el
     * fichero de configuración
     *
     */
    private void loadDataGalaxy() {

        //Estructura de almacenamiento de datos de inicio
        String[] dataGalaxy = lector.getDatosGalaxia();

        Cerradura cerradura = new Cerradura(Integer.parseInt(dataGalaxy[4]));
        // Creación de la lista de identificadores impares
        // {1,3,5,7,9,11,13,15,17,19,21,23,25,27,29}

        int numMidis = 15;
        int deepCombination = 4;

        ArrayList<Midicloriano> combinacion = new ArrayList<>();
        int j = 1;
        for (int i = 0; i < numMidis; i++) {
            Midicloriano m = new Midicloriano(j);
            combinacion.add(m);
            j += 2;
        }

        cerradura.setCombinacionInicial(combinacion);
        cerradura.generarCombinacion();

        cerradura.setEstado(false);

        EstacionPuerta puerta = new EstacionPuerta(
                Integer.parseInt(dataGalaxy[3]), cerradura);

        //Crea la galaxia respecto a las especificaciones del archivo de datos
        Galaxia galaxia;
        galaxia = Galaxia.obtenerInstancia(Integer.parseInt(dataGalaxy[3]), //Num Puerta
                puerta,
                Integer.parseInt(dataGalaxy[2]), //Ancho
                Integer.parseInt(dataGalaxy[1]));//Alto

        galaxia.construirGalaxia();
        galaxia.generarLaberinto();
        galaxia.getGrafo().floyd();
        galaxia.getGrafo().warshall();

        Logger.obtenerInstancia().escribeLog(
                Galaxia.obtenerInstancia().imprimirLaberinto2(), 4);

    }

    /**
     * Carga los datos de los personajes que hay en el fichero de configuracion
     *
     */
    private void loadDataCharacters() {

        String[][] datosPersonaje;
        Galaxia galaxia = Galaxia.obtenerInstancia();
        Logger logger = Logger.obtenerInstancia();
        String msg;

        //Crea los Jedis
        datosPersonaje = lector.getJedis();
        Jedi jedi;
        for (int i = 0; i < datosPersonaje.length; i++) {
            jedi = new Jedi(datosPersonaje[i][2].charAt(0), datosPersonaje[i][1],
                    0, Integer.parseInt(datosPersonaje[i][3]));

            jedi.generarCamino();
            jedi.toLogini();

            personajes.add(jedi);
        }

        //Crea los Contrabandistas
        datosPersonaje = lector.getContrabandistas();
        Contrabandista contrabandista;
        for (int i = 0; i < datosPersonaje.length; i++) {
            contrabandista = new Contrabandista(datosPersonaje[i][2].charAt(0),
                    datosPersonaje[i][1],
                    galaxia.getEstacion(
                            (galaxia.getDimX() - 1), 0).getID(),
                    Integer.parseInt(datosPersonaje[i][3]));

            contrabandista.generarCamino();
            contrabandista.toLogini();
            personajes.add(contrabandista);
        }

        //Crea los Familia Real
        datosPersonaje = lector.getReales();
        FamiliaReal real;
        for (int i = 0; i < datosPersonaje.length; i++) {
            real = new FamiliaReal(datosPersonaje[i][2].charAt(0),
                    datosPersonaje[i][1], 0,
                    Integer.parseInt(datosPersonaje[i][3]));

            real.generarCamino();
            real.toLogini();
            personajes.add(real);
        }

        //Crea los Imperiales
        datosPersonaje = lector.getImperiales();
        Imperial imperial;
        for (int i = 0; i < datosPersonaje.length; i++) {
            imperial = new Imperial(datosPersonaje[i][2].charAt(0),
                    datosPersonaje[i][1],
                    galaxia.getIdEstacionPuerta(),
                    Integer.parseInt(datosPersonaje[i][3]));

            imperial.generarCamino();
            imperial.toLogini();

            imperial.setMidiclorianos(galaxia.generarMidiclorianos());

            personajes.add(imperial);
        }
        
    }

    // PUBLICOS ################################################################
}
