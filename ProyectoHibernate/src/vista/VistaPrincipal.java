package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import modelo.BigPanel;

@SuppressWarnings("serial")
public class VistaPrincipal extends javax.swing.JPanel {

    private static final String URL_ALMACEN = "recursos/almacen.png";
    private static final String URL_USUARIO = "recursos/usuario.png";
    private static final String URL_FACTURA = "recursos/factura.png";
    private static final String URL_VENTA = "recursos/venta.png";
    
    private final BigPanel barra;
    
    public VistaPrincipal(BigPanel barra) {
        this.barra = barra;
        initComponents();
        cargarAjustesComponentes();
        
    }
    
    //
    // Inicio configurar imagen y texto de los botones
    //
    private void cargarAjustesComponentes(){
        jPanelContenedor.setBorder(new EmptyBorder(80, 80, 80, 80));
        botonConImagenTexto(URL_ALMACEN, jButtonAlmacen);
        botonConImagenTexto(URL_FACTURA, jButtonFacturas);
        botonConImagenTexto(URL_USUARIO, jButtonUsuario);
        botonConImagenGrandeTexto(URL_VENTA, jButtonVenta);
        this.add(barra, BorderLayout.NORTH);
    }
    
    /**
     * Agrega una imagen arriba del texto
     * 
     * @param urlImagen Direccion de la imagen String
     * @param boton JButton afectado
     */
    private void botonConImagenGrandeTexto(String urlImagen, JButton boton){
        ImageIcon imagen = new ImageIcon(urlImagen);
        boton.setIcon(imagen);
        boton.setVerticalAlignment(SwingConstants.CENTER);
        boton.setHorizontalTextPosition(SwingConstants.CENTER);
        boton.setVerticalTextPosition(SwingConstants.BOTTOM);
    }

    /**
     * Agrega una imagen a la izquierda del texto
     * 
     * @param urlImagen Direccion de la imagen String
     * @param boton JButton afectado
     */
    private void botonConImagenTexto(String urlImagen, JButton boton){
        ImageIcon imagen = new ImageIcon(urlImagen);
        boton.setIcon(imagen);
        boton.setHorizontalAlignment(SwingConstants.CENTER);
        boton.setHorizontalTextPosition(SwingConstants.RIGHT);
        boton.setVerticalTextPosition(SwingConstants.CENTER);
    }
    //
    // Fin
    //

    /**
     * Se agregan a los componentes que lo necesiten para controlarlos desde otra clase.
     * 
     * @param c ActionListener
     */
     public void setControlador(ActionListener c) {
         jButtonAlmacen.setActionCommand("almacen");
         jButtonUsuario.setActionCommand("usuario");
         jButtonFacturas.setActionCommand("factura");
         jButtonVenta.setActionCommand("venta");
         
         jButtonAlmacen.addActionListener(c);
         jButtonUsuario.addActionListener(c);
         jButtonFacturas.addActionListener(c);
         jButtonVenta.addActionListener(c);
    }
     
     public BigPanel getBigPanel(){
         return barra;
     }

    private void initComponents() {
        @SuppressWarnings("unused")
		java.awt.GridBagConstraints gridBagConstraints;

        jPanelContenedor = new javax.swing.JPanel();
        jPanelIzquierda = new javax.swing.JPanel();
        jButtonAlmacen = new javax.swing.JButton();
        jButtonUsuario = new javax.swing.JButton();
        jButtonFacturas = new javax.swing.JButton();
        jPanelDerecha = new javax.swing.JPanel();
        jButtonVenta = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanelContenedor.setLayout(new java.awt.GridLayout(1, 2, 80, 80));

        jPanelIzquierda.setToolTipText("");
        jPanelIzquierda.setLayout(new java.awt.GridLayout(3, 1, 80, 80));

        jButtonAlmacen.setFont(new java.awt.Font("Tahoma", 1, 48)); 
        jButtonAlmacen.setText("ALMACEN");
        jPanelIzquierda.add(jButtonAlmacen);

        jButtonUsuario.setFont(new java.awt.Font("Tahoma", 1, 48)); 
        jButtonUsuario.setText("USUARIOS");
        jPanelIzquierda.add(jButtonUsuario);

        jButtonFacturas.setFont(new java.awt.Font("Tahoma", 1, 48)); 
        jButtonFacturas.setText("FACTURAS");
        jPanelIzquierda.add(jButtonFacturas);

        jPanelContenedor.add(jPanelIzquierda);

        jPanelDerecha.setLayout(new java.awt.GridLayout());

        jButtonVenta.setFont(new java.awt.Font("Tahoma", 1, 48)); 
        jButtonVenta.setText("NUEVA VENTA");
        jPanelDerecha.add(jButtonVenta);

        jPanelContenedor.add(jPanelDerecha);

        add(jPanelContenedor, java.awt.BorderLayout.CENTER);
    }
    private javax.swing.JButton jButtonAlmacen;
    private javax.swing.JButton jButtonFacturas;
    private javax.swing.JButton jButtonUsuario;
    private javax.swing.JButton jButtonVenta;
    private javax.swing.JPanel jPanelContenedor;
    private javax.swing.JPanel jPanelDerecha;
    private javax.swing.JPanel jPanelIzquierda;

}
