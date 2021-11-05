package servlet;

import java.util.ArrayList;

public class Catalogo {
	private ArrayList <Producto> listaProductos;

	
	public Catalogo() {
		this.listaProductos = new ArrayList <>();
	}
	
	public void anadirProducto (Producto p) {
		listaProductos.add(p);
	}

	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}
	
}
