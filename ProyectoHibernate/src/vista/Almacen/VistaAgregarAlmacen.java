package vista.Almacen;

import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.border.EmptyBorder;

import persistencia.TipoJuego;

@SuppressWarnings("serial")
public class VistaAgregarAlmacen extends javax.swing.JPanel {
    
    @SuppressWarnings("unused")
	private String nombreTipo;
    
    public VistaAgregarAlmacen() {
        initComponents();
        cargarDatos();
    }
    
    private void cargarDatos(){
        this.setBorder(new EmptyBorder(80, 80, 80, 80));
        JComboBoxTipoJuego.setModel(new DefaultComboBoxModel<TipoJuego>(TipoJuego.values()));
        
    }
    
    public void setControlador(ActionListener e){
        jButtonAgregar.addActionListener(e);
        jButtonLimpiar.addActionListener(e);
        
        jButtonAgregar.setActionCommand("agregar");
        jButtonLimpiar.setActionCommand("limpiar");
        
    }
    
    public String getNombre(){
    	return jTextFieldNombre.getText().toString();
    }
    public int getEdadMinima(){
    	int resul = -1;
    	
		try {
			resul = Integer.valueOf(jFormattedTextFieldEdadMinima.getText().toString());
		} catch (NumberFormatException e) {}
		
    	return resul;
    }
    
    public double getPrecio(){
    	double resul = -1;
    	
		try {
			resul = Double.valueOf(jFormattedTextFieldPrecio.getValue().toString());
		} catch (NullPointerException e) {}
		
    	return resul;
    }
    
    public TipoJuego getTipoJuego(){
    	TipoJuego tipo = TipoJuego.NO_DEFINIDO;
    	
    	try {
			tipo = TipoJuego.valueOf(JComboBoxTipoJuego.getSelectedItem().toString());
		} catch (NullPointerException e) {}
    	
        return tipo;
        
    }
    
    public void limpiarDatos() {
        jFormattedTextFieldEdadMinima.setText("");
        jFormattedTextFieldPrecio.setText("");
        jTextFieldNombre.setText("");
    }

    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroupSexo = new javax.swing.ButtonGroup();
        jLabelDni = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelApellido = new javax.swing.JLabel();
        jLabelTelefono = new javax.swing.JLabel();
        jLabelDireccion = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jButtonAgregar = new javax.swing.JButton();
        jButtonLimpiar = new javax.swing.JButton();
        jLabelImagen = new javax.swing.JLabel();
        jLabelDescripcion = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        JComboBoxTipoJuego = new javax.swing.JComboBox<TipoJuego>();
        jLabelIdArticulo = new javax.swing.JLabel();
        jFormattedTextFieldPrecio = new javax.swing.JFormattedTextField();
        jFormattedTextFieldEdadMinima = new javax.swing.JFormattedTextField();

        setLayout(new java.awt.GridBagLayout());

        jLabelDni.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabelDni.setText("ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jLabelDni, gridBagConstraints);

        jLabelNombre.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabelNombre.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jLabelNombre, gridBagConstraints);

        jLabelApellido.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabelApellido.setText("Edad mínima");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jLabelApellido, gridBagConstraints);

        jLabelTelefono.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabelTelefono.setText("Precio");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jLabelTelefono, gridBagConstraints);

        jLabelDireccion.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabelDireccion.setText("Tipo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jLabelDireccion, gridBagConstraints);

        jTextFieldNombre.setFont(new java.awt.Font("Tahoma", 0, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jTextFieldNombre, gridBagConstraints);

        jButtonAgregar.setFont(new java.awt.Font("Tahoma", 0, 24));
        jButtonAgregar.setText("Agregar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jButtonAgregar, gridBagConstraints);

        jButtonLimpiar.setFont(new java.awt.Font("Tahoma", 0, 24));
        jButtonLimpiar.setText("Limpiar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jButtonLimpiar, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jLabelImagen, gridBagConstraints);

        jLabelDescripcion.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabelDescripcion.setText("AGREGAR UN NUEVO ARTÍCULO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jLabelDescripcion, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 40;
        add(jSeparator3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 40;
        gridBagConstraints.insets = new java.awt.Insets(40, 0, 40, 0);
        add(jSeparator1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(JComboBoxTipoJuego, gridBagConstraints);

        jLabelIdArticulo.setFont(new java.awt.Font("Tahoma", 0, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jLabelIdArticulo, gridBagConstraints);

        jFormattedTextFieldPrecio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.##"))));
        jFormattedTextFieldPrecio.setFont(new java.awt.Font("Tahoma", 0, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jFormattedTextFieldPrecio, gridBagConstraints);

        jFormattedTextFieldEdadMinima.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedTextFieldEdadMinima.setFont(new java.awt.Font("Tahoma", 0, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jFormattedTextFieldEdadMinima, gridBagConstraints);
    }


    @SuppressWarnings("unused")
	private javax.swing.ButtonGroup buttonGroupSexo;
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JComboBox<TipoJuego> JComboBoxTipoJuego;
    private javax.swing.JFormattedTextField jFormattedTextFieldEdadMinima;
    private javax.swing.JFormattedTextField jFormattedTextFieldPrecio;
    private javax.swing.JLabel jLabelApellido;
    private javax.swing.JLabel jLabelDescripcion;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelDni;
    private javax.swing.JLabel jLabelIdArticulo;
    private javax.swing.JLabel jLabelImagen;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextFieldNombre;


}
