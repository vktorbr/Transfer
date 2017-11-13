package atividade123;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

class TratadorCliente implements Runnable {

	private Socket cliente;
	private Servidor servidor;

	public TratadorCliente(Socket cliente, Servidor servidor) {
		this.cliente = cliente;
		this.servidor = servidor;
	}

	public void run() {
		try(Scanner s = new Scanner(this.cliente.getInputStream())) {
			while (s.hasNextLine()) {
				servidor.mandamensagem(this.cliente, s.nextLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}