package GUI;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PanelFichero extends JScrollPane{
	private JTextArea area = new JTextArea();
	
	public PanelFichero(){
		super();
		setViewportView(area);
		area.setEditable(true);
		area.setLineWrap(true);
	}
	
	public void addTexto(String texto){
		area.append(texto);
	}
	
	public void setTexto(String texto){
		area.setText(texto);
	}
	
	public String getTexto(){
		return area.getText();
	}
}
