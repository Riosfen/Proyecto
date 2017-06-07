package principal;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controlador.ControladorPrincipal;
import modelo.BigPanel;
import persistencia.HibernateUtil;
import vista.VistaPrincipal;

public class Principal {

	private static final String URL_TIENDA = "recursos/videojuegos.png";
	
	public static void main(String[] args) {

        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSessionAndBindToThread();
		
		//Toolkit t = Toolkit.getDefaultToolkit();
        //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        JFrame ventana = new JFrame();
        BigPanel barra = new BigPanel(new ImageIcon(URL_TIENDA), "Tienda de videojuegos", BigPanel.tipoVentana.CERRAR);
        VistaPrincipal vp = new VistaPrincipal(barra);
        ControladorPrincipal c = new ControladorPrincipal(vp, ventana);
        
        vp.setControlador(c);
        
        ventana.setContentPane(vp);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //ventana.setSize(500,500);
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventana.setUndecorated(true);
        ventana.setVisible(true);
        ventana.setResizable(false);
        
        barra.setFontSize(ventana.getSize().height*10/100);

	}
	
}
