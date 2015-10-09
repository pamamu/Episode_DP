/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author naker
 */
public class WormHole extends Station{
    public WormHole(int fila, int columna){
        super(fila, columna);
    }

    @Override
    public String toString() {
        String output = "";
        
        output += "\nWorm Hole (puerta de entrada) Info: \n";
        output += super.toString();
        
        return output;
    }
    
    @Override
    public String getType(){
        return "WormHole";
    }
}
