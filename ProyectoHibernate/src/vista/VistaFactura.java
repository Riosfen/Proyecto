package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import modelo.BigPanel;

@SuppressWarnings("serial")
public class VistaFactura extends javax.swing.JPanel {

    private final BigPanel barra;
    private JPanel panelPostizo;
    
    public VistaFactura(BigPanel barra) {
        setLayout(new java.awt.BorderLayout());
        this.barra = barra;
        cargarAjustesComponentes();
    }
    
    private void cargarAjustesComponentes() {
        panelPostizo = new JPanel(new BorderLayout());
        this.add(barra, BorderLayout.NORTH);
        this.add(panelPostizo, BorderLayout.CENTER);
        
    }
    
    /**
     * Nuevo controlador vacio, se utiliza mas adelante
     * 
     * @param e ActionListener
     */
    public void setControlador(ActionListener e){}
    
    public BigPanel getBigPanel(){
        return barra;
    }

    public void setPanelDerecho(JPanel panelDerecho){
        panelPostizo.removeAll();
        panelPostizo.add(panelDerecho, java.awt.BorderLayout.CENTER);
        panelPostizo.updateUI();
        panelPostizo.repaint();
        
    }

}
