package GUI;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;


public class DPInitGUI extends JFrame{
	//Componente principal, panel con pesta�as
	private JTabbedPane pestañas = new JTabbedPane();
	//Componentes para cada pesta�a del JTabbedPane
	private PanelFichero inicio = new PanelFichero();
	private PanelFichero log = new PanelFichero();
	private PanelTablero panelTablero = new PanelTablero();
	// Componentes para la barra de Men�s
	private JMenuBar menus = new JMenuBar();
	private JMenu archivo = new JMenu("Archivo");
	private JMenuItem abrirInicio = new JMenuItem("Abrir Inicio");
	private JMenuItem guardarLog = new JMenuItem("Guardar Log");
	private JMenuItem salir = new JMenuItem("Salir");
	private JSeparator separador = new JSeparator();

	public DPInitGUI(){
		super("StarWars DP");	

		pestañas.add("Fichero Inicio", inicio);
		pestañas.add("Galaxia", panelTablero);
		pestañas.add("Fichero Log", log);
		
		initMenus();		
		
		this.setContentPane(pestañas);
		
		this.setBounds(300,100,500,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void initMenus(){
		// La opci�n abrir de archivo debe invocar el m�todo abrirInicio()
		// La opci�n guardar de archivo debe invocar el m�todo guardarLog()
		// La opci�n salir de archivo debe invocar el m�todo salir()
		abrirInicio.setMnemonic(KeyEvent.VK_A);
		abrirInicio.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, Event.CTRL_MASK));
		guardarLog.setMnemonic(KeyEvent.VK_S);
                guardarLog.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK));
                salir.setMnemonic(KeyEvent.VK_ESCAPE);
                salir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, Event.ALT_MASK));

		// TODO: a�adir un escuchador y manejador de eventos a la opci�n abrir
                

		//TODO: Configurar el resto de opciones del men� Archivo: Cerrar, Separador, Salir 
		
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
		//TODO: A�adir el resto de opciones al men� Archivo

		menus.add(archivo);
		this.setJMenuBar(menus);
	}
	
	public void abrirInicio(){
		JFileChooser fc = new JFileChooser();
		int respuesta = fc.showOpenDialog(this);
		if (respuesta == JFileChooser.APPROVE_OPTION){
			inicio.setTexto("");
			File f = fc.getSelectedFile();
			 try {
			      FileReader fr = new FileReader(f);	
			      BufferedReader br = new BufferedReader(fr);
			      String linea;
			      while ((linea=br.readLine()) != null){
			            inicio.addTexto(linea + "\n");
			     }
			     fr.close();
			  }   catch (Exception e) {
			     // TODO: handle exception
			  }
		}
	}
	
	public void guardarLog(){
		
//TODO: Guardar el texto que hay en el panel fichero del log en un fichero de texto
	}
	
	
	public void salir(){
		System.exit(0);
	}
	
	
	public static void main(String[] args) {
		DPInitGUI ventana = new DPInitGUI();
	}

}
