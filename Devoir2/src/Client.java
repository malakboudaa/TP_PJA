import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int port = 1023;
			Socket s = new Socket("hostname",port);
			
			File F = new File( "C:\\Users\\ASUS\\Desktop\\Master1 en cours\\PJA\\TP_PJA\\Devoir2\\directory");
			
			if (F.exists()) 
			{
				
				PrintWriter bufout = new PrintWriter(s.getOutputStream(),true);
				bufout.write("List"+F.list());
		        bufout.write("Get"+F.getName());
		        
		        BufferedReader reader = new BufferedReader(new FileReader(F));
	            String str = reader.readLine();
	    		System.out.println(str);
	    		
	    			bufout.close();
	    			reader.close();
	    			s.close();
	    		
			} 
			else 
			{
				System.out.println("Directory doesn't exist");
			}
						
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
