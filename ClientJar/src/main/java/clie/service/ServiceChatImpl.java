package clie.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ServiceChatImpl implements ServiceChat {

	/**
	 * 
	 * @param list
	 *            available users
	 * @return
	 */
	public String chooseParticipant(List<User> list) {
		System.out.println("Select user: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String consoleInput;
		try {
			consoleInput = br.readLine();

			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).userName.equalsIgnoreCase(consoleInput)) {
					return list.get(i).ip;// return the chosen one
				} else if (consoleInput.equalsIgnoreCase("exit")) {
					System.exit(0);
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("No such user! ");
		return chooseParticipant(list);

	}

	public void printParticipantsOnConsole(List<User> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).userName);
		}
	}

	// get them from the other method and parse them
	/**
	 * return list with the chat participants
	 */
	public List<User> getAvailableChatParticipants() {
		String json = retrieveAvailableChatParticipants(getLinkFromFile());//"http://localhost:8080/clients"
		List<User> availableChatUsers = parseJSON(json);
		return availableChatUsers;
	}

	private String getLinkFromFile() {

		Properties prop = new Properties();
		try {
			// load a properties file from class path, inside static method
			prop.load(ServiceChatImpl.class.getClassLoader().getResourceAsStream("config.properties"));

			// get the property value
			return prop.getProperty("link");

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private static String retrieveAvailableChatParticipants(String url) {
		try {
			// TODO retrieve from server
			String availableChatClients = HTTPGet.getHTML(url);
			// we assume that all ports are equal - we need only the ip
			return availableChatClients;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}

	}

	private static List<User> parseJSON(String json) {
		// String json =
		// "[{\"userName\":\"Jake\",\"ip\":\"127.268.0.1\"},{\"userName\":\"Blake\",\"ip\":\"127.268.0.2\"}]";
		ObjectMapper objectMapper = new ObjectMapper();

		List<User> list = new ArrayList<User>();
		try {
			list = objectMapper.readValue(json, new TypeReference<List<User>>() {
			});
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(list.get(0).userName);
		// System.out.println(list.get(0).ip);
		// System.out.println(list.get(1));
		return list;
	}

}
