package backend;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	private static Socket socket = null;
	private static ObjectOutputStream oos = null;
	private static ObjectInputStream ois = null;
	private static ClientInformation ci = new ClientInformation();
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		// TODO: Remove this test function once GUI is set up properly!
		Client client = new Client();
		client.connect("localhost", 1995);
		
		Message msg = (Message) client.ois.readObject();
		Message rMsg = new Message();
		rMsg.setResponse(client.checkRequest(msg.getRequest()));
		
		client.oos.writeObject(rMsg);
	}
	
	// TODO: Client should be able to choose a name.
	// TODO: Add fullscreen mode.
	
	public static void connect(String ip, int port) {
		if(socket != null)
			return;
		
		try {
			socket = new Socket(ip, port);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String checkRequest(String request) {
		if(request == null)
			return null;
		
		if(request.equals("version"))
			return ci.getVersion();
		
		throw new IllegalArgumentException("Tried to do an illegal request: " + request);
	}
}
