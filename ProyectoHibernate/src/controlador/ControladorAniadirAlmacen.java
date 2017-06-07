package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;

import patronDAO.JuegoDAO;
import persistencia.HibernateUtil;
import persistencia.Juego;
import persistencia.TipoJuego;
import persistencia.TipoJuegos;
import vista.Almacen.VistaAgregarAlmacen;

public class ControladorAniadirAlmacen implements ActionListener {

	private VistaAgregarAlmacen panelAgregarAlmacen;
	
	public ControladorAniadirAlmacen(VistaAgregarAlmacen panelAgregarAlmacen) {
		this.panelAgregarAlmacen = panelAgregarAlmacen;
        HibernateUtil.buildSessionFactory();
        
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
        case "agregar":
        	try {
                agregarAlmacen();
				
			} catch (HibernateException e2) {
				JOptionPane.showMessageDialog(null, e2.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
			} catch (ClassCastException e2){
				JOptionPane.showMessageDialog(null, "Formato no aceptado, inserta un valor correcto. Ej: 12,99", "ERROR", JOptionPane.ERROR_MESSAGE);
			}catch (NumberFormatException e2){
				JOptionPane.showMessageDialog(null, "Formato no aceptado, inserta un valor correcto. Ej: 14", "ERROR", JOptionPane.ERROR_MESSAGE);
			}catch (NullPointerException e2){
				JOptionPane.showMessageDialog(null, "Formato no aceptado, inserta un valor correcto. Ej: 12,99", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
            panelAgregarAlmacen.limpiarDatos();
            break;
        
        case "limpiar":
            panelAgregarAlmacen.limpiarDatos();
            break;
		}

	}

	private void agregarAlmacen() throws HibernateException {
		TipoJuegos tipo;
		HashSet<TipoJuegos> tipos = new HashSet<>();

		String nombre = panelAgregarAlmacen.getNombre();
		int edadMin = panelAgregarAlmacen.getEdadMinima();
		double precio = panelAgregarAlmacen.getPrecio();
		ArrayList<TipoJuego> tipoJuego = panelAgregarAlmacen.getTipoJuego();
		
		Juego nuevoJuego = new Juego(nombre, edadMin, precio, tipos);
		
		for (int i = 0; i < tipoJuego.size(); i++) {
			tipo = new TipoJuegos(tipoJuego.get(i), nuevoJuego);
			tipos.add(tipo);
		}
		
		nuevoJuego.setTipoJuego(tipos);
		
		try {
			HibernateUtil.openSessionAndBindToThread();
			if (!comprobarNombre(nombre)){
				JuegoDAO juegoDao = new JuegoDAO();
				juegoDao.guardar(nuevoJuego);
				
			}
			
		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}
		
	}

	private boolean comprobarNombre(String nombre) throws HibernateException{
		boolean encontrado = false;
		Juego juego = new JuegoDAO().getJuegoPorNombre(nombre);
		
		if(juego != null){
			encontrado = true;
			throw new HibernateException("El juego "+ nombre +" ya se encuentra en la base de datos");
		}
		
		return encontrado;
	}

}
