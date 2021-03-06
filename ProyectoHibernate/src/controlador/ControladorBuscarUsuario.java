package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
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
			editarCliente();
            
			break;
		case "eliminar":
			eliminarCliente();
			
			break;
		case "factura":
			System.out.println("factura");
			break;
		case "buscar":
			buscarCliente();
			break;
		}
	}

	private void buscarCliente() {
		Object[][] datos = buscarCliente(panelBuscarUsuario.getFiltro());
		String[] cabecera = new String[]{"DNI", "Apellidos", "Nombre", "Tel�fono", "Direcci�n", "Fecha de Nacimiento"};
		
		if (datos == null){
			JOptionPane.showMessageDialog(null, "No se ha encontrado nada relacionado con '"+ panelBuscarUsuario.getTextoFiltro() +"' en la base de datos.", "ERROR!", JOptionPane.ERROR_MESSAGE);
		}else{
			panelBuscarUsuario.cargarTabla(datos, cabecera);
		}
	}
	
	
	

	private void eliminarCliente() {
		try {
			new ClienteDAO().borrar(obtenerClienteTabla());
			
			actualizarTabla();
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "No se ha encontrado al cliente seleccionado o no se ha seleccionado ninguno.", "ERROR!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	

	private void editarCliente() {
		try {
			Cliente cliente = obtenerClienteTabla();
			this.panelModificarUsuario = new VistaModificarUsuario(cliente);
		    panelModificarUsuario.setControlador(new ControladorModificarUsuario(panelModificarUsuario));
		    panelUsuario.setPanelDerecho(panelModificarUsuario);

			actualizarTabla();
			panelUsuario.getBotonAgregar().setEnabled(true);
			panelUsuario.getBotonBuscar().setEnabled(true);
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "No se ha encontrado al cliente seleccionado o no se ha seleccionado ninguno.", "ERROR!", JOptionPane.ERROR_MESSAGE);
		}
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
	
	private void actualizarTabla() {
		Object[][] datos2 = buscarCliente("TODO");
		String[] cabecera2 = new String[]{"DNI", "Apellidos", "Nombre", "Tel�fono", "Direcci�n", "Fecha de Nacimiento"};
		panelBuscarUsuario.cargarTabla(datos2, cabecera2);
		
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
