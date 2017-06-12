package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import patronDAO.ClienteDAO;
import patronDAO.LineaVentaDAO;
import patronDAO.VentaDAO;
import persistencia.Cliente;
import persistencia.HibernateUtil;
import persistencia.LineaVenta;
import persistencia.Venta;
import vista.VistaFactura;
import vista.Factura.VistaFacturaCliente;

public class ControladorFactura implements ActionListener{
    
    private final VistaFactura panelFactura;
    private final JDialog ventna;
    private VistaFacturaCliente panelFacturaCliente;
    
    private Cliente cliente;
    private List<Venta> listaVenta;
    private List<LineaVenta> listaLineaVenta;
    
    public ControladorFactura(VistaFactura panelFactura, JDialog ventana){
        this.ventna = ventana;
        this.panelFactura = panelFactura;
        this.panelFacturaCliente = new VistaFacturaCliente();
        this.panelFactura.getBigPanel().controladorSalir(this, "atras");
        this.panelFactura.getBigPanel().controladorAyuda(this, "ayuda");
        panelFacturaCliente.setControlador(this);
        panelFactura.setPanelDerecho(panelFacturaCliente);
        
        panelFacturaCliente.cargarFiltro(new String[]{"DNI", "APELLIDO" ,"NOMBRE"});
        panelFacturaCliente.cargarTablaCliente(obtenerListaCliente(), new String[]{"DNI", "Apellido", "Nombre", "Compras realizadas"});
        asignarClienteMouseListener();
        asignarCompraMouseListener();
        
    }
    
