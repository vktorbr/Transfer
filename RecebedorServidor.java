package atividade123;

import java.io.InputStream;
import java.util.Scanner;

class RecebedorServidor implements Runnable {

	private InputStream servidor;

	public RecebedorServidor(InputStream servidor) {
		this.servidor = servidor;
	}

	public void run() {
		try(Scanner s = new Scanner(this.servidor)){
			while (s.hasNextLine()) {
				System.out.println(s.nextLine());
			}
		}
	}
}