package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import patronDAO.ClienteDAO;
import patronDAO.JuegoDAO;

import persistencia.Cliente;
import persistencia.HibernateUtil;
import persistencia.Juego;

import vista.VistaVenta;
import vista.Ventana.VistaBuscarUsuarioEspecífico;
import vista.Ventana.VistaVentaPrincipal;

public class ControladorVenta implements ActionListener{
    
    private final VistaVenta panelVenta;
    private final JDialog ventna;
    private VistaBuscarUsuarioEspecífico panelBuscarUsuario;
    private VistaVentaPrincipal panelVentanaPrincipal;
    
    private Cliente cliente;
    
    public ControladorVenta(VistaVenta panelVenta, JDialog ventana){
        this.ventna = ventana;
        this.panelVenta = panelVenta;
        this.panelVentanaPrincipal = panelVentanaPrincipal;
        this.panelBuscarUsuario = new VistaBuscarUsuarioEspecífico();
        this.panelVentanaPrincipal = new VistaVentaPrincipal();
        this.panelVenta.getBigPanel().controladorSalir(this, "atras");
        this.panelVenta.getBigPanel().controladorAyuda(this, "ayuda");

        this.panelVenta.setPanelDerecho(panelVentanaPrincipal);
        this.panelVentanaPrincipal.setControlador(this);
    	this.panelBuscarUsuario.setControlador(this);
        
        this.cliente = null;
        cargarFiltroJuego();
        
        HibernateUtil.buildSessionFactory();
        
    }

