package beans;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

enum sector{
	TECNOLOGICO,MEDICINA,EDUCACION,SERVICIOS;
}
public class UsuarioBean {
	private String nombre;
	private LocalDate fechaNacimiento;
	private int edad;
	private sector trabajo;
	private String email;
	
	public UsuarioBean() {
		this.nombre = null;
		this.fechaNacimiento = null;
		this.edad = 0;
		this.trabajo = null;
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
		LocalDate cumple= LocalDate.parse(fechaNacimiento);
		this.edad = (int) ChronoUnit.YEARS.between(cumple,LocalDate.now());
		this.fechaNacimiento = cumple;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getTrabajo() {
		return trabajo.toString();
	}
	
	/**
	 * Usamos valueOf para obtener el numerado que corresponde al string introducido
	 * @param trabajo
	 */
	public void setTrabajo(String trabajo) {
		this.trabajo = sector.valueOf(trabajo.toUpperCase());
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
