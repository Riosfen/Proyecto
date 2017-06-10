package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import patronDAO.ClienteDAO;
import patronDAO.JuegoDAO;

import persistencia.Cliente;
import persistencia.HibernateUtil;
import persistencia.Juego;
import persistencia.TipoJuego;
import vista.VistaVenta;
import vista.Ventana.VistaBuscarUsuarioEspecifico;
import vista.Ventana.VistaVentaPrincipal;

public class ControladorVenta implements ActionListener{
    
    private final VistaVenta panelVenta;
    private final JDialog ventna;
    private VistaBuscarUsuarioEspecifico panelBuscarUsuario;
    private VistaVentaPrincipal panelVentanaPrincipal;
    
    private Cliente cliente;
    
    public ControladorVenta(VistaVenta panelVenta, JDialog ventana){
        this.ventna = ventana;
        this.panelVenta = panelVenta;
        this.panelBuscarUsuario = new VistaBuscarUsuarioEspecifico();
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

    /*
     * Carga la tabla con todos los articulos
     */
	private void cargarFiltroJuego() {
		panelVentanaPrincipal.cargarFiltro(new String[]{"NOMBRE","EDAD","PRECIO", "STOCK"});
        
        String[] columnas = new String[]{"Nombre", "Edad mínima", "Precio", "Tipo", "Stock"};
        @SuppressWarnings("rawtypes") Class[] types = new Class[] {String.class, String.class, String.class, TipoJuego.class, String.class};

        panelVentanaPrincipal.cargarTabla1(obtenerListaJuegos(),columnas, types);
        panelVentanaPrincipal.cargarTabla2(new Object[][]{{"","",""}}, new String[]{"Nombre artículo", "Stock", "Precio"}, new Class[]{String.class, String.class, String.class});
	}
    
    private Object[][] obtenerListaJuegos() {
		HibernateUtil.openSessionAndBindToThread();
		Object[][] datos;
		try {
			List<Juego> juegos = new JuegoDAO().obtenerTodo();
			datos = new Object[juegos.size()][5];
			
			for (int i = 0; i < juegos.size(); i++){
				datos[i][0] = juegos.get(i).getNombre();
				datos[i][1] = juegos.get(i).getEdadMinima();
				datos[i][2] = juegos.get(i).getPrecio();
				datos[i][3] = juegos.get(i).getTipoJuego();
				datos[i][4] = juegos.get(i).getStock();
			}
			
		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}
		
		return datos;
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "atras":
                ventna.dispose();
                break;
            case "ayuda":
                System.out.println("no hay ayuda todavï¿½a");//TODO hacer ayuda
                break;
            case "buscarArticulo":
        		buscarArticulo();
        			
                break;
            case "buscarUsuario":
            	buscarUsuario();
            	
                break;
            case "cobrar":
            	//TODO aqui se utiliza el cliente para agregarlo a una venta, puede ser null
            	
                break;
            case "limpiar":
            	int resul = JOptionPane.showConfirmDialog(null, "¿Seguro que desea borrar toda la compra?", "AVISO!!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            	if (resul == 0){
            		panelVentanaPrincipal.limpiarTablaCompra();
            	}
            	
                break;
            case "aniadirArticulo":
                HibernateUtil.openSessionAndBindToThread();
                Juego j = null;
				JuegoDAO juegoDao = new JuegoDAO();
				int stock = panelVentanaPrincipal.getCantidad();
				
            	try{
            		try {
            			
                    	j = juegoDao.getJuegoPorNombre(panelVentanaPrincipal.getJuegoNombre());
                    	System.out.println(panelVentanaPrincipal.getJuegoNombre());
                    	
                    	if (j.getStock()-stock < 0){
        					JOptionPane.showMessageDialog(null, "Se ha superado el limite de stock del artículo "+ j.getNombre() + ".\nEl maximo que se puede comprar es de "+ j.getStock(), "ERROR!", JOptionPane.ERROR_MESSAGE);
                    	}else{
                        	j.setStock(j.getStock()-stock);
                        	juegoDao.actualizar(j);
                    		
                        	Object[] fila = new Object[]{j.getNombre(), stock, j.getPrecio()*stock};
                        	panelVentanaPrincipal.tablaCompraAnniadirCompra(fila);
                        	
                    	}
    					
    				} catch (NullPointerException e2) {
    					JOptionPane.showMessageDialog(null, "No se ha encontrado el artículo seleccionado o no se ha seleccionado ninguno.", "ERROR!", JOptionPane.ERROR_MESSAGE);
    				}
            		
		        } finally {
					HibernateUtil.closeSessionAndUnbindFromThread();
				}
            	
                break;
            case "aumentarCantidad":
            	int linea = panelVentanaPrincipal.getselectedRowTablaCompra();
            	if (linea != -1){
                	panelVentanaPrincipal.setCantidadTablaCompraMas(linea);
            	}
            	
                break;
            case "disminuirCanitdad":
            	int linea2 = panelVentanaPrincipal.getselectedRowTablaCompra();
            	if (linea2 != -1){
                	panelVentanaPrincipal.setCantidadTablaCompraMenos(linea2);
            	}
            	
                break;
            case "eliminar":
            	HibernateUtil.openSessionAndBindToThread();
            	JuegoDAO juegoDa = new JuegoDAO();
            	
            	try{
	            	int stoc = panelVentanaPrincipal.getFilaSelecStock();
	            	String nombre = panelVentanaPrincipal.getFilaSelecNombre();
	            	
	            	Juego juego = juegoDa.getJuegoPorNombre(nombre);
	            	juego.setStock(juego.getStock()+stoc);
	            	
	            	juegoDa.actualizar(juego);
	            	
	            	panelVentanaPrincipal.eliminarFilaTablaCompra();
            	
            	} finally {
					HibernateUtil.closeSessionAndUnbindFromThread();
				}
            	
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
    
    /*
     * Todo los metodos de buscar articulo
     */
	private void buscarArticulo() {
		Object[][] datos = buscarJuego(panelVentanaPrincipal.getFiltro());
		String[] cabecera = new String[]{"Nombre", "Edad mínima", "Precio", "Tipo", "Stock"};
		@SuppressWarnings("rawtypes") Class[] types = new Class[] {String.class, String.class, String.class, TipoJuego.class, String.class};
		
		if (datos == null){
			JOptionPane.showMessageDialog(null, "No se ha encontrado nada relacionado con '"+ panelVentanaPrincipal.getTextoFiltro() +"' en la base de datos.", "ERROR!", JOptionPane.ERROR_MESSAGE);
		}else{
			panelVentanaPrincipal.cargarTabla1(datos, cabecera, types);
		}
		
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
				return obtenerListaJuego(juegoDao.buscarJuegoPorEdadMayor(Integer.parseInt(texto)));
			case "PRECIO":
				return obtenerListaJuego(juegoDao.buscarJuegoPorPrecioMayor(Double.parseDouble(texto)));
			case "STOCK":
				return obtenerListaJuego(juegoDao.buscarJuegoPorStockMayor(Integer.parseInt(texto)));
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
			datos = new Object[juegos.size()][5];
			
			for (int i = 0; i < juegos.size(); i++){
				datos[i][0] = juegos.get(i).getNombre();
				datos[i][1] = juegos.get(i).getEdadMinima();
				datos[i][2] = juegos.get(i).getPrecio();
				datos[i][3] = juegos.get(i).getTipoJuego();
				datos[i][4] = juegos.get(i).getStock();
			}
		}
		
		return datos;
	} 
	/*
     * Fin de los metodos de busqueda de articulos
     */
    
    /*
     * Todo los metodos de buscar clientes
     */
	private void buscarUsuario() {
		panelVenta.setPanelDerecho(panelBuscarUsuario);
		panelBuscarUsuario.cargarFiltro(new String[]{"DNI","NOMBRE","APELLIDO","TELEFONO"});
		
		String[] columnas = new String[]{"DNI", "Apellidos", "Nombre", "Teléfono", "Dirección", "Fecha de Nacimiento"};
		
		panelBuscarUsuario.cargarTabla(obtenerListaClientes(),columnas);
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
	
	/*
     * Fin de los metodos de busqueda de clientes
     */

	/*
	 * Todos los metodos de seleccionar usuario
	 */
	private void buscarCliente() {
		Object[][] datos = buscarCliente(panelBuscarUsuario.getFiltro());
		String[] cabecera = new String[]{"DNI", "Apellidos", "Nombre", "Teléfono", "Dirección", "Fecha de Nacimiento"};
		
		if (datos == null){
			JOptionPane.showMessageDialog(null, "No se ha encontrado nada relacionado con '"+ panelBuscarUsuario.getTextoFiltro() +"' en la base de datos.", "ERROR!", JOptionPane.ERROR_MESSAGE);
		}else{
			panelBuscarUsuario.cargarTabla(datos, cabecera);
		}
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
    
    // metodo para obtener el usuario seleccionado
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
	/*
	 * Fin de los metodos de seleccionar usuario
	 */

}
