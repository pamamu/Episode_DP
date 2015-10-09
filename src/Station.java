/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author naker
 */
public class Station {
    
    private int fila;
    private int columna;
    private String id;
    
    public Station(int fila, int columna){
        this.fila = fila;
        this.columna = columna;
        this.id = Integer.toString(fila) + Integer.toString(columna);
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String output="Station Info: \n";
        
        output += "Latitud " + fila +"\n";
        output += "Longitud " + columna + "\n";
        output += "ID " + id + "\n";
        
        return output;
    }
    
    
    public String getType(){
        return "Station ";
    }
    
}
