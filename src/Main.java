
import estructura.EstacionPuerta;
import estructura.Galaxia;
import etc.Loader;
import etc.Logger;
import java.io.IOException;
import java.util.ArrayList;

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
        galaxia.setPersonajes(cargador.getPersonajes());
        
        System.out.println(galaxia.imprimirLaberinto2());
        
        //Simulacion de turnos
        for (int i = 0; i < 50; i++) {
            
            if(((EstacionPuerta)galaxia.getEstacion(galaxia.getIdEstacionPuerta()))
                    .cerradura.Abierta()){
                
                galaxia.fin();
                
                break;
            }else{
                
                galaxia.accion(i);
                galaxia.toLog(i);

            }
            
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            
        }
        
        log.close();
    }

}
