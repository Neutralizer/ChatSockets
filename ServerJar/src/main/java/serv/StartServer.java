package serv;

//access manually the manifest file in the jar file after running maven clean install and 
//specify the entry point (main method class) 
//Main-Class: MyPackage.MyClass - insert this in manifest mf
//access target folder in cmd and run - java -jar ServerJar.jar (for client also)
//make sure that the cmd header is active (with the command java -jar ServerJar.jar)
//communication now active - client first
public class StartServer {

	public static void main(String[] args) {
		Server server = new TCPServer();
		server.start();

	}

}
