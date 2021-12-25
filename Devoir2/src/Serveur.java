import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int port = 1030;
		try {
			//la socket du serveur 
			ServerSocket ss = new ServerSocket(port);
			//le port sur le quel le serveur et le client communiquent
			System.out.println("Server Listening on Port :" +port );
			//connexion acceptée
			Socket sock = ss.accept();
			//le directory
			File D = new File("C:/Users/ASUS/Desktop/Master1 en cours/PJA/TP_PJA/Devoir2/directory");
            // receboir les données du client 
			PrintWriter out = new PrintWriter(new FileWriter(D));
	        BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));


             //traitement du serveur 
			File [] liste = D.listFiles();
	
			for(File item : liste){
		       
				if( item.isDirectory()   )
		        { 
		        	System.out.format("Noms ", item.getName()); 
		          
		        } 
		        else 
		        {
		        	System.out.println("Erreur");

		        }
		        
		        if (item.isFile())
		        {
		        	 System.out.println("Liste "+ item.list()); 
		        } 
		        else 
		        {
		        	System.out.println("Erreur");
		        }
		       
		      }
			
			out.close();
			in.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
