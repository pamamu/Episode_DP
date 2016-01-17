package GUI;

import java.awt.event.FocusListener;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PanelFichero extends JScrollPane {

    private JTextArea area = new JTextArea();
    
    @Override
    public synchronized void addFocusListener(FocusListener l) {
        area.addFocusListener(l);
    }
    
    public PanelFichero() {
        super();
        setViewportView(area);
        area.setEditable(true);
        area.setLineWrap(true);
    }
    
    public void addTexto(String texto) {
        area.append(texto);
    }
    
    public void setTexto(String texto) {
        area.setText(texto);
    }
    
    public String getTexto() {
        return area.getText();
    }
}
