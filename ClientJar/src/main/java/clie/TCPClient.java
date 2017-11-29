package clie;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.List;

import clie.service.ClientService;
import clie.service.ClientServiceImpl;
import clie.service.ServiceChat;
import clie.service.ServiceChatImpl;
import clie.service.User;

public class TCPClient implements Client{

	public void start() {
		ServiceChat service = new ServiceChatImpl();
		ClientService clientService = new ClientServiceImpl();
		
		List<User> availableChatClients = service.getAvailableChatParticipants();
		service.printParticipantsOnConsole(availableChatClients);
		//select one of the participants 
		String ip = service.chooseParticipant(availableChatClients);
		//provide ip to the socket connection
		System.out.println("The service provided ip is: " + ip);
		
		clientService.connectTo(ip);
		
		
	}

}
