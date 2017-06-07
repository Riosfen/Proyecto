package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
				actualizarCliente(panelModificarUsuario.getCliente());
				break;
			case "limpiar":
				panelModificarUsuario.limpiarDatos();
				break;
		}

	}

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
			ClienteDAO clienteDao = new ClienteDAO();
			clienteDao.actualizar(cliente);
			
		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}
		
	}

}
