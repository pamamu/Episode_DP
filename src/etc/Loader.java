/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etc;

import characters.Contrabandist;
import characters.Empire;
import characters.Jedi;
import characters.RoyalFamily;
import estructura.Galaxy;
import java.io.IOException;
import java.util.ArrayList;

/**
 *  Clase Loader
 * 
 *  Se encarga de cargar los datos e inicializar las estructuras principales
 *  galaxia y personajes
 * 
 * @author fernandogonzalez
 */
public class Loader {
 
    private Galaxy galaxy;      //Galaxia o tablero global
    private Reader reader;      //Lector objeto necesario para leer el fichero de configuracion
    private ArrayList<Object> personajes;   //Lista de personajes
    
    //Constructor se encarga de todo el proceso de inicializacion y creacion de los objetos
    public Loader() throws IOException{
        
        //Leer fichero de configuracion
        reader = new Reader();
        //Preparar lista de personajes
        personajes = new ArrayList<>();
        
        //IMPORTANTE PRIMERO INICIALIZAR LA GALAXIA Y DESPUES LOS PERSONAJES 
        // YA QUE ESTOS DEPENDEN DE LA GALAXIA POR EL PARAMETRO ORIGINSTATION
        
        //Llamada para obtener los datos de la galaxia
        loadDataGalaxy();
        //Llamada a rellenar la lista de personajes
        loadDataCharacters();
        
    }
    
    //Carga los datos de la galaxia con la informacion del fichero de configuracion
    private void loadDataGalaxy(){
        //Estructura de almacenamiento de datos de inicio
        String[] dataGalaxy = reader.getGalaxyInfo();
        
        //Crea la galaxia respecto a las especificaciones del archivo de datos
        galaxy = new Galaxy(Integer.parseInt(dataGalaxy[3]), //Num Puerta
                                   Integer.parseInt(dataGalaxy[2]), //Ancho
                                   Integer.parseInt(dataGalaxy[1]));//Alto
    }
    
    //Carga los datos de los personajes que hay en el fichero de configuracion
    private void loadDataCharacters(){
        
        String[][] dataCharacters;
        
        //Crea los Jedis
        dataCharacters = reader.getJedis();
        Jedi jedi;
        for (int i = 0; i < dataCharacters.length; i++) {
            jedi = new Jedi(dataCharacters[i][2].charAt(0), dataCharacters[i][1], 
                    galaxy.getStation(0));
            personajes.add(jedi);
        }
        
        //Crea los Contrabandistas
        dataCharacters = reader.getContrabandists();
        Contrabandist contrabandist;
        for (int i = 0; i < dataCharacters.length; i++) {
            contrabandist = new Contrabandist(dataCharacters[i][2].charAt(0), dataCharacters[i][1], 
                    galaxy.getStation(galaxy.getHeight() - 1, 0));
            personajes.add(contrabandist);
        }
        
        //Crea los Familia Real
        dataCharacters = reader.getRoyal();
        RoyalFamily royalFamily;
        for (int i = 0; i < dataCharacters.length; i++) {
            royalFamily = new RoyalFamily(dataCharacters[i][2].charAt(0), dataCharacters[i][1], 
                    galaxy.getStation(0));
            personajes.add(royalFamily);
        }
        
        //Crea los Imperiales
        dataCharacters = reader.getEmpire();
        Empire empire;
        for (int i = 0; i < dataCharacters.length; i++) {
            empire = new Empire(dataCharacters[i][2].charAt(0), dataCharacters[i][1], 
                    galaxy.getStation(galaxy.getStationGateId()));
            personajes.add(empire);
        }
    }
    
    //Retorna la lista de personajes (CUIDADO VAN MEZCLADOS y ES UNA LISTA DE OBJECT!!)
    public ArrayList<Object> getPersonajes(){
        return personajes;
    }
    
    //Retorna la galaxia
    public Galaxy getGalaxy(){
        return galaxy;
    }
}
