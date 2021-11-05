package servlet;

public class Producto {
	private String nombre;
	private int precio;
	
	/**
	 * 
	 * @param nombre producto
	 * @param precio producto
	 */
	public Producto(String nombre, int precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}

	
	/**
	 * 
	 * @return nombre del producto
	 */
	public String getNombre() {
		return nombre;
	}
	
	
	/**
	 * 
	 * @return precio del producto
	 */
	public int getPrecio() {
		return precio;
	}

	
	@Override
	public String toString() {
		return "nombre:" + nombre + ", precio:" + precio;
	}
	
	
}
