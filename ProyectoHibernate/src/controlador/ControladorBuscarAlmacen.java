package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;

import javax.swing.JOptionPane;

import patronDAO.JuegoDAO;

import persistencia.HibernateUtil;
import persistencia.Juego;

import vista.VistaAlmacen;
import vista.Almacen.VistaBuscarAlmacen;
import vista.Almacen.VistaModificarAlmacen;

public class ControladorBuscarAlmacen implements ActionListener {

	private VistaBuscarAlmacen panelBuscarAlmacen;
	private VistaModificarAlmacen panelModificarAlmacen;
	private VistaAlmacen panelAlmacen;
	
	public ControladorBuscarAlmacen(VistaBuscarAlmacen panelBuscarAlmacen, VistaAlmacen panelAlmacen) {
		this.panelBuscarAlmacen = panelBuscarAlmacen;
		this.panelAlmacen = panelAlmacen;
        HibernateUtil.buildSessionFactory();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "editar":
			try {
				Juego juego = obtenerJuegoTabla();
				this.panelModificarAlmacen = new VistaModificarAlmacen(juego);
	            panelModificarAlmacen.setControlador(new ControladorModificarAlmacen(panelModificarAlmacen));
	            panelAlmacen.setPanelDerecho(panelModificarAlmacen);
	            
				actualizarTabla();
	            
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "No se ha encontrado el juego seleccionado o no se ha seleccionado ninguno.", "ERROR!", JOptionPane.ERROR_MESSAGE);
			}
            
			break;
		case "eliminar":
			try {
				new JuegoDAO().borrar(obtenerJuegoTabla());
				
				actualizarTabla();
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "No se ha encontrado el juego seleccionado o no se ha seleccionado ninguno.", "ERROR!", JOptionPane.ERROR_MESSAGE);
			}
			
			
			break;
		case "buscar":
			Object[][] datos = buscarJuego(panelBuscarAlmacen.getFiltro());
			String[] cabecera = new String[]{"Nombre", "Edad m�nima", "Precio"};
			@SuppressWarnings("rawtypes") Class[] types = new Class[] {String.class, String.class, String.class};
			
			if(datos != null){
				panelBuscarAlmacen.cargarTabla(datos, cabecera, types);
			}
			break;
		}

	}
	
	private void actualizarTabla() {
		Object[][] datos2 = buscarJuego("TODO");
		String[] cabecera2 = new String[]{"Nombre", "Edad m�nima", "Precio"};
		@SuppressWarnings("rawtypes") Class[] types2 = new Class[] {String.class, String.class, String.class};
		panelBuscarAlmacen.cargarTabla(datos2, cabecera2, types2);
		
	}

	private Object[][] buscarJuego(String filtro) {
        HibernateUtil.openSessionAndBindToThread();
        try {
        	String texto = panelBuscarAlmacen.getTextoFiltro();
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
				//datos[i][3] = juegos.get(i).getTipoJuego();
			}
		}
		
		return datos;
	}
	
	private Juego obtenerJuegoTabla() {
        HibernateUtil.openSessionAndBindToThread();
        Juego j = null;
		try {
			j = new JuegoDAO().getJuegoPorNombre(panelBuscarAlmacen.getJuegoNombre());
			
		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}
		return j;
	}

}