	private void cargarFiltroJuego() {
		panelVentanaPrincipal.cargarFiltro(obtenerColumnasJuego());
        
        String[] columnas = new String[]{"Nombre", "Edad mínima", "Precio"};
        @SuppressWarnings("rawtypes") Class[] types = new Class[] {String.class, String.class, String.class};
        
        panelVentanaPrincipal.cargarTabla1(obtenerListaJuegos(),columnas, types);
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "atras":
                ventna.dispose();
                break;
            case "ayuda":
                System.out.println("no hay ayuda todavía");
                break;
            case "buscarArticulo":
        			buscarArtículo();
        			
                break;
            case "buscarUsuario":
            	
            	panelVenta.setPanelDerecho(panelBuscarUsuario);
            	panelBuscarUsuario.cargarFiltro(obtenerColumnas());
                
                String[] columnas = new String[]{"DNI", "Apellidos", "Nombre", "Teléfono", "Dirección", "Fecha de Nacimiento"};
                @SuppressWarnings("rawtypes") Class[] types = new Class[] {String.class, String.class, String.class, String.class, String.class, String.class, Date.class};
                
                panelBuscarUsuario.cargarTabla(obtenerListaClientes(),columnas, types);
            	
                break;
            case "cobrar":
            	//TODO aqui se obtiene el cliente
            	
                break;
            case "limpiar":
                break;
            case "aniadirArticulo":
                break;
            case "aumentarCantidad":
                break;
            case "disminuirCanitdad":
                break;
            case "eliminar":
                break;
                //
                // Esta parte es de la ventana de seleccionar usuario
                //
            case "buscar":
            	buscarCliente();
            	break;
            case "cancelar":
            	panelVenta.setPanelDerecho(panelVentanaPrincipal);
            	
            	break;
            case "seleccionar":
            	cliente = obtenerClienteTabla();
            	if (cliente == null){
        			JOptionPane.showMessageDialog(null, "No se ha ningun usuario, seleccione uno y seleccione seleccionar o seleccione cancelar.", "ERROR!", JOptionPane.ERROR_MESSAGE);
            	}else{
                	panelVenta.setPanelDerecho(panelVentanaPrincipal);
                	panelVentanaPrincipal.setFiltroCliente(cliente.getDni()+" "+cliente.getNombre()+" "+cliente.getApellido());
            	}
            	
            	break;
        }
    }
    
    private Object[][] obtenerListaJuegos() {
		HibernateUtil.openSessionAndBindToThread();
		Object[][] datos;
		try {
			List<Juego> juegos = new JuegoDAO().obtenerTodo();
			datos = new Object[juegos.size()][3];
			
			for (int i = 0; i < juegos.size(); i++){
				datos[i][0] = juegos.get(i).getNombre();
				datos[i][1] = juegos.get(i).getEdadMinima();
				datos[i][2] = juegos.get(i).getPrecio();
				//datos[i][3] = juegos.get(i).getTipoJuego();
			}
			
		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}
		
		return datos;
	}

	private String[] obtenerColumnasJuego() {
		return new String[]{"NOMBRE","EDAD","PRECIO"};
	}

	private void buscarCliente() {
		Object[][] datos = buscarCliente(panelBuscarUsuario.getFiltro());
		String[] cabecera = new String[]{"DNI", "Apellidos", "Nombre", "Teléfono", "Dirección", "Fecha de Nacimiento"};
		@SuppressWarnings("rawtypes") Class[] type = new Class[] {String.class, String.class, String.class, String.class, String.class, String.class, Date.class};
		
		if (datos == null){
			JOptionPane.showMessageDialog(null, "No se ha encontrado nada relacionado con '"+ panelBuscarUsuario.getTextoFiltro() +"' en la base de datos.", "ERROR!", JOptionPane.ERROR_MESSAGE);
		}else{
			panelBuscarUsuario.cargarTabla(datos, cabecera, type);
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
    
    private Object[][] obtenerListaClientes() {
		HibernateUtil.openSessionAndBindToThread();
		Object[][] datos;
		try {
			List<Cliente> clientes = new ClienteDAO().obtenerTodo();
			datos = new Object[clientes.size()][6];
			
			for (int i = 0; i < clientes.size(); i++){
				datos[i][0] = clientes.get(i).getDni();
				datos[i][1] = clientes.get(i).getApellido();
				datos[i][2] = clientes.get(i).getNombre();
				datos[i][3] = clientes.get(i).getTelefono();
				datos[i][4] = clientes.get(i).getDireccion();
				datos[i][5] = new SimpleDateFormat("dd-MM-yyyy").format(clientes.get(i).getFechaNacimiento());
			}
			
		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}
		
		return datos;
	}

	private void buscarArtículo() {
		Object[][] datos = buscarJuego(panelVentanaPrincipal.getFiltro());
		String[] cabecera = new String[]{"Nombre", "Edad mínima", "Precio"};
		@SuppressWarnings("rawtypes") Class[] types = new Class[] {String.class, String.class, String.class};
		
		if (datos == null){
			JOptionPane.showMessageDialog(null, "No se ha encontrado nada relacionado con '"+ panelVentanaPrincipal.getTextoFiltro() +"' en la base de datos.", "ERROR!", JOptionPane.ERROR_MESSAGE);
		}else{
			panelVentanaPrincipal.cargarTabla1(datos, cabecera, types);
		}
		
	}

	private String[] obtenerColumnas() {
		return new String[]{"DNI","NOMBRE","APELLIDO","TELEFONO"};
	}
    
	private Object[][] buscarJuego(String filtro) {
        HibernateUtil.openSessionAndBindToThread();
        try {
        	String texto = panelVentanaPrincipal.getTextoFiltro();
			JuegoDAO juegoDao = new JuegoDAO();
			
			switch(filtro){
			case "NOMBRE":
				return obtenerListaJuego(juegoDao.buscarJuegoPorNombre(texto));
			case "EDAD":
				return obtenerListaJuego(juegoDao.buscarJuegoPorEdad(texto));
			case "PRECIO":
				return obtenerListaJuego(juegoDao.buscarJuegoPorPrecio(texto));
			case "TODO":
				return obtenerListaJuego(juegoDao.obtenerTodo());
			}
			
		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}
		
		
		return null;
	}
	
	private Object[][] obtenerListaJuego(List<Juego> juegos) {
		Object[][] datos = null;
		
		if (juegos.size() != 0){
			datos = new Object[juegos.size()][3];
			
			for (int i = 0; i < juegos.size(); i++){
				datos[i][0] = juegos.get(i).getNombre();
				datos[i][1] = juegos.get(i).getEdadMinima();
				datos[i][2] = juegos.get(i).getPrecio();
			}
		}
		
		return datos;
	}

}
