package Transfer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientTransfer {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//Cria uma classe cliente para receber arquivos
		ClientTransfer cliente = new ClientTransfer();
		//
		/*System.out.println("---------------INSTRUÇÕES---------------");
		System.out.println("Digite i para iniciar uma transferência");
		System.out.println("Digite p para pausar uma transferência");
		System.out.println("Digite c para cancelar uma transferência");
		System.out.println("Digite r para reiniciar uma transferência");
		*/
	
				System.out.println("DIGITE O IP DO EMISSOR");
				String ip = in.nextLine();
				System.out.println("DIGITE A PORTA DO EMISSOR");
				int porta = in.nextInt();
				System.out.println("DIGITE O DIRETORIO DE DESTINO");
				String diretorio=in.nextLine();
				//solicita arquivo
				cliente.getFileFromServer(ip, porta, diretorio);
	}
	
	private void getFileFromServer(String ip, int porta, String diretorio) {
		Socket socket = null;
		FileOutputStream dos = null;
		InputStream dis = null;
		
		try {
			//cria conexão com o servidor
			System.out.println("Conectando com o Servidor pela porta: "+porta);
			socket = new Socket(ip, porta);
			dis=socket.getInputStream();
			
			//cria arquivo local no destinatário
			dos=new FileOutputStream(new File("diretorio.zip"));
			
			//variaveis para transferencia
			byte [] buffer= new byte[1024];
			int byteRead;
			
			System.out.println("Recebendo arquivo...");
			while((byteRead=dis.read(buffer))!=-1) {
				dos.write(buffer, 0, byteRead);
				dos.flush();
			}
			System.out.println("Arquivo recebido!");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
