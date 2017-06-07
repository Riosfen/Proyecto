package vista.Almacen;

import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.EmptyBorder;
import modelo.ModeloTablaPersonal;


@SuppressWarnings("serial")
public class VistaBuscarAlmacen extends javax.swing.JPanel {

    public VistaBuscarAlmacen() {
        initComponents();
        this.setBorder(new EmptyBorder(80, 80, 80, 80));
    }
    
    public void setControlador(ActionListener e){
        jButtonEditar.addActionListener(e);
        jButtonEliminar.addActionListener(e);
        
        jButtonEditar.setActionCommand("editar");
        jButtonEliminar.setActionCommand("eliminar");
        
    }
    
    public String getFiltro(){
    	return jComboBoxFiltro.getSelectedItem().toString();
    }
    public String getTextoFiltro(){
    	return jTextFieldFiltro.getText().toString();
    }
    
    public String getJuegoNombre(){
    	String nombre = null;
    	int linea = jTableUsuario.getSelectedRow();
    	if (linea != -1){
    		nombre = jTableUsuario.getValueAt(linea, 0).toString();
    	}
    	
    	return nombre;
    }
    
    public void cargarFiltro(String[] filtro){
    	jComboBoxFiltro.setModel(new DefaultComboBoxModel<String>(filtro));
    }
    public void cargarTabla(Object[][] Juegos, String[] cabecera, @SuppressWarnings("rawtypes") Class[] types){ 
    	ModeloTablaPersonal myModeloTabla = new ModeloTablaPersonal(cabecera, Juegos, types);
        jTableUsuario.setModel(myModeloTabla);
    }
              
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabelImagen = new javax.swing.JLabel();
        jLabelDescripcion = new javax.swing.JLabel();
        jLabelFiltro = new javax.swing.JLabel();
        jComboBoxFiltro = new javax.swing.JComboBox<>();
        jTextFieldFiltro = new javax.swing.JTextField();
        jScrollPaneTabla = new javax.swing.JScrollPane();
        jTableUsuario = new javax.swing.JTable();
        jButtonEditar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setLayout(new java.awt.GridBagLayout());

        jLabelImagen.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jLabelImagen, gridBagConstraints);

        jLabelDescripcion.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelDescripcion.setText("Buscar artículo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jLabelDescripcion, gridBagConstraints);

        jLabelFiltro.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelFiltro.setText("Filtro");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 20, 0);
        add(jLabelFiltro, gridBagConstraints);

        jComboBoxFiltro.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jComboBoxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 20, 0);
        add(jComboBoxFiltro, gridBagConstraints);

        jTextFieldFiltro.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        add(jTextFieldFiltro, gridBagConstraints);

        jScrollPaneTabla.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jTableUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jScrollPaneTabla.setViewportView(jTableUsuario);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jScrollPaneTabla, gridBagConstraints);

        jButtonEditar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonEditar.setText("EDITAR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        add(jButtonEditar, gridBagConstraints);

        jButtonEliminar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonEliminar.setText("ELIMINAR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        add(jButtonEliminar, gridBagConstraints);

        jButtonBuscar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonBuscar.setText("Buscar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 20, 0);
        add(jButtonBuscar, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(40, 0, 40, 0);
        add(jSeparator1, gridBagConstraints);
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JComboBox<String> jComboBoxFiltro;
    private javax.swing.JLabel jLabelDescripcion;
    private javax.swing.JLabel jLabelFiltro;
    private javax.swing.JLabel jLabelImagen;
    private javax.swing.JScrollPane jScrollPaneTabla;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableUsuario;
    private javax.swing.JTextField jTextFieldFiltro;
    // End of variables declaration                   
}