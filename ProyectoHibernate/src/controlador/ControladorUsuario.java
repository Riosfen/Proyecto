package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JDialog;

import patronDAO.ClienteDAO;
import persistencia.Cliente;
import persistencia.HibernateUtil;
import vista.Usuario.VistaAgregarUsuario;
import vista.Usuario.VistaBuscarUsuario;
import vista.VistaUsuario;

public class ControladorUsuario implements ActionListener {
	
    private final VistaUsuario panelUsuario;
    private final JDialog ventana;
    private final VistaAgregarUsuario panelAgregarUsuario;
    private final VistaBuscarUsuario panelBuscarUsuario;
    
    public ControladorUsuario(VistaUsuario panelUsuario, JDialog ventana){
        this.ventana = ventana;
        this.panelBuscarUsuario = new VistaBuscarUsuario();
        this.panelAgregarUsuario = new VistaAgregarUsuario();
        this.panelUsuario = panelUsuario;
        this.panelUsuario.getBigPanel().controladorSalir(this, "atras");
        this.panelUsuario.getBigPanel().controladorAyuda(this, "ayuda");
        this.panelUsuario.setActivarBotones();
        
        panelAgregarUsuario.setControlador(new ControladorAniadirUsuario(panelAgregarUsuario));
        panelBuscarUsuario.setControlador(new ControladorBuscarUsuario(panelBuscarUsuario, panelUsuario));
        HibernateUtil.buildSessionFactory();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "atras":
                ventana.dispose();
                break;
                
            case "ayuda":
                System.out.println("no hay ayuda todavía");
                break;
                
            case "ventana_agregar":
                panelUsuario.setPanelDerecho(panelAgregarUsuario);
                panelUsuario.getBotonAgregar().setEnabled(false);
                panelUsuario.getBotonBuscar().setEnabled(true);
                
                break;
                
            case "ventana_buscar":
                panelUsuario.setPanelDerecho(panelBuscarUsuario);
                panelBuscarUsuario.cargarFiltro(obtenerColumnas());
                
                String[] columnas = new String[]{"DNI", "Apellidos", "Nombre", "Teléfono", "Dirección", "Fecha de Nacimiento"};
                
                panelBuscarUsuario.cargarTabla(obtenerListaClientes(),columnas);
                panelUsuario.getBotonAgregar().setEnabled(true);
                panelUsuario.getBotonBuscar().setEnabled(false);
                break;
        }
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

	private String[] obtenerColumnas() {
		return new String[]{"DNI","NOMBRE","APELLIDO","TELEFONO"};
	}
    
}
