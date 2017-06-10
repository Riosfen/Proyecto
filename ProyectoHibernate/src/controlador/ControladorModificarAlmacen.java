package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import patronDAO.JuegoDAO;

import persistencia.HibernateUtil;
import persistencia.Juego;

import vista.Almacen.VistaModificarAlmacen;

public class ControladorModificarAlmacen implements ActionListener {

	private VistaModificarAlmacen panelModificarAlmacen;
	
	public ControladorModificarAlmacen(VistaModificarAlmacen panelModificarAlmacen) {
		this.panelModificarAlmacen = panelModificarAlmacen;
        HibernateUtil.buildSessionFactory();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		switch(e.getActionCommand()){
			case "modificar":
				actualizarAlmacen(panelModificarAlmacen.getJuego());
				break;
			case "limpiar":
				panelModificarAlmacen.limpiarDatos();
				break;
		}
		
	}
	
	private void actualizarAlmacen(Juego juego) {
		HibernateUtil.openSessionAndBindToThread();
		
		try {
			
			if (!juego.getNombre().equals(panelModificarAlmacen.getNombre()) ||
					juego.getEdadMinima() != panelModificarAlmacen.getEdadMinima() ||
					juego.getPrecio() != panelModificarAlmacen.getPrecio() ||
					juego.getTipoJuego() != panelModificarAlmacen.getTipoJuego()){

				juego.setNombre(panelModificarAlmacen.getNombre());
				juego.setEdadMinima(panelModificarAlmacen.getEdadMinima());
				juego.setPrecio(panelModificarAlmacen.getPrecio());
				juego.setTipoJuego(panelModificarAlmacen.getTipoJuego());
				juego.setStock(panelModificarAlmacen.getStock());
				
				JuegoDAO juegoDao = new JuegoDAO();
				juegoDao.actualizar(juego);
				
			}
			
			
		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}
		
	}

}
