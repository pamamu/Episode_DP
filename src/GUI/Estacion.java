package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

enum Orientacion{
	S,E,N,O
};

public class Estacion extends JPanel{

	private BorderLayout layout = new BorderLayout();
	private JLabel idSala = new JLabel("",JLabel.LEFT);
	private JLabel robots = new JLabel("",JLabel.CENTER);
	private int paredes[] = {1,1,1,1}; // N, O, S, E
	
	public Estacion(int id){
		this.setLayout(layout);
		this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		setBackground(Color.white);
		
		//Configuramos la etiqueta del identificador de sala
		idSala.setForeground(Color.blue);
		Font fuente = new Font("Helvetica", Font.ITALIC, 10);
		idSala.setFont(fuente);
		idSala.setText(Integer.toString(id));
		this.add(idSala, BorderLayout.NORTH);
		
		//Configuramos la etiqueta del robot que hay en cada sala
                robots.setForeground(Color.red);
                fuente = new Font("Helvetica", Font.BOLD, 18);
                robots.setFont(fuente);
                this.add(robots, BorderLayout.CENTER);
		//TODO: A�adir la etiqueta robots en el centro, color rojo y tama�o 18
	}
	
	public void setTexto(String texto){
		//TODO: Cambiar el texto central de la sala (etiqueta robots)
                robots.setText(texto);

	}
	
	public void tirarPared(Orientacion pared){
		switch (pared) {
			case N: paredes[0]=0;break;
			case O: paredes[1]=0;break;
			case S: paredes[2]=0;break;
			case E: paredes[3]=0;
		}
	}
	
	public void pintarParedes(){
		Border border;
		border = BorderFactory.createMatteBorder(paredes[0], paredes[1], paredes[2], paredes[3], Color.black);
		this.setBorder(border);		
	}
	
}
