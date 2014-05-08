package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javabeans.*;
import modelo.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    
    public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String op = request.getParameter("operacion");
		
		// acceso a la página de envío de mensajes
		if (op.equals("envio"))
			response.sendRedirect("envio.jsp");
		
		// grabación de un mensaje
		if (op.equals("grabar")) {
			Mensaje men = (Mensaje) request.getAttribute("mensa");
			Operaciones oper = new Operaciones();
			oper.grabaMensaje(men);
			response.sendRedirect("inicio.html");
		}
		
		// acceso a la página de solicitud de mensajes
		if (op.equals("muestra"))
			response.sendRedirect("mostrar.html");
		
		// acceso a la lista de mensajes del usuario
		if (op.equals("ver")) {
			Operaciones oper = new Operaciones();
			
			ArrayList<Mensaje> mensajes = 
				oper.obtenerMensajes(request.getParameter("nombre"));
			
			request.setAttribute("mensajes", mensajes);
			RequestDispatcher rd = request.getRequestDispatcher("/ver.jsp");
			rd.forward(request, response);
		}
	}
}




