package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JDialog;

import patronDAO.JuegoDAO;

import persistencia.HibernateUtil;
import persistencia.Juego;
import persistencia.TipoJuego;
import vista.Almacen.VistaAgregarAlmacen;
import vista.Almacen.VistaBuscarAlmacen;
import vista.VistaAlmacen;

public class ControladorAlmacen implements ActionListener{
    
    private final VistaAlmacen panelAlmacen;
    private final JDialog ventana;
    private final VistaAgregarAlmacen panelAgregarAlmacen;
    private final VistaBuscarAlmacen panelBuscarAlmacen;
    
    public ControladorAlmacen(VistaAlmacen panelAlmacen, JDialog ventana){
        this.ventana = ventana;
        this.panelAgregarAlmacen = new VistaAgregarAlmacen();
        this.panelBuscarAlmacen = new VistaBuscarAlmacen();
        this.panelAlmacen = panelAlmacen;
        this.panelAlmacen.getBigPanel().controladorSalir(this, "atras");
        this.panelAlmacen.getBigPanel().controladorAyuda(this, "ayuda");
        this.panelAlmacen.setActivarBotones();
        
        panelAgregarAlmacen.setControlador(new ControladorAniadirAlmacen(panelAgregarAlmacen));
        panelBuscarAlmacen.setControlador(new ControladorBuscarAlmacen(panelBuscarAlmacen, panelAlmacen));
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
                panelAlmacen.setPanelDerecho(panelAgregarAlmacen);
                panelAlmacen.getBotonAgregar().setEnabled(false);
                panelAlmacen.getBotonBuscar().setEnabled(true);
                
                break;
                
            case "ventana_buscar":
                panelAlmacen.setPanelDerecho(panelBuscarAlmacen);
                panelBuscarAlmacen.cargarFiltro(obtenerColumnas());
                
                String[] columnas = new String[]{"Nombre", "Edad mínima", "Precio", "Tipo juego"};
                @SuppressWarnings("rawtypes") Class[] types = new Class[] {String.class, String.class, String.class, TipoJuego.class};
                
                panelBuscarAlmacen.cargarTabla(obtenerListaJuegos(),columnas, types);
                panelAlmacen.getBotonAgregar().setEnabled(true);
                panelAlmacen.getBotonBuscar().setEnabled(false);
                break;
        }
    }
    
    private Object[][] obtenerListaJuegos() {
		HibernateUtil.openSessionAndBindToThread();
		Object[][] datos;
		try {
			List<Juego> juegos = new JuegoDAO().obtenerTodo();
			datos = new Object[juegos.size()][4];
			
			for (int i = 0; i < juegos.size(); i++){
				datos[i][0] = juegos.get(i).getNombre();
				datos[i][1] = juegos.get(i).getEdadMinima();
				datos[i][2] = juegos.get(i).getPrecio();
				datos[i][3] = juegos.get(i).getTipoJuego();
			}
			
		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}
		
		return datos;
	}

	private String[] obtenerColumnas() {
		return new String[]{"NOMBRE","EDAD","PRECIO"};
	}
    
}
