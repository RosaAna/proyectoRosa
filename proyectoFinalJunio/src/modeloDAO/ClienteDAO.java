package modeloDAO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

import com.google.gson.Gson;
import modelo.ClienteDTO;
import modelo.ConexionProfe;
import vista.Vista;
import modelo.ClienteDTO;

public class ClienteDAO implements IClienteDAO {
	private static Connection conexion= ConexionProfe.getConexion();
	PreparedStatement preparedStatement;
	ClienteDTO cdto;
	Statement statement;
	String sql;
	Vista vista;
	private String path;
	
   public  String rutaAlFichero() {
	   JFileChooser jFileChooser = new JFileChooser(".");
	   int resultado = jFileChooser.showOpenDialog(vista.getFrame());
	     if (resultado == jFileChooser.APPROVE_OPTION) {
		   path = jFileChooser.getSelectedFile().getPath();  
	     }
	   return path;
	}
	
	
	   public List<ClienteDTO> readListClientesDesdeJson(String rutAlFicheroJson){
		   //ruta="Datos/clientes.json"
			List<ClienteDTO> listClientes=new ArrayList<>();
				BufferedReader reader = null; 
				
			    try {
					reader = new BufferedReader ( new FileReader ( rutAlFicheroJson ));
					 Gson gson = new Gson();
				        ClienteDTO[] clientesDTO = gson.fromJson(reader, ClienteDTO[].class);

				        for (ClienteDTO clienteDTO : clientesDTO) { 
				            listClientes.add(clienteDTO);
				        }
			    
				  } catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				  }
				return listClientes;
	       } 
	
	
	@Override
	public List<ClienteDTO> getListaClientes() {
		List<ClienteDTO> listClientes = new ArrayList<>();
		
	String	sql = "SELECT * FROM clientes;";
		try {
			Statement statement=conexion.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
		
			while (resultset.next()){
				String dni = resultset.getString("DNI");
				String nombre = resultset.getString("NOMBRE");
				String apellidos = resultset.getString("APELLIDOS");
				String email = resultset.getString("EMAIL");
				String fecha=resultset.getString("FECHA");
				ClienteDTO cliente = new ClienteDTO(dni, nombre, apellidos, email, fecha);
				listClientes.add(cliente);
			}
				
		} catch (SQLException e2) {
			System.out.println("No se pudo leer getListaClientes");
		}
		return listClientes;
	}

	@Override
	public  boolean addCliente(ClienteDTO cliente) {
        boolean add = false;
		
		String sql = "INSERT INTO clientes VALUES (?, ? , ?, ?, ?);";
		try {
			System.out.println("Entra en tr11y");
		    preparedStatement = conexion.prepareStatement(sql);
		    System.out.println("Entra en tr12y");
			preparedStatement.setString(1, cliente.getDni());
			System.out.println("Entra en tr13y");
			preparedStatement.setString(2, cliente.getNombre());
			preparedStatement.setString(3, cliente.getApellidos());
			preparedStatement.setString(4, cliente.getEmail());
			preparedStatement.setString(5, cliente.getFecha());
			int rows = preparedStatement.executeUpdate();
			if (rows != 0)
				add = true;
		} catch (SQLException e) {
			System.out.println("No se pudo añadir el cliente");

		}
		
		return add;	
	}

	@Override
	public boolean deleteCliente(String dni) {
		boolean delete= false;
		sql = "DELETE FROM clientes WHERE DNI = ?";
		try {
			preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setString(1, dni);
			int rows = preparedStatement.executeUpdate();
			if (rows != 0)
				delete = true;
		} catch (SQLException e) {
			System.out.println("No se pudo borrar el cliente");

		}
		
		return delete;
	}
	



 
	

	@Override
	public boolean updateEmailCliente( String email, String dni) {
		boolean update = false;
	
		String sql = "UPDATE clientes SET EMAIL=?   WHERE DNI = ?";
		try {
			preparedStatement = conexion.prepareStatement(sql);
			System.out.println("1");
			preparedStatement.setString(1, email);
			System.out.println("2");
			preparedStatement.setString(2, dni);
			System.out.println("3");
			int rows = preparedStatement.executeUpdate();
			if (rows != 0)
				update = true;
		} catch (SQLException e) {
			System.out.println("No se pudo modificar el email");

		}
		
		return update;
	}



	@Override
	public boolean addListaClientes(List<ClienteDTO> listaClientes) {
		boolean addC=false;
		for(ClienteDTO cto: listaClientes){
			ClienteDAO cd=new ClienteDAO();
			cd.addCliente(cto); 
			addC=true;
        }
	
		return addC;
	}
	
	public static Object [][] listaData (List<ClienteDTO> lista){
		Object [][] matriz = new Object [lista.size()][5];
			
			for (int i=0 ; i < lista.size() ;i++){
			matriz[i][0] = lista.get(i).getDni();
			matriz[i][1] = lista.get(i).getNombre();
			matriz[i][2] = lista.get(i).getApellidos();
			matriz[i][3] = lista.get(i).getEmail();
			matriz[i][4] = lista.get(i).getFecha();
			}
		
		return matriz;	
		}
	
	
	
	public static void main(String[] args) {
		ClienteDAO c=new ClienteDAO();
		ClienteDTO d=new ClienteDTO("77777777S", "Josemary", "Sanlores", "mvrg@gmail.com","12/04/2018");
		//c.addCliente(d);
		//System.out.println("SQLITE");
		System.out.println(c.getListaClientes());
		//c.addListaClientes(c.readListClientesDesdeJson("Datos/clientes.json"));
		//System.out.println(c.readListClientesDesdeJson("Datos/clientes.json"));
		System.out.println(c.deleteCliente("77777777Q"));
		System.out.println(c.updateEmailCliente("77777777S", "PuebloJienense@gmail.com"));
		//System.out.println(c.getListaClientes());

		
	}


}






