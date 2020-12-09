package game;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ComsJoueur {
	private ObjectOutputStream serverOut;
	private ObjectInputStream serverIn;
	
	public ComsJoueur(Socket connection) throws IOException
	{
		serverOut = new ObjectOutputStream(connection.getOutputStream());
		serverIn = new ObjectInputStream(connection.getInputStream());
	}
	
	public void send(Object object) throws IOException
	{
		serverOut.writeObject(object);
	}
	
	public Object recieve()
	{
		try {
			return serverIn.readObject();
		} catch (ClassNotFoundException e) {
			System.err.println("ERREUR une classe non trouvé a éte transimise , essayer de n'evoyer que des String au possible");
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
}
