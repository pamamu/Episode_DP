package estructura;

/**
 *  <p color="#01DF01">
 *     Este codigo es parte del proyecto StarsWars - DP desarrollado en la Universidad<br/>
 *     de Extremadura en el curso 2015 - 2016 en la asignatura Desarrollo de Programas
 *  </p>
 * <br/>
 * 
 * Puerta de entrada de la galaxia para los personajes
 * 
 *  @since <p color="red">
 *     by: Fernando G. & Pablo Macias<br/>
 *         Revenge of the Sith™ 2015 
 *      
 * </p>
 *  @author Fernando.G & Pablo Macias
 *  @version 1.0 ALFA
 * 
 *  @deprecated <br/>
 *      Esta es una primera implementacion de puerta de entrada dicho tipo de objeto<br/>
 *      será eliminado en las siguientes versiones, lo cual no se aconseja uso de ello
 *
 */
public class WormHole {
    public WormHole(/*int fila, int columna*/){
        //super(fila, columna);
    }

    @Override
    public String toString() {
        String output = "";
        
        output += "\nWorm Hole (puerta de entrada) Info: \n";
        output += super.toString();
        
        return output;
    }
    
    public String getType(){
        return "WormHole";
    }
}
