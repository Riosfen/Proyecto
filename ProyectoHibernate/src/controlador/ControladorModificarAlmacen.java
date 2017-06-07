package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;

import patronDAO.JuegoDAO;

import persistencia.HibernateUtil;
import persistencia.Juego;
import persistencia.TipoJuego;
import persistencia.TipoJuegos;

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
		juego.setNombre(panelModificarAlmacen.getNombre());
		juego.setEdadMinima(panelModificarAlmacen.getEdadMinima());
		juego.setPrecio(panelModificarAlmacen.getPrecio());

		TipoJuegos tipo;
		HashSet<TipoJuegos> tipos = new HashSet<>();
		ArrayList<TipoJuego> tipoJuego = panelModificarAlmacen.getTipoJuego();
		
		for (int i = 0; i < tipoJuego.size(); i++) {
			tipo = new TipoJuegos(tipoJuego.get(i), juego);
			tipos.add(tipo);
		}
		
		juego.setTipoJuego(tipos);
		
		
		
		try {
			JuegoDAO juegoDao = new JuegoDAO();
			juegoDao.actualizar(juego);
			
		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}
		
	}

}
