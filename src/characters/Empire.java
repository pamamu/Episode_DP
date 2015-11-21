package characters;

import estructura.BaseStation;
import estructura.Galaxy;
import estructura.GateStation;
import estructura.Midiclorian;

/**
 * <p color="#01DF01">
 * Este codigo es parte del proyecto StarsWars - DP desarrollado en la
 * Universidad<br/>
 * de Extremadura en el curso 2015 - 2016 en la asignatura Desarrollo de
 * Programas
 * </p>
 * <br/>
 *
 * @since
 * <p color="red">
 * by: Fernando G. & Pablo Macias<br/>
 * Revenge of the Sith™ 2015
 *
 * </p>
 * @author Fernando.G & Pablo Macias
 * @version 1.0 ALFA
 *
 */
public class Empire extends Character {

    private boolean iClosed;    //Bandera que se utiliza como switch si he cerrado o no
    
    /**
     * Constructor parametrizado
     *
     * @param iD iD del personaje
     * @param name Nombre del personaje
     */
    public Empire(char iD, String name, BaseStation originStation) {
        super(iD, name, originStation);
        this.iClosed = false;
    }

    
    public boolean getClosed(){
        return iClosed;
    }
    /**
     * Elimina y devuelve el primer midicloriano que tiene almacenado
     *
     * @return Devuelve el primer midicloriano de la ED
     */
    public Midiclorian throwMidiclorian() {
        return super.midiclorians.remove(0);
    }

    /**
     * TODO IMPLEMENTAR COMPORTAMIENTO EN ESTACIÓN NORMAL
     *
     * @param galaxy 
     */
    @Override
    public void onStation(Galaxy galaxy) {
        //Nueva estacion
        if (this.getOriginStation() instanceof GateStation) {
            //Salta a onGate
            this.onGate(galaxy);
        } else {
            //Si tengo midiclorianos, inserto en la nueva estacion
            if (!this.midiclorians.isEmpty()) {
                this.getOriginStation().insertMidiclorian(this.throwMidiclorian());
            }
        }
    }

    /**
     * TODO IMPLEMENTAR COMPORTAMIENTO EN ESTACION CON PUERTA
     *
     * @param station
     */
    @Override
    public void onGate(Galaxy galaxy) {
        //Si no he cerrado cierro
        if(!getClosed()){
            GateStation originStation = (GateStation) this.getOriginStation();
            System.out.println("CERRANDO PUERTA");
            originStation.starsgate.close();
        }else{
            //Si he cerrado me muevo
            System.out.println("MOVIENDO");
            this.move(galaxy);
        }
        
        //Cambio de estado mi memoria de cerrado
        iClosed();
        
    }
    
    public void iClosed() {
        iClosed = !iClosed;
    }

    /**
     * Devuelve tipo
     *
     * @return Devuelve el tipo de objeto que es.
     * @pre
     * @post Devuelve el string "LightSide"
     * @complex O(1)
     */
    public String getType() {
        return "Empire";
    }
    
    @Override
    public String toString() {
        return ""+super.getClassMark()+"";
    }

}
