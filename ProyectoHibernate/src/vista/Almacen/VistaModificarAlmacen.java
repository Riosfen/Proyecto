package vista.Almacen;

import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.border.EmptyBorder;

import persistencia.Juego;
import persistencia.TipoJuego;

@SuppressWarnings("serial")
public class VistaModificarAlmacen extends javax.swing.JPanel {
    
    private Juego juego;

    public VistaModificarAlmacen(Juego juego) {
        this.juego = juego;
        initComponents();
		inicializarJuego();
        this.setBorder(new EmptyBorder(80, 80, 80, 80));
        JComboBoxTipoJuego.setModel(new DefaultComboBoxModel<TipoJuego>(TipoJuego.values()));
        JComboBoxTipoJuego.setSelectedItem(juego.getTipoJuego());
        
    }
    
    public void inicializarJuego(){
		jLabelIdArticulo1.setText(String.valueOf(juego.getId()));
		jTextFieldNombre1.setText(juego.getNombre());
		jFormattedTextFieldEdadMinima1.setText(String.valueOf(juego.getEdadMinima()));
		jFormattedTextFieldPrecio1.setText(String.valueOf(juego.getPrecio()));
		JComboBoxTipoJuego.setSelectedItem(juego.getTipoJuego());
		JFormattedTextFieldStock.setText(String.valueOf(juego.getStock()));
		
	}

	public Juego getJuego() {
		return juego;
	}
	
	public void setControlador(ActionListener e) {
        jButtonAgregar1.addActionListener(e);
        jButtonLimpiar1.addActionListener(e);
        
        jButtonAgregar1.setActionCommand("modificar");
        jButtonLimpiar1.setActionCommand("limpiar");
		
	}
	
	public String getNombre(){
    	return jTextFieldNombre1.getText().toString();
    }
	public int getEdadMinima(){
    	int resul = -1;
    	
		try {
			resul = Integer.valueOf(jFormattedTextFieldEdadMinima1.getText().toString());
		} catch (NumberFormatException e) {}
		
    	return resul;
    }
    
    public double getPrecio(){
    	double resul = -1;
    	
		try {
			resul = Double.valueOf(jFormattedTextFieldPrecio1.getValue().toString());
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
		jTextFieldNombre1.setText("");
		jFormattedTextFieldEdadMinima1.setText("");
		jFormattedTextFieldPrecio1.setText("");
	}
	
	public int getStock() {
    	int resul = -1;
    	
		try {
			resul = Integer.valueOf(JFormattedTextFieldStock.getText().toString());
		} catch (NumberFormatException e) {}
		
    	return resul;
	}
    
	private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabelDni1 = new javax.swing.JLabel();
        jLabelNombre1 = new javax.swing.JLabel();
        jLabelApellido1 = new javax.swing.JLabel();
        jLabelTelefono1 = new javax.swing.JLabel();
        jLabelDireccion1 = new javax.swing.JLabel();
        jLabelStock = new javax.swing.JLabel();
        jTextFieldNombre1 = new javax.swing.JTextField();
        jButtonAgregar1 = new javax.swing.JButton();
        jButtonLimpiar1 = new javax.swing.JButton();
        jLabelImagen1 = new javax.swing.JLabel();
        jLabelDescripcion1 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        JComboBoxTipoJuego = new javax.swing.JComboBox<>();
        jLabelIdArticulo1 = new javax.swing.JLabel();
        jFormattedTextFieldPrecio1 = new javax.swing.JFormattedTextField();
        jFormattedTextFieldEdadMinima1 = new javax.swing.JFormattedTextField();
        JFormattedTextFieldStock = new javax.swing.JFormattedTextField();

        setLayout(new java.awt.GridBagLayout());

        jLabelDni1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelDni1.setText("ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 0);
        add(jLabelDni1, gridBagConstraints);

        jLabelNombre1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelNombre1.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 0);
        add(jLabelNombre1, gridBagConstraints);

        jLabelApellido1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelApellido1.setText("Edad mínima");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 0);
        add(jLabelApellido1, gridBagConstraints);

        jLabelTelefono1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelTelefono1.setText("Precio");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 0);
        add(jLabelTelefono1, gridBagConstraints);

        jLabelDireccion1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelDireccion1.setText("Tipo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 0);
        add(jLabelDireccion1, gridBagConstraints);

        jLabelStock.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelStock.setText("Stock");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 0);
        add(jLabelStock, gridBagConstraints);

        jTextFieldNombre1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 1);
        add(jTextFieldNombre1, gridBagConstraints);

        jButtonAgregar1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonAgregar1.setText("Agregar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(40, 0, 0, 1);
        add(jButtonAgregar1, gridBagConstraints);

        jButtonLimpiar1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonLimpiar1.setText("Limpiar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(40, 0, 0, 0);
        add(jButtonLimpiar1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jLabelImagen1, gridBagConstraints);

        jLabelDescripcion1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelDescripcion1.setText("MODIFICAR UN NUEVO ARTÍCULO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jLabelDescripcion1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 40;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 1);
        add(jSeparator4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 40;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 1, 0, 1);
        add(jSeparator2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(JComboBoxTipoJuego, gridBagConstraints);

        JFormattedTextFieldStock.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##0"))));
        JFormattedTextFieldStock.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 1);
        add(JFormattedTextFieldStock, gridBagConstraints);

        jLabelIdArticulo1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 1);
        add(jLabelIdArticulo1, gridBagConstraints);

        jFormattedTextFieldPrecio1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.##"))));
        jFormattedTextFieldPrecio1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 1);
        add(jFormattedTextFieldPrecio1, gridBagConstraints);

        jFormattedTextFieldEdadMinima1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedTextFieldEdadMinima1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 1);
        add(jFormattedTextFieldEdadMinima1, gridBagConstraints);
    }

               
    private javax.swing.JButton jButtonAgregar1;
    private javax.swing.JButton jButtonLimpiar1;
    private javax.swing.JComboBox<TipoJuego> JComboBoxTipoJuego;
    private javax.swing.JFormattedTextField jFormattedTextFieldEdadMinima1;
    private javax.swing.JFormattedTextField JFormattedTextFieldStock;
    private javax.swing.JFormattedTextField jFormattedTextFieldPrecio1;
    private javax.swing.JLabel jLabelApellido1;
    private javax.swing.JLabel jLabelDescripcion1;
    private javax.swing.JLabel jLabelStock;
    private javax.swing.JLabel jLabelDireccion1;
    private javax.swing.JLabel jLabelDni1;
    private javax.swing.JLabel jLabelIdArticulo1;
    private javax.swing.JLabel jLabelImagen1;
    private javax.swing.JLabel jLabelNombre1;
    private javax.swing.JLabel jLabelTelefono1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField jTextFieldNombre1;

}