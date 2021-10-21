package beans;

enum sector{
	TECNOLOGICO,MEDICINA,EDUCACION,SERVICIOS;
}
public class Usuario {
	private String nombre;
	private int edad;
	private sector trabajo;
	private String email;
	
	public Usuario() {
		this.nombre = null;
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
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getTrabajo() {
		return trabajo.toString();
	}
	public void setTrabajo(String trabajo) {
		this.trabajo = sector.valueOf(trabajo);
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
