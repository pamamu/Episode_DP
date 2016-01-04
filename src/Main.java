
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
        Loader cargador = new Loader(args[0]);
        
        Galaxia galaxia = Galaxia.obtenerInstancia();

        //Simulacion de turnos
        for (int i = 0; i < 50 && !galaxia.getStarsgate().cerradura.Abierta(); i++) {

            galaxia.accion(i);
            galaxia.toLog(i);
        }
        log.close();
    }

}
