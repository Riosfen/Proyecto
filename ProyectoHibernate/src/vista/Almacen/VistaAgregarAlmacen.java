package vista.Almacen;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;
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
    	return Integer.valueOf(jFormattedTextFieldEdadMinima.getText().toString());
    }
    public double getPrecio(){
    	return (Double)jFormattedTextFieldPrecio.getValue();
    }
    
    public ArrayList<TipoJuego> getTipoJuego(){
    	ArrayList<TipoJuego> tipos = new ArrayList<>();
    	JCheckBox[] jBox = new JCheckBox[]{jCheckBox1,jCheckBox2,jCheckBox3,
            jCheckBox4,jCheckBox5,jCheckBox6,jCheckBox7,jCheckBox8,
            jCheckBox9,jCheckBox10,jCheckBox11,jCheckBox12};
        
        for (int i = 0; i < jBox.length; i++) {
        	if (jBox[i].isSelected()){
        		tipos.add(TipoJuego.valueOf(jBox[i].getText().toString().toUpperCase()));
        	}
        }
        
        return tipos;
        
    }
    
    public void limpiarDatos() {
        jFormattedTextFieldEdadMinima.setText("");
        jFormattedTextFieldPrecio.setText("");
        jTextFieldNombre.setText("");
        jCheckBox1.setSelected(false);
        jCheckBox2.setSelected(false);
        jCheckBox3.setSelected(false);
        jCheckBox4.setSelected(false);
        jCheckBox5.setSelected(false);
        jCheckBox6.setSelected(false);
        jCheckBox7.setSelected(false);
        jCheckBox8.setSelected(false);
        jCheckBox9.setSelected(false);
        jCheckBox10.setSelected(false);
        jCheckBox11.setSelected(false);
        jCheckBox12.setSelected(false);
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
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jCheckBox10 = new javax.swing.JCheckBox();
        jCheckBox11 = new javax.swing.JCheckBox();
        jCheckBox12 = new javax.swing.JCheckBox();
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

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        jCheckBox1.setText("Shooter");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jCheckBox1, gridBagConstraints);

        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 18));
        jCheckBox2.setText("Accion");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jCheckBox2, gridBagConstraints);

        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 18));
        jCheckBox3.setText("Estrategia");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jCheckBox3, gridBagConstraints);

        jCheckBox4.setFont(new java.awt.Font("Tahoma", 0, 18));
        jCheckBox4.setText("Simulacion");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jCheckBox4, gridBagConstraints);

        jCheckBox5.setFont(new java.awt.Font("Tahoma", 0, 18));
        jCheckBox5.setText("Deportes");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jCheckBox5, gridBagConstraints);

        jCheckBox6.setFont(new java.awt.Font("Tahoma", 0, 18));
        jCheckBox6.setText("Carreras");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jCheckBox6, gridBagConstraints);

        jCheckBox7.setFont(new java.awt.Font("Tahoma", 0, 18));
        jCheckBox7.setText("Aventuras");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jCheckBox7, gridBagConstraints);

        jCheckBox8.setFont(new java.awt.Font("Tahoma", 0, 18));
        jCheckBox8.setText("Rol");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jCheckBox8, gridBagConstraints);

        jCheckBox9.setFont(new java.awt.Font("Tahoma", 0, 18));
        jCheckBox9.setText("Sandbox");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jCheckBox9, gridBagConstraints);

        jCheckBox10.setFont(new java.awt.Font("Tahoma", 0, 18));
        jCheckBox10.setText("Musical");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jCheckBox10, gridBagConstraints);

        jCheckBox11.setFont(new java.awt.Font("Tahoma", 0, 18));
        jCheckBox11.setText("Agilidad");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jCheckBox11, gridBagConstraints);

        jCheckBox12.setFont(new java.awt.Font("Tahoma", 0, 18));
        jCheckBox12.setText("Educacion");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jCheckBox12, gridBagConstraints);

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
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
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
