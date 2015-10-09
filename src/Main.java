/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author naker
 */
public class Main {
    public static void main(String[] args) {
        
        Midiclorian myMidiclorian = new Midiclorian(8);
        System.out.println("Mi midicloriano es: " + myMidiclorian.toString());
        
        StarGate myStarGate = new StarGate(5, 4);
        System.out.println("\n" + myStarGate.toString() + "\n\n");
        
        Galaxy myGalaxy = new Galaxy();
        //System.out.println(myGalaxy.toString());
        
        System.out.println(myGalaxy.getInfoStations());
        
    }
}
