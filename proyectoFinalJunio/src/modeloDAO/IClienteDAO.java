package modeloDAO;

import java.util.List;
import modelo.ClienteDTO;
import modelo.ProductoDTO;

public interface IClienteDAO { 
	List<ClienteDTO> readListClientesDesdeJson(String rutAlFicheroJson);
	List<ClienteDTO> getListaClientes();
	boolean addCliente(ClienteDTO  cliente);
	boolean deleteCliente(String  dni);
	boolean updateEmailCliente(String dni, String email);
	boolean addListaClientes(List<ClienteDTO> listaClientes);
	
}