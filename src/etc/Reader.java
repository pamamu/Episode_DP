/*
 * Este codigo es parte del proyecto STAR WARS - DP desarrollado en la
 * Universidad de Extremadura curso 2015 - 2016 | 
 * Asignatura Desarrollo de Programas
 * 
 * @author Fernando.G & Pablo Macias
 * @version 1.0 ALFA The force Awakens™ 2015
 */

package etc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

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
 * Clase Reader<br/>
 * Implementa un objeto de lectura de un fichero de configuracion inicial
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
public class Reader {

    // ATRIBUTOS ###############################################################
    /**
     * Datos a cargar en el programa
     */
    private String datos;

    // CONSTRUCTORES ###########################################################
    
    public Reader() throws IOException {
        datos = "";
        leerFichero();     //Lectura del fichero
    }

    // PRIVADOS ################################################################
    /**
     * Lee el fichero de configuracion y pasa la informacion relevante a memoria 
     * principal
     * 
     * @throws FileNotFoundException
     * @throws IOException 
     */
    private void leerFichero() throws FileNotFoundException, IOException {
        
        String preProcesado = "";           //String de preprocesado para depurar 
                                            //la entrada
        String ruta = "./files/datos.txt";  //Ruta del fichero de entrada

//        Logger.obtenerInstancia().escribelog("Leyendo fichero de configuracion "
//                + "inicial");
        
        try {
            //Apertura del fichero
            File f = new File(ruta);
            //Escaner de entrada del buffer del fichero
            Scanner in = new Scanner(f);

            //Lectura del fichero mientras queden lineas
            while (in.hasNextLine()) {
                //Pide nueva linea
                preProcesado = in.nextLine();
                //Quita linea de comentarios
                if (!preProcesado.startsWith("--"))
                    this.datos += preProcesado + "\n";  //Agrega la informacion 
            }
        } catch (Exception e) {
            System.err.println("El archivo parece que no se encuentra en " 
                    + ruta);
//            Logger.obtenerInstancia().escribeLog("Fallo al abrir el archivo de "
//                    + "configuracion inicial\n" + e.getMessage(), 3);
        }

    }
    
    /**
    * Obtiene los datos de cada tipo de personaje
    * 
    * @param tipo Indica el codigo de tipo de personaje a recoger los datos
    *<pre>
    * CODIGO:
    *   1 -> JEDI
    *   2 -> CONTRABANDISTA
    *   3 -> FAMILIAREAL
    *   4 -> IMPERIAL
    * </pre>
    * @return String[numPersonajes][datosPersonaje]
    * <pre>
    *   En la primera dimension de la matriz o filas, se halla cada personaje
    * ej:
    *       De haber 4 JEDIS -> la matriz tendra 4 filas
    * 
    *   En la segunda dimension estaran los datos referentes al personaje cuya 
    *   fila es la actual
    * ej:
    *       JEDI | LukeSkyWalker | S | 1
    * 
    * </pre>
    */
    private String[][] getDatosPersonajes(int tipo){
        
        String[][] salida = null;   //Variable de salida
        int numPers = 0;            //Numero de personajes de la clase buscada
        String preProcesado = "";   //Var de preprocesado
        String codigo;              //Codigo de tipo de personaje buscado 
                                    //  (palabra que indica el tipo de personaje)
        
        //Trascodificacion del numero de codigo con su respectiva palabra
        switch(tipo){
            case 1:
                codigo = "JEDI";
                break;
            case 2:
                codigo = "CONTRABANDISTA";
                break;
            case 3:
                codigo = "FAMILIAREAL";
                break;
            case 4:
                codigo = "IMPERIAL";
                break;
            default:
                codigo = null;
        }
        
//        Logger.obtenerInstancia().escribelog("Obteniendo datos de personajes "
//                + "tipo " + codigo);
        
        //Escaner sobre el string de entrada de datos
        Scanner line = new Scanner(datos);
        
        //Bucle sobre las lineas de datos
        while (line.hasNextLine()) {
            preProcesado = line.nextLine();
            //En caso de encontrar la palabra buscada
            if (preProcesado.startsWith(codigo)) {
                numPers++;      //Incremento del numero de personaje
                
                //Implementacion de array dinamico
                //Nuevo array con la dimension de tantos personajes como haya 
                //  al momento
                String[][] aux = new String[numPers][]; 
                
                //Si no esta vacio el array de salida anterior
                if(salida != null)
                    //Recorre el array antiguo
                    for (int i = 0; i < salida.length; i++) {   
                        //Copia los datos al nuevo array con 1 posicion mas
                        aux[i] = salida[i];
                    }
                //Agrega los datos del nuevo personaje encontrado
                aux[numPers - 1] = preProcesado.split("#");
                //Sobreescribe el array anterior con el nuevo
                salida = aux;
            }
        }
        
        //RECOLECTOR DE BASURA
        //Se llama al recolector para limpiar el rastro de los arrays auxiliares
        //  perdidos en memoria
        System.gc();
        
        //SALIDA
        if(null != salida) 
            return salida;
        else 
            return null;
    }
    
