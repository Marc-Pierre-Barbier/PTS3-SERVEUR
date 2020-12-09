package game;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class SimpleUDP {
	private byte[] buf;
	private DatagramSocket uDPServeur;
	private InetAddress address;
	private static int port;
	
	public SimpleUDP(DatagramSocket uDPServeur,Socket baseSocket)
	{
		this.uDPServeur=uDPServeur;
		this.address=baseSocket.getInetAddress();
		port = baseSocket.getPort();
	}
	
	public void sendPacket(String message) throws IOException
	{
		DatagramPacket packet 
        = new DatagramPacket(buf, buf.length, address, port);
		uDPServeur.send(packet);
	}
	
	public String recivePacket() throws IOException
	{
		DatagramPacket packet = new DatagramPacket(buf, buf.length);
		uDPServeur.receive(packet);
        return new String(packet.getData(), 0, packet.getLength());
	}
}
