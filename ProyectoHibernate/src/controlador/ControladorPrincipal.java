package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import modelo.BigPanel;
import vista.VistaAlmacen;
import vista.VistaFactura;
import vista.VistaPrincipal;
import vista.VistaUsuario;
import vista.VistaVenta;

public class ControladorPrincipal implements ActionListener{
    
    private static final String URL_TIENDA = "recursos/videojuegos.png";
    
    private final VistaPrincipal vista;
    private final JFrame ventana;
    private JDialog ventanaAnnadir;
    private BigPanel barraN;
    
    public ControladorPrincipal(VistaPrincipal vista, JFrame ventana){
        this.ventana = ventana;
        this.vista = vista;
        this.vista.getBigPanel().controladorSalir(this, "cerrar");
        this.vista.getBigPanel().controladorAyuda(this, "ayuda");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        switch(e.getActionCommand()){
            case "cerrar":
                System.exit(0);
                break;
            case "ayuda":
                System.out.println("no hay ayuda todavÃ­a");
                break;
            case "almacen":
                
                ventanaAnnadir = new JDialog(ventana);
                barraN = new BigPanel(new ImageIcon(URL_TIENDA), "Control almacén", new Color(149, 95, 032), BigPanel.tipoVentana.ATRAS);
                VistaAlmacen panelAlmacen = new VistaAlmacen(barraN);
                
                ventanaAnnadir.setContentPane(panelAlmacen);
                ventanaAnnadir.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
                ventanaAnnadir.setSize(ventana.getWidth(), ventana.getHeight());
                ventanaAnnadir.setUndecorated(true);
                ventanaAnnadir.setVisible(true);
                ventanaAnnadir.setModal(false);
                barraN.setFontSize(ventana.getSize().height*10/100);
                
                ControladorAlmacen ctrAlmacen= new ControladorAlmacen(panelAlmacen, ventanaAnnadir);
                panelAlmacen.setControlador(ctrAlmacen);
                
                break;
            case "usuario":
                
                ventanaAnnadir = new JDialog(ventana);
                barraN = new BigPanel(new ImageIcon(URL_TIENDA), "Control usuario", new Color(073, 103, 141), BigPanel.tipoVentana.ATRAS);
                VistaUsuario panelUsuario = new VistaUsuario(barraN);
                
                ventanaAnnadir.setContentPane(panelUsuario);
                ventanaAnnadir.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
                ventanaAnnadir.setSize(ventana.getWidth(), ventana.getHeight());
                ventanaAnnadir.setUndecorated(true);
                ventanaAnnadir.setVisible(true);
                ventanaAnnadir.setModal(false);
                barraN.setFontSize(ventana.getSize().height*10/100);
                
                ControladorUsuario ctrUsuario= new ControladorUsuario(panelUsuario, ventanaAnnadir);
                panelUsuario.setControlador(ctrUsuario);
                
                break;
            case "factura":
                
                ventanaAnnadir = new JDialog(ventana);
                barraN = new BigPanel(new ImageIcon(URL_TIENDA), "Control factura", new Color(199, 180, 70), BigPanel.tipoVentana.ATRAS);
                VistaFactura panelFactura = new VistaFactura(barraN);
                
                ventanaAnnadir.setContentPane(panelFactura);
                ventanaAnnadir.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
                ventanaAnnadir.setSize(ventana.getWidth(), ventana.getHeight());
                ventanaAnnadir.setUndecorated(true);
                ventanaAnnadir.setVisible(true);
                ventanaAnnadir.setModal(false);
                barraN.setFontSize(ventana.getSize().height*10/100);
                
                ControladorFactura ctrFactura= new ControladorFactura(panelFactura, ventanaAnnadir);
                panelFactura.setControlador(ctrFactura);
                break;
            case "venta":
                
                ventanaAnnadir = new JDialog(ventana);
                barraN = new BigPanel(new ImageIcon(URL_TIENDA), "Nueva venta", new Color(1, 93, 82), BigPanel.tipoVentana.ATRAS);
                VistaVenta panelVenta = new VistaVenta(barraN);
                
                ventanaAnnadir.setContentPane(panelVenta);
                ventanaAnnadir.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
                ventanaAnnadir.setSize(ventana.getWidth(), ventana.getHeight());
                ventanaAnnadir.setUndecorated(true);
                ventanaAnnadir.setVisible(true);
                ventanaAnnadir.setModal(false);
                barraN.setFontSize(ventana.getSize().height*10/100);
                
                ControladorVenta ctrVenta= new ControladorVenta(panelVenta, ventanaAnnadir);
                panelVenta.setControlador(ctrVenta);
                break;
        }
        
    }
    
    
    
}
