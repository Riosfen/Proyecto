package vista.Usuario;

import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.border.EmptyBorder;

import persistencia.Cliente;
import persistencia.TipoSexo;

@SuppressWarnings("serial")
public class VistaModificarUsuario extends javax.swing.JPanel {

	private Cliente cliente;
	
    public VistaModificarUsuario(Cliente cliente) {
        this.cliente = cliente;
		initComponents();
		inicializarCliente();
        this.setBorder(new EmptyBorder(80, 80, 80, 80));
    
    }

    public void inicializarCliente(){
    	jTextFieldDni.setText(cliente.getDni());
    	jTextFieldNombre.setText(cliente.getNombre());
    	jTextFieldApellido.setText(cliente.getApellido());
    	jTextFieldTelefono.setText(cliente.getTelefono());
    	jTextFieldDireccion.setText(cliente.getDireccion());
    	switch (cliente.getSexo().name()) {
		case "HOMBRE":
			jRadioButtonHombre.setSelected(true);
			break;
		case "MUJER":
			jRadioButtonMujer.setSelected(true);
			break;
		case "OTRO":
			break;
		}
    	jDateChooserFechaNac.setDate(cliente.getFechaNacimiento());
    }
    
    public Cliente getCliente(){
    	return cliente;
    }
    
    public void setControlador(ActionListener e){
        jButtonAgregar.addActionListener(e);
        jButtonLimpiar.addActionListener(e);
        
        jButtonAgregar.setActionCommand("agregar");
        jButtonLimpiar.setActionCommand("limpiar");
    
    }
    
    public String getDni(){
    	return jTextFieldDni.getText().toString();
    }
    public String getNombre(){
    	return jTextFieldNombre.getText().toString();
    	}
    public String getApellido(){
    	return jTextFieldApellido.getText().toString();
    	}
    public String getDireccion(){
    	return jTextFieldDireccion.getText().toString();
    	}
    public String getTelefono(){
    	return jTextFieldTelefono.getText().toString();
    	}
    public Date getFechaNac(){
    	return jDateChooserFechaNac.getDate();
    }
    public TipoSexo getSexo(){
    	if (jRadioButtonHombre.isSelected()){
    		return TipoSexo.valueOf(jRadioButtonHombre.getText().toString().toUpperCase());
    	}else{
    		if (jRadioButtonMujer.isSelected()){
    			return TipoSexo.valueOf(jRadioButtonMujer.getText().toString().toUpperCase());
    		}else{
    			return TipoSexo.OTRO;
    		}
    	}
    }
    
    public void limpiarDatos() {
        jTextFieldDni.setText("");
        jTextFieldNombre.setText("");
        jTextFieldApellido.setText("");
        jTextFieldDireccion.setText("");
        jTextFieldTelefono.setText("");
        jDateChooserFechaNac.setCalendar(null);
        buttonGroupSexo.clearSelection();
    }

    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroupSexo = new javax.swing.ButtonGroup();
        jLabelDni = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelApellido = new javax.swing.JLabel();
        jLabelTelefono = new javax.swing.JLabel();
        jLabelDireccion = new javax.swing.JLabel();
        jLabelSexo = new javax.swing.JLabel();
        jLabelFechaNac = new javax.swing.JLabel();
        jTextFieldDni = new javax.swing.JTextField();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldApellido = new javax.swing.JTextField();
        jTextFieldTelefono = new javax.swing.JTextField();
        jTextFieldDireccion = new javax.swing.JTextField();
        jRadioButtonHombre = new javax.swing.JRadioButton();
        jRadioButtonMujer = new javax.swing.JRadioButton();
        jDateChooserFechaNac = new com.toedter.calendar.JDateChooser();
        jButtonAgregar = new javax.swing.JButton();
        jButtonLimpiar = new javax.swing.JButton();
        jLabelImagen = new javax.swing.JLabel();
        jLabelDescripcion = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();

        setLayout(new java.awt.GridBagLayout());

        jLabelDni.setFont(new java.awt.Font("Tahoma", 0, 24)); 
        jLabelDni.setText("DNI");
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
        jLabelApellido.setText("Apellidos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jLabelApellido, gridBagConstraints);

        jLabelTelefono.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabelTelefono.setText("Teléfono");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jLabelTelefono, gridBagConstraints);

        jLabelDireccion.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabelDireccion.setText("Dirección");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jLabelDireccion, gridBagConstraints);

        jLabelSexo.setFont(new java.awt.Font("Tahoma", 0, 24)); 
        jLabelSexo.setText("Sexo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jLabelSexo, gridBagConstraints);

        jLabelFechaNac.setFont(new java.awt.Font("Tahoma", 0, 24)); 
        jLabelFechaNac.setText("Fecha de nacimiento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jLabelFechaNac, gridBagConstraints);

        jTextFieldDni.setFont(new java.awt.Font("Tahoma", 0, 24)); 
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jTextFieldDni, gridBagConstraints);

        jTextFieldNombre.setFont(new java.awt.Font("Tahoma", 0, 24)); 
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jTextFieldNombre, gridBagConstraints);

        jTextFieldApellido.setFont(new java.awt.Font("Tahoma", 0, 24)); 
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jTextFieldApellido, gridBagConstraints);

        jTextFieldTelefono.setFont(new java.awt.Font("Tahoma", 0, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jTextFieldTelefono, gridBagConstraints);

        jTextFieldDireccion.setFont(new java.awt.Font("Tahoma", 0, 24)); 
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jTextFieldDireccion, gridBagConstraints);

        buttonGroupSexo.add(jRadioButtonHombre);
        jRadioButtonHombre.setFont(new java.awt.Font("Tahoma", 0, 24));
        jRadioButtonHombre.setText("Hombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jRadioButtonHombre, gridBagConstraints);

        buttonGroupSexo.add(jRadioButtonMujer);
        jRadioButtonMujer.setFont(new java.awt.Font("Tahoma", 0, 24));
        jRadioButtonMujer.setText("Mujer");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jRadioButtonMujer, gridBagConstraints);

        jDateChooserFechaNac.setFont(new java.awt.Font("Tahoma", 0, 24)); 
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jDateChooserFechaNac, gridBagConstraints);

        jButtonAgregar.setFont(new java.awt.Font("Tahoma", 0, 24));
        jButtonAgregar.setText("Modificar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jButtonAgregar, gridBagConstraints);

        jButtonLimpiar.setFont(new java.awt.Font("Tahoma", 0, 24)); 
        jButtonLimpiar.setText("Limpiar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
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
        jLabelDescripcion.setText("MODIFICAR CLIENTE " + cliente.getNombre().toUpperCase());
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
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 40;
        gridBagConstraints.insets = new java.awt.Insets(40, 0, 40, 0);
        add(jSeparator1, gridBagConstraints);
    }


    private javax.swing.ButtonGroup buttonGroupSexo;
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonLimpiar;
    private com.toedter.calendar.JDateChooser jDateChooserFechaNac;
    private javax.swing.JLabel jLabelApellido;
    private javax.swing.JLabel jLabelDescripcion;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelDni;
    private javax.swing.JLabel jLabelFechaNac;
    private javax.swing.JLabel jLabelImagen;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelSexo;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JRadioButton jRadioButtonHombre;
    private javax.swing.JRadioButton jRadioButtonMujer;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextFieldApellido;
    private javax.swing.JTextField jTextFieldDireccion;
    private javax.swing.JTextField jTextFieldDni;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldTelefono;

}
