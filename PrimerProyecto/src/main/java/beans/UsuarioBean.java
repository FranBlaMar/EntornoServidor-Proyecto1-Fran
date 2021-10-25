package beans;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class UsuarioBean {
	private String nombre;
	private String fechaNacimiento;
	private LocalDate fechaEnLocalDate;
	private int edad;
	private String sector;
	private String email;
	

	public UsuarioBean() {
		this.nombre = null;
		this.fechaNacimiento = null;
		this.fechaEnLocalDate = null;
		this.edad = 0;
		this.sector = null;
		this.email = null;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	/**
	 * Parseamos la string de la fecha de cumpelaños a LocalDate, y 
	 * calculamos la edad obteniendo los años entre la fecha actual y la introducida
	 * @param fechaNacimiento
	 */
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
		LocalDate cumple= LocalDate.parse(fechaNacimiento);
		this.edad = (int) ChronoUnit.YEARS.between(cumple,LocalDate.now());
		this.fechaEnLocalDate = cumple;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public LocalDate getFechaEnLocalDate() {
		return fechaEnLocalDate;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getSector() {
		return sector;
	}
	
	/**
	 * Usamos valueOf para obtener el numerado que corresponde al string introducido
	 * @param trabajo
	 */
	public void setSector(String trabajo) {
		this.sector = trabajo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
