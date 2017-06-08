package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JDialog;

import patronDAO.JuegoDAO;
import persistencia.HibernateUtil;
import persistencia.Juego;
import vista.VistaVenta;

public class ControladorVenta implements ActionListener{
    
    private final VistaVenta panelVenta;
    private final JDialog ventna;
    
    public ControladorVenta(VistaVenta panelVenta, JDialog ventana){
        this.ventna = ventana;
        this.panelVenta = panelVenta;
        this.panelVenta.getBigPanel().controladorSalir(this, "atras");
        this.panelVenta.getBigPanel().controladorAyuda(this, "ayuda");
        panelVenta.getModeloTabla();
        HibernateUtil.buildSessionFactory();
        
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
            case "buscarArticulo":
            	Object[][] datos = buscarJuego(panelVenta.getFiltro());
    			String[] cabecera = new String[]{"Nombre", "Edad mínima", "Precio"};
    			@SuppressWarnings("rawtypes") Class[] types = new Class[] {String.class, String.class, String.class};
    			
    			panelVenta.cargarTabla1(datos, cabecera, types);
                break;
            case "buscarUsuario":
                break;
            case "cobrar":
                break;
            case "limpiar":
                break;
            case "aniadirArticulo":
                break;
            case "aumentarCantidad":
                break;
            case "disminuirCanitdad":
                break;
            case "eliminar":
                break;
        }
    }

	private Object[][] buscarJuego(String filtro) {
        HibernateUtil.openSessionAndBindToThread();
        try {
        	String texto = panelVenta.getTextoFiltro();
			JuegoDAO juegoDao = new JuegoDAO();
			
			switch(filtro){
			case "NOMBRE":
				return obtenerListaJuego(juegoDao.buscarJuegoPorNombre(texto));
			case "EDAD":
				return obtenerListaJuego(juegoDao.buscarJuegoPorEdad(texto));
			case "PRECIO":
				return obtenerListaJuego(juegoDao.buscarJuegoPorPrecio(texto));
			case "TODO":
				return obtenerListaJuego(juegoDao.obtenerTodo());
			}
			
		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}
		
		
		return null;
	}
	
	private Object[][] obtenerListaJuego(List<Juego> juegos) {
		Object[][] datos = null;
		
		if (juegos.size() != 0){
			datos = new Object[juegos.size()][3];
			
			for (int i = 0; i < juegos.size(); i++){
				datos[i][0] = juegos.get(i).getNombre();
				datos[i][1] = juegos.get(i).getEdadMinima();
				datos[i][2] = juegos.get(i).getPrecio();
			}
		}
		
		return datos;
	}

}
