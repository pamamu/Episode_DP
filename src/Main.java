
import estructura.Galaxia;
import etc.Loader;
import etc.Logger;
import java.io.IOException;

/**
 * Main pruebas de funcionalidad sobre el proyecto
 *
 */
public class Main {

    /**
     * Metodo main carga los modulos de simulacion oportunos
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        Logger log = Logger.obtenerInstancia();
        Loader cargador = new Loader();
        Galaxia galaxia = Galaxia.obtenerInstancia();
        
        System.out.println(galaxia.imprimirLaberinto2());
        
        //Simulacion de turnos
        for (int i = 0; i < 100; i++) {
            
            galaxia.accion(i+1);
            
            System.out.println("TURNO " + (i+1));
            
            System.out.println(galaxia.imprimirLaberinto2());
            System.out.println(galaxia.imprimir());
            
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            
        }
        
        log.close();
    }

}
