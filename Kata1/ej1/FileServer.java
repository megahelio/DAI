package ej1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {

	public static void main(String[] args) {
		int bufferSize = 1024;
		
		try (ServerSocket socketServer = new ServerSocket(56321)){
			
			try(Socket client = socketServer.accept()) {
				DataInputStream input = new DataInputStream(client.getInputStream());
				DataOutputStream output = new DataOutputStream(client.getOutputStream());
				
				String filename = input.readUTF();
				
				File file = new File(filename);
				
				if(!file.exists()) {
					output.writeLong(-1);
				} else {
					output.writeLong(file.length());
					
					try(FileInputStream fileStream = new FileInputStream(file)){
						
						byte[] buffer = new byte[bufferSize];
						int len;						
						
						while ((len = fileStream.read(buffer)) != -1) {
							output.write(buffer, 0, len);
						}
							
					}					
					
				}
				
				output.flush();
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

public class HTTPRequest{
	
	public HTTPRequest(){

	}
}
