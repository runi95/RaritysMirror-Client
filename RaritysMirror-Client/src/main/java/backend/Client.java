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
	private static ClientInformation ci;
	
	// TODO: Client should be able to choose a name.
	// TODO: Add fullscreen mode.
	
	public static void connect(String ip, int port, ClientInformation ci) {
		Client.ci = ci;
		startConnection(ip, port);
		
		run();
	}
	
	private static void run() {
		try {
			Message msg = (Message) ois.readObject();
			Message rMsg = new Message();
			rMsg.setResponse(msg.getRequest());
			rMsg.setRequest(checkRequest(msg.getRequest(), msg.getResponse()));
			
			Client.oos.writeObject(rMsg);
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		run();
	}
	
	private static void startConnection(String ip, int port) {
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
	
	private static String checkRequest(String request, String response) {
		if(request == null)
			return null;
		
		if(request.equals("version"))
			return ci.getVersion();
		
		if(request.equals("name"))
			return ci.getName();
		
		if(request.equals("setName")) {
			ci.setName(response);
			return response;
		}
		
		throw new IllegalArgumentException("Tried to do an illegal request: " + request);
	}
}
