package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.hibernate.HibernateException;

import patronDAO.ClienteDAO;
import persistencia.Cliente;
import persistencia.HibernateUtil;
import persistencia.TipoSexo;
import vista.Usuario.VistaAgregarUsuario;

public class ControladorAniadirUsuario implements ActionListener{

	private VistaAgregarUsuario panelAgregarUsuario;
	
	public ControladorAniadirUsuario(VistaAgregarUsuario panelAgregarUsuario){
		this.panelAgregarUsuario = panelAgregarUsuario;
        HibernateUtil.buildSessionFactory();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
        case "agregar":
        	try {
                agregarUsuario();
                panelAgregarUsuario.limpiarDatos();
				
			} catch (ConstraintViolationException e2) {
				StringBuilder cadena = new StringBuilder("No se ha podido insertar el cliente debido a los siguientes errores:\n\n");
				for (@SuppressWarnings("rawtypes") ConstraintViolation constraintViolation : e2.getConstraintViolations()) {
					cadena.append("En el campo '" + constraintViolation.getPropertyPath() + "':" + constraintViolation.getMessage() + "\n");
			    }
				JOptionPane.showMessageDialog(null, cadena, "ERROR!!", JOptionPane.ERROR_MESSAGE);
			}
            break;
        
        case "limpiar":
        	System.out.println("limpiar datos");
            break;
		}
		
	}

	private void agregarUsuario() {

		String nombre = panelAgregarUsuario.getNombre();
		String dni = panelAgregarUsuario.getDni();
		String telefono = panelAgregarUsuario.getTelefono();
		String apellido = panelAgregarUsuario.getApellido();
		String direccion = panelAgregarUsuario.getDireccion();
		Date fechaNac = panelAgregarUsuario.getFechaNac();
		TipoSexo sexo = panelAgregarUsuario.getSexo();
		
		Cliente nuevoCliente = new Cliente(dni, nombre, apellido, fechaNac, telefono, direccion, sexo);
		
		
		try {
			HibernateUtil.openSessionAndBindToThread();
			if (!comprobarDni(dni)){
				ClienteDAO clienteDao = new ClienteDAO();
				clienteDao.guardar(nuevoCliente);
				
			}
			
		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}
		
		
	}
	
	private boolean comprobarDni(String dni) throws HibernateException {
		
		boolean encontrado = false;
		
			Cliente cliente = new ClienteDAO().getClientePorDni(dni);
			
			if(cliente != null){
				encontrado = true;
				throw new HibernateException(cliente.getNombre() + " con DNI: " + cliente.getDni() + ", ya se encuentra en la base de datos.");
			}
		
		return encontrado;
		
	}
	
}
