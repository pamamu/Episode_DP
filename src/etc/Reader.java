/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author fernandogonzalez
 */
public class Reader {

    private String data;

    public Reader() throws IOException {
        data = "";
        readFile();
    }

    private void readFile() throws FileNotFoundException, IOException {

        String preProcess = "";
        String ruta = "./files/datos.txt";

        try {
            File f = new File(ruta);
            Scanner in = new Scanner(f);

            //Lectura del fichero mientras queden lineas
            while (in.hasNextLine()) {
                //Pide nueva linea
                preProcess = in.nextLine();
                //Quita linea de comentarios
                if (!preProcess.startsWith("--"))
                    this.data += preProcess + "\n";        //Agrega la informacion de la linea que nos interesa
            }
        } catch (Exception e) {
            System.err.println("El archivo parece que no se encuentra en " + ruta);
        }

    }

    public String[] getGalaxyInfo() {

        String output = "";
        String preProcess = "";
        Scanner line = new Scanner(data);
        boolean haveInfo = false;

        while (line.hasNextLine() && !haveInfo) {
            preProcess = line.nextLine();
            if (preProcess.startsWith("GALAXIA")) {
                output = preProcess;
                haveInfo = true;
            }
        }

        if (haveInfo) {
            return output.split("#");
        } else {
            return null;
        }

    }
    
   /*
    * Parametro type indica el codigo de palabra a recoger los datos 
    *
    * CODIGO:
    *   1 -> JEDI
    *   2 -> CONTRABANDISTA
    *   3 -> FAMILIAREAL
    *   4 -> IMPERIAL
    */
        
    private String[][] obtainData(int type){
        
        String[][] output = null;
        int numPers = 0;
        String preProcess = "";
        String code;
        
        switch(type){
            case 1:
                code = "JEDI";
                break;
            case 2:
                code = "CONTRABANDISTA";
                break;
            case 3:
                code = "FAMILIAREAL";
                break;
            case 4:
                code = "IMPERIAL";
                break;
            default:
                code = null;
        }
        
        Scanner line = new Scanner(data);
        
        
        while (line.hasNextLine()) {
            preProcess = line.nextLine();
            
            if (preProcess.startsWith(code)) {
                numPers++;
                
                String[][] aux = new String[numPers][];
                
                if(output != null)
                    for (int i = 0; i < output.length; i++) {
                        aux[i] = output[i];
                    }
                
                aux[numPers - 1] = preProcess.split("#");
                output = aux;
            }
            
        }
        
        if(null != output) 
            return output;
        else 
            return null;
    }
    
    public String[][] getJedis() {
        return obtainData(1);
    }
    
    public String[][] getContrabandists() {
        return obtainData(2);
    }
    
    public String[][] getRoyal(){
        return obtainData(3);
    }
    
    public String[][] getEmpire(){
        return obtainData(4);
    }
}
