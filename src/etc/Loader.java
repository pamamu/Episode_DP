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
import java.io.IOException;
import java.util.ArrayList;
import personajes.Contrabandista;
import personajes.FamiliaReal;
import personajes.Imperial;
import personajes.Jedi;

/**
 * <p color="#ffdd00">
 *      -= STAR WARS DP DOCUMENTATION=-<br/>
 *      <br/>
 *      Este codigo es parte del proyecto StarsWars - DP desarrollado en la
 *      Universidad de Extremadura curso 2015 - 2016 | asignatura Desarrollo de
 *      Programas
 * </p>
 * <br/>
 *
 *  Clase Loader<br/>
 *  Se encarga de cargar los datos e inicializar las estructuras principales
 *  galaxia y personajes
 *
 *  @since
 *      <p color="red">
 *          by: Fernando G. & Pablo Macias<br/>
 *          The force Awakens™ 2015
 *      </p>
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
    public Loader() throws IOException{
        
        Logger.obtenerInstancia().escribelog(
                "Preparando estructuras de datos principales");
        
        //Leer fichero de configuracion
        lector = new Reader();
        //Prepara la lista de personajes
        personajes = new ArrayList<>();
        
        //IMPORTANTE PRIMERO INICIALIZAR LA GALAXIA Y DESPUES LOS PERSONAJES 
        // YA QUE ESTOS DEPENDEN DE LA GALAXIA POR EL PARAMETRO ESTACION DE 
        // ORIGEN
        
        Logger.obtenerInstancia().escribelog("Cargando datos de galaxia");
        //Llamada para obtener los datos de la galaxia
        loadDataGalaxy();
        Logger.obtenerInstancia().escribelog("Cargando datos de personajes");
        //Llamada a rellenar la lista de personajes
        loadDataCharacters();
        
    }
    
    // GETTER & SETTER #########################################################
    /**
     * Devuelve la lista de personajes
     * 
     * Puede usarse para obtener datos de las instancias
     * 
     * @return Lista de Object (Son objetos de tipo Personaje, van meclados)
     */
    public ArrayList<Object> getPersonajes(){
        return personajes;
    }
    
    // PRIVADOS ################################################################
    /**
     * Carga los datos de la galaxia con la informacion proporcionada por el
     * fichero de configuración
     * 
     */
    private void loadDataGalaxy(){
        
        Logger.obtenerInstancia().escribelog("Creando galaxia");
        
        //Estructura de almacenamiento de datos de inicio
        String[] dataGalaxy = lector.getDatosGalaxia();
        
        Cerradura cerradura = new Cerradura(Integer.parseInt(dataGalaxy[4]));
        
        EstacionPuerta puerta = new EstacionPuerta(
                Integer.parseInt(dataGalaxy[3]), cerradura);
        
        //Crea la galaxia respecto a las especificaciones del archivo de datos
        Galaxia.obtenerInstancia(Integer.parseInt(dataGalaxy[3]), //Num Puerta
                                 puerta,  
                                 Integer.parseInt(dataGalaxy[2]), //Ancho
                                 Integer.parseInt(dataGalaxy[1]));//Alto
        
        Galaxia.obtenerInstancia().construirGalaxia();
        Galaxia.obtenerInstancia().generarLaberinto();
        
        Logger.obtenerInstancia().escribelog("STAR WARS GALAXY \n"
                + "\tAnchura: " + dataGalaxy[2]
                + "\n\tAltura: " + dataGalaxy[1]
                + "\n\tDimension: "
                + (Integer.parseInt(dataGalaxy[2]) *
                   Integer.parseInt(dataGalaxy[1]))
                +" Estaciones planetarias\n"
                + "\tEstacion de salida Tatooine en la posicion "
                + dataGalaxy[3]);
        
        Logger.obtenerInstancia().escribelog("Creada con exito");
        
    }
    /**
     * Carga los datos de los personajes que hay en el fichero de configuracion
     * 
     */
    private void loadDataCharacters(){
        
        String[][] datosPersonaje;
        
        Logger.obtenerInstancia().escribelog("Creando personajes");
        
        //Crea los Jedis
        datosPersonaje = lector.getJedis();
        Jedi jedi;
        for (int i = 0; i < datosPersonaje.length; i++) {
            jedi = new Jedi(datosPersonaje[i][2].charAt(0), datosPersonaje[i][1], 
                    0, Integer.parseInt(datosPersonaje[i][3]));
            
            Logger.obtenerInstancia().escribelog("Personaje tipo "
                    + datosPersonaje[i][0] + "\n"
                    + "\tNombre " + datosPersonaje[i][1]
                    + "\n\tMarca " + datosPersonaje[i][2]
                    + "\n\tTurno de accion " + datosPersonaje[i][3]);
            
            Logger.obtenerInstancia().escribelog("Creado con exito");
            
            personajes.add(jedi);
        }
        
        //Crea los Contrabandistas
        datosPersonaje = lector.getContrabandistas();
        Contrabandista contrabandista;
        for (int i = 0; i < datosPersonaje.length; i++) {
            contrabandista = new Contrabandista(datosPersonaje[i][2].charAt(0), 
                    datosPersonaje[i][1], 
                    Galaxia.obtenerInstancia().getEstacion(
                        Galaxia.obtenerInstancia().getAltura()-1, 0).getID(),
                        Integer.parseInt(datosPersonaje[i][3]));
            
            Logger.obtenerInstancia().escribelog("Personaje tipo " 
                    + datosPersonaje[i][0] + "\n"
                    + "\tNombre " + datosPersonaje[i][1] 
                    + "\n\tMarca " + datosPersonaje[i][2] 
                    + "\n\tTurno de accion " + datosPersonaje[i][3]);
            
            Logger.obtenerInstancia().escribelog("Creado con exito");
            
            personajes.add(contrabandista);
        }
        
        //Crea los Familia Real
        datosPersonaje = lector.getReales();
        FamiliaReal real;
        for (int i = 0; i < datosPersonaje.length; i++) {
            real = new FamiliaReal(datosPersonaje[i][2].charAt(0), 
                    datosPersonaje[i][1], 0, 
                    Integer.parseInt(datosPersonaje[i][3]));
            
            Logger.obtenerInstancia().escribelog("Personaje tipo " 
                    + datosPersonaje[i][0] + "\n"
                    + "\tNombre " + datosPersonaje[i][1] 
                    + "\n\tMarca " + datosPersonaje[i][2] 
                    + "\n\tTurno de accion " + datosPersonaje[i][3]);
            
            Logger.obtenerInstancia().escribelog("Creado con exito");
            
            personajes.add(real);
        }
        
        //Crea los Imperiales
        datosPersonaje = lector.getImperiales();
        Imperial imperial;
        for (int i = 0; i < datosPersonaje.length; i++) {
            imperial = new Imperial(datosPersonaje[i][2].charAt(0), 
                    datosPersonaje[i][1], 
                    Galaxia.obtenerInstancia().getDimension()-1, 
                    Integer.parseInt(datosPersonaje[i][3]));
            
            Logger.obtenerInstancia().escribelog("Personaje tipo "
                    + datosPersonaje[i][0] + "\n"
                    + "\tNombre " + datosPersonaje[i][1] 
                    + "\n\tMarca " + datosPersonaje[i][2]
                    + "\n\tTurno de accion " + datosPersonaje[i][3]);
            
            Logger.obtenerInstancia().escribelog("Creado con exito");
            
            personajes.add(imperial);
        }
    }
    
    // PUBLICOS ################################################################
    
}
