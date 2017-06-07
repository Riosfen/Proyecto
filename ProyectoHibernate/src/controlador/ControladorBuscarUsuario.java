package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import patronDAO.ClienteDAO;
import persistencia.Cliente;
import persistencia.HibernateUtil;
import vista.VistaUsuario;
import vista.Usuario.VistaBuscarUsuario;
import vista.Usuario.VistaModificarUsuario;

public class ControladorBuscarUsuario implements ActionListener {

	private VistaBuscarUsuario panelBuscarUsuario;
	private VistaModificarUsuario panelModificarUsuario;
	private VistaUsuario panelUsuario;
	
	public ControladorBuscarUsuario(VistaBuscarUsuario panelBuscarUsuario, VistaUsuario panelUsuario) {
		this.panelBuscarUsuario = panelBuscarUsuario;
		this.panelUsuario = panelUsuario;
        HibernateUtil.buildSessionFactory();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "editar":
			try {
				Cliente cliente = obtenerClienteTabla();
				this.panelModificarUsuario = new VistaModificarUsuario(cliente);
	            panelModificarUsuario.setControlador(new ControladorModificarUsuario(panelModificarUsuario));
	            panelUsuario.setPanelDerecho(panelModificarUsuario);
	
				actualizarTabla();
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "No se ha encontrado al cliente seleccionado o no se ha seleccionado ninguno.", "ERROR!", JOptionPane.ERROR_MESSAGE);
			}
            
			break;
		case "eliminar":
			try {
				new ClienteDAO().borrar(obtenerClienteTabla());
				
				actualizarTabla();
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "No se ha encontrado al cliente seleccionado o no se ha seleccionado ninguno.", "ERROR!", JOptionPane.ERROR_MESSAGE);
			}
			
			break;
		case "factura":
			System.out.println("factura");
			break;
		case "buscar":
			Object[][] datos = buscarCliente(panelBuscarUsuario.getFiltro());
			String[] cabecera = new String[]{"DNI", "Apellidos", "Nombre", "Teléfono", "Dirección", "Fecha de Nacimiento"};
			@SuppressWarnings("rawtypes") Class[] types = new Class[] {String.class, String.class, String.class, String.class, String.class, String.class, Date.class};
			
			if(datos != null){
				panelBuscarUsuario.cargarTabla(datos, cabecera, types);
			}
			break;
		}
	}

	private void actualizarTabla() {
		Object[][] datos2 = buscarCliente("TODO");
		String[] cabecera2 = new String[]{"DNI", "Apellidos", "Nombre", "Teléfono", "Dirección", "Fecha de Nacimiento"};
		@SuppressWarnings("rawtypes") Class[] types2 = new Class[] {String.class, String.class, String.class, String.class, String.class, String.class, Date.class};
		panelBuscarUsuario.cargarTabla(datos2, cabecera2, types2);
		
	}

	private Cliente obtenerClienteTabla() {
        HibernateUtil.openSessionAndBindToThread();
        Cliente c = null;
		try {
			c = new ClienteDAO().getClientePorDni(panelBuscarUsuario.getClienteDni());
			
		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}
		return c;
	}

	private Object[][] buscarCliente(String filtro) {
        HibernateUtil.openSessionAndBindToThread();
        try {
        	String texto = panelBuscarUsuario.getTextoFiltro();
			ClienteDAO clienteDao = new ClienteDAO();
			
			switch(filtro){
			case "DNI":
				return obtenerListaClientes(clienteDao.buscarClientePorDni(texto));
			case "NOMBRE":
				return obtenerListaClientes(clienteDao.buscarClientePorNombre(texto));
			case "APELLIDO":
				return obtenerListaClientes(clienteDao.buscarClientePorApellido(texto));
			case "TELEFONO":
				return obtenerListaClientes(clienteDao.buscarClientePorTelefono(texto));
			case "TODO":
				return obtenerListaClientes(clienteDao.obtenerTodo());
			}
			
		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}
		
		
		return null;
	}
	
	private Object[][] obtenerListaClientes(List<Cliente> clientes) {
		Object[][] datos = null;
		
		if (clientes.size() != 0){
			datos = new Object[clientes.size()][6];
			
			for (int i = 0; i < clientes.size(); i++){
				datos[i][0] = clientes.get(i).getDni();
				datos[i][1] = clientes.get(i).getApellido();
				datos[i][2] = clientes.get(i).getNombre();
				datos[i][3] = clientes.get(i).getTelefono();
				datos[i][4] = clientes.get(i).getDireccion();
				datos[i][5] = new SimpleDateFormat("dd-MM-yyyy").format(clientes.get(i).getFechaNacimiento());
			}
		}
		
		return datos;
	}

}
