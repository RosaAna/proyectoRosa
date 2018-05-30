package vista;

import javax.swing.JPanel;

import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import modelo.ProductoDTO;
import modelo.VentaDTO;
import modeloDAO.ProductoDAO;
import modeloDAO.VentaDAO;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelo.ClienteDTO;

public class PanelVentas extends JPanel {
	private JTable tablev;
	private JTextField textFdni_v;
	private JTextField textFproducto_v;
	private boolean cargadov=false;
	private boolean cargadop=false;
    private List<VentaDTO> listaVentas;
    private List<ProductoDTO> listaProductos;
    private JTable tablep;
    private JTextField textFImporte;
    private JTextField textFecha_v;
    private JButton btnCargar;
    private JButton btnCargarProductos;
    private JButton btnInsertarCliente;
    private JButton btnAnular_v;
    private JButton btnBuscar_v;
    private JTable table;
    private JLabel lblNewLabel;
  
	/**
	 * Create the panel.
	 */
	public PanelVentas() {
		cargadov=false;
		cargadop=false;
	
		btnAnular_v = new JButton("ANULAR VENTA");
		
		
	
		btnBuscar_v = new JButton("BUSCAR");
		btnBuscar_v.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblDniv = new JLabel("DNI");
		lblDniv.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDniv.setForeground(Color.WHITE);
		
		JLabel lblProducto_v = new JLabel("Cod_Producto");
		lblProducto_v.setForeground(Color.WHITE);
		lblProducto_v.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textFdni_v = new JTextField();
		textFdni_v.setColumns(5);
		
		textFproducto_v = new JTextField();
		textFproducto_v.setColumns(5);
		
		textFecha_v = new JTextField();
		textFecha_v.setColumns(5);
		
		JLabel lblVenta = new JLabel("Venta");
		lblVenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblVenta.setForeground(Color.WHITE);
		lblVenta.setFont(new Font("Verdana", Font.BOLD, 20));
		
		btnInsertarCliente = new JButton("INSERTAR VENTA");
		btnInsertarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            String dni=getTextFdni_v().getText();
                            String codigo_producto=getTextFproducto_v().getText();
                            String importes=getTextField().getText();
                            int importe=Integer.parseInt(importes);

                            ClienteDTO cd= new ClienteDTO(dni, " "," ","");
                            ProductoDTO pd=new ProductoDTO(codigo_producto,0, 0);
                            VentaDAO ve=new VentaDAO();

                            boolean registroVenta=ve.addVenta(dni, codigo_producto, importe);

                            if(registroVenta) {
                                    JOptionPane.showMessageDialog(null, "Recoja su producto  "+registroVenta);
                            } else {
                                    JOptionPane.showMessageDialog(null, "Usted ya adquirió este producto hoy"+registroVenta);
                            }
                            
                            
                        }
		});
		
		btnCargar = new JButton("CARGAR VENTAS");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JPanel panel = new JPanel();
		
		JLabel lblProductos = new JLabel("Productos");
		lblProductos.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductos.setForeground(Color.WHITE);
		lblProductos.setFont(new Font("Tahoma", Font.BOLD, 28));
		
		JLabel lblimporte = new JLabel("Importe");
		lblimporte.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblimporte.setForeground(Color.WHITE);
		
		textFImporte = new JTextField();
		textFImporte.setColumns(10);
		
		btnCargarProductos = new JButton("CARGAR PRODUCTOS");
		btnCargarProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
					
				
			}
		});
		
		JPanel panel_1 = new JPanel();
		
		lblNewLabel = new JLabel("Ventas");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setForeground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(32)
									.addComponent(lblimporte))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(51)
									.addComponent(lblDniv)))
							.addGap(44)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(textFImporte, Alignment.LEADING)
								.addComponent(textFproducto_v, Alignment.LEADING)
								.addComponent(textFdni_v, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblProducto_v))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(82)
							.addComponent(lblVenta))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnInsertarCliente, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(btnBuscar_v)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(37)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnAnular_v, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(btnCargar)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnCargarProductos, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE))
							.addGap(100))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(206)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
							.addGap(277))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(407)
					.addComponent(lblProductos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(235))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblProductos)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblVenta))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFdni_v, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDniv, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblProducto_v)
								.addComponent(textFproducto_v, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFImporte, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblimporte))
							.addGap(68)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnInsertarCliente)
								.addComponent(btnBuscar_v))
							.addGap(11))
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnCargarProductos)
							.addComponent(btnCargar))
						.addComponent(btnAnular_v))
					.addGap(26))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"DNI CLIENTE", "CODIGO PRODUCTO", "IMPORTE", "FECHA"
			}
		));
		scrollPane.setViewportView(table);
		panel_1.setLayout(gl_panel_1);
		DefaultTableModel modelo= new DefaultTableModel();
		setLayout(groupLayout);
                
                table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent e) {
                    	btnAnular_v.setEnabled(true);
                    	lblimporte.setText("Fecha");
                    	btnInsertarCliente.setEnabled(false);
                        if(!(table.getSelectionModel().isSelectionEmpty( ))) {
                            int fila = table.getSelectedRow();
                           
                            String dni_cliente = table.getValueAt(fila, 0).toString();
                            String codigo_producto= table.getValueAt(fila, 1).toString();
                            String fecha = table.getValueAt(fila, 3).toString();
                            textFproducto_v.setText(codigo_producto);
                            textFdni_v.setText(dni_cliente);
                            textFImporte.setText(fecha);
                        }
                    }
                });
		
		
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		tablep = new JTable();
		tablep.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CODIGO PRODUCTO", "PRECIO", "CANTIDAD"
			}
		));
		scrollPane_1.setViewportView(tablep);
		panel.setLayout(gl_panel);
		
		DefaultTableModel modelo2= new DefaultTableModel();
		setLayout(groupLayout);
                
                tablep.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent e) {
                    	btnAnular_v.setEnabled(false);
                    	btnInsertarCliente.setEnabled(true);
                        if(!(tablep.getSelectionModel().isSelectionEmpty( ))) {
                            int filap = tablep.getSelectedRow();
                           
                            String codigo_producto = tablep.getValueAt(filap, 0).toString();
                            String importe = tablep.getValueAt(filap, 1).toString();
                            textFproducto_v.setText(codigo_producto);
                            textFImporte.setText(importe);
                            textFdni_v.setText("");
                        }
                    }
                });
		
		btnAnular_v.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            if(!(table.getSelectionModel().isSelectionEmpty( ))) {

                                int fila = table.getSelectedRow();
                                String dni=table.getValueAt(fila, 0).toString();
                                String codigo_producto=table.getValueAt(fila, 1).toString();
                                String fecha=table.getValueAt(fila, 3).toString();
                                textFdni_v.setText(dni);
                                textFproducto_v.setText(codigo_producto);
                                textFecha_v.setText(fecha);
                                   VentaDAO vdo=new VentaDAO();
                                   vdo.deleteVenta(dni, codigo_producto,fecha);
                               
                                boolean registroVenta=vdo.deleteVenta(dni, codigo_producto, fecha);

                                if(registroVenta) {
                                        JOptionPane.showMessageDialog(null, "Venta  anulada");
                                } else {
                                        JOptionPane.showMessageDialog(null, "Venta no anulada");
                                }
                                

                            }
			}
		});
		
		
		
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFproducto_v.setText("");
                textFdni_v.setText("");
                textFImporte.setText("");
			int numCols=table.getModel().getColumnCount();
			    table.repaint();
				limpiarTabla(table);
			    
			     listaVentas=new VentaDAO().getListaVentas();
			     VentaDTO v;
			     for (int i = 0; i < listaVentas.size(); i++) {
			    	 Object[]  fila= new Object[4];
			    	 v=listaVentas.get(i);
			         fila[0]=v.getDniCliente();
			         fila[1]=v.getCodigoProducto();
			         fila[2]=v.getImporte();
			         fila[3]=v.getFechaVenta();
			       
			
			        ((DefaultTableModel) table.getModel()).addRow(fila)	;
		         } 
		  }
		 });
		
		
		
		   btnCargarProductos.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
				int numCols=tablep.getModel().getColumnCount();	
					 listaProductos=new ProductoDAO().getListaProductos();
					 textFproducto_v.setText("");
		             textFdni_v.setText("");
		             textFImporte.setText("");
				     ProductoDTO p;
				     tablep.repaint();
				     limpiarTabla(tablep);
				     
				     for (int i = 0; i < listaProductos.size(); i++) {
				    	 Object[]  filap= new Object[3];
				    	 p=listaProductos.get(i);
				         filap[0]=p.getCodigo_producto();
				         filap[1]=p.getPrecio();
				         filap[2]=p.getCantidad();
				        cargadop=true;   
				     
				
				        ((DefaultTableModel) tablep.getModel()).addRow(filap)	;
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
	 * @return the tablev
	 */
	public JTable getTablev() {
		return tablev;
	}

	/**
	 * @return the textFdni_v
	 */
	public JTextField getTextFdni_v() {
		return textFdni_v;
	}

	/**
	 * @return the textFproducto_v
	 */
	public JTextField getTextFproducto_v() {
		return textFproducto_v;
	}

	/**
	 * @return the listaVentas
	 */
	public List<VentaDTO> getListaVentas() {
		return listaVentas;
	}

	/**
	 * @return the listaProductos
	 */
	public List<ProductoDTO> getListaProductos() {
		return listaProductos;
	}

	/**
	 * @return the tablep
	 */
	public JTable getTablep() {
		return tablep;
	}

	/**
	 * @return the textField
	 */
	public JTextField getTextField() {
		return textFImporte;
	}

	/**
	 * @return the btnCargar
	 */
	public JButton getBtnCargar() {
		return btnCargar;
	}

	/**
	 * @return the btnCargarProductos
	 */
	public JButton getBtnCargarProductos() {
		return btnCargarProductos;
	}

	/**
	 * @return the btnInsertarCliente
	 */
	public JButton getBtnInsertarCliente() {
		return btnInsertarCliente;
	}

	/**
	 * @return the btnAnular_v
	 */
	public JButton getBtnAnular_v() {
		return btnAnular_v;
	}

	/**
	 * @return the btnBuscar_v
	 */
	public JButton getBtnBuscar_v() {
		return btnBuscar_v;
	}
	
	
}
