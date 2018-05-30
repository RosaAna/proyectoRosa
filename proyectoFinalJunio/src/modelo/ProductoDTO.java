package modelo;

import java.time.LocalDate;
import java.util.Date;

public class ProductoDTO {
private String codigo_producto;
private int precio;
private int cantidad;
private String fecha;
public ProductoDTO(String codigo_producto, int precio, int cantidad, String fecha) {
	super();
	this.codigo_producto = codigo_producto;
	this.precio = precio;
	this.cantidad=cantidad;
	this.fecha = fecha;
}

public ProductoDTO(String codigo_producto, int precio, int cantidad) {
	super();
	this.codigo_producto = codigo_producto;
	this.precio = precio;
	this.cantidad=cantidad;
}


public ProductoDTO(String dni, String codigo, int precio) {
	// TODO Auto-generated constructor stub
}

public ProductoDTO(String dni, String codigoProducto, String fecha2) {
	// TODO Auto-generated constructor stub
}



public ProductoDTO(String dniCliente, String codigoProducto) {
	// TODO Auto-generated constructor stub
}

/**
 * @return the codigo_producto
 */
public String getCodigo_producto() {
	return codigo_producto;
}
/**
 * @param codigo_producto the codigo_producto to set
 */
public void setCodigo_producto(String codigo_producto) {
	this.codigo_producto = codigo_producto;
}
/**
 * @return the precio
 */
public int getPrecio() {
	return precio;
}
/**
 * @param precio the precio to set
 */
public void setPrecio(int precio) {
	this.precio = precio;
}


/**
 * @return the cantidad
 */
public int getCantidad() {
	return cantidad;
}

/**
 * @param cantidad the cantidad to set
 */
public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}

/**
 * @return the fecha
 */
public String getFecha() {
	return fecha;
}
/**
 * @param fecha the fecha to set
 */
public void setFecha(String fecha) {
	this.fecha = fecha;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "codigo_producto=" + codigo_producto + ", precio=" + precio + ", cantidad=" + cantidad
			+ ", fecha=" + fecha + "\n";
}





}
