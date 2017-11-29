package clie.service;

import java.util.List;

public interface ServiceChat {
	
	String chooseParticipant(List<User>list);
	
	void printParticipantsOnConsole(List<User> list);
	
	List<User> getAvailableChatParticipants();

}
