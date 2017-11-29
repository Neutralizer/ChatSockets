package clie.service;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientServiceImpl implements ClientService{
	
	public void connectTo(String userIP) {
		// sends and receives messages 
				try {
					Socket s = new Socket(userIP, 1201);//"127.0.0.1"
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
