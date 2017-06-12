package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import modelo.BigPanel;

@SuppressWarnings("serial")
public class VistaAlmacen extends javax.swing.JPanel {
    
    private static final String URL_AGREGAR = "recursos/anadir.png";
    private static final String URL_BUSCAR = "recursos/buscar.png";

    private final BigPanel barra;
    private JPanel panelPostizo;
     /**
      * 
      * @param barra BigPanel (bean proporcionado)
      */
    public VistaAlmacen(BigPanel barra) {
        this.barra = barra;
        initComponents();
        cargarAjustesComponentes();
    }
    
    private void cargarAjustesComponentes() {
        panelPostizo = new JPanel(new BorderLayout());
        this.add(barra, BorderLayout.NORTH);
        this.add(panelPostizo, BorderLayout.CENTER);
        jPanelListaBotones.setBorder(new EmptyBorder(80, 80, 80, 80));
        jScrollPaneListaBotones.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPaneListaBotones.getVerticalScrollBar().setUnitIncrement(15);
        botonConImagenGrandeTexto(URL_AGREGAR, jButtonAgregar);
        botonConImagenGrandeTexto(URL_BUSCAR, jButtonBuscar);
        
    }
    
    private void botonConImagenGrandeTexto(String urlImagen, JButton boton){
        ImageIcon imagen = new ImageIcon(urlImagen);
        boton.setIcon(imagen);
        boton.setVerticalAlignment(SwingConstants.CENTER);
        boton.setHorizontalTextPosition(SwingConstants.CENTER);
        boton.setVerticalTextPosition(SwingConstants.BOTTOM);
    }
    
    /**
     * Se agregan a los componentes que lo necesiten para controlarlos desde otra clase.
     * 
     * @param e ActionListener
     */
    public void setControlador(ActionListener e){
        jButtonAgregar.addActionListener(e);
        jButtonBuscar.addActionListener(e);
        
        jButtonAgregar.setActionCommand("ventana_agregar");
        jButtonBuscar.setActionCommand("ventana_buscar");
        
    }
    
    /**
     * Devuelve el beans BigPanel.
     * 
     * @return BigPanel.
     */
    public BigPanel getBigPanel(){
        return barra;
    }
    
    /**
     * Introduce el componente pasado por parametro al centro del contenedor superior.
     * 
     * @param panelDerecho Component generalmente JPanel, JScrollPanel...
     */
    public void setPanelDerecho(JPanel panelDerecho){
        panelPostizo.removeAll();
        panelPostizo.add(panelDerecho, java.awt.BorderLayout.CENTER);
        panelPostizo.updateUI();
        panelPostizo.repaint();
        
    }
    
    /**
     * Devuelve un Component JButton
     * 
     * @return JButton
     */
    public JButton getBotonAgregar(){
    	return jButtonAgregar;
    }
    
    /**
     * Devuelve un Component JButton
     * 
     * @return JButton
     */
    public JButton getBotonBuscar(){
    	return jButtonBuscar;
    }
    
    /**
     * Activa los botones {@code 
     * jButtonAgregar.setEnabled(true);
     * jButtonBuscar.setEnabled(true);}
     */
    public void setActivarBotones(){
    	jButtonAgregar.setEnabled(true);
    	jButtonBuscar.setEnabled(true);
    }
    
    private void initComponents() {

        jScrollPaneListaBotones = new javax.swing.JScrollPane();
        jPanelListaBotones = new javax.swing.JPanel();
        jButtonAgregar = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanelListaBotones.setLayout(new java.awt.GridLayout(0, 1, 80, 80));

        jButtonAgregar.setFont(new java.awt.Font("Tahoma", 1, 24));
        jButtonAgregar.setText("AGREGAR ARTICULO");
        jPanelListaBotones.add(jButtonAgregar);

        jButtonBuscar.setFont(new java.awt.Font("Tahoma", 1, 24));
        jButtonBuscar.setText("BUSCAR ARTICULO");
        jPanelListaBotones.add(jButtonBuscar);

        jScrollPaneListaBotones.setViewportView(jPanelListaBotones);

        add(jScrollPaneListaBotones, java.awt.BorderLayout.LINE_START);
    }

    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JPanel jPanelListaBotones;
    private javax.swing.JScrollPane jScrollPaneListaBotones;

}