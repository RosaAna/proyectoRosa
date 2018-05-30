package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import modelo.ProductoDTO;
import modeloDAO.ProductoDAO;
import vista.PanelProductos;


public class ModeloTablaProducto implements ActionListener, TableModel {
  ProductoDAO pdao=new ProductoDAO();
  PanelProductos po=new PanelProductos();

public ModeloTablaProducto(ProductoDAO pdao, PanelProductos po) {
  this.pdao=pdao;
  this.po=po;
  this.po.getBtnBorrar().addActionListener(this);
  this.po.getBtnBuscar().addActionListener(this);
  this.po.getBtnCargar().addActionListener(this);
  this.po.getBtnInsertar().addActionListener(this);
  this.po.getBtnInsertarCliente().addActionListener(this);
  this.po.getBtnModificar().addActionListener(this);
}
	

public void inicializar() {
	
}

public void llenarTabla(JTable tablaD) {
    DefaultTableModel modeloT=new DefaultTableModel();
    tablaD.setModel(modeloT);
 
    modeloT.addColumn("CODIGO PRODUCTO");
    modeloT.addColumn("PRECIO");
    modeloT.addColumn("CANTIDAD");
 
    Object[] columna=new Object[3];
 
    int numeroDeRegistros=pdao.getListaProductosDisponibles().size();
 
    for(int i=0; i<numeroDeRegistros; i++) {
        columna[0]=pdao.getListaProductosDisponibles().get(i).getCodigo_producto();
        columna[1]=pdao.getListaProductosDisponibles().get(i).getPrecio();
        columna[2]=pdao.getListaProductosDisponibles().get(i).getCantidad();
     }
 
 }
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	   if(e.getSource()== po.getBtnInsertarCliente()) {
		String codigo_producto=po.getTextCodigo().getText();
		String precios=po.getTextPrecio().getText();
		String cantidas=po.getTextCantidad().getText();
		int cantidad=Integer.parseInt(cantidas);
		int precio=Integer.parseInt(precios);
		ProductoDTO producto=new ProductoDTO(codigo_producto, precio, cantidad);
		boolean registroProducto=pdao.addProducto(producto);
		
		if(registroProducto) {
			JOptionPane.showMessageDialog(null, "Se ha guardado: true= "+registroProducto);
		}else {
			JOptionPane.showMessageDialog(null, "No se ha guardado: false= "+registroProducto);
		}
		
	   }
		
	   if(e.getSource()== po.getBtnCargar()) {
	   
	     llenarTabla(po.getTabla());
	   }
	   
	}

	@Override
	public void addTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<?> getColumnClass(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getColumnName(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueAt(Object arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

}
