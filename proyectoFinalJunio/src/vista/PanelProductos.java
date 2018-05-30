package vista;


import javax.swing.JPanel;

import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import controlador.ModeloTablaProducto;
import modelo.ClienteDTO;
import modelo.ProductoDTO;
import modeloDAO.ClienteDAO;
import modeloDAO.ProductoDAO;
import modeloDAO.VentaDAO;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import modeloDAO.ClienteDAO;
import modelo.ClienteDTO;
public class PanelProductos extends JPanel {
private JTable tabla;
private JTextField textCantidad;
private boolean cargado=false;
private List<ProductoDTO> listaProductos;
private JTextField textCodigo;
private JTextField textPrecio;
private JButton btnBorrar ;
private JButton btnInsertar ;
private JButton btnModificar ;
private JButton btnBuscar ;
private JButton btnInsertarCliente ;
private JButton btnCargar ;
	/**
	 * Create the panel.
	 */
	public PanelProductos()  {
		cargado=false;
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnBorrar = new JButton("BORRAR");	
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            String codigo=getTextCodigo().getText().toString();
                            ProductoDTO co= new ProductoDTO(codigo, 0, 0,"");
                            ProductoDAO po= new ProductoDAO();
              

                            boolean updateProducto=po.deleteProducto(codigo);

                            if(updateProducto) {
                                    JOptionPane.showMessageDialog(null, "Borrado correctamente ");
                            } else {
                                    JOptionPane.showMessageDialog(null, "No se ha podido borrar ");
                            }
                            
                            
                        }
		});
		
		
		
		
		
		
		
		JButton btnInsertar = new JButton("INSERTAR LISTA");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				  String codigo=getTextCodigo().getText().toString();
                  String preci=getTextPrecio().getText().toString();
                  int precio=Integer.parseInt(preci);
                  ProductoDTO co= new ProductoDTO(codigo, precio, 0,"");
                  ProductoDAO po= new ProductoDAO();
    

                  boolean updateProducto=po.updatePrecioProducto(codigo, precio);

                  if(updateProducto) {
                          JOptionPane.showMessageDialog(null, "Modificado correctamente ");
                  } else {
                          JOptionPane.showMessageDialog(null, "No se ha podido modificar ");
                  }
                  
                  
              }
		});
		
		
		JLabel lblCodigo_producto = new JLabel("Codigo");
		lblCodigo_producto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCodigo_producto.setForeground(Color.WHITE);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setForeground(Color.WHITE);
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textCodigo = new JTextField();
		textCodigo.setColumns(5);
		
		textPrecio = new JTextField();
		textPrecio.setColumns(5);
		
		textCantidad = new JTextField();
		textCantidad.setColumns(5);
		
		JLabel lblProducto = new JLabel("Producto");
		lblProducto.setForeground(Color.WHITE);
		lblProducto.setFont(new Font("Verdana", Font.BOLD, 16));
		
		JButton btnInsertarCliente = new JButton("INSERTAR PRODUCTO");	
		btnInsertarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            String codigo=getTextCodigo().getText().toString();
                            String preci=getTextPrecio().getText().toString();
                            String cantida=getTextCantidad().getText().toString();
                            int precio=Integer.parseInt(preci);
                            int cantidad=Integer.parseInt(cantida);
                          
                            
                            ProductoDTO co= new ProductoDTO(codigo, precio, cantidad);
                            ProductoDAO po= new ProductoDAO();
              

                            boolean registroProducto=po.addProducto(co);

                            if(registroProducto) {
                                    JOptionPane.showMessageDialog(null, "Registrado correctamente "+registroProducto);
                            } else {
                                    JOptionPane.showMessageDialog(null, "No se ha podido registrar "+registroProducto);
                            }
                            
                            System.out.println(codigo +""+precio);
                        }
		});
		
		
		JButton btnCargar = new JButton("CARGAR");
		
		
		JLabel lblProductos = new JLabel("Productos");
		lblProductos.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblProductos.setForeground(new Color(255, 255, 255));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCantidad, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPrecio)
						.addComponent(lblCodigo_producto))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(textPrecio, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
								.addComponent(textCantidad, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textCodigo, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addComponent(btnInsertarCliente, Alignment.LEADING))
							.addGap(87))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblProducto)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 657, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(395)
					.addComponent(btnCargar)
					.addGap(46)
					.addComponent(btnModificar)
					.addGap(30)
					.addComponent(btnInsertar)
					.addGap(18)
					.addComponent(btnBorrar)
					.addContainerGap(125, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(558, Short.MAX_VALUE)
					.addComponent(lblProductos)
					.addGap(285))
		);
		
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(218)
							.addComponent(lblProducto)
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCodigo_producto))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPrecio))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textCantidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCantidad)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(33)
							.addComponent(lblProductos)
							.addGap(18)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(39)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnCargar)
								.addComponent(btnModificar)
								.addComponent(btnInsertar)
								.addComponent(btnBorrar)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(48)
							.addComponent(btnInsertarCliente)))
					.addGap(112))
		);
		
	
		DefaultTableModel modelop= new DefaultTableModel();
		JTable tablep=new JTable();
		
		tablep.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CODIGO_PRODUCTO", "PRECIO", "CANTIDAD"
			}
		));
		
		scrollPane.setViewportView(tablep);
		setLayout(groupLayout);
		
	
		
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		

		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int numCols=tablep.getModel().getColumnCount();
			try {
				//tablep.repaint();
			       limpiarTabla(tablep);
			       System.out.println("1");
				   listaProductos=new ProductoDAO().getListaProductos();
				   System.out.println("2");
			       ProductoDTO p;
			       for (int i = 0; i < listaProductos.size(); i++) {
			    	   Object[]  fila= new Object[3];
			    	   p=listaProductos.get(i);
			           fila[0]=p.getCodigo_producto();
			           fila[1]=p.getPrecio();
			           fila[2]=p.getCantidad();
			          // fila[3]=p.getFecha();
			           ((DefaultTableModel) tablep.getModel()).addRow(fila);
			       }
			     }catch(Exception e2) {
			    	 
			     }
			
			        
		       
			//}
		  }
		 });
			
		
		 tablep.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
             public void valueChanged(ListSelectionEvent e) {
                 if(!(tablep.getSelectionModel().isSelectionEmpty( ))) {
                     int filap = tablep.getSelectedRow();
                    
                     String codigo_producto = tablep.getValueAt(filap, 0).toString();
                     String precio = tablep.getValueAt(filap, 1).toString();
                     String cantidad = tablep.getValueAt(filap, 2).toString();
                   //  String fecha = tablep.getValueAt(filap, 3).toString();
                     textCodigo.setText(codigo_producto);
                     textPrecio.setText(precio);
                     textCantidad.setText(cantidad);
                    // textFecha.setText(fecha);
                 }
             }
         });	
	}
