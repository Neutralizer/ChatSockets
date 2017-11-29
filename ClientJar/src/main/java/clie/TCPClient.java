package clie;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.List;

import clie.service.ServiceChat;
import clie.service.ServiceChatImpl;
import clie.service.User;

public class TCPClient implements Client{

	public void start() {
		ServiceChat service = new ServiceChatImpl();
		
		List<User> availableChatClients = service.getAvailableChatParticipants();
		service.printParticipantsOnConsole(availableChatClients);
		//select one of the participants 
		String ip = service.chooseParticipant(availableChatClients);
		//provide ip to the socket connection
		System.out.println("The service provided ip is: " + ip);
		
		
		
		// sends and receives messages 
		try {
			Socket s = new Socket(ip, 1201);//"127.0.0.1"
			DataInputStream din = new DataInputStream(s.getInputStream());
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String msgin = "", msgout = "";
			while (!msgin.equals("end")) {
				msgout = br.readLine();
				dout.writeUTF(msgout);
				msgin = din.readUTF();
				System.out.println(msgin);
				dout.flush();
			}
			
			s.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
