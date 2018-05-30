package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFileChooser;

import modeloDAO.ClienteDAO;
import modeloDAO.DevolucionDAO;
import modeloDAO.PerdidasDAO;
import modeloDAO.ProductoDAO;
import modeloDAO.VentaDAO;
import vista.Vista;


public class Controlador implements ActionListener {

private Vista vista;
private ClienteDAO clienteDAO;
private ProductoDAO productoDAO;
private DevolucionDAO devolucionesDAO;
private PerdidasDAO perdidas;

private List<ClienteDAO> listaClientes;
private List<ProductoDAO> listaProductos;
private List<VentaDAO> listaVentas;
private List<DevolucionDAO>listaDevoluciones;
private List<PerdidasDAO> listaPerdidas;

boolean comprobarCliente;
boolean comprobarProducto;
boolean comprobarVenta;
private VentaDAO ventasDAO;
private String path;

	public Controlador(Vista vista, ClienteDAO clienteDAO, ProductoDAO productoDAO, VentaDAO ventasDAO,
		DevolucionDAO devolucionesDAO, PerdidasDAO perdidas) {
	
	this.vista = vista;
	this.clienteDAO = clienteDAO;
	this.productoDAO = productoDAO;
	this.ventasDAO = ventasDAO;
	this.devolucionesDAO = devolucionesDAO;
	this.perdidas = perdidas;
	actionListener(this);
	
}

	private void registrarComponentes() {
	
    }
	//--------------------
	public  String rutaAlFichero() {
		   JFileChooser jFileChooser = new JFileChooser(".");
		   int resultado = jFileChooser.showOpenDialog(vista.getFrame());
		   if (resultado == jFileChooser.APPROVE_OPTION) {
			 path = jFileChooser.getSelectedFile().getPath();  
		   }
	 return path;
	}
	
	//------------------
	
	@Override
	public void actionPerformed(ActionEvent e) {
	     if (e.getActionCommand().equals("INSERTAR VENTA")) {
		
	    	 rutaAlFichero();
	     }
	     
	     else if(true) {
	    	 
	     }
	
	}
	
	private void actionListener(ActionListener escucha) {
		
	    
	}
	public static void main(String[] args) {
		Vista v=new Vista();
	}

}