public void limpiarTabla(JTable t){
	try {
		DefaultTableModel modelo=(DefaultTableModel) t.getModel();
		int filas=t.getRowCount();
		for(int i=0; filas>i; i++) {
		modelo.removeRow(0);
		}
	}catch(Exception e) {
	JOptionPane.showMessageDialog(null,  "Error al limpiar la tabla");	
	} 		 
}
	/**
	 * @return the tabla
	 */
	public JTable getTabla() {
		return tabla;
	}
	/**
	 * @return the textCantidad
	 */
	public JTextField getTextCantidad() {
		return textCantidad;
	}

	/**
	 * @return the cargado
	 */
	public boolean isCargado() {
		return cargado;
	}
	/**
	 * @return the listaProductos
	 */
	public List<ProductoDTO> getListaProductos() {
		return listaProductos;
	}
	/**
	 * @return the textCodigo
	 */
	public JTextField getTextCodigo() {
		return textCodigo;
	}
	/**
	 * @return the textPrecio
	 */
	public JTextField getTextPrecio() {
		return textPrecio;
	}
	/**
	 * @return the btnBorrar
	 */
	public JButton getBtnBorrar() {
		return btnBorrar;
	}
	/**
	 * @return the btnInsertar
	 */
	public JButton getBtnInsertar() {
		return btnInsertar;
	}
	/**
	 * @return the btnModificar
	 */
	public JButton getBtnModificar() {
		return btnModificar;
	}
	/**
	 * @return the btnBuscar
	 */
	public JButton getBtnBuscar() {
		return btnBuscar;
	}
	/**
	 * @return the btnInsertarCliente
	 */
	public JButton getBtnInsertarCliente() {
		return btnInsertarCliente;
	}
	/**
	 * @return the btnCargar
	 */
	public JButton getBtnCargar() {
		return btnCargar;
	}
}	
				


