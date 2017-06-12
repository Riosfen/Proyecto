package vista.Factura;

import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import modelo.ModeloTablaPersonal;

/**
 *
 * @author samo_
 */
@SuppressWarnings("serial")
public class VistaFacturaCliente extends javax.swing.JPanel {

    public VistaFacturaCliente() {
        initComponents();
        this.setBorder(new EmptyBorder(80, 80, 80, 80));
    }

    /**
     * Se agregan a los componentes que lo necesiten para controlarlos desde otra clase.
     * 
     * @param e ActionListener
     */
    public void setControlador(ActionListener e){
        jButtonEliminar.addActionListener(e);
        jTextFieldFiltro.addActionListener(e);
        jButtonBuscar.addActionListener(e);
        jButton1.addActionListener(e);
        
        jButton1.setActionCommand("eliminarCompra");
        jButtonEliminar.setActionCommand("eliminar");
        jTextFieldFiltro.setActionCommand("buscar");
        jButtonBuscar.setActionCommand("buscar");
        
    }
    
    /**
     * 
     * @return devuelve un String con el item seleccionado del JComboBox
     */
    public String getFiltro(){
    	return jComboBoxFiltro.getSelectedItem().toString();
    }
    
    /**
     * 
     * @return devuelve un String con el contenido de JTextField
     */
    public String getTextoFiltro(){
    	return jTextFieldFiltro.getText().toString();
    }
    
    /**
     * 
     * @param filtro String[] se carga el JComboBox con el filtro
     */
    public void cargarFiltro(String[] filtro){
    	jComboBoxFiltro.setModel(new DefaultComboBoxModel<String>(filtro));
    }
    
    /**
     * 
     * @param Juegos Object[][] se carga los datos de la tabla
     * @param cabecera String[] se carga la cabecera de la tabla
     */
    public void cargarTablaCliente(Object[][] Juegos, String[] cabecera){ 
    	ModeloTablaPersonal myModeloTabla = new ModeloTablaPersonal(cabecera, Juegos);
        jTableUsuario.setModel(myModeloTabla);
    }
    
    public JTable getTablaCliente() {
    	return jTableUsuario;
	}

    /**
     * 
     * @param Juegos Object[][] se carga los datos de la tabla
     * @param cabecera String[] se carga la cabecera de la tabla
     */
    public void cargarTablaDetalle(Object[][] Juegos, String[] cabecera){ 
    	ModeloTablaPersonal myModeloTabla = new ModeloTablaPersonal(cabecera, Juegos);
    	jTableCompra.setModel(myModeloTabla);
    }
    
    public JTable getTablaDetalle() {
		return jTableCompra;
	}

    /**
     * 
     * @param Juegos Object[][] se carga los datos de la tabla
     * @param cabecera String[] se carga la cabecera de la tabla
     */
    public void cargarTablaCompra(Object[][] Juegos, String[] cabecera){ 
    	ModeloTablaPersonal myModeloTabla = new ModeloTablaPersonal(cabecera, Juegos);
    	jTableDetalle.setModel(myModeloTabla);
    }
    
	public JTable getTablaCompra() {
		return jTableDetalle;
	}
                      
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabelFiltro = new javax.swing.JLabel();
        jComboBoxFiltro = new javax.swing.JComboBox<>();
        jTextFieldFiltro = new javax.swing.JTextField();
        jScrollPaneTabla = new javax.swing.JScrollPane();
        jTableUsuario = new javax.swing.JTable();
        jButtonEliminar = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDetalle = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCompra = new javax.swing.JTable();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        jLabelFiltro.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelFiltro.setText("Filtro");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 20, 0);
        add(jLabelFiltro, gridBagConstraints);

        jComboBoxFiltro.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jComboBoxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 20, 0);
        add(jComboBoxFiltro, gridBagConstraints);

        jTextFieldFiltro.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        add(jTextFieldFiltro, gridBagConstraints);

        jScrollPaneTabla.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jTableUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jScrollPaneTabla.setViewportView(jTableUsuario);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jScrollPaneTabla, gridBagConstraints);

        jButtonEliminar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonEliminar.setText("ELIMINAR ARTÍCULO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        add(jButtonEliminar, gridBagConstraints);

        jButtonBuscar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonBuscar.setText("Buscar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 20, 0);
        add(jButtonBuscar, gridBagConstraints);

        jTableDetalle.setModel(new javax.swing.table.DefaultTableModel(null, new String [] {"Fecha compra", "Artículos comprados", "Total gastado"}));
        jScrollPane1.setViewportView(jTableDetalle);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jScrollPane1, gridBagConstraints);
        
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        add(jSeparator2, gridBagConstraints);

        jTableCompra.setModel(new javax.swing.table.DefaultTableModel(null, new String [] {"Nombre", "Cantidad", "Precio"}));
        jScrollPane2.setViewportView(jTableCompra);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jScrollPane2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 20, 0);
        add(jSeparator3, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridLayout(0, 1, 0, 80));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setText("ELIMINAR COMPRA");
        jPanel1.add(jButton1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridheight = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jPanel1, gridBagConstraints);
    }// </editor-fold>                        


    // Variables declaration - do not modify                        
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;               
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JComboBox<String> jComboBoxFiltro;
    private javax.swing.JLabel jLabelFiltro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPaneTabla;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTableCompra;
    private javax.swing.JTable jTableDetalle;
    private javax.swing.JTable jTableUsuario;
    private javax.swing.JTextField jTextFieldFiltro;
    // End of variables declaration    
	
}
