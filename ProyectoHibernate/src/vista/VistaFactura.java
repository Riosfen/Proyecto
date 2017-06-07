package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import modelo.BigPanel;

@SuppressWarnings("serial")
public class VistaFactura extends javax.swing.JPanel {

    private final BigPanel barra;
    
    public VistaFactura(BigPanel barra) {
        this.barra = barra;
        initComponents();
        cargarAjustesComponentes();
    }
    
    private void cargarAjustesComponentes() {
        this.add(barra, BorderLayout.NORTH);
        
    }
    
    public void setControlador(ActionListener e){
        
    }
    
    public BigPanel getBigPanel(){
        return barra;
    }

    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }

}
