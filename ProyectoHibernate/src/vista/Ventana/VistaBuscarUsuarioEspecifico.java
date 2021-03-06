package vista.Ventana;

import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.EmptyBorder;

import modelo.ModeloTablaPersonal;

@SuppressWarnings("serial")
public class VistaBuscarUsuarioEspecifico extends javax.swing.JPanel {

    public VistaBuscarUsuarioEspecifico() {
        initComponents();
        this.setBorder(new EmptyBorder(80, 80, 80, 80));
    }

    /**
     * Se agregan a los componentes que lo necesiten para controlarlos desde otra clase.
     * 
     * @param e ActionListener
     */
    public void setControlador(ActionListener e){
        jButtonSeleccionar.addActionListener(e);
        jButtonCancelar.addActionListener(e);
        jButtonBuscar.addActionListener(e);
        jTextFieldFiltro.addActionListener(e);
        
        jButtonSeleccionar.setActionCommand("seleccionar");
        jButtonCancelar.setActionCommand("cancelar");
        jButtonBuscar.setActionCommand("buscar");
        jTextFieldFiltro.setActionCommand("buscar");
    }
    
    public String getFiltro(){
    	return jComboBoxFiltro.getSelectedItem().toString();
    }
    public String getTextoFiltro(){
    	return jTextFieldFiltro.getText().toString();
    }
    public String getClienteDni(){
    	String dni = null;
    	int linea = jTableUsuario.getSelectedRow();
    	if (linea != -1){
    		dni = jTableUsuario.getValueAt(linea, 0).toString();
    	}
    	
    	return dni;
    }
     /**
      * 
      * @param filtro String[] carga el JComboBox
      */
    public void cargarFiltro(String[] filtro){
    	jComboBoxFiltro.setModel(new DefaultComboBoxModel<String>(filtro));
    }
    
    /**
     * 
     * @param clientes Object[][] carga los datos a la tabla
     * @param cabecera String[] carga los datos de la cabecera a la tabla
     */
    public void cargarTabla(Object[][] clientes, String[] cabecera){ 
    	ModeloTablaPersonal myModeloTabla = new ModeloTablaPersonal(cabecera, clientes);
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
        jButtonSeleccionar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setLayout(new java.awt.GridBagLayout());

        jLabelImagen.setFont(new java.awt.Font("Tahoma", 0, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jLabelImagen, gridBagConstraints);

        jLabelDescripcion.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabelDescripcion.setText("Buscar usuario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jLabelDescripcion, gridBagConstraints);

        jLabelFiltro.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabelFiltro.setText("Filtro");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 20, 0);
        add(jLabelFiltro, gridBagConstraints);

        jComboBoxFiltro.setFont(new java.awt.Font("Tahoma", 0, 24)); 
        jComboBoxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 20, 0);
        add(jComboBoxFiltro, gridBagConstraints);

        jTextFieldFiltro.setFont(new java.awt.Font("Tahoma", 0, 24)); 
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        add(jTextFieldFiltro, gridBagConstraints);

        jScrollPaneTabla.setFont(new java.awt.Font("Tahoma", 0, 18));

        jTableUsuario.setFont(new java.awt.Font("Tahoma", 0, 18));
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

        jButtonSeleccionar.setFont(new java.awt.Font("Tahoma", 0, 24)); 
        jButtonSeleccionar.setText("SELECCIONAR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        add(jButtonSeleccionar, gridBagConstraints);

        jButtonCancelar.setFont(new java.awt.Font("Tahoma", 0, 24)); 
        jButtonCancelar.setText("CANCELAR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        add(jButtonCancelar, gridBagConstraints);

        jButtonBuscar.setFont(new java.awt.Font("Tahoma", 0, 24)); 
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
    }


    private javax.swing.JButton jButtonSeleccionar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JComboBox<String> jComboBoxFiltro;
    private javax.swing.JLabel jLabelDescripcion;
    private javax.swing.JLabel jLabelFiltro;
    private javax.swing.JLabel jLabelImagen;
    private javax.swing.JScrollPane jScrollPaneTabla;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableUsuario;
    private javax.swing.JTextField jTextFieldFiltro;
}
