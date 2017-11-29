package clie.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPGet{

   public static String getHTML(String urlToRead) throws Exception {
	   StringBuilder result = new StringBuilder();
	   URL url = new URL(urlToRead);
	   HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	   conn.setRequestMethod("GET");
	   BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	   String line;
	   while ((line = br.readLine()) != null) {
		result.append(line);
	   }
	   br.close();
	   return result.toString();
   }

}