    // PUBLICOS ################################################################

    /**
     * Obtiene los datos referentes a la configuracion de la galaxia
     * 
     * @return String[]
     * 
     *  - String con los datos referidos a la galaxia
     */
    public String[] getDatosGalaxia() {

        //Variable de salida de datos
        String salida = "";         
        //Variable para preprocesar las lineas de informacion
        String preProcesado = "";   
        //Escaner sobre la variable de datos
        Scanner line = new Scanner(datos);
        //Bandera de salida del bucle al encontrar la linea de datos
        boolean hayDatos = false;
        
//        Logger.obtenerInstancia().escribelog("Obteniendo datos de la galaxia");
        
        //Bucle sobre las lineas de informacion de los datos obtenidos del fichero
        while (line.hasNextLine() && !hayDatos) {
            preProcesado = line.nextLine();     //Pide linea
            //Busqueda de la linea que interesa
            if (preProcesado.startsWith("GALAXIA")) {
                salida = preProcesado;
                hayDatos = true;
            }
        }

        if (hayDatos) {
            return salida.split("#");   //Corte del String por los tokens designados
        } else {
            return null;
        }

    }
    
    /**
     * Obtiene la informacion de los Jedis del fichero de configuracion inicial
     * 
     * @return String[][]
     *  -Matriz de string 
     * <pre>
     *   Primera dimension o filas = numero de personajes
     *   Segunda dimension o columnas = datos del personaje de dicha fila
     * </pre>
     */
    public String[][] getJedis() {
        return getDatosPersonajes(1);
    }
    
    /**
     * Obtiene la informacion de los Contrabandistas del fichero de configuracion 
     * inicial
     *
     * @return String[][]
     *  -Matriz de string 
     * <pre>
     *   Primera dimension o filas = numero de personajes
     *   Segunda dimension o columnas = datos del personaje de dicha fila
     * </pre> 
     */
    public String[][] getContrabandistas() {
        return getDatosPersonajes(2);
    }
    
    /**
     * Obtiene la informacion de los Familia Real del fichero de configuracion 
     * inicial
     * 
     * @return String[][]
     *  -Matriz de string 
     * <pre>
     *   Primera dimension o filas = numero de personajes
     *   Segunda dimension o columnas = datos del personaje de dicha fila
     * </pre>
     */
    public String[][] getReales(){
        return getDatosPersonajes(3);
    }
    
    /**
     * Obtiene la informacion de los Imperiales del fichero de configuracion 
     * inicial
     * 
     * @return String[][]
     *  -Matriz de string 
     * <pre>
     *   Primera dimension o filas = numero de personajes
     *   Segunda dimension o columnas = datos del personaje de dicha fila
     * </pre>
     */
    public String[][] getImperiales(){
        return getDatosPersonajes(4);
    }
}
