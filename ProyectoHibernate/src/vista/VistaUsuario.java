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
public class VistaUsuario extends javax.swing.JPanel {

    private static final String URL_AGREGAR = "recursos/anadir.png";
    private static final String URL_BUSCAR = "recursos/buscar.png";
    
    //El panel postizo es el panel al que añadiremos los
    //diferentes paneles que tenga esa vista y refrescaremos.
    //
    private final BigPanel barra;
    private JPanel panelPostizo;
    
    public VistaUsuario(BigPanel barra) {
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
    
    public BigPanel getBigPanel(){
        return barra;
    }
    
    public void setPanelDerecho(JPanel panelDerecho){
        panelPostizo.removeAll();
        panelPostizo.add(panelDerecho, java.awt.BorderLayout.CENTER);
        panelPostizo.updateUI();
        panelPostizo.repaint();
        
    }
    
    public JButton getBotonAgregar(){
    	return jButtonAgregar;
    }
    
    public JButton getBotonBuscar(){
    	return jButtonBuscar;
    }
    
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
        jButtonAgregar.setText("AGREGAR USUARIO");
        jPanelListaBotones.add(jButtonAgregar);

        jButtonBuscar.setFont(new java.awt.Font("Tahoma", 1, 24));
        jButtonBuscar.setText("BUSCAR USUARIO");
        jPanelListaBotones.add(jButtonBuscar);

        jScrollPaneListaBotones.setViewportView(jPanelListaBotones);

        add(jScrollPaneListaBotones, java.awt.BorderLayout.LINE_START);
    }

    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JPanel jPanelListaBotones;
    private javax.swing.JScrollPane jScrollPaneListaBotones;
}
