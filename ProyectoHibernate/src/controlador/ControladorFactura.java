package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import vista.VistaFactura;

public class ControladorFactura implements ActionListener{
    
    private final VistaFactura panelFactura;
    private final JDialog ventna;
    
    public ControladorFactura(VistaFactura panelFactura, JDialog ventana){
        this.ventna = ventana;
        this.panelFactura = panelFactura;
        this.panelFactura.getBigPanel().controladorSalir(this, "atras");
        this.panelFactura.getBigPanel().controladorAyuda(this, "ayuda");
        
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
