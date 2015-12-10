
import characters.Empire;
import characters.Jedi;
import characters.Way;
import estructura.Galaxy;
import estructura.Midiclorian;
import estructura.Starsgate;
import etc.Loader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * <p color="#01DF01">
 * Este codigo es parte del proyecto StarsWars - DP desarrollado en la
 * Universidad<br/>
 * de Extremadura en el curso 2015 - 2016 en la asignatura Desarrollo de
 * Programas
 * </p>
 * <br/>
 *
 * @since <p color="red">
 * by: Fernando G. & Pablo Macias<br/>
 * Revenge of the Sith™ 2015
 *
 * </p>
 * @author Fernando.G & Pablo Macias
 * @version 1.0 ALFA
 *
 */
public class Main {

    /**
     * Método main donde se inicializan los objetos y se simula el sistema
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
       
        //LLamada a la simulacion de la primera entrega EC1
        //simulacionEC1();
	
        //LLamada a la simulacion de la segunda entrega EC2
        //simulacionEC2();
        
        //Llamada a la simulacion de la tercera entrega EC3
        simulacionEC3();
    }
    
    //SIMULACION DE LA PRIMERA ENTREGA
    private static void simulacionEC1(){
         // CreaciÛn de la lista de identificadores impares
        // {1,3,5,7,9,11,13,15,17,19,21,23,25,27,29}

        int numMidis = 15;
        int deepCombination = 4;

        ArrayList<Midiclorian> midicloriansList = new ArrayList<Midiclorian>();
        int j = 1;
        for (int i = 0; i < numMidis; i++) {
            Midiclorian m = new Midiclorian(j);
            System.out.println(j + " - " + (midicloriansList.add(m) ? "insertado" : "error"));
            j += 2;
        }

		// CreaciÛn del tablero de la galaxia
        // Par·metros: estaciÛn de la puerta, n∫ columnas, n∫ filas y
        // profundidad de combinaciÛn secreta
        int dimX = 6;
        int dimY = 6;
        int gateStation = (dimX * dimY) - 1;

        Galaxy galaxy = new Galaxy(gateStation, dimX, dimY);

		// Algoritmo que reordena los identificadores para crear los
        // midiclorianos en el orden correcto
        System.out.println("SIN ORDENAR");

        for (Midiclorian midiclorian : midicloriansList) {
            System.out.println(midiclorian.getID());
        }

        midicloriansList = galaxy.generateCombination(midicloriansList);

        System.out.println("ORDENADOS");

        for (Midiclorian midiclorian : midicloriansList) {
            System.out.println(midiclorian.getID());
        }

		// Crear la puerta de la galaxia
        Starsgate starsgate = new Starsgate();
        System.out.println(starsgate);
        starsgate.configure(midicloriansList);
        starsgate.close();
        galaxy.setStarsGate(starsgate, deepCombination);

        Midiclorian mid;
        mid = new Midiclorian(1);
        starsgate.testMidiclorian(mid);
        mid = new Midiclorian(5);
        starsgate.testMidiclorian(mid);
        mid = new Midiclorian(9);
        starsgate.testMidiclorian(mid);
        mid = new Midiclorian(13);
        starsgate.testMidiclorian(mid);
        mid = new Midiclorian(17);
        starsgate.testMidiclorian(mid);
        mid = new Midiclorian(21);
        starsgate.testMidiclorian(mid);
        mid = new Midiclorian(25);
        starsgate.testMidiclorian(mid);
        mid = new Midiclorian(29);
        starsgate.testMidiclorian(mid);
        mid = new Midiclorian(3);
        starsgate.testMidiclorian(mid);

        System.out.println(galaxy.getInfoStations());
    }
    
    //SIMULACION DE LA SEGUNDA ENTREGA
    private static void simulacionEC2(){
        
        //Scanner para leer la tecla ENTER en cada turno
        Scanner waitForKeypress = new Scanner(System.in);
        
        //TODO:
        //    Crear galaxia
        //    Tablero
        //    Puerta y llaves
        //    Personajes
        //    Turnos
        //    Mover los personajes
        
        // Crea la galaxia y tablero
        int dimX = 6;
        int dimY = 6;
        int gateStation = (dimX * dimY) - 1;

        Galaxy galaxy = new Galaxy(gateStation, dimX, dimY);
        
        //Preparacion de la lista de midiclorianos a generar
        int numMidis = 15;
        int deepCombination = 4;

        ArrayList<Midiclorian> midicloriansList = new ArrayList<Midiclorian>();
        int j = 1;
        for (int i = 0; i < numMidis; i++) {
            Midiclorian m = new Midiclorian(j);
            System.out.println(j + " - " + (midicloriansList.add(m) ? "insertado" : "error"));
            j += 2;
        }
        
        midicloriansList = galaxy.generateCombination(midicloriansList);
        
        Starsgate starsgate = new Starsgate();
        starsgate.configure(midicloriansList);
        starsgate.close();
        galaxy.setStarsGate(starsgate, deepCombination);
        
        
        System.out.println(starsgate);
        System.out.println(midicloriansList.toString());
        
        ArrayList<Midiclorian> midisForVader = (ArrayList)midicloriansList.clone();
        
        galaxy.dispenseMidiclorians(midicloriansList, 5);
        
        //Crea los personajes
        Jedi skyWalker = new Jedi('J', "Anakin", galaxy.getStation(0, 0));
        
        LinkedList<Way> rutaAnakin = new LinkedList();
        
        rutaAnakin.add(Way.EAST);
        rutaAnakin.add(Way.EAST);
        rutaAnakin.add(Way.EAST);
        rutaAnakin.add(Way.EAST);
        rutaAnakin.add(Way.EAST);
        rutaAnakin.add(Way.WEST);
        rutaAnakin.add(Way.WEST);
        rutaAnakin.add(Way.WEST);
        rutaAnakin.add(Way.WEST);
        rutaAnakin.add(Way.WEST);
        rutaAnakin.add(Way.EAST);
        rutaAnakin.add(Way.EAST);
        rutaAnakin.add(Way.EAST);
        rutaAnakin.add(Way.EAST);
        rutaAnakin.add(Way.EAST);
        rutaAnakin.add(Way.WEST);
        rutaAnakin.add(Way.WEST);
        rutaAnakin.add(Way.WEST);
        rutaAnakin.add(Way.WEST);
        rutaAnakin.add(Way.WEST);
        rutaAnakin.add(Way.EAST);
        rutaAnakin.add(Way.EAST);
        rutaAnakin.add(Way.EAST);
        rutaAnakin.add(Way.EAST);
        rutaAnakin.add(Way.EAST);
        rutaAnakin.add(Way.SOUTH);
        rutaAnakin.add(Way.SOUTH);
        rutaAnakin.add(Way.SOUTH);
        rutaAnakin.add(Way.SOUTH);
        rutaAnakin.add(Way.SOUTH);

        //Seteamos la ruta al personaje
        skyWalker.setRoute(rutaAnakin);
        
        Empire vader = new Empire('V', "Vader", galaxy.getStation(5, 0));
        
        LinkedList<Way> rutaVader = new LinkedList();
        
        rutaVader.add(Way.EAST);
        rutaVader.add(Way.EAST);
        rutaVader.add(Way.EAST);
        rutaVader.add(Way.EAST);
        rutaVader.add(Way.EAST);
        rutaVader.add(Way.NORTH);
        rutaVader.add(Way.NORTH);
        rutaVader.add(Way.NORTH);
        rutaVader.add(Way.NORTH);
        rutaVader.add(Way.NORTH);
        rutaVader.add(Way.WEST);
        rutaVader.add(Way.WEST);
        rutaVader.add(Way.WEST);
        rutaVader.add(Way.WEST);
        rutaVader.add(Way.WEST);
        rutaVader.add(Way.SOUTH);
        rutaVader.add(Way.SOUTH);
        rutaVader.add(Way.SOUTH);
        rutaVader.add(Way.SOUTH);
        rutaVader.add(Way.SOUTH);

        //Seteamos la ruta al personaje
        vader.setRoute(rutaVader);
        
        System.out.println("MIDISFORVADER: " +midisForVader);
        vader.setMidiclorianos(midisForVader);
        
        vader.showmidiclorians();
        
        //Muestra el tablero
        System.out.println(galaxy.getInfoStations());
        
        for(int turn=0;turn<50;turn++){
            System.out.print("Presiona la tecla Enter para continuar");
            waitForKeypress.nextLine();
            
//            amidala.move(galaxy);
//            solo.move(galaxy);

            //ESPACIOS PARA MOSTRAR ENTRE TURNOS aqui debe ir informacion adicional
            // de turnos info de midiclorianos estado de puerta
            for(int i=0;i<50;i++){
                System.out.println("");
            }
            
            //Movemos el personaje
            skyWalker.action(galaxy);
            vader.action(galaxy);
            System.out.print("Vader lleva: ");
            vader.showmidiclorians();
            
            System.out.println("TURNO: " + (turn+1)+"º");
            // Muestra el estado de la puerta
            System.out.println(starsgate);
            //Muestra el tablero
            System.out.println(galaxy.getInfoStations());
        }
            
    }
    
    
    //SIMULACION DE LA TERCERA ENTREGA
    private static void simulacionEC3() throws IOException{
        
        //Cargador -> lee / carga / e inicializa los personajes y la galaxia
        Loader load = new Loader();
        
        //Lista de personajes
        ArrayList<Object> personajes = load.getPersonajes();
        
        //Galaxia
        Galaxy galaxy = load.getGalaxy();
        
//        
//        
//        //MUESTRA INFORMACION DE LOS PERSONAJES Y LA GALAXIA
//        for (Iterator<Object> iterator = personajes.iterator(); iterator.hasNext();) {
//            Object next = iterator.next();
//            System.out.println(next.toString());
//        }
        
        System.out.println(galaxy.getInfoStations());
    }
}
