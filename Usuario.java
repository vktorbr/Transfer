package Transfer;

import java.io.IOException;
import java.util.Scanner;

public class Usuario {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			(new Thread(new Servidor())).start();
			(new Thread(new Cliente("localhost", 3000))).start();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
