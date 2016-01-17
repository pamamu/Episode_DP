package GUI;

import edd.Grafo;
import estructura.EstacionBase;
import estructura.Galaxia;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import personajes.Personaje;

public class PanelTablero extends JPanel {

    //Dimensiones del tablero
    private int dimX;
    private int dimY;
    //Componentes de parte superior del panel: tabla de personajes
    private Galaxia galaxia = Galaxia.obtenerInstancia();
    private JTable tabla;
    private JScrollPane scroll;
    //Componentes centrales: tablero
    private Tablero tablero;
    //Componentes parte inferior: panel con dos botones
    private JPanel panelInferior = new JPanel();
    private JButton bGenerar = new JButton(new ImageIcon("images/laberinto.png"));
    private JButton bSimular = new JButton(new ImageIcon("images/play_verde.gif"));
    //Layout del panel principal
    private GridBagLayout layout = new GridBagLayout();

    //Datos para realizar pruebas
    private Integer[][] listaParedesTirar = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}, {0, 6}, {4, 10}, {6, 12}, {7, 8}, {8, 9},
    {9, 10}, {10, 11}, {7, 13}, {8, 14}, {9, 15}, {10, 16}, {11, 17}, {12, 18},
    {13, 19}, {14, 20}, {15, 21}, {16, 22}, {20, 21}, {21, 22}, {22, 23}, {18, 24},
    {22, 28}, {23, 29}, {24, 25}, {26, 27}, {27, 28}, {25, 31}, {26, 32}, {28, 34},
    {30, 31}, {33, 34}, {34, 35}};

    private Object[][] personajes;
    private String[] filasTabla = {"Tipo", "Marca", "Nombre", "Turno"};

    public PanelTablero(int dimX, int dimY) {
        this.dimX = dimX;
        this.dimY = dimY;
        iniciarListaRobots();
        iniciarTablero();
        iniciarPanelInferior();
        añadirComponentes();
    }

    public void iniciarListaRobots() {
        ArrayList<Personaje> personajes = galaxia.getPersonajes();
        Object[][] informacion = new Object[personajes.size()][5];
        for (int i = 0; i < personajes.size(); i++) {
            Personaje get = personajes.get(i);
            informacion[i][0] = get.getTipo();
            informacion[i][1] = get.getMarcaClase();
            informacion[i][2] = get.getNombre();
            informacion[i][3] = get.getTurno();
        }
        this.personajes = this.personajes;
        tabla = new JTable(informacion, filasTabla);
        scroll = new JScrollPane(tabla);
    }

    public void iniciarTablero() {
        tablero = new Tablero(dimX, dimY);
    }

    public void iniciarPanelInferior() {
        this.setLayout(new FlowLayout());
        panelInferior.add(bGenerar);
        panelInferior.add(bSimular);

        bGenerar.setToolTipText("Tirar paredes");
        bSimular.setToolTipText("Iniciar simulaci��n");
        bSimular.setEnabled(false);
    }

    public void añadirComponentes() {
        this.setLayout(layout);
        GridBagConstraints cons = new GridBagConstraints();

        // A�adiendo una etiqueta antes de lista de personajes
        JLabel lRobots = new JLabel("Lista de personajes: ");
        cons.gridx = 0;
        cons.gridy = 0;
        this.add(lRobots, cons);

        // A�adiendo la tabla de robots
        cons.weighty = 1;
        cons.weightx = 1;
        cons.gridx = 0;
        cons.gridy = 1;
        cons.ipady = 60;
//		cons.gridwidth=2;
        cons.fill = GridBagConstraints.BOTH;
        this.add(scroll, cons);

        // A�adiendo el tablero de salas
        cons.gridx = 0;
        cons.gridy = 2;
        cons.ipady = 150;
        this.add(tablero, cons);

        // A�adiendo el panel inferior con los botones
        cons.gridx = 0;
        cons.gridy = 3;
        cons.ipady = 10;
        cons.fill = GridBagConstraints.NONE;
        cons.anchor = GridBagConstraints.PAGE_END;
        this.add(panelInferior, cons);

        //A�adir acciones sobre los botones
        addAccionesBotones();
    }

    public void addAccionesBotones() {
        // TODO: A�adir acciones sobre los botones (bGenerar = tirarParedes) (bSimular=InsertarPersonajes)
                
        bGenerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tirarParedes();
                bGenerar.setEnabled(false);
                bSimular.setEnabled(true);
            }
        });
        bSimular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                galaxia.simular();
                if(galaxia.getStarsgate().cerradura.Abierta()){
                    javax.swing.JOptionPane.showMessageDialog(null, "Puerta Abierta");
                    bSimular.setEnabled(false);
                }
                insertarRobots();
            }
        });

    }

    public void tirarParedes() {
        Grafo grafo = galaxia.getGrafo();
        for (int i = 0; i < galaxia.getDimX(); i++) {
            for (int j = 0; j < galaxia.getDimY(); j++) {
                Set<Integer> s = new HashSet();
                int ID = galaxia.coordenadastoID(i, j);
                grafo.adyacentes(ID, s);
                ArrayList<Integer> adyacentes = new ArrayList<>(s);
                for (int k = 0; k < adyacentes.size(); k++) {
                    Integer get = adyacentes.get(k);
                    tablero.tirarPared(ID, get);
                }

            }
        }
        tablero.pintarParedes();

        //TODO: Habilitar el bot�n de simulaci�n
    }

    public void insertarRobots() {
        for (int i = 0; i < dimX * dimY; i++) {
            tablero.insertarPersonajeEstacion(' ', i);
        }

        for (int i = 0; i < galaxia.getDimX() * galaxia.getDimY(); i++) {
            EstacionBase estacion = galaxia.getEstacion(i);
            Object[] personajes = estacion.getPersonajes();
            if (personajes.length > 0) {
                if (personajes.length > 1) {
                    tablero.insertarNumPersonajesEstacion(personajes.length, i);
                } else {
                    Personaje pers = (Personaje) personajes[0];
                    tablero.insertarPersonajeEstacion(pers.getMarcaClase(), i);
                }
            }
        }
    }
}
