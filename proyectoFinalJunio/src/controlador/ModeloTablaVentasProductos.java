package controlador;

import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import modelo.ProductoDTO;
import modeloDAO.ClienteDAO;
import modeloDAO.DevolucionDAO;
import modeloDAO.ProductoDAO;
import vista.PanelVentas;

public class ModeloTablaVentasProductos  implements TableModel, TableModelListener{
PanelVentas panelVentas;

	private static String[] columnNames = {"CODIGO PRODUCTO",
            "PRECIO",
            "CANTIDAD",
            "FECHA"};
	
	private static Object[][] data = ClienteDAO.listaData(new ClienteDAO().getListaClientes());	
		
	public ModeloTablaVentasProductos() {
		addTableModelListener(this);
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.length;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return data[rowIndex][columnIndex];
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columnNames[column];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex < 1) {
            return false;
        } else {
            return true;
        }
	}
	@Override
	public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
       // fireTableCellUpdated(row, col);
    }
	public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
	
	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}
    
	
	@Override
	public void tableChanged(TableModelEvent e) {
		// TODO Auto-generated method stub
		int row = e.getFirstRow(); //fila 
        int column = e.getColumn(); //columna
        ModeloTablaClientes model = (ModeloTablaClientes)e.getSource();
        String columnName = model.getColumnName(column);
        Object data = model.getValueAt(row, column);
        System.out.printf("Cambio en la fila %d, en la columna %d,"
        		+ " nuevo valor %S%n", row, column, data);
	}
	
	
	
}
	


