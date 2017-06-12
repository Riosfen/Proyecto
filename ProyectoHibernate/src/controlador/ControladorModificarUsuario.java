package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import patronDAO.ClienteDAO;
import persistencia.Cliente;
import persistencia.HibernateUtil;
import vista.Usuario.VistaModificarUsuario;

public class ControladorModificarUsuario implements ActionListener {

	private VistaModificarUsuario panelModificarUsuario;
	
	public ControladorModificarUsuario(VistaModificarUsuario panelModificarUsuario) {
		this.panelModificarUsuario = panelModificarUsuario;
        HibernateUtil.buildSessionFactory();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		switch(e.getActionCommand()){
			case "modificar":
				try{
					actualizarCliente(panelModificarUsuario.getCliente());
				
				} catch (ConstraintViolationException e2) {
					StringBuilder cadena = new StringBuilder("No se ha podido insertar el artículo debido a los siguientes errores:\n\n");
					for (@SuppressWarnings("rawtypes") ConstraintViolation constraintViolation : e2.getConstraintViolations()) {
						cadena.append("En el campo '" + constraintViolation.getPropertyPath() + "':" + constraintViolation.getMessage() + "\n");
				    }
					JOptionPane.showMessageDialog(null, cadena, "ERROR!!", JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "limpiar":
				panelModificarUsuario.limpiarDatos();
				break;
		}

	}

	/**
	 * 
	 * @param cliente Cliente que se actualizara
	 */
	private void actualizarCliente(Cliente cliente) {
		HibernateUtil.openSessionAndBindToThread();
		
		cliente.setNombre(panelModificarUsuario.getNombre());
		cliente.setDni(panelModificarUsuario.getDni());
		cliente.setTelefono(panelModificarUsuario.getTelefono());
		cliente.setApellido(panelModificarUsuario.getApellido());
		cliente.setDireccion(panelModificarUsuario.getDireccion());
		cliente.setFechaNacimiento(panelModificarUsuario.getFechaNac());
		cliente.setSexo(panelModificarUsuario.getSexo());
		
		try {
			if (!cliente.getNombre().equals(panelModificarUsuario.getNombre()) ||
					!cliente.getDni().equals(panelModificarUsuario.getDni()) ||
					!cliente.getTelefono().equals(panelModificarUsuario.getTelefono()) ||
					!cliente.getApellido().equals(panelModificarUsuario.getApellido()) ||
					!cliente.getDireccion().equals(panelModificarUsuario.getDireccion()) ||
					cliente.getFechaNacimiento() != panelModificarUsuario.getFechaNac() ||
					cliente.getSexo() != panelModificarUsuario.getSexo()){
				
				ClienteDAO clienteDao = new ClienteDAO();
				clienteDao.actualizar(cliente);
				
			}
			
		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}
		
	}

}
