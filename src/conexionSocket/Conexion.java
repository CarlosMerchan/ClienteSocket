package conexionSocket;

import java.net.*;
import java.util.Scanner;
import java.io.*;;

public class Conexion {
	
	private Socket cliente;
	private final int PUERTO = 6958;
	private String localhost="127.0.0.1";
    private DataInputStream entrada;
	private DataOutputStream salida;
	private boolean conectado = true;
	
	public void incio() {
		
		try {
			cliente = new Socket(localhost,PUERTO);//socket cliente que se le pasa como parametro la direccio ip y el puerto del servidor
			entrada = new DataInputStream(cliente.getInputStream()); //entrada de datos del cliente
			salida = new DataOutputStream(cliente.getOutputStream());
			
				Scanner scan = new Scanner(System.in);
				String mensajeEnviar = scan.nextLine();
				salida.writeUTF(mensajeEnviar);				
				System.out.println(entrada.readUTF());
				cliente.close();
			
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}
