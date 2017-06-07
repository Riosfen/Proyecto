package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JDialog;

import patronDAO.JuegoDAO;

import persistencia.HibernateUtil;
import persistencia.Juego;

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
                panelAgregarAlmacen.setControlador(new ControladorAniadirAlmacen(panelAgregarAlmacen));
                panelAlmacen.setPanelDerecho(panelAgregarAlmacen);
                break;
                
            case "ventana_buscar":
                panelBuscarAlmacen.setControlador(new ControladorBuscarAlmacen(panelBuscarAlmacen, panelAlmacen));
                panelAlmacen.setPanelDerecho(panelBuscarAlmacen);
                panelBuscarAlmacen.cargarFiltro(obtenerColumnas());
                
                String[] columnas = new String[]{"Nombre", "Edad mínima", "Precio"};
                @SuppressWarnings("rawtypes") Class[] types = new Class[] {String.class, String.class, String.class};
                
                panelBuscarAlmacen.cargarTabla(obtenerListaJuegos(),columnas, types);
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

	private String[] obtenerColumnas() {
		return new String[]{"NOMBRE","EDAD","PRECIO"};
	}
    
}
