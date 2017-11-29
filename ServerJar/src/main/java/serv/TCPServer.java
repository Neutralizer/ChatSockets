package serv;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer implements Server{

	public void start() {

		try {
			ServerSocket ss = new ServerSocket(1201);
			Socket s = ss.accept();

			DataInputStream din = new DataInputStream(s.getInputStream());
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String msgin = "", msgout = "";
			while (!msgin.equals("end")) {
				msgin = din.readUTF(); // reads the input from the client socket and returns a string
				System.out.println(msgin);//prints the string  in the server console
				msgout = br.readLine();//detects the string,written in server console and saves it
				dout.writeUTF(msgout);//sends the saved string to the client socket
				dout.flush();
			}
			ss.close();
			s.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
