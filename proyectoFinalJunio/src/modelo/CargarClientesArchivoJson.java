package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class CargarClientesArchivoJson {
   public static void main(String[] args) {
	   
	List<ClienteDTO> listClientes=new ArrayList<>();
	BufferedReader reader = null; 
	
    try {
		reader = new BufferedReader ( new FileReader ( "Datos/clientes.json" ));
		 Gson gson = new Gson();
	        ClienteDTO[] clientesDTO = gson.fromJson(reader, ClienteDTO[].class);

	        for (ClienteDTO clienteDTO : clientesDTO) {
	           // System.out.println(clienteDTO);
	          //  System.out.println(clienteDTO.getNombre());
	            listClientes.add(clienteDTO);
	        }
	        System.out.println(" ");
	        System.out.println(listClientes); 
	        System.out.println(clientesDTO.length);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
   } 
}
