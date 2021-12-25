import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadedServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int port = 1030;
		boolean listening = true;
        ServerSocket ss= null;
		 // Set up the Server Socket
		try {
			//la socket du serveur 
			ss = new ServerSocket(port);
			//le port sur le quel le serveur et le client communiquent
			System.out.println("Server Listening on Port :" +port );
			//connexion acceptée
			
		}
			catch (Exception e ){
	            System.out.println("Cannot listen on port: " + port + ", Exception: " + e);
	            }
		//Traitement 
		 while (listening) 
	        { Socket sock =null;
	            
	            try{
	            	System.out.println("**. Listening for a connection...");
	            	sock = ss.accept();
	    			File D = new File("C:/Users/ASUS/Desktop/Master1 en cours/PJA/TP_PJA/Devoir2/directory");
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

	               
	            } 
	            catch (IOException e){
	                System.out.println("failed: " + port + e);
	                listening = false;   // end the loop - stop listening for further client requests
	            }	
	            
	            ThreadTask con = new ThreadTask(sock);
	            con.start(); 
	        }
		 //fermer la socket du serveur 
		 try 
	        {
	            System.out.println("Closing down the server socket.");
	            ss.close();
	        } 
	        catch (IOException e) 
	        {
	            System.err.println("Could not close server socket. " + e.getMessage());
	        }
			

	}

}
