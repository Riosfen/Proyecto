package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

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
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, e2.getMessage(), "ERROR!!", JOptionPane.ERROR_MESSAGE);
				//TODO Ivan me va a decir como hacer pa que no me salgan cosas raras
			}
            panelAgregarUsuario.limpiarDatos();
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
				throw new HibernateException("Ese Cliente ya se encuentra en la base de datos.");
			}
		
		return encontrado;
		
	}
	
}
