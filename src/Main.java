
import estructura.Galaxia;
import etc.Camino;
import etc.Loader;
import etc.Logger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import personajes.Contrabandista;
import personajes.FamiliaReal;
import personajes.Imperial;
import personajes.Jedi;
import personajes.Personaje;

/**
 * Main pruebas de funcionalidad sobre el proyecto
 * 
 */
public class Main {
    
    /**
     * Modulo que ejecuta la simulacion de la EC3
     * 
     * @throws IOException 
     */
    public static void EC3() throws IOException{
        
        Loader cargador = new Loader();
                
        ArrayList<Object> personajes = cargador.getPersonajes();
        
        Jedi jedi;
        Contrabandista contra;
        FamiliaReal real;
        Imperial imperial;
        
        LinkedList<Camino> rutaJedi = new LinkedList<>();
        LinkedList<Camino> rutaContra = new LinkedList<>();
        LinkedList<Camino> rutaReal = new LinkedList<>();
        LinkedList<Camino> rutaDelMal = new LinkedList<>();
        
        rutaJedi.add(Camino.ESTE);
        rutaJedi.add(Camino.ESTE);
        rutaJedi.add(Camino.SUR);
        rutaJedi.add(Camino.SUR);
        rutaJedi.add(Camino.ESTE);
        rutaJedi.add(Camino.SUR);
        rutaJedi.add(Camino.SUR);
        rutaJedi.add(Camino.ESTE);
        rutaJedi.add(Camino.ESTE);
        rutaJedi.add(Camino.SUR);
        rutaJedi.add(Camino.NORTE);
        rutaJedi.add(Camino.OESTE);
        rutaJedi.add(Camino.OESTE);
        
        rutaContra.add(Camino.ESTE);
        rutaContra.add(Camino.ESTE);
        rutaContra.add(Camino.NORTE);
        rutaContra.add(Camino.NORTE);
        rutaContra.add(Camino.OESTE);
        rutaContra.add(Camino.OESTE);
        rutaContra.add(Camino.SUR);
        rutaContra.add(Camino.SUR);
        
        rutaDelMal.add(Camino.OESTE);
        rutaDelMal.add(Camino.OESTE);
        rutaDelMal.add(Camino.NORTE);
        rutaDelMal.add(Camino.NORTE);
        rutaDelMal.add(Camino.ESTE);
        rutaDelMal.add(Camino.ESTE);
        rutaDelMal.add(Camino.SUR);
        rutaDelMal.add(Camino.SUR);
        
        rutaReal.add(Camino.ESTE);
        rutaReal.add(Camino.ESTE);
        rutaReal.add(Camino.OESTE);
        rutaReal.add(Camino.OESTE);
        rutaReal.add(Camino.SUR);
        rutaReal.add(Camino.SUR);
        rutaReal.add(Camino.NORTE);
        rutaReal.add(Camino.NORTE);
        
        
        for (int i = 0; i < personajes.size(); i++) {
            if(((Personaje)personajes.get(i)).esJedi()){
                ((Jedi)personajes.get(i)).setRuta(rutaJedi);
            }
            if(((Personaje)personajes.get(i)).esContrabandista()){
                ((Contrabandista)personajes.get(i)).setRuta(rutaContra);
            }
            if(((Personaje)personajes.get(i)).esFamiliaReal()){
                ((FamiliaReal)personajes.get(i)).setRuta(rutaReal);
            }
            if(((Personaje)personajes.get(i)).esImperial()){
                ((Imperial)personajes.get(i)).setRuta(rutaDelMal);
            }
        }
        
        
        System.out.println(Galaxia.obtenerInstancia().imprimirMini());
        System.out.println(Galaxia.obtenerInstancia().imprimirLaberinto2());
        
        for (int i = 0; i < 50; i++) {
            
            System.out.println("\n\n\n\n\n\n\n\n\n\n");
            
            Galaxia.obtenerInstancia().accion(i+1);
//            IMPRIME EL TURNO DE CADA PERSONAJE
//            for (int j = 0; j < personajes.size(); j++) {
//                System.out.print(((Personaje)personajes.get(j)).getMarca());
//                System.out.println(" Turno: " + ((Personaje)personajes.get(j)).getTurno() + "\n");
//            }
            System.out.println("TURNO " + (i+1));
            System.out.println(Galaxia.obtenerInstancia().imprimirMini());
            System.out.println(Galaxia.obtenerInstancia().imprimirLaberinto2());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                java.util.logging.Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
    /**
     * Metodo main carga los modulos de simulacion oportunos
     * 
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        
        java.util.Date fecha = new Date();
               
        Logger.obtenerInstancia().escribeLog("\n\n\n\n<<<< -- Ejecucion del "
                + "programa DP - STARWARS "+ fecha + "-- >>>>\n\n", 4);
        Logger.obtenerInstancia();
        
        Logger.obtenerInstancia().escribelog("EJECUTANDO SIMULACION DE LA TERCERA"
                + " ENTREGA EC3\n");
        
        EC3();
        
        Logger.obtenerInstancia().escribelog("Fin de la simulacion");
        
        Logger.obtenerInstancia().close();
        
    }
    
}
