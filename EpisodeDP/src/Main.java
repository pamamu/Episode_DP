
import GUI.GUI;
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

        Logger log = Logger.obtenerInstancia();
        GUI ventana = new GUI();
        log.close();
    }

}
