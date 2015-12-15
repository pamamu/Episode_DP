/*
 * Este codigo es parte del proyecto STAR WARS - DP desarrollado en la
 * Universidad de Extremadura curso 2015 - 2016 | 
 * Asignatura Desarrollo de Programas
 * 
 * @author Fernando.G & Pablo Macias
 * @version 1.0 ALFA The force Awakens™ 2015
 */

package etc;

import java.io.FileWriter;

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
 * La clase Logger implementa un objeto de generacion de logs para el programa
 * 
 * @since
 *      <p color="red">
 *          by: Fernando G. & Pablo Macias<br/>
 *          The force Awakens™ 2015
 *      </p>
 * @author Fernando.G & Pablo Macias
 * @version 1.0 ALFA
 *
 */
public class Logger {
    
    // ATRIBUTOS ###############################################################
    /**
     * Objeto de escritura en fichero
     */
    private FileWriter archivo;
    
    /**
     * Buffer de memoria principal donde se irán escribiendo las lineas del log
     */
    private String buffer;
    
    /**
     * Instancia única de Logger mediante uso de patrón Singleton
     */
    private static Logger instancia = null;
    
    // CONSTRUCTORES ###########################################################
    /**
     * Constructor privado por singleton
     * Inicializa el buffer de memoria
     */
    private Logger(){
        buffer = "";
    }
    
    // GETTER & SETTER #########################################################
    
    /**
     * Método que retorna la única instancia existente de la clase Logger.<br/>
     * En caso de no existir instancia, ejecuta el constructor para crearla
     * 
     * @return Única instancia de objeto Logger
     */
    public static Logger obtenerInstancia(){
        if(instancia == null)
            instancia = new Logger();
        
        return instancia;
    }
    
    // PRIVADOS ################################################################
    
    /**
     * Abre el buffer de escritura en el archivo pasado por parámetro
     * 
     * @param ruta String con la ruta del fichero de log
     */
    public void init(String ruta){
        try{
            archivo = new FileWriter(ruta, true);
        }catch(Exception e){
            System.err.println("Error al abrir el archivo " + ruta + " ERROR:\n"
                    + e.getMessage());
            
            
        }
    }
    
    // PUBLICOS ################################################################
    
    /**
     * Escribe un mensaje pasado por parámetro en el buffer de memoria del 
     * log.<br/>
     * Por defecto el mensaje se categoriza en INFO (mensaje de informativo)
     * 
     * @param mensaje String con el contenido del mensaje a mostrar
     */
    public void escribelog(String mensaje){
        
        escribeLog(mensaje, 1);
        
    }
    
    /**
     * Escribe un mensaje pasado por parámetro en el buffer de memoria del 
     * log.<br/>
     * 
     * @param mensaje String con el contenido del mensaje a mostrar
     * @param tipo
     *      Codigo del mensaje:<br/>
     *  <pre>
     *      1 para mensajes de INFO (Informacion)
     *      2 para mensajes de WARNING (Advertencia)
     *      3 para mensajes de SEVERE (Criticos)
     *      4 para mensajes de inicio o fin del log
     * </pre>
     * 
     */
    public void escribeLog(String mensaje, int tipo){
        
        String msgTipo;
        
        switch (tipo){
            case 2:
                msgTipo = "WARNING!!: ";
                break;
            case 3:
                msgTipo = "SEVERE!!: ";
                break;
            case 4:         //Mensaje para inicio del log
                msgTipo = "\n";
                break;
            default:
                msgTipo = "INFO: ";
        }
        
        buffer += "\n" + msgTipo + mensaje;
        
        //Forzado de escritura tras un error critico
        if(tipo == 3)
            forzarVolcado();
    }
    
    /**
     * Fuerza el volcado en el archivo de log<br/>
     * <pre>
     * PRINCIPALMENTE PENSADO PARA USARSE AL PRODUCIR UN ERROR CRITICO EN EL 
     * PROGRAMA
     * 
     * Accede directo al archivo de log rescatando lo que se pueda del buffer 
     * de log
     * de memoria y aniadiendo el mensaje que se ha producido para tener 
     * constancia del fallo.
     * 
     * </pre>
     */
    private void forzarVolcado(){
        
        //Abre archivo
        instancia.init("./files/starwars-dp.log");
        
        try {
            //Inserta en el buffer de memoria al final del ultimo mensaje
            buffer += " - PANICO EN LA GALAXIA!!!";
            //Escribe el archivo
            archivo.write(buffer);
            //Cierra el buffer del archivo de log
            archivo.close();
            
        } catch (Exception e) {
            System.err.println("Error al escribir en log ERROR:\n" 
                    + e.getMessage());
        }
        
        //Vacia el buffer una vez escrito
        buffer = "";
        //Llamada al recolector de basura
        System.gc();
        
    }
    
    /**
     * Escribe en el fichero de log y cierra el buffer
     * @return 
     *  <pre>
     *      True si ha conseguido escribir
     *      False si no
     *  </pre>
     */
    public boolean close(){
        
        instancia.init("./files/starwars-dp.log");
        
        try{
            archivo.write(buffer);      //escritura del archivo con el contenido 
                                        //del buffer
            archivo.close();            //cerrado del buffer de escritura
        }catch(Exception e){
            System.err.println("Error cerrar log ERROR:\n" + e.getMessage());
            
            //Se reemplazan los mensajes de error de consola por mensajes de 
            //  advertencia del log
            instancia.escribeLog("Error al cerrar log ERROR:" + e.getMessage(),
                    2);
            
            return false;
        }
        
        //Vacia el buffer una vez escrito
        buffer = "";
        //Llamada al recolector de basura
        System.gc();
        
        return true;
        
    }
    
}
