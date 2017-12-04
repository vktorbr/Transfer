import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Cliente implements Runnable{
    Socket sockServer;
    boolean pausado;
    public Cliente(String ip, int port) throws IOException {
        //Cria conexao com o servidor
        System.out.println("Conectado com o servidor pela porta: "+port);
        sockServer = new Socket(ip, port);
    }
    public synchronized void verificaPausa() throws InterruptedException {
        while(pausado){
            wait();
            System.out.println("A TRANSFERENCIA FOI PAUSADA!");
        }
    }

    public synchronized void setPausado(boolean pausado){
        this.pausado=pausado;
        if(!this.pausado){
            notifyAll();
            System.out.println("A TRANSFERENCIA FOI RETORNADA!");
        }
    }

    public void run() {
        FileOutputStream fos = null;
        InputStream is = null;
        try {
            is = sockServer.getInputStream();
            // Cria arquivo local no cliente
            fos = new FileOutputStream(new File("c:\\Users\\Wykthor\\Desktop\\batman.mkv"));
            System.out.println("Arquivo Local Criado");
            // Prepara variaveis para transferencia
            byte[] cbuffer = new byte[1024];
            int bytesRead;
            // Copia conteudo do canal
            System.out.println("Recebendo arquivo...");
            while ((bytesRead = is.read(cbuffer)) != -1) {
                verificaPausa();
                fos.write(cbuffer, 0, bytesRead);
                fos.flush();
            }System.out.println("Arquivo recebido!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sockServer != null) {
                try {
                    sockServer.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }

            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }

            if (is != null) {
                try {
                    is.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }

    }
}
