package sockets.basico;

import java.net.*;
import java.io.*;

public class ConexCliente {
	final String HOST = "localhost";
	final int PUERTO = 5000;
	Socket sc;
	DataOutputStream mensaje;
	DataInputStream entrada;

	// Cliente
	public void initClient() /* ejecuta este metodo para correr el cliente */
	{
		try {
			/*
			 * conectar a un servidor en
			 * localhost con puerto 5000
			 */
			sc = new Socket(HOST, PUERTO); 
			
			// creamos el flujo de datos por el que se enviara un mensaje
			mensaje = new DataOutputStream(sc.getOutputStream());
			sc.setSoLinger(true, 10);
			// enviamos el mensaje
			mensaje.writeUTF("hola que tal!!");
			
			// cerramos la conexión
			sc.close();
		} catch (Exception e) {

			System.out.println("Error: " + e.getMessage());
		}
	}
	

}