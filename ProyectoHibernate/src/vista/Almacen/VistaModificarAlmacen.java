package vista.Almacen;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.border.EmptyBorder;

import persistencia.Juego;
import persistencia.TipoJuego;
import persistencia.TipoJuegos;

@SuppressWarnings("serial")
public class VistaModificarAlmacen extends javax.swing.JPanel {
    
    private Juego juego;

    public VistaModificarAlmacen(Juego juego) {
        this.juego = juego;
        initComponents();
		inicializarJuego();
        this.setBorder(new EmptyBorder(80, 80, 80, 80));
        
    }
    
    public void inicializarJuego(){
		jLabelIdArticulo1.setText(String.valueOf(juego.getId()));
		jTextFieldNombre1.setText(juego.getNombre());
		jFormattedTextFieldEdadMinima1.setText(String.valueOf(juego.getEdadMinima()));
		jFormattedTextFieldPrecio1.setText(String.valueOf(juego.getPrecio()));
		
		ArrayList<TipoJuegos> tipos = new ArrayList<>();
		tipos.addAll(juego.getTipoJuego());
        
		JCheckBox[] jBox = new JCheckBox[]{jCheckBox18,jCheckBox19,jCheckBox20,
	            jCheckBox21,jCheckBox22,jCheckBox23,jCheckBox24,jCheckBox25,
	            jCheckBox26,jCheckBox27,jCheckBox28,jCheckBox29};
		
        for (int i = 0; i < tipos.size(); i++) {
        	TipoJuego e = tipos.get(i).getTipo();
        	
        	for (int j = 0; j < jBox.length; j++) {
        		TipoJuego m = TipoJuego.valueOf(jBox[j].getText().toString().toUpperCase());
        		
        		if (e == m){
        			jBox[j].setSelected(true);
        		}
        		
			}
        	
        }
	}

	public Juego getJuego() {
		return juego;
	}
	
	public void setControlador(ActionListener e) {
        jButtonAgregar1.addActionListener(e);
        jButtonLimpiar1.addActionListener(e);
        
        jButtonAgregar1.setActionCommand("agregar");
        jButtonLimpiar1.setActionCommand("limpiar");
		
	}
	
	public String getNombre(){
    	return jTextFieldNombre1.getText().toString();
    }
    public int getEdadMinima(){
    	return Integer.valueOf(jFormattedTextFieldEdadMinima1.getText().toString());
    }
    public double getPrecio(){
    	return (Double)jFormattedTextFieldPrecio1.getValue();
    }
    
    public ArrayList<TipoJuego> getTipoJuego(){
    	ArrayList<TipoJuego> tipos = new ArrayList<>();
    	JCheckBox[] jBox = new JCheckBox[]{jCheckBox18,jCheckBox19,jCheckBox20,
	            jCheckBox21,jCheckBox22,jCheckBox23,jCheckBox24,jCheckBox25,
	            jCheckBox26,jCheckBox27,jCheckBox28,jCheckBox29};
        
        for (int i = 0; i < jBox.length; i++) {
        	if (jBox[i].isSelected()){
        		tipos.add(TipoJuego.valueOf(jBox[i].getText().toString().toUpperCase()));
        	}
        }
        
        return tipos;
        
    }

	public void limpiarDatos() {
		jTextFieldNombre1.setText("");
		jFormattedTextFieldEdadMinima1.setText("");
		jFormattedTextFieldPrecio1.setText("");
	}
    
	private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabelDni1 = new javax.swing.JLabel();
        jLabelNombre1 = new javax.swing.JLabel();
        jLabelApellido1 = new javax.swing.JLabel();
        jLabelTelefono1 = new javax.swing.JLabel();
        jLabelDireccion1 = new javax.swing.JLabel();
        jTextFieldNombre1 = new javax.swing.JTextField();
        jButtonAgregar1 = new javax.swing.JButton();
        jButtonLimpiar1 = new javax.swing.JButton();
        jLabelImagen1 = new javax.swing.JLabel();
        jLabelDescripcion1 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jCheckBox18 = new javax.swing.JCheckBox();
        jCheckBox19 = new javax.swing.JCheckBox();
        jCheckBox20 = new javax.swing.JCheckBox();
        jCheckBox21 = new javax.swing.JCheckBox();
        jCheckBox22 = new javax.swing.JCheckBox();
        jCheckBox23 = new javax.swing.JCheckBox();
        jCheckBox24 = new javax.swing.JCheckBox();
        jCheckBox25 = new javax.swing.JCheckBox();
        jCheckBox26 = new javax.swing.JCheckBox();
        jCheckBox27 = new javax.swing.JCheckBox();
        jCheckBox28 = new javax.swing.JCheckBox();
        jCheckBox29 = new javax.swing.JCheckBox();
        jLabelIdArticulo1 = new javax.swing.JLabel();
        jFormattedTextFieldPrecio1 = new javax.swing.JFormattedTextField();
        jFormattedTextFieldEdadMinima1 = new javax.swing.JFormattedTextField();

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

        jCheckBox18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jCheckBox18.setText("Shooter");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jCheckBox18, gridBagConstraints);

        jCheckBox19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jCheckBox19.setText("Accion");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 1);
        add(jCheckBox19, gridBagConstraints);

        jCheckBox20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jCheckBox20.setText("Estrategia");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jCheckBox20, gridBagConstraints);

        jCheckBox21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jCheckBox21.setText("Simulacion");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 1);
        add(jCheckBox21, gridBagConstraints);

        jCheckBox22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jCheckBox22.setText("Deportes");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jCheckBox22, gridBagConstraints);

        jCheckBox23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jCheckBox23.setText("Carreras");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 1);
        add(jCheckBox23, gridBagConstraints);

        jCheckBox24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jCheckBox24.setText("Aventuras");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jCheckBox24, gridBagConstraints);

        jCheckBox25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jCheckBox25.setText("Rol");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 1);
        add(jCheckBox25, gridBagConstraints);

        jCheckBox26.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jCheckBox26.setText("Sandbox");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jCheckBox26, gridBagConstraints);

        jCheckBox27.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jCheckBox27.setText("Musical");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 1);
        add(jCheckBox27, gridBagConstraints);

        jCheckBox28.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jCheckBox28.setText("Agilidad");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jCheckBox28, gridBagConstraints);

        jCheckBox29.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jCheckBox29.setText("Educacion");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 1);
        add(jCheckBox29, gridBagConstraints);

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
    private javax.swing.JCheckBox jCheckBox18;
    private javax.swing.JCheckBox jCheckBox19;
    private javax.swing.JCheckBox jCheckBox20;
    private javax.swing.JCheckBox jCheckBox21;
    private javax.swing.JCheckBox jCheckBox22;
    private javax.swing.JCheckBox jCheckBox23;
    private javax.swing.JCheckBox jCheckBox24;
    private javax.swing.JCheckBox jCheckBox25;
    private javax.swing.JCheckBox jCheckBox26;
    private javax.swing.JCheckBox jCheckBox27;
    private javax.swing.JCheckBox jCheckBox28;
    private javax.swing.JCheckBox jCheckBox29;
    private javax.swing.JFormattedTextField jFormattedTextFieldEdadMinima1;
    private javax.swing.JFormattedTextField jFormattedTextFieldPrecio1;
    private javax.swing.JLabel jLabelApellido1;
    private javax.swing.JLabel jLabelDescripcion1;
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