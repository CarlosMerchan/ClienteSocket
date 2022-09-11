package conexionSocket;

import java.net.*;
import java.util.Scanner;
import java.io.*;;

public class Conexion {
	
	private Socket cliente;
	private final int PUERTO = 5000;
	private String localhost="127.0.0.1";
    private DataInputStream entrada;
	private DataOutputStream salida;
	private boolean conectado = true;
	
	public void incio() {
		
		try {
			cliente = new Socket(localhost,PUERTO);//socket cliente que se le pasa como parametro la direccio ip y el puerto del servidor
			entrada = new DataInputStream(cliente.getInputStream()); //entrada de datos del cliente
			salida = new DataOutputStream(cliente.getOutputStream());			
			String opciones ="1.lista de clientes.\n"
					+"2.agregar un cliente.\n"
					+"3.consultar saldo por cedula.\n"
					+"4.agregar dinero a cuenta.\n"
					+"5.Salir";			
			String opcSalida;
			Scanner scan = new Scanner(System.in);
			while(conectado) {				
				System.out.println(opciones);
				opcSalida = scan.nextLine();
				opciones(opcSalida);
				
			}
			scan.close();
			cliente.close();
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void opciones(String opcion) throws IOException {
		Scanner scan = new Scanner(System.in);
		switch(Integer.parseInt(opcion)) {
		case 1:
			salida.writeUTF(opcion);
			System.out.println(entrada.readUTF());
			break;
		case 2:
			 System.out.println("Digitar Nombres");
			 opcion+=","+scan.nextLine();
			 System.out.println("Digitar Apellidos");
			 opcion+=","+scan.nextLine();
			 System.out.println("Digitar el saldo");
			 opcion+=","+scan.nextLine();
			 salida.writeUTF(opcion);
			 System.out.println(entrada.readUTF());
			 break;
		case 3:			
			 System.out.println("Digitar el id del cliente");
			 opcion+=","+scan.nextLine();
			 salida.writeUTF(opcion);
			 System.out.println(entrada.readUTF());
		     break;
		case 4:
			 System.out.println("Digitar el id del cliente");
			 opcion+=","+scan.nextLine();
			 System.out.println("Digitar el saldo a agregar");
			 opcion+=","+scan.nextLine();
			 salida.writeUTF(opcion);
			 System.out.println(entrada.readUTF());
			 break;
		default:
			entrada.close();
			salida.close();
			cliente.close();
			System.out.println("Hasta luego");
			conectado = false;
			break;
		}
	}
	
	
	
	
	 
}
