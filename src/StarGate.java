/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author naker
 */
public class StarGate extends Station{
    
    private Midiclorian[] midiclorians;
    
    public StarGate(int fila, int columna){
        super(fila, columna);
        this.midiclorians = new Midiclorian[15];
        
        initMidiclorians();
    }
    
    private void initMidiclorians(){
        for(int i = 0;i < midiclorians.length;i++){
            midiclorians[i]= new Midiclorian(i);
        }
    }
    
    public void getMidiclorians(){
        for(Midiclorian i : midiclorians){
            System.out.print(i.toString());
        }
    }

    @Override
    public String toString() {
        String output = super.toString();
        
        output += "\nStarGate Info: \n";
        output += "Pass Midiclorians: \n";
        
        for(Midiclorian i : midiclorians){
            output += i.toString();
            output += " | ";
        }
        
        return output;
    }
    
    @Override
    public String getType(){
        return "StarGate";
    }
    
}
