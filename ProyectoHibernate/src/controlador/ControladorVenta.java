package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import vista.VistaVenta;

public class ControladorVenta implements ActionListener{
    
    private final VistaVenta panelVenta;
    private final JDialog ventna;
    
    public ControladorVenta(VistaVenta panelVenta, JDialog ventana){
        this.ventna = ventana;
        this.panelVenta = panelVenta;
        this.panelVenta.getBigPanel().controladorSalir(this, "atras");
        this.panelVenta.getBigPanel().controladorAyuda(this, "ayuda");
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "atras":
                ventna.dispose();
                break;
            case "ayuda":
                System.out.println("no hay ayuda todavía");
                break;
        }
    }
    
}