    private Object[][] obtenerListaCliente() {
		HibernateUtil.openSessionAndBindToThread();
		Object[][] datos;
		try {
			List<Cliente> clientes = new ClienteDAO().obtenerTodoCountVenta();
			datos = new Object[clientes.size()][6];
			
			for (int i = 0; i < clientes.size(); i++){
				datos[i][0] = clientes.get(i).getDni();
				datos[i][1] = clientes.get(i).getApellido();
				datos[i][2] = clientes.get(i).getNombre();
				datos[i][3] = clientes.get(i).getVentas().size();
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
                System.out.println("no hay ayuda todaía");
                break;
            case "buscar":
            	Object[][] datos = null;
    			String[] cabecera = new String[]{"DNI", "Apellido", "Nombre", "Compras realizadas"};
    			
    			try {
    				datos = buscarJuego(panelFacturaCliente.getFiltro());
    				
    			} catch (NullPointerException e2) {
    				JOptionPane.showMessageDialog(null, "Base de datos vacía, considere introducir datos.", "ERROR!", JOptionPane.ERROR_MESSAGE);
    			} catch (NumberFormatException e2){
    				JOptionPane.showMessageDialog(null, "Asegurese de escribir un número mayor a 0.", "ERROR!", JOptionPane.ERROR_MESSAGE);
    			}
    			
    			if (datos == null){
    				JOptionPane.showMessageDialog(null, "No se ha encontrado nada relacionado con '"+ panelFacturaCliente.getTextoFiltro() +"' en la base de datos.", "ERROR!", JOptionPane.ERROR_MESSAGE);
    			}else{
    				panelFacturaCliente.cargarTablaCliente(datos, cabecera);
    			}
                break;
            case "eliminar":
            	try {
                	int i = panelFacturaCliente.getTablaDetalle().getSelectedRow();
                	
                	new LineaVentaDAO().borrar(listaLineaVenta.get(i));
                	
                	if (listaLineaVenta == null){
                		int linea = panelFacturaCliente.getTablaCompra().getSelectedRow();
                		new VentaDAO().borrar(listaVenta.get(linea));
                	}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "No se ha encontrado el artículo o no se ha seleccionado ninguno.", "ERROR!", JOptionPane.ERROR_MESSAGE);
				}
            	
                break;
            case "eliminarCompra":
            	try {
	            	int filaCompra = panelFacturaCliente.getTablaCompra().getSelectedRow();
	            	
	            	new VentaDAO().borrar(listaVenta.get(filaCompra));
		
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "No se ha encontrado la venta o no se ha seleccionado ninguna.", "ERROR!", JOptionPane.ERROR_MESSAGE);
				}
                break;
        }
    }
    
    private Object[][] buscarJuego(String filtro) {
        HibernateUtil.openSessionAndBindToThread();
        try {
        	String texto = panelFacturaCliente.getTextoFiltro();
			ClienteDAO clienteDao = new ClienteDAO();
			
			switch(filtro){
			case "DNI":
				return obtenerListaCliente(clienteDao.buscarClientePorDni(texto));
			case "APELLIDO":
				return obtenerListaCliente(clienteDao.buscarClientePorApellido(texto));
			case "NOMBRE":
				return obtenerListaCliente(clienteDao.buscarClientePorNombre(texto));
			case "TODO":
				return obtenerListaCliente(clienteDao.obtenerTodoCountVenta());
			}
			
		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}
		
		
		return null;
	}
	
	private Object[][] obtenerListaCliente(List<Cliente> juegos) {
		Object[][] datos = null;
		
		if (juegos.size() != 0){
			datos = new Object[juegos.size()][4];
			
			for (int i = 0; i < juegos.size(); i++){
				datos[i][0] = juegos.get(i).getDni();
				datos[i][1] = juegos.get(i).getApellido();
				datos[i][2] = juegos.get(i).getNombre();
				datos[i][3] = juegos.get(i).getVentas().size();
			}
		}
		
		return datos;
	}
	
	private void asignarCompraMouseListener() {
    	panelFacturaCliente.getTablaCompra().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {	}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				HibernateUtil.openSessionAndBindToThread();
				
		        try {
		        	
		        	int i = panelFacturaCliente.getTablaCompra().getSelectedRow();
		        	
					listaLineaVenta = listaVenta.get(i).getLineaVentas();
		        	Object[][] datos = new Object[listaLineaVenta.size()][3];
					
					for (int j = 0; j < listaLineaVenta.size(); j++) {
						int cantidad = listaLineaVenta.get(j).getCantidad();
						String nombre = listaLineaVenta.get(j).getJuego().getNombre();
						double precio = listaLineaVenta.get(j).getJuego().getPrecio();

						datos[j][0] = nombre;
						datos[j][1] = cantidad;
						datos[j][2] = precio;
					}
	        	
		        	panelFacturaCliente.cargarTablaDetalle(datos, new String [] {"Nombre", "Cantidad", "Precio"});
		        	
				} finally {
					HibernateUtil.closeSessionAndUnbindFromThread();
				}
			}
		});
    }
    
    private void asignarClienteMouseListener() {
    	panelFacturaCliente.getTablaCliente().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {	}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				HibernateUtil.openSessionAndBindToThread();

	        	panelFacturaCliente.cargarTablaDetalle(null, new String [] {"Nombre", "Cantidad", "Precio"});
				
				int fila = panelFacturaCliente.getTablaCliente().getSelectedRow();
		        String dni = panelFacturaCliente.getTablaCliente().getValueAt(fila, 0).toString();
		        try {
		        	try {
			            cliente = new ClienteDAO().getVentasClientePorDni(dni);
			            
			            listaVenta = cliente.getVentas();
			            Object[][] datos = new Object[listaVenta.size()][3];
			            
			            for (int i = 0; i < listaVenta.size(); i++) {
							datos[i][0] = listaVenta.get(i).getFechaVenta();
							datos[i][1] = listaVenta.get(i).getLineaVentas().size();
							
							List<LineaVenta> listaLineaVenta = listaVenta.get(i).getLineaVentas();
							int precioTotal = 0;
							
							for (LineaVenta lineaVenta : listaLineaVenta) {
								precioTotal += lineaVenta.getCantidad() * lineaVenta.getJuego().getPrecio();
							}
							
							datos[i][2] = precioTotal;
						}
			            
			            panelFacturaCliente.cargarTablaCompra(datos, new String[]{"Fecha compra", "Artículos comprados", "Total gastado"});
			            
			            
			         } catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "No se encuentra el cliente especificado o no ha efectuado ninguna compra aun.", "ERROR!!", JOptionPane.ERROR_MESSAGE);
			         }

				} finally {
					HibernateUtil.closeSessionAndUnbindFromThread();
				}
			}
		});
    }
    
}
