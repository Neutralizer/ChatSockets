package clie;

public class StartClient {

	public static void main(String[] args) {
		Client client = new TCPClient();
		client.start();

	}

}
