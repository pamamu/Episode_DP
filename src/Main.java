
import GUI.DPInitGUI;
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
     * @param args Argumentos del Main
     * @throws IOException Lanzza una IOException
     */
    public static void main(String[] args) throws IOException {
        
        System.err.println(args.length);

        Logger log = Logger.obtenerInstancia();
//        Loader cargador = new Loader();
        
        //Galaxia galaxia = Galaxia.obtenerInstancia();
        
        DPInitGUI ventana = new DPInitGUI();
        //Simulacion de turnos
//        for (int i = 0; i < 50; i++) {
//            galaxia.simular();
//        }
        log.close();
    }

}
