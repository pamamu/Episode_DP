package GUI;

import java.awt.Color;
import java.awt.Font;
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
        Font fuente = new Font("Consolas", Font.BOLD, 15);
        area.setFont(fuente);
        area.setBackground(Color.black);
        area.setForeground(Color.green);
    }

    public void setEditable(boolean opcion) {
        area.setEditable(opcion);
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
