package Transfer;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTransfer {
	public static void main(String[] args) {

		// Cria um servidor
		ServerTransfer server = new ServerTransfer();

		// Aguarda conexao de cliente para transferencia
		server.waitForClient();	
	}
	
	public void waitForClient() {
		OutputStream dos = null;
		ServerSocket serverSocket = null;
		FileInputStream fileIn = null;
		
		try {
			//abrindo porta para conexao
			serverSocket = new ServerSocket(12345);
			System.out.println("Porta de conexao aberta 12345");
			
			//Cliente conectado
			Socket socket = serverSocket.accept();
			System.out.println("Conexao recebedida pelo cliente");
			
			//Criando tamanho de leitura
			byte[] buffer = new byte[1024];
			int bytesRead;
			
			//Criando arquivo que sera transferido pelo servidor
			File file = new File("c:\\\\Users\\\\vms5\\\\Downloads\\\\halliday.zip");
			fileIn = new FileInputStream(file);
			System.out.println("Lendo arquivo...");
			
			//criando canal de transferencia
			dos=socket.getOutputStream();
			
			while((bytesRead=fileIn.read(buffer))!=-1) {
				dos.write(buffer, 0, bytesRead);
				dos.flush();
			}
			System.out.println("Arquivo enviado!");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
}
