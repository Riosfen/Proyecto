package modelo;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class ModeloTablaPersonal extends AbstractTableModel {

	private String[] nombreColumnas;
	private Object[][] datos;
	@SuppressWarnings("rawtypes")
	private Class[] types;
	
	public ModeloTablaPersonal(String[] nombreColumnas, Object[][] datos, @SuppressWarnings("rawtypes") Class[] types) {
		this.nombreColumnas = nombreColumnas;
		this.datos = datos;
		this.types = types;
		
	}
     
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
    public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
    }
	
	@Override
	public int getColumnCount() {
		return nombreColumnas.length;
	}

	@Override
	public int getRowCount() {
		return datos.length;
	}
	
	@Override
	public String getColumnName(int column) {
		return nombreColumnas[column];
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		return datos[arg0][arg1];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
}
