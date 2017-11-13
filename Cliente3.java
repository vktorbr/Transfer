package atividade123;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import java.io.IOException;
import java.net.UnknownHostException;

public class Cliente {

	private String host;
	private int porta;

	public Cliente(String host, int porta) {
		this.host = host;
		this.porta = porta;
	}

	public void executa() throws UnknownHostException, IOException {
		try(Socket cliente = new Socket(this.host, this.porta); 
				Scanner teclado = new Scanner(System.in); 
				PrintStream saida = new PrintStream(cliente.getOutputStream())) {
			System.out.println("O cliente se conectou ao servidor!");
	
			RecebedorServidor r = new RecebedorServidor(cliente.getInputStream());
			new Thread(r).start();
	
			while (teclado.hasNextLine()) {
				saida.println(teclado.nextLine());
			}
		}
	}
	public static void main(String[] args) 
			throws UnknownHostException,	IOException {
		new Cliente("127.0.0.1", 12345).executa();
	}
}
