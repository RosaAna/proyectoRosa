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
import modelo.PerdidasDTO;

public class PerdidasDAO  implements IPerdidasDAO{
	private static Connection conexion= ConexionProfe.getConexion();
	Statement statement;
	String sql;

@Override
public List<PerdidasDTO> getListaPerdidas() {
	List<PerdidasDTO> listaPerdidas = new ArrayList<>();
	
String	sql = "SELECT * FROM perdidas ORDER BY DNI_CLIENTE;";
	try {
		Statement statement=conexion.createStatement();
		ResultSet resultset = statement.executeQuery(sql);
	
		while (resultset.next()){
			String codigo = resultset.getString("CODIGO_PRODUCTO");
			String dni = resultset.getString("DNI_CLIENTE");
			int importe = resultset.getInt("IMPORTE");
			String fecha=resultset.getString("FECHA");
			PerdidasDTO pd = new PerdidasDTO(codigo, dni, importe, fecha);
			listaPerdidas.add(pd);
		}
			
	} catch (SQLException e2) {
		System.out.println("No se pudo leer getListaClientes");
	}
	return listaPerdidas;
  }





public static void main(String[] args) {
	PerdidasDAO p=new PerdidasDAO();
	System.out.println(p.getListaPerdidas());
 }
}