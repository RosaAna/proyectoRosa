package vista;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import modelo.PerdidasDTO;
import modelo.ProductoDTO;
import modeloDAO.PerdidasDAO;
import modeloDAO.ProductoDAO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelAdministracion extends JPanel {
	private JTable tableA;
	boolean cargadoA=false;
	List<PerdidasDTO>listaPerdidas;
	/**
	 * Create the panel.
	 */
	public PanelAdministracion() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(222, 65, 737, 400);
		add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		
		tableA = new JTable();
		tableA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		tableA.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"CODIGO PRODUCTO", "DNI CLIENTE", "IMPORTE", "FECHA"
			}
		));
		scrollPane.setViewportView(tableA);
		panel.setLayout(gl_panel);
		
		JButton btnNewButton = new JButton("CARGAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						int numCols=tableA.getModel().getColumnCount();
						if(cargadoA==false) {	
							 listaPerdidas=new PerdidasDAO().getListaPerdidas();
						     PerdidasDTO p;
						     for (int i = 0; i < listaPerdidas.size(); i++) {
						    	 Object[]  filap= new Object[4];
						    	 p=listaPerdidas.get(i);
						         filap[0]=p.getCodigoProducto();
						         filap[1]=p.getDniCliente();
						         filap[2]=p.getImporte();
						         filap[3]=p.getFecha();
						         cargadoA=true;   
						         ((DefaultTableModel) tableA.getModel()).addRow(filap)	;
					         }
						     cargadoA=true;
					       }
					        
						}			  	    
				  	});	
			
		btnNewButton.setBounds(548, 476, 89, 23);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("P\u00E9rdidas");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(512, 31, 119, 23);
		add(lblNewLabel);

	}

}
