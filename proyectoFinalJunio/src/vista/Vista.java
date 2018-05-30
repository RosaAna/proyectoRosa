package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class Vista extends JFrame {
public Image imagenFondo1, imagenFondo2, imagenFondo3, imagenFondo4;
public URL fondo, fondo2, fondo3, fondo4;
private JTextField textField_login;
private JTextField textField_pass;
private JFrame frame;
public JFrame getFrame() {
	return frame;
}
/**
 * @return the panelVentas
 */
public JPanel getPanelVentas() {
	return PanelVentas;
}

private JPanel PanelVentas;
private JPanel panelC;
private JPanel panelV;
private JPanel panelP;
private JPanel panelI;
private JPanel panelD;
private JTabbedPane pestanas;
	/**
	 * Launch the application.
	 */
public JButton btnCargarProductos;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);//centrarla en la ventana
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the frame.
	 */
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 0, 1050, 820);
		getContentPane().setLayout(new BorderLayout(0, 0));
		//this.setSize(new Dimension(1200, 800));
		
		fondo=this.getClass().getResource("barner.PNG");
		imagenFondo1=new ImageIcon(fondo).getImage();
		
		
		fondo2=this.getClass().getResource("fondoInformac.PNG");
		imagenFondo2=new ImageIcon(fondo2).getImage();
		
		fondo3=this.getClass().getResource("fondo.PNG");
		imagenFondo3=new ImageIcon(fondo3).getImage();
		

		fondo4=this.getClass().getResource("fondod.PNG");
		imagenFondo4=new ImageIcon(fondo4).getImage();
		
		JPanel panel = new JPanel()
		{
		public void paintComponent(Graphics g) {
	    g.drawImage(imagenFondo1, 0, 0, getWidth() , getHeight(), this);
		}	
		}
		;
		
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setBorder(new EmptyBorder(140, 5, 5, 5));
		
	
		
		
	    JTabbedPane pestanas=new JTabbedPane();
		/*
		    JPanel panel0 =new JPanel() {
			public void paintComponent(Graphics g) {
		    g.drawImage(imagenFondo2, 0, 0, getWidth() , getHeight(), this);
			}	
			}
			;		
	        pestanas.addTab("INFORMACION", panel0);
	
	      */  
	        
	        PanelVentas panelV= new  PanelVentas() {
	        public void paintComponent(Graphics g) {
	        g.drawImage(imagenFondo3, 0, 0, getWidth() , getHeight(), this);
			}
	        }
			;	
	      //  panel1.setBackground(Color.BLUE);
	        pestanas.addTab("VENTAS", panelV);
	 
	        
	        
	        PanelDevolucione panelD=new PanelDevolucione() {;
	        public void paintComponent(Graphics g) {
		    g.drawImage(imagenFondo4, 0, 0, getWidth() , getHeight(), this);
			}
		    }
			;
	        
	        pestanas.addTab("DEVOLUCIONES", panelD);
	        panelD.setBackground(Color.RED);
	 
	       
	        PanelClientes panelC= new  PanelClientes() {
	        public void paintComponent(Graphics g) {
		    g.drawImage(imagenFondo3, 0, 0, getWidth() , getHeight(), this);
			}
	        }
			;	
	        pestanas.addTab("CLIENTES", panelC);
	     
	        
	        PanelProductos panelP=new PanelProductos() {
	        public void paintComponent(Graphics g) {
			g.drawImage(imagenFondo3, 0, 0, getWidth() , getHeight(), this);
			}
	        }
		    ;	
	        pestanas.addTab("PRODUCTOS", panelP);
	        
	         
	      
	        PanelAdministracion panelA=new PanelAdministracion() {
	        public void paintComponent(Graphics g) {
			g.drawImage(imagenFondo4, 0, 0, getWidth() , getHeight(), this);
			}
	        }
		    ;	
		    pestanas.addTab("ADMINISTRACION", panelA);
		    getContentPane().add(pestanas, BorderLayout.CENTER);
	
		}

	

	/**
	 * @return the panelC
	 */
	public JPanel getPanelC() {
		return panelC;
	}



	/**
	 * @return the panelV
	 */
	public JPanel getPanelV() {
		return panelV;
	}
    


	/**
	 * @return the panelP
	 */
	public JPanel getPanelP() {
		return panelP;
	}

	/**
	 * @return the panelI
	 */
	public JPanel getPanelI() {
		return panelI;
	}

	/**
	 * @return the pestanas
	 */
	public JTabbedPane getPestanas() {
		return pestanas;
	}

	/**
	 * @return the panelD
	 */
	public JPanel getPanelD() {
		return panelD;
	}
	
	
	
	}


