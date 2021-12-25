import java.net.*;
import java.io.*;

public class ThreadTask extends Thread {
	
	private Socket s = null;				// Client socket object
    private PrintWriter pw = null;			// Input stream
    private BufferedReader br = null;
	
	// établir la connexion avec un constructeur 

    public ThreadTask (Socket s) {
        this.s = s;
        //Set up a service object to get the current date and time
    }
	
	
    //// la methode d'execution du thread 
	@Override 
	public void run() {
		super.run();
		
		try {
			File D = new File("C:/Users/ASUS/Desktop/Master1 en cours/PJA/TP_PJA/Devoir2/directory");

			this.pw = new PrintWriter(new FileWriter(D));
	        this.br = new BufferedReader(new InputStreamReader(s.getInputStream()));
	        } 
		catch (Exception e) {
			System.out.println(e.getMessage());
			}
		}
	
		private void read() {
	        String s = null;
	        try {
	            s = br.readLine();
	        } 
	        catch (Exception e){    // catch a general exception
	        	e.printStackTrace();
	        }
		
	}
		private void send(String s) {
			
	        try {
	            this.pw.write(s);
	            
	        } 
	        catch (Exception e) {
	            System.out.println("XX." + e.getStackTrace());
	        }
	    }
	
	
	// Close the client socket 
    public void closeSocket() { //gracefully close the socket connection
        try {
            this.pw.close();
            this.br.close();
            this.s.close();
        } 
        catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
	
	
}


