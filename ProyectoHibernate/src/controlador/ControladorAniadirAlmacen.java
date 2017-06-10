package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.hibernate.HibernateException;

import patronDAO.JuegoDAO;
import persistencia.HibernateUtil;
import persistencia.Juego;
import persistencia.TipoJuego;
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
                panelAgregarAlmacen.limpiarDatos();
				
        	} catch (ConstraintViolationException e2) {
				StringBuilder cadena = new StringBuilder("No se ha podido insertar el artículo debido a los siguientes errores:\n\n");
				for (@SuppressWarnings("rawtypes") ConstraintViolation constraintViolation : e2.getConstraintViolations()) {
					cadena.append("En el campo '" + constraintViolation.getPropertyPath() + "':" + constraintViolation.getMessage() + "\n");
			    }
				JOptionPane.showMessageDialog(null, cadena, "ERROR!!", JOptionPane.ERROR_MESSAGE);
			}
        	
            break;
        
        case "limpiar":
            panelAgregarAlmacen.limpiarDatos();
            break;
		}

	}

	private void agregarAlmacen() throws HibernateException {
		
		String nombre = panelAgregarAlmacen.getNombre();
		int edadMin = panelAgregarAlmacen.getEdadMinima();
		double precio = panelAgregarAlmacen.getPrecio();
		TipoJuego tipo = panelAgregarAlmacen.getTipoJuego();
		int stock = panelAgregarAlmacen.getStock();

		Juego nuevoJuego = new Juego(nombre,edadMin,precio,tipo, stock);
		
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
			throw new HibernateException("El artículo "+ nombre +" ya se encuentra en la base de datos");
		}
		
		return encontrado;
	}

}
