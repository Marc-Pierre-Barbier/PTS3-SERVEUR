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

	/**
	 * envoie un message sous forme de chaine de caractére
	 * le choix de la chaine de caractére permet déviter des crash on n'a pas euh de cours sur le reseau
	 * donc ce genre de communication est assez obscure pour nous
	 * @param message
	 * @throws IOException
	 */
	public void send(String message) throws IOException
	{
		serverOut.writeObject(message);
		System.out.println("Sending "+message);
	}


	/**
	 * recoit une chaine de caractére
	 * voire la description de send() pour des info suplementaire
	 * @return
	 */
	public String recieve()
	{
		try {
			String message = (String) serverIn.readObject();
			return message;
		} catch (ClassNotFoundException e) {
			System.err.println("ERREUR une classe non trouvé a éte transimise , essayer de n'evoyer que des String");
			return "";
		} catch (IOException e) {
			return "time out";
		}
	}

	/**
	 * ferme la connection a la fin du match
	 * @throws IOException
	 */
	public void close() throws IOException
	{
		serverOut.close();
		serverIn.close();
	}

	/**
	 * retourne le socket de connection
	 * @return
	 */
	public Socket getSocket() {
		return socket;
	}

	/**
	 * envoie un entier en le convertissant en chaine
	 * @param message
	 * @throws IOException
	 */
	public void send(int message) throws IOException {
		send(""+message);
		
	}
}
