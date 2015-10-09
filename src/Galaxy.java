/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author naker
 */

/*
 * La clase galaxia es un tablero bidimensional compuesto de X Y elementos de la clase
 * Station, cuando llamamos al contructor de Galaxy, este nos genera un tablero X Y
 * que por defecto tendra 8x8 estaciones, si no se especifican el numero de filas
 * y columnas, reasignando aleatoriamente la puerta o estacion de entrada y la
 * puerta o estacion de salida
 */
public class Galaxy {
    
    private Station[][] galaxy;

    /*
     Constructor por defecto de un tablero de la galaxia
    */
    public Galaxy() {
        //Inicializa la galaxia (Tablero)
        galaxy = new Station[100][100];
        initGalaxy();
    }
    
    /*
    Constructor parametrizado de un tablero de la galaxia
    
    Recibe:
        Int numero de filas
        int numero de columnas
    */
    public Galaxy(int filas, int columnas){
        galaxy = new Station[filas][columnas];
        initGalaxy();
    }
    
    //Inicializa el tablero de la galaxia
    private void initGalaxy(){
        
        for(int i=0;i < galaxy.length;i++){
            for(int e=0;e < galaxy[i].length;e++){
        
                Station estacion = new Station(i, e);
                galaxy[i][e] = estacion;
            
            }
        }
        
        //Inicialmente se va a definir la estacion de entrada o wormhole como la estacion 
        //[1][1] de la galaxia, mas tarde sera elegida con un pseudorandom, al igual
        //que la puerta de salida o Stargate que sera la [n]x[m]
        int x = galaxy.length;
        int y = galaxy[x-1].length;
        
        galaxy[0][0] = new WormHole(0,0);
        galaxy[x-3][y-1] = 
                new StarGate(x-3, y-1);
    }

    @Override
    public String toString() {
        String output = "";
        
        for(int i=0;i< galaxy.length;i++){
            output += "|";
            for(int e=0; e<galaxy[i].length;e++){
                
                output += galaxy[i][e].getId()+"|";
                
            }
            output += "\n";
        }
        
        return output;
    }
    
    public String getInfoStations(){
        String output = "";
        
        
        for(int i=0;i< galaxy.length;i++){
            for(int j=0;j< galaxy[i].length;j++){
                output += " _______________";
            }
            output += "\n";
            //Linea del id de celda
            for(int e=0; e<galaxy[i].length;e++){
                output += "|" + galaxy[i][e].getId() + "\t\t|";
            }
            output += "\n";
            //Linea del tipo
            for(int e=0; e<galaxy[i].length;e++){
                output += "|" + galaxy[i][e].getType() + "\t|";
            }
            output += "\n";
            //Linea de espacio
            for(int e=0; e<galaxy[i].length;e++){
                output += "|\t\t|";
            }
            output += "\n";
            //Linea de espacio
            for(int e=0; e<galaxy[i].length;e++){
                output += "|\t\t|";
            }
            output += "\n";
            for(int e=0; e<galaxy[i].length;e++){
                output += "|\t\t|";
            }
            output += "\n";
            for(int j=0;j< galaxy[i].length;j++){
                output += "| ______________";
            }
            output += "\n";
        }
        
        
        return output;
    }
    
    
}
