package Transfer;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor implements Runnable{
	ServerSocket serverSocket;
	DataInputStream dis;
	Socket socket;
	
	public Servidor() throws IOException {
		
		this.serverSocket=new ServerSocket(3000);
		
	}
	
	
	public void run() {
		try {
			this.socket=this.serverSocket.accept();
			this.dis= new DataInputStream(this.socket.getInputStream());
			while(true) {
				System.out.println(dis.readUTF());
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}

