package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import modelo.BigPanel;
import modelo.ModeloTablaPersonal;

@SuppressWarnings("serial")
public class VistaVenta extends javax.swing.JPanel {

	private final BigPanel barra;
    private JPanel panelPostizo;
    
    public VistaVenta(BigPanel barra) {
        setLayout(new java.awt.BorderLayout());
        this.barra = barra;
        cargarAjustesComponentes();
    }
    
    private void cargarAjustesComponentes() {
        panelPostizo = new JPanel(new BorderLayout());
        this.add(barra, BorderLayout.NORTH);
        this.add(panelPostizo, BorderLayout.CENTER);
        
    }
    
    public void setControlador(ActionListener e){
        
    }
    
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