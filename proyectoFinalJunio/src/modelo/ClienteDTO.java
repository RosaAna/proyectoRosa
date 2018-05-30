package modelo;

import java.time.LocalDate;

public class ClienteDTO {
private String dni;
private String nombre;
private String apellidos;
private String email;
private String fecha;

public ClienteDTO(String dni, String nombre, String apellidos, String email, String fecha) {
	this.dni = dni;
	this.nombre = nombre;
	this.apellidos = apellidos;
	this.email = email;
	this.fecha = fecha;
}



public ClienteDTO(String dni, String nombre, String apellidos, String email) {
	this.dni = dni;
	this.nombre = nombre;
	this.apellidos = apellidos;
	this.email = email;
}



/**
 * @return the dni
 */
public String getDni() {
	return dni;
}

/**
 * @param dni the dni to set
 */
public void setDni(String dni) {
	this.dni = dni;
}

/**
 * @return the nombre
 */
public String getNombre() {
	return nombre;
}

/**
 * @param nombre the nombre to set
 */
public void setNombre(String nombre) {
	this.nombre = nombre;
}

/**
 * @return the apellidos
 */
public String getApellidos() {
	return apellidos;
}

/**
 * @param apellidos the apellidos to set
 */
public void setApellidos(String apellidos) {
	this.apellidos = apellidos;
}

/**
 * @return the email
 */
public String getEmail() {
	return email;
}

/**
 * @param email the email to set
 */
public void setEmail(String email) {
	this.email = email;
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
@Override
public String toString() {
	return "dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", fecha="
			+ fecha + "\n";
}


}