package servlet;

import java.io.*;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Creamos la clase users, que contiene el hashmap dee usuarios
		Users users = new Users();
		HashMap<String,String> listaUsers =	users.getUsers();
		//Creamos el writer y la sesion
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession sesion = request.getSession();
		//Obtenemos los valores de usuario y contraseña introducidos por el cliente
		String usuario = request.getParameter("usuario");
		String contraseña = request.getParameter("contraseña");
		String validarUsuario = listaUsers.get(usuario);
		
		if(validarUsuario.equals(contraseña)) {
			sesion.setAttribute("usuario", usuario);
			sesion.setAttribute("errorLog","false");
		}
		else {
			sesion.setAttribute("errorLog","true");
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
