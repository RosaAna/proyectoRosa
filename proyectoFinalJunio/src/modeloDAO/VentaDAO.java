package modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.ClienteDTO;
import modelo.ConexionProfe;
import modelo.ProductoDTO;
import modelo.VentaDTO;

public class VentaDAO implements IVentaDAO {
	private static Connection conexion= ConexionProfe.getConexion();
	PreparedStatement preparedStatement;
    VentaDTO vdto;
	String sql=null;
	
	@Override
	public List<VentaDTO> getListaVentas() {
		  List<VentaDTO> listaVentas=new ArrayList<>();
			String sql=" SELECT * FROM VENTAS ";
			//Creamos el objeto statement
		    try {
				Statement statement=conexion.createStatement();
			   //Creamos el objeto resultSet
			    ResultSet resultSet=statement.executeQuery(sql);
			    while(resultSet.next()) {
			        	String dniCliente=resultSet.getString("DNI");
			        	String codigoProducto=resultSet.getString("CODIGO_PRODUCTO");
			        	int importe=resultSet.getInt("IMPORTE");
			            String fechaVenta=resultSet.getString("FECHA_VENTA");
			        	VentaDTO venta=new VentaDTO(dniCliente, codigoProducto, importe, fechaVenta);
			            listaVentas.add(venta);
			    }       
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("No lee getListaVentas");
			}
			
			return listaVentas;
	}
@Override
	public boolean addVenta (String dniCliente, String codigoProducto, int importe) {
   boolean add = false;
		
		String sql = "INSERT INTO ventas(DNI, CODIGO_PRODUCTO, IMPORTE) VALUES (?, ?, ?)";
		try {
			System.out.println("add1");
		    preparedStatement = conexion.prepareStatement(sql);
		    System.out.println("add2");
			preparedStatement.setString(1, dniCliente);
			System.out.println("add3");
			preparedStatement.setString(2, codigoProducto);
			preparedStatement.setInt(3, importe);
			System.out.println("add4");
			int rows = preparedStatement.executeUpdate();
			if (rows != 0) {
				ProductoDTO p=new ProductoDTO(dniCliente, codigoProducto, importe);
				ProductoDAO pdao=new ProductoDAO();
				pdao.productoCantidadMenosUno(p.getCodigo_producto());
				add = true;
				System.out.println("Venta Correcta");
			}
		} catch (SQLException e) {
			System.out.println("No se pudo a�adir la venta");

		}
		
		return add;
		
	}

	@Override
	public boolean deleteVenta(String dni, String  codigoProducto, String fecha) {
		boolean delete= false;
		sql = "DELETE FROM ventas WHERE DNI = ? AND CODIGO_PRODUCTO = ? AND FECHA_VENTA=?";
		try {
			preparedStatement = conexion.prepareStatement(sql);
		System.out.println(1);
			preparedStatement.setString(1, dni);
		System.out.println(2);
			preparedStatement.setString(2, codigoProducto);
			preparedStatement.setString(3, fecha);
			int rows = preparedStatement.executeUpdate();
			if (rows != 0)
				delete = true;
			System.out.println("Venta borrar perfectamente");
		} catch (SQLException e) {
			System.out.println("No se pudo borrar la venta");

		}
		
		return delete;
	}
	
	
	public static void main(String[] args) {
		VentaDAO vdao=new VentaDAO();
		//ClienteDTO cd= new ClienteDTO("33333333C", "","","");
		ClienteDTO cd= new ClienteDTO("44444444D", "","","");
    	//ProductoDTO pd=new ProductoDTO("A7", 787, 0, "");
    	ProductoDTO pd=new ProductoDTO("B25", 384, 0, "");
	    System.out.println(vdao.addVenta("11111111A", "A5", 0));
		//System.out.println(vdao.getListaVentas());
		System.out.println(vdao.deleteVenta("44444444D", "C25", "2018-05-27"));
		System.out.println(vdao.getListaVentas());
	}

}
