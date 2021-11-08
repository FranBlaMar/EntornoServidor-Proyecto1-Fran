package servlet;

import java.io.*;
import java.util.HashMap;
import java.util.Set;

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
		
		
		//Creamos el objeto catalogo y le añadimos productos
		Catalogo c =  new Catalogo();
		
		HashMap <String,Double> lista = c.getListaProductos();
		StringBuilder htmlListaProductos = new StringBuilder();
		Set <String> listaKeys = lista.keySet();
		
		for (String key : listaKeys) {
			String nombreProducto = key;
			Double precioProducto = lista.get(key);
			htmlListaProductos.append("<div id=\""+ nombreProducto + "\">"
					+ "<label for=\""+nombreProducto+"\"> "+ nombreProducto +",  Precio: "+ precioProducto + " eu <br>"
					+ "            <img src=\"img/"+nombreProducto+".jpg\"/> <br>"
					+ "            <input type=\"number\" name=\""+nombreProducto+"\"/ placeholder=\"Introduzca la cantidad\"> <br>"
					+ "        </label>"
					+ "</div>"); 
		}
		
		
		
				
		
		if (sesion.isNew() || sesion.getAttribute("usuario") == null) {
			response.sendRedirect("/CarroDeLaCompra/HTML/Login.jsp");
		}
		
			//Obtenemos los valores de usuario y contraseña introducidos por el cliente
			String usuario = request.getParameter("usuario").toUpperCase();
			String contrasena = request.getParameter("contrasena").toUpperCase();
			String validarUsuario = listaUsers.get(usuario);
			//Si la contraseña obtenida del usuario introducido no es nula y coincide con la contraseña introducida por el usuario
			//Guardamos el usuario en la sesion y mostramos el catalogo
			if(validarUsuario != null && validarUsuario.equals(contrasena)) {
				sesion.setAttribute("usuario", usuario);
				sesion.setAttribute("errorLog","false");
				out.println("<html> \n"
						+ "<head>\n"
						+ "	<meta charset=\"UTF-8\">\n"
						+ "		<title>Catalogo</title>\n"
						+ "<link rel=\"styleSheet\" type=\"text/css\" href=\"css/style.css\">"
						+ "	</head>\n"
						+ "<body>\n"
						+ "<form action=\"/CarroDeLaCompra/resumen\">"
						+ htmlListaProductos
						+ "<input type=\"submit\" class=\"boton\" value=\"Comprar\"/>"
						+ "</form>"
						+ "</body>\n"
						+ "</html>");
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
