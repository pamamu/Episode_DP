package GUI;

import java.awt.GridLayout;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Tablero extends JPanel {

    private short dimX;
    private short dimY;
    private int numSalas;
    private GridLayout layout;
    private List<Estacion> estaciones = new ArrayList<Estacion>();

    public Tablero(int dimX, int dimY) {
        this.dimX = (short) dimX;
        this.dimY = (short) dimY;
        this.numSalas = this.dimX * this.dimY;
        layout = new GridLayout(dimX, dimY);
        this.setLayout(layout);
        for (int i = 0; i < dimX * dimY; i++) {
            estaciones.add(new Estacion(i));
            this.add(estaciones.get(i));
        }
        // TODO: Establecer el layout del tablero (dimx x dimy)

        //TODO: Insertar estaciones en la lista de estaciones y en el tablero
    }

    public void tirarPared(Integer salaX, Integer salaY) {
        int diferencia = salaY - salaX;
        switch (diferencia) {
            case 1:
                estaciones.get(salaX).tirarPared(Orientacion.E);
                estaciones.get(salaY).tirarPared(Orientacion.O);
                break;
            case -1:
                estaciones.get(salaX).tirarPared(Orientacion.O);
                estaciones.get(salaY).tirarPared(Orientacion.E);
                break;
            default:
                if (diferencia == dimX) {
                    estaciones.get(salaX).tirarPared(Orientacion.S);
                    estaciones.get(salaY).tirarPared(Orientacion.N);
                }
                if (diferencia == -dimX) {
                    estaciones.get(salaX).tirarPared(Orientacion.N);
                    estaciones.get(salaY).tirarPared(Orientacion.S);
                }
        }
    }

    public void insertarPersonajeEstacion(char marca, int sala) {
        //TODO: Establecer el texto de la celda con la marca del personaje
        estaciones.get(sala).setTexto(String.valueOf(marca));
    }

    public void insertarNumPersonajesEstacion(int numPers, int sala) {
        //TODO: Establecer el texto de la celda con el n�mero de personajes pasado por par�metro (numPers)
        estaciones.get(sala).setTexto(String.valueOf(numPers));
    }

    public void pintarParedes() {
        for (Estacion estacion : estaciones) {
            estacion.pintarParedes();
        }
    }
}
