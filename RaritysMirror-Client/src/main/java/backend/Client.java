package backend;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	// TODO: Client should be able to choose a name.
	// TODO: Add fullscreen mode.
	
	public void run() {
		try (Socket socket = new Socket("localhost", 1995);) {
			System.out.println("Created socket!");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
