package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import modelo.BigPanel;
import patronDAO.JuegoDAO;
import persistencia.HibernateUtil;
import persistencia.Juego;
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
                

                panelVenta.cargarFiltro(obtenerColumnas());
                String[] columnas = new String[]{"Nombre", "Edad mínima", "Precio"};
                @SuppressWarnings("rawtypes") Class[] types = new Class[] {String.class, String.class, String.class};
                panelVenta.cargarTabla1(obtenerListaArticulos(),columnas, types);
                
                @SuppressWarnings("rawtypes") Class[] types2 = new Class[] {String.class, String.class, String.class};
                panelVenta.cargarTabla2(new Object[0][0], types2);
                
                
                break;
        }
        
    }

    private Object[][] obtenerListaArticulos() {
		HibernateUtil.openSessionAndBindToThread();
		Object[][] datos;
		try {
			List<Juego> juegos = new JuegoDAO().obtenerTodo();
			datos = new Object[juegos.size()][3];
			
			for (int i = 0; i < juegos.size(); i++){
				datos[i][0] = juegos.get(i).getNombre();
				datos[i][1] = juegos.get(i).getEdadMinima();
				datos[i][2] = juegos.get(i).getPrecio();
				//datos[i][3] = juegos.get(i).getTipoJuego();
			}
			
		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}
		
		return datos;
	}

	private String[] obtenerColumnas() {
		return new String[]{"NOMBRE","EDAD","PRECIO"};
	}
    
    
    
}
