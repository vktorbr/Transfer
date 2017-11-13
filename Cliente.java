package Transfer;


import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

public class Cliente implements Runnable {
	Socket socket;
	DataOutputStream dos;
	static Scanner in = new Scanner(System.in);
	public Cliente(String ip, int port) throws IOException{
		this.socket=new Socket(ip, port);
		this.dos=new DataOutputStream(socket.getOutputStream());
	}

	
	public void sendMessage(String message) throws IOException {
		this.dos.writeUTF(message);
		this.dos.flush();
	}
	
	public void run() {
		
		while(true) {
			try {
				sendMessage(in.next());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}