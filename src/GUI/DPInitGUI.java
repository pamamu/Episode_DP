package GUI;

import etc.Loader;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DPInitGUI extends JFrame {
    //Componente principal, panel con pesta�as

    private JTabbedPane pestañas = new JTabbedPane();
    //Componentes para cada pesta�a del JTabbedPane
    private PanelFichero inicio = new PanelFichero();
    private PanelFichero log = new PanelFichero();
    private PanelTablero panelTablero = new PanelTablero();
    // Componentes para la barra de Men�s
    private JMenuBar menus = new JMenuBar();
    private JMenu archivo = new JMenu("Archivo");
    private JMenu generar = new JMenu("Generar");
    private JMenuItem generarGalaxia = new JMenuItem("Generar Galaxia");
    private JMenuItem abrirInicio = new JMenuItem("Abrir Inicio");
    private JMenuItem guardarLog = new JMenuItem("Guardar Log");
    private JMenuItem salir = new JMenuItem("Salir");
    private JSeparator separador = new JSeparator();

    public DPInitGUI() {
        super("Episode DP");

        pestañas.add("Fichero Inicio", inicio);
        pestañas.add("Galaxia", panelTablero);
        pestañas.add("Fichero Log", log);

        initMenus();

        this.setContentPane(pestañas);

        this.setBounds(300, 100, 500, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void initMenus() {
        // La opci�n abrir de archivo debe invocar el m�todo abrirInicio()
        // La opci�n guardar de archivo debe invocar el m�todo guardarLog()
        // La opci�n salir de archivo debe invocar el m�todo salir()
        generarGalaxia.setMnemonic(KeyEvent.VK_G);
        abrirInicio.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, Event.CTRL_MASK));
        abrirInicio.setMnemonic(KeyEvent.VK_A);
        abrirInicio.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, Event.CTRL_MASK));
        guardarLog.setMnemonic(KeyEvent.VK_S);
        guardarLog.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK));
        salir.setMnemonic(KeyEvent.VK_ESCAPE);
        salir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, Event.ALT_MASK));

        // TODO: a�adir un escuchador y manejador de eventos a la opci�n abrir
        //TODO: Configurar el resto de opciones del men� Archivo: Cerrar, Separador, Salir 
        generar.add(generarGalaxia);
        archivo.add(abrirInicio);
        archivo.addSeparator();
        archivo.add(guardarLog);
        archivo.addSeparator();
        archivo.add(salir);

        abrirInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirInicio();
            }
        });
        guardarLog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarLog();
            }
        });

        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salir();
            }
        });

        generarGalaxia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generarGalaxia();
            }
        });

        menus.add(archivo);
        menus.add(generar);
        this.setJMenuBar(menus);
    }

    public void abrirInicio() {
        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File("./files"));
        FileNameExtensionFilter filtroExtension = new FileNameExtensionFilter("Texto(*.txt)", "txt");
        fc.setFileFilter(filtroExtension);
        int respuesta = fc.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            inicio.setTexto("");
            File f = fc.getSelectedFile();
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String linea;
                while ((linea = br.readLine()) != null) {
                    inicio.addTexto(linea + "\n");
                }
                fr.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }

    public void guardarLog() {
        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File("./files"));
        FileNameExtensionFilter filtroExtension = new FileNameExtensionFilter("Texto(*.log)", "log");
        fc.setFileFilter(filtroExtension);
        int respuesta = fc.showSaveDialog(this);
        String s = "Has guardado ";
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File guardar = fc.getSelectedFile();
            try {
                FileWriter archivolog = new FileWriter(guardar);
                String slog = log.getTexto();
                archivolog.write(slog + "");
                archivolog.close();
                s += fc.getSelectedFile().getName();
            } catch (IOException ex) {
                s = "ARCHIVO INCORRECTO";
            }
        } else {
            s = "OPERACIÓN CANCELADA";
        }
        JOptionPane.showMessageDialog(null, s);

    }

    public void generarGalaxia() {
        String s = "Va a generar una galaxia de acuerdo con el texto escrito en la Pestaña Fichero Inicio";
        int opcion = JOptionPane.showConfirmDialog(null, s);
        if (opcion == JOptionPane.YES_OPTION) {
            String ruta = "./files/inicio.txt";
            File guardar = new File(ruta);
            try {
                FileWriter guardarinicio = new FileWriter(guardar);
                String textinicio = inicio.getTexto();
                guardarinicio.write(textinicio);
                guardarinicio.close();
                Loader l = new Loader();
            } catch (IOException ex) {

            }

        }

    }

    public void salir() {
        System.exit(0);
    }

}
