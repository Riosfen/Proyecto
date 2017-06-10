package modelo;

import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class ModeloTablaPersonal extends DefaultTableModel {
	
	public ModeloTablaPersonal(String[] nombreColumnas, Object[][] datos) {
		super(datos, nombreColumnas);
		
	}
     
    @Override
    public boolean isCellEditable(int row, int column) {
    	return false;
    }
	
}
