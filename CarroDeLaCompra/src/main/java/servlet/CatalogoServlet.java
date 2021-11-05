package servlet;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/catalogo")
public class CatalogoServlet extends HttpServlet {
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CatalogoServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		//Creamos la clase users, que contiene el hashmap de usuarios
		Users users = new Users();
		HashMap<String,String> listaUsers =	users.getUsers();
		//Creamos el writer y la sesion
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession sesion = request.getSession();
		
		
		
		//Obtenemos los valores de usuario y contraseña introducidos por el cliente
		String usuario = request.getParameter("usuario").toUpperCase();
		String contrasena = request.getParameter("contrasena").toUpperCase();
		String validarUsuario = listaUsers.get(usuario);
		
		
		//Creamos el objeto catalogo y le añadimos productos
		Catalogo c =  new Catalogo();
		c.anadirProducto(new Producto ("Reloj",15));
		c.anadirProducto(new Producto ("Gorra",22));
		c.anadirProducto(new Producto ("Cartera Gucci",130));
		c.anadirProducto(new Producto ("Anillo plata de ley",38));
		
		ArrayList <Producto> lista = c.getListaProductos();
		StringBuilder htmlListaProductos = new StringBuilder();
		Iterator<Producto> it = lista.iterator();
		
		while (it.hasNext()) {
			Producto p = it.next();
			String nombre = p.getNombre();
			int precio = p.getPrecio();
			htmlListaProductos.append("<label for=\"" + nombre + "\"> "+nombre + ", " + precio + "eu </label>\n"
					+ "<input type=\"radio\" id = \"" + nombre +"\"value=\"" +precio+ "\" name=\"producto\" >\n<br>"); 
		}
		
		//Si la contraseña obtenida del usuario introducido no es nula y coincide con la contraseña introducida por el usuario
		//Guardamos el usuario en la sesion y mostramos el catalogo
		if(validarUsuario != null && validarUsuario.equals(contrasena)) {
			sesion.setAttribute("usuario", usuario);
			sesion.setAttribute("errorLog","false");
			out.println("<html> \n"
					+ "<head>\n"
					+ "	<meta charset=\"UTF-8\">\n"
					+ "		<title>Catalogo</title>\n"
					+ "	</head>\n"
					+ "<body>\n"
					+ "<p>hola</p>"
					+ "<form action=\"/CarroDeLaCompra/resumen\">"
					+ htmlListaProductos
					+ "</form>"
					+ "</body>\n"
					+ "</html>");
			System.out.println(htmlListaProductos);
		}
		else {
			sesion.setAttribute("errorLog","true");
			response.sendRedirect("/CarroDeLaCompra/HTML/Login.jsp");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
