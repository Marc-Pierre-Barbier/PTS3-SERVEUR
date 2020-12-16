package game;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ComsJoueur {
	private ObjectOutputStream serverOut;
	private ObjectInputStream serverIn;
	private Socket socket;
	
	public ComsJoueur(Socket connection) throws IOException
	{
		serverOut = new ObjectOutputStream(connection.getOutputStream());
		serverIn = new ObjectInputStream(connection.getInputStream());
		this.socket=connection;
	}
	
	public void send(String message) throws IOException
	{
		serverOut.writeObject(message);
		System.out.println("Sending "+message);
	}
	
	public String recieve()
	{
		try {
			return (String) serverIn.readObject();
		} catch (ClassNotFoundException e) {
			System.err.println("ERREUR une classe non trouvé a éte transimise , essayer de n'evoyer que des String");
			return "";
		} catch (IOException e) {
			return "time out";
		}
	}
	
	public Object waitAndRecieve()
	{
		String returnVal;
		while((returnVal =(String) recieve())!= null);
		return returnVal;
	}
	
	public void close() throws IOException
	{
		serverOut.close();
		serverIn.close();
	}
	
	public Socket getSocket() {
		return socket;
	}

	public void send(int cardId) throws IOException {
		send(""+cardId);
		
	}
